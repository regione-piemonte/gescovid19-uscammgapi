package it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto;

public enum StatoEnum {
	
	BOZZA("B"), 
	INVIATO("I"), 
	PRESO_IN_CARICO("P"), 
	ESEGUITO("E"), 
	RESPINTO("R");
	
	private final String codice;
	
	
	StatoEnum(String codice) {
		this.codice = codice;

	}

	public String getCodice() {
		return codice;
	}

}
