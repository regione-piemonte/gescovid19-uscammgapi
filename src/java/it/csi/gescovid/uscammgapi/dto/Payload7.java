package it.csi.gescovid.uscammgapi.dto;

import java.util.List;
import java.util.Objects;

import org.codehaus.jackson.annotate.JsonProperty;



public class Payload7   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  
  private List<ModelNotificaPresaVisione> notifiche;

  @JsonProperty("notifiche") 
  public List<ModelNotificaPresaVisione> getNotifiche() {
	return notifiche;
  }

  public void setNotifiche(List<ModelNotificaPresaVisione> notifiche) {
	this.notifiche = notifiche;
  }


 
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Payload7 payload6 = (Payload7) o;
    return Objects.equals(notifiche, payload6.notifiche);
  }



  @Override
  public int hashCode() {
    return Objects.hash(notifiche);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Payload7 {\n");
    sb.append("    : ").append(toIndentedString("")).append("\n");
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

