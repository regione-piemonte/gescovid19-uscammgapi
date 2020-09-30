package it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.extended;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.DNotificaAzione;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.DNotificaEvento;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.DNotificaPriorita;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.DNotificaTipo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.DNotificaUtenteTipo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Medico;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Notifica;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Soggetto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.UtenteContatto;

public class NotificaExt extends Notifica {
	
	private Soggetto soggetto;
	private DNotificaPriorita dNotificaPriorita;
	private DNotificaTipo dNotificaTipo;
	private DNotificaEvento dNotificaEvento;
	private DNotificaAzione dNotificaAzione;
	private DNotificaUtenteTipo dNotificaUtenteTipo;
	private DNotificaUtenteTipo dNotificaUtenteTipoDest;
	private UtenteContatto utenteContatto;
	private Medico medico;
	
		
	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public UtenteContatto getUtenteContatto() {
		return utenteContatto;
	}

	public void setUtenteContatto(UtenteContatto utenteContatto) {
		this.utenteContatto = utenteContatto;
	}

	public DNotificaUtenteTipo getdNotificaUtenteTipoDest() {
		return dNotificaUtenteTipoDest;
	}

	public void setdNotificaUtenteTipoDest(DNotificaUtenteTipo dNotificaUtenteTipoDest) {
		this.dNotificaUtenteTipoDest = dNotificaUtenteTipoDest;
	}

	public DNotificaAzione getdNotificaAzione() {
		return dNotificaAzione;
	}

	public void setdNotificaAzione(DNotificaAzione dNotificaAzione) {
		this.dNotificaAzione = dNotificaAzione;
	}

	public DNotificaUtenteTipo getdNotificaUtenteTipo() {
		return dNotificaUtenteTipo;
	}

	public void setdNotificaUtenteTipo(DNotificaUtenteTipo dNotificaUtenteTipo) {
		this.dNotificaUtenteTipo = dNotificaUtenteTipo;
	}

	public DNotificaEvento getdNotificaEvento() {
		return dNotificaEvento;
	}

	public void setdNotificaEvento(DNotificaEvento dNotificaEvento) {
		this.dNotificaEvento = dNotificaEvento;
	}

	public DNotificaTipo getdNotificaTipo() {
		return dNotificaTipo;
	}

	public void setdNotificaTipo(DNotificaTipo dNotificaTipo) {
		this.dNotificaTipo = dNotificaTipo;
	}

	public DNotificaPriorita getdNotificaPriorita() {
		return dNotificaPriorita;
	}

	public void setdNotificaPriorita(DNotificaPriorita dNotificaPriorita) {
		this.dNotificaPriorita = dNotificaPriorita;
	}

	public Soggetto getSoggetto() {
		return soggetto;
	}

	public void setSoggetto(Soggetto soggetto) {
		this.soggetto = soggetto;
	}
	
	

}
