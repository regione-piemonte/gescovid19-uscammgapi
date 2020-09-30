package it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto;

public enum ProfiloEnum {
	
	MEDICO_USCA("MED USCA"), 
	MEDICO_118("MED EMERGENZA"), 
	MEDICO_CONTASSISTENZIALE("MED CONT ASS"), 
	MEDICO_MMG("Medico MMG"), MEDICO_GESTIONE_PAZIENTI("SuperUser Pazienti");
	
	private final String codice;
	
	
	ProfiloEnum(String codice) {
		this.codice = codice;

	}

	public String getCodice() {
		return codice;
	}

}
