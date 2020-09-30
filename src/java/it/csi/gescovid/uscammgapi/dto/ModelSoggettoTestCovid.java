package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;
import javax.validation.constraints.*;

public class ModelSoggettoTestCovid   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private Integer idTestCovid = null;
  private String testCovid = null;

  /**
   **/
  

  @JsonProperty("idTestCovid") 
 
  public Integer getIdTestCovid() {
    return idTestCovid;
  }
  public void setIdTestCovid(Integer idTestCovid) {
    this.idTestCovid = idTestCovid;
  }

  /**
   **/
  

  @JsonProperty("testCovid") 
 
  public String getTestCovid() {
    return testCovid;
  }
  public void setTestCovid(String testCovid) {
    this.testCovid = testCovid;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelSoggettoTestCovid modelSoggettoTestCovid = (ModelSoggettoTestCovid) o;
    return Objects.equals(idTestCovid, modelSoggettoTestCovid.idTestCovid) &&
        Objects.equals(testCovid, modelSoggettoTestCovid.testCovid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idTestCovid, testCovid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelSoggettoTestCovid {\n");
    
    sb.append("    idTestCovid: ").append(toIndentedString(idTestCovid)).append("\n");
    sb.append("    testCovid: ").append(toIndentedString(testCovid)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

