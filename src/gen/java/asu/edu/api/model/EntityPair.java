package asu.edu.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * EntityPair
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-08T12:52:36.960Z")
public class EntityPair   {
  private String subject = null;

  private String object = null;

  public EntityPair subject(String subject) {
    this.subject = subject;
    return this;
  }

   /**
   * Subject entity of the entity pair.
   * @return subject
  **/
  @ApiModelProperty(required = true, value = "Subject entity of the entity pair.")
  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public EntityPair object(String object) {
    this.object = object;
    return this;
  }

   /**
   * Object entity of the entity pair.
   * @return object
  **/
  @ApiModelProperty(required = true, value = "Object entity of the entity pair.")
  public String getObject() {
    return object;
  }

  public void setObject(String object) {
    this.object = object;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EntityPair entityPair = (EntityPair) o;
    return Objects.equals(this.subject, entityPair.subject) &&
        Objects.equals(this.object, entityPair.object);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subject, object);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EntityPair {\n");
    
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    object: ").append(toIndentedString(object)).append("\n");
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

