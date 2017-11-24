package asu.edu.rule_miner.api.impl.model;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.jena.ext.com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Sets;

import asu.edu.rule_miner.api.impl.utils.Constant;
import asu.edu.rule_miner.api.model.EntityPair;
import asu.edu.rule_miner.api.model.HornRuleAtom;
import asu.edu.rule_miner.api.model.HornRuleBody;
import asu.edu.rule_miner.api.model.KeyValuePair;
import asu.edu.rule_miner.api.model.RuleResult;
import asu.edu.rule_miner.api.model.RuleSpecification;
import asu.edu.rule_miner.api.model.RuleSpecification.TypeEnum;
import asu.edu.rule_miner.api.model.RuleStatistics;
import asu.edu.rule_miner.rudik.model.horn_rule.HornRule;
import asu.edu.rule_miner.rudik.model.statistic.StatisticsContainer;
import asu.edu.rule_miner.rudik.predicate.analysis.KBPredicateSelector;
import asu.edu.rule_miner.rudik.predicate.analysis.SparqlKBPredicateSelector;
import asu.edu.rule_miner.rudik.rule_generator.DynamicPruningRuleDiscovery;

public class RuleGeneratorWorker implements Runnable {

  private static final Logger LOGGER = LoggerFactory.getLogger(RuleGeneratorWorker.class);

  final RuleStorage storage;
  final DynamicPruningRuleDiscovery rudik;
  final KBPredicateSelector predicateSel;
  final RuleSpecification ruleSpecification;

  public RuleGeneratorWorker(final RuleStorage storage, final RuleSpecification ruleSpec) {
    this.storage = storage;
    this.rudik = new DynamicPruningRuleDiscovery();
    this.predicateSel = new SparqlKBPredicateSelector();
    this.ruleSpecification = ruleSpec;
  }

  public void generateAndStoreRules(final RuleSpecification ruleSpec) {
    final RuleResult result = generateRules(ruleSpec);
    if (result != null) {
      try {
        LOGGER.info("Storing the output result for rule id '{}' at <{}>", ruleSpec.getId(),
            ruleSpec.getResultEndpoint());
        if (!this.storage.storeRule(result, ruleSpec.getId())) {
          LOGGER.error("Cannot store result for rule result with id '{}'.", ruleSpec.getId());
        } else {
          LOGGER.info("Output for rule id '{}' successfully stored at <{}>.", ruleSpec.getId(),
              ruleSpec.getResultEndpoint());
        }
      } catch (final Exception e) {
        // cannot store result, just skip
        LOGGER.error(StringUtils.join("Cannot store result for rule result with id '", ruleSpec.getId(), "'."), e);
      }
    }
  }

  public RuleResult generateRules(final RuleSpecification ruleSpec) {
    LOGGER.info("Starting rules generation for rule id '{}' at '{}'.", ruleSpec.getId(), Instant.now().toString());
    if ((ruleSpec.getType() == null) || (ruleSpec.getTargetRelation() == null)
        || ruleSpec.getTargetRelation().isEmpty()) {
      return null;
    }
    try {
      // get subject and object type
      String subjType = ruleSpec.getSubjectType();
      String objType = ruleSpec.getObjectType();
      if ((subjType == null) || (objType == null) || subjType.isEmpty() || objType.isEmpty()) {
        final Pair<String, String> subjObjType = predicateSel.getPredicateTypes(ruleSpec.getTargetRelation().get(0));
        subjType = subjType == null ? subjObjType.getLeft() : subjType;
        objType = objType == null ? subjObjType.getRight() : objType;
        // set subject and object type in the specification
        ruleSpec.setSubjectType(subjType);
        ruleSpec.setObjectType(objType);
      }
      // compute examples
      final Set<Pair<String, String>> posExamples = getPositiveExamples(ruleSpec, subjType, objType);
      final Set<Pair<String, String>> negExamples = getNegativeExamples(ruleSpec, subjType, objType);
      Map<HornRule, Double> results;
      // reset statistics
      StatisticsContainer.initialiseContainer(ruleSpec.getId());
      // compute actual rules
      if (ruleSpec.getType() == TypeEnum.POSITIVE) {
        results = generatePositiveRules(ruleSpec, subjType, objType, posExamples, negExamples,
            ruleSpec.getCoverBound());
      } else {
        results = generateNegativeRules(ruleSpec, subjType, objType, posExamples, negExamples,
            ruleSpec.getCoverBound());
      }
      final int rulesSize = results != null ? results.size() : 0;
      LOGGER.info("Rule computation for rule id '{}' finished successfully at '{}' with {} rules generated.",
          ruleSpec.getId(), Instant.now().toString(), rulesSize);
      return buildResult(results, ruleSpec);
    } catch (final Exception e) {
      // create a fake result that incapsulate the exceptions
      LOGGER.error(
          StringUtils.join("Exception while computing results for rule with id '", buildResultId(ruleSpec), "'."), e);
      final RuleResult result = buildResult(null, ruleSpec);
      result.addMetadataItem(new KeyValuePair().key(Constant.ERROR_MESSAGE).value(ExceptionUtils.getStackTrace(e)));
      result.addMetadataItem(new KeyValuePair().key(Constant.ERROR_TIMESTAMP).value(Instant.now().toString()));
      return result;
    }
  }

  private Map<HornRule, Double> generatePositiveRules(final RuleSpecification ruleSpec, String subjType, String objType,
      final Set<Pair<String, String>> posExamples, final Set<Pair<String, String>> negExamples, Integer kBound) {
    if (kBound == null) {
      return this.rudik.discoverPositiveHornRules(negExamples, posExamples,
          Sets.newHashSet(ruleSpec.getTargetRelation()), subjType, objType);
    }
    return this.rudik.discoverAllPositiveHornRules(negExamples, posExamples,
        Sets.newHashSet(ruleSpec.getTargetRelation()), subjType, objType, kBound);
  }

  private Map<HornRule, Double> generateNegativeRules(final RuleSpecification ruleSpec, String subjType, String objType,
      final Set<Pair<String, String>> posExamples, final Set<Pair<String, String>> negExamples, Integer kBound) {
    if (kBound == null) {
      return this.rudik.discoverNegativeHornRules(negExamples, posExamples,
          Sets.newHashSet(ruleSpec.getTargetRelation()), subjType, objType);
    }
    return this.rudik.discoverAllNegativeHornRules(negExamples, posExamples,
        Sets.newHashSet(ruleSpec.getTargetRelation()), subjType, objType, kBound);
  }

  private RuleResult buildResult(final Map<HornRule, Double> ruleResults, final RuleSpecification ruleSpec) {
    final RuleResult result = new RuleResult();
    // id is the same of the specification plus current time stamp
    result.setId(buildResultId(ruleSpec));
    result.setSpecification(ruleSpec);
    // build output rules
    if (ruleResults != null) {
      ruleResults.forEach((k, v) -> {
        final asu.edu.rule_miner.api.model.HornRule apiRule = new asu.edu.rule_miner.api.model.HornRule();
        final HornRuleBody body = new HornRuleBody();
        k.getRules().forEach(atom -> {
          body.addAtomItem(new HornRuleAtom().predicate(atom.getRelation())
              .variablePair(new EntityPair().subject(atom.getSubject()).object(atom.getObject())));
        });
        apiRule.setBody(body);
        apiRule.setScore(v);
        // TODO: to be implemented
        apiRule.setGenerationCoverage(null);
        apiRule.setValidationCoverage(null);
        result.addRuleItem(apiRule);
      });
    }
    final RuleStatistics statistics = new RuleStatistics();
    statistics.setExpansionAvgTime(StatisticsContainer.getExpansionAvgTime());
    statistics.setExpansionTotTime(StatisticsContainer.getExpanasionTotTime());
    statistics.setExpansionQueries(StatisticsContainer.getNumberExpansionQueries());
    statistics.setNegativeExamplesTime(StatisticsContainer.getNegativeExamplesGenerationTime());
    statistics.setPositiveExamplesTime(StatisticsContainer.getPositiveExamplesGenerationTime());
    statistics.setRunTime(StatisticsContainer.getTotatlRuntime());
    statistics.setSubgraphEdges(StatisticsContainer.getSubgraphEdges());
    statistics.setSubgraphNodes(StatisticsContainer.getSubgraphNodes());
    statistics.setValidationAvgTime(StatisticsContainer.getValidationAvgTime());
    statistics.setValidationTotTime(StatisticsContainer.getValidationTotTime());
    statistics.setValidationQueries(StatisticsContainer.getNumberValidationQueries());
    result.setStatistics(statistics);
    return result;
  }

  private Set<Pair<String, String>> getPositiveExamples(final RuleSpecification ruleSpec, final String typeSubject,
      final String typeObject) {
    final Set<Pair<String, String>> specifiedExamples = getSpecifiedExamples(ruleSpec.getPositiveExamples());
    if (specifiedExamples != null) {
      return specifiedExamples;
    }
    // examples not specified, need to compute them
    Integer examplesLimit = ruleSpec.getGraph().getPositiveExamplesLimit();
    examplesLimit = examplesLimit == null ? -1 : examplesLimit;
    final Set<Pair<String, String>> examples = this.rudik.generatePositiveExamples(
        Sets.newHashSet(ruleSpec.getTargetRelation()), typeSubject, typeObject, examplesLimit);
    final List<EntityPair> specExamples = Lists.newArrayList();
    examples.forEach(p -> {
      specExamples.add(new EntityPair().subject(p.getLeft()).object(p.getRight()));
    });
    // set examples in the specification
    ruleSpec.setPositiveExamples(specExamples);
    return examples;
  }

  private Set<Pair<String, String>> getNegativeExamples(final RuleSpecification ruleSpec, final String typeSubject,
      final String typeObject) {
    final Set<Pair<String, String>> specifiedExamples = getSpecifiedExamples(ruleSpec.getNegativeExamples());
    if (specifiedExamples != null) {
      return specifiedExamples;
    }
    // examples not specified, need to compute them
    Integer examplesLimit = ruleSpec.getGraph().getNegativeExamplesLimit();
    examplesLimit = examplesLimit == null ? -1 : examplesLimit;
    final Set<Pair<String, String>> examples = this.rudik.generateNegativeExamples(
        Sets.newHashSet(ruleSpec.getTargetRelation()), typeSubject, typeObject, examplesLimit);
    final List<EntityPair> specExamples = Lists.newArrayList();
    examples.forEach(p -> {
      specExamples.add(new EntityPair().subject(p.getLeft()).object(p.getRight()));
    });
    // set examples in the specification
    ruleSpec.setNegativeExamples(specExamples);
    return examples;
  }

  private Set<Pair<String, String>> getSpecifiedExamples(final List<EntityPair> specifiedExamples) {
    if ((specifiedExamples == null) || specifiedExamples.isEmpty()) {
      return null;
    }
    final Set<Pair<String, String>> allExamples = Sets.newHashSet();
    specifiedExamples.forEach(en -> {
      allExamples.add(Pair.of(en.getSubject(), en.getObject()));
    });
    return allExamples;
  }

  /**
   * Build result id as <specId_curTimeStamp>
   * @param ruleSpec
   * @return
   */
  private String buildResultId(final RuleSpecification ruleSpec) {
    String ruleId = ruleSpec.getId();
    ruleId = ruleId == null ? "rule" : ruleId;
    return StringUtils.join(ruleId, "_", Instant.now().toEpochMilli());
  }

  @Override
  public void run() {
    this.generateAndStoreRules(this.ruleSpecification);
  }

}
