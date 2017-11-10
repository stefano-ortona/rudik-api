/**
 * RuDiK 1.0 Async APIs Collection of APIs for inducing declarative rules with RuDiK and few others utility methods for
 * RDF knowledge graphs accesible via a SPARQL endpoint.
 *
 * OpenAPI spec version: 1.0.0 Contact: stefano.ortona@meltwater.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package asu.edu.rule_miner.api.api;

import org.junit.Test;

import asu.edu.api.model.RuleExample;
import asu.edu.api.model.RuleSpecification;
import asu.edu.rule_miner.api.service.ApiException;

/**
 * API tests for ExampleApi
 */
public class ExampleApiTest {

  private final ExampleApi api = new ExampleApi();

  /**
   * Positive and Negative Example Generation
   *
   * Generate positive and negative examples for the given target predicate. If types of subject and/or object are not
   * specified, then the most common ones from the graph will be used.
   *
   * @throws ApiException if the Api call fails
   */
  @Test
  public void exampleGenerationTest() throws ApiException {
    final RuleSpecification predicateSpecification = new RuleSpecification();
    final RuleExample response = api.exampleGeneration(predicateSpecification);

    // TODO: test validations
  }

  /**
   * Most Common Type Example Generation
   *
   * Generate most common types for subject and object examples for the given input target predicate according to the
   * graph.
   *
   * @throws ApiException if the Api call fails
   */
  @Test
  public void exampleTypeTest() throws ApiException {
    final RuleSpecification predicateSpecification = null;
    // EntityPair response = api.exampleType(predicateSpecification);

    // TODO: test validations
  }

}
