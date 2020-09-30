package it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom;

public class InformazioniUtenteCustomDto {

	// Info utente
	private String utenteCf;
	private String utenteNome;
	private String utenteCognome;
	private String utenteTelefono;
	private String utenteEmail;

	// Info struttura
	private String strutturaId;
	private String strutturaNome;
	private String strutturaNatura;

	// Info profilo
	private String profiloNome;

	// Info ente
	private String enteNome;
	private Integer enteId;
	
	

	public Integer getEnteId() {
		return enteId;
	}

	public void setEnteId(Integer enteId) {
		this.enteId = enteId;
	}

	public String getUtenteCf() {
		return utenteCf;
	}

	public void setUtenteCf(String utenteCf) {
		this.utenteCf = utenteCf;
	}

	public String getUtenteNome() {
		return utenteNome;
	}

	public void setUtenteNome(String utenteNome) {
		this.utenteNome = utenteNome;
	}

	public String getUtenteCognome() {
		return utenteCognome;
	}

	public void setUtenteCognome(String utenteCognome) {
		this.utenteCognome = utenteCognome;
	}

	public String getUtenteTelefono() {
		return utenteTelefono;
	}

	public void setUtenteTelefono(String utenteTelefono) {
		this.utenteTelefono = utenteTelefono;
	}

	public String getUtenteEmail() {
		return utenteEmail;
	}

	public void setUtenteEmail(String utenteEmail) {
		this.utenteEmail = utenteEmail;
	}

	public String getStrutturaId() {
		return strutturaId;
	}

	public void setStrutturaId(String strutturaId) {
		this.strutturaId = strutturaId;
	}

	public String getStrutturaNome() {
		return strutturaNome;
	}

	public void setStrutturaNome(String strutturaNome) {
		this.strutturaNome = strutturaNome;
	}

	public String getStrutturaNatura() {
		return strutturaNatura;
	}

	public void setStrutturaNatura(String strutturaNatura) {
		this.strutturaNatura = strutturaNatura;
	}

	public String getProfiloNome() {
		return profiloNome;
	}

	public void setProfiloNome(String profiloNome) {
		this.profiloNome = profiloNome;
	}

	public String getEnteNome() {
		return enteNome;
	}

	public void setEnteNome(String enteNome) {
		this.enteNome = enteNome;
	}

}
