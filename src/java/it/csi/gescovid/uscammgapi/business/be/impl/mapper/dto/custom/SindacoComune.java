package it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Comuni;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Sindaco;


public class SindacoComune extends Sindaco{

	private Comuni comune;

	public Comuni getComune() {
		return comune;
	}

	public void setComune(Comuni comune) {
		this.comune = comune;
	}
	
	
}
