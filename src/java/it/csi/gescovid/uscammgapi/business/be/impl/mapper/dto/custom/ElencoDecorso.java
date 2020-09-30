package it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Area;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Comuni;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.DecodeTipoEvento;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Decorso;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Ente;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.EsitoDimissioni;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.RepartoRicovero;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Sintomo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Struttura;


public class ElencoDecorso extends Decorso {
	
	private Comuni comuneRicovero;
	private EsitoDimissioni esitoDimissioni;
	private RepartoRicovero repartoRicovero;
	private DecodeTipoEvento decodeTipoEvento;
	private Area area;
	private Struttura struttura;
	private Ente ente;
	private Sintomo sintomo;
	
	public Sintomo getSintomo() {
		return sintomo;
	}
	public void setSintomo(Sintomo sintomo) {
		this.sintomo = sintomo;
	}
	public DecodeTipoEvento getDecodeTipoEvento() {
		return decodeTipoEvento;
	}
	public void setDecodeTipoEvento(DecodeTipoEvento decodeTipoEvento) {
		this.decodeTipoEvento = decodeTipoEvento;
	}
	public Comuni getComuneRicovero() {
		return comuneRicovero;
	}
	public void setComuneRicovero(Comuni comuneRicovero) {
		this.comuneRicovero = comuneRicovero;
	}
	public EsitoDimissioni getEsitoDimissioni() {
		return esitoDimissioni;
	}
	public void setEsitoDimissioni(EsitoDimissioni esitoDimissioni) {
		this.esitoDimissioni = esitoDimissioni;
	}
	public RepartoRicovero getRepartoRicovero() {
		return repartoRicovero;
	}
	public void setRepartoRicovero(RepartoRicovero repartoRicovero) {
		this.repartoRicovero = repartoRicovero;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public Struttura getStruttura() {
		return struttura;
	}
	public void setStruttura(Struttura struttura) {
		this.struttura = struttura;
	}
	public Ente getEnte() {
		return ente;
	}
	public void setEnte(Ente ente) {
		this.ente = ente;
	}
	

	
}
