package it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto;

import java.util.List;

public class UserLogged extends Utenti {
	
	private String nome;
	private String cognome;
	private String email;
	private String telefono;
	
	private List<Struttura> elencoStruttura;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public List<Struttura> getElencoStruttura() {
		return elencoStruttura;
	}
	public void setElencoStruttura(List<Struttura> elencoStruttura) {
		this.elencoStruttura = elencoStruttura;
	}

	

}
