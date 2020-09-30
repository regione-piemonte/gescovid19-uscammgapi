package it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.extended;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Utenti;

public class UtentiExt extends Utenti {

	private Long id;
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
