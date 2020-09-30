package it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDFarmaco;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDOssigenoTerapia;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusRSchedaPresc;

public class PrescrizioneSchedaCustomDto extends CovidusRSchedaPresc{

	private Integer schprescId;
	private String prescrizione;
	private Integer prescTipoId;
	private String prescTipoCod;
	private String prescTipoDesc;
	

	private CovidusDFarmaco farmaco;
	
	private CovidusDOssigenoTerapia ossigenoTerapia;
	
	public CovidusDFarmaco getFarmaco() {
		return farmaco;
	}

	public void setFarmaco(CovidusDFarmaco farmaco) {
		this.farmaco = farmaco;
	}

	public CovidusDOssigenoTerapia getOssigenoTerapia() {
		return ossigenoTerapia;
	}


	public void setOssigenoTerapia(CovidusDOssigenoTerapia ossigenoTerapia) {
		this.ossigenoTerapia = ossigenoTerapia;
	}

	public Integer getSchprescId() {
		return schprescId;
	}

	public void setSchprescId(Integer schprescId) {
		this.schprescId = schprescId;
	}

	public String getPrescrizione() {
		return prescrizione;
	}

	public void setPrescrizione(String prescrizione) {
		this.prescrizione = prescrizione;
	}

	public Integer getPrescTipoId() {
		return prescTipoId;
	}

	public void setPrescTipoId(Integer prescTipoId) {
		this.prescTipoId = prescTipoId;
	}

	public String getPrescTipoCod() {
		return prescTipoCod;
	}

	public void setPrescTipoCod(String prescTipoCod) {
		this.prescTipoCod = prescTipoCod;
	}

	public String getPrescTipoDesc() {
		return prescTipoDesc;
	}

	public void setPrescTipoDesc(String prescTipoDesc) {
		this.prescTipoDesc = prescTipoDesc;
	}

}
