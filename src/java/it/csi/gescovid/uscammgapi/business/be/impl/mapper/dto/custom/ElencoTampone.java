package it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Laboratorio;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.RisTampone;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Tampone;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.TamponeMotivo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.TestCovid;

public class ElencoTampone extends Tampone {

	private Laboratorio laboratorio;
	private TestCovid	testCovid;
	private RisTampone  risTampone;
	private TamponeMotivo tamponeMotivo;
	
	
	public TamponeMotivo getTamponeMotivo() {
		return tamponeMotivo;
	}
	public void setTamponeMotivo(TamponeMotivo tamponeMotivo) {
		this.tamponeMotivo = tamponeMotivo;
	}
	public Laboratorio getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}
	public TestCovid getTestCovid() {
		return testCovid;
	}
	public void setTestCovid(TestCovid testCovid) {
		this.testCovid = testCovid;
	}
	public RisTampone getRisTampone() {
		return risTampone;
	}
	public void setRisTampone(RisTampone risTampone) {
		this.risTampone = risTampone;
	}
	
	
	
}
