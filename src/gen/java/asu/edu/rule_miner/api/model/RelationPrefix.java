package asu.edu.rule_miner.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * RelationPrefix
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-20T17:54:27.167Z")
public class RelationPrefix   {
  private String name = null;

  private String uri = null;

  public RelationPrefix name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name to assign to the current RDF prefix.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Name to assign to the current RDF prefix.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public RelationPrefix uri(String uri) {
    this.uri = uri;
    return this;
  }

   /**
   * URI of the prefix
   * @return uri
  **/
  @ApiModelProperty(required = true, value = "URI of the prefix")
  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RelationPrefix relationPrefix = (RelationPrefix) o;
    return Objects.equals(this.name, relationPrefix.name) &&
        Objects.equals(this.uri, relationPrefix.uri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, uri);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RelationPrefix {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

