package it.csi.gescovid.uscammgapi.dto;

import java.util.Objects;

import org.codehaus.jackson.annotate.JsonProperty;

public class Payload8   {
  // verra' utilizzata la seguente strategia serializzazione degli attributi: [explicit-as-modeled] 
  
  private Integer idTipoMonitoraggio = null;

 
  
  @Override
  public boolean equals(Object o) {
	    if (this == o) {
	    	return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	    	return false;
	    }
	    Payload8 payload8 = (Payload8) o;
	    return Objects.equals(idTipoMonitoraggio, payload8.idTipoMonitoraggio);
  }


  /**
   * Il codice del monitoraggio tipo  da usare 
   **/
  @JsonProperty("idTipoMonitoraggio") 
  public Integer getIdTipoMonitoraggio() {
	return idTipoMonitoraggio;
  }

  public void setIdTipoMonitoraggio(Integer idTipoMonitoraggio) {
		this.idTipoMonitoraggio = idTipoMonitoraggio;
  }



  @Override
  public int hashCode() {
    return Objects.hash(idTipoMonitoraggio);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Payload8 {\n");    
    sb.append("    idTipoMonitoraggio: ").append(toIndentedString(idTipoMonitoraggio)).append("\n");
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

