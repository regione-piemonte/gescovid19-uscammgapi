package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.ElencoDecorso;
import it.csi.gescovid.uscammgapi.dto.ModelSoggettoElencoDecorso;

public class ModelSoggettoElencoDecorsoElencoDecorsoMapping extends BaseMapper<ModelSoggettoElencoDecorso, ElencoDecorso> {

	@Override
	public ElencoDecorso to(ModelSoggettoElencoDecorso source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelSoggettoElencoDecorso from(ElencoDecorso dest) {
		if(dest == null) {
			return null;
		}
		ModelSoggettoElencoDecorso source = new ModelSoggettoElencoDecorso();

		source.setIdDecorso(dest.getIdDecorso() !=null ? dest.getIdDecorso().intValue(): 0 );
		source.setIdSoggetto(dest.getIdSoggetto() != null ? dest.getIdSoggetto().intValue(): 0);
		source.setLuogoPaziente(dest.getLuogoPaziente() !=null ? dest.getLuogoPaziente() : "");
        source.setDescrizioneContesto(dest.getDescrizioneContesto() !=null ? dest.getDescrizioneContesto(): "");
        source.setComuneRicoveroIstat(dest.getComuneRicoveroIstat()!=null ? dest.getComuneRicoveroIstat(): "");
		source.setIdRepRicovero(dest.getIdRepRicovero() !=null ? dest.getIdRepRicovero().intValue() : 0);
		source.setCondizioniCliniche(dest.getCondizioniCliniche() !=null ? dest.getCondizioniCliniche() : "");
		source.setIdDimiss(dest.getIdDimiss() !=null ? dest.getIdDimiss().intValue() : 0);
		source.setSintomi(dest.getSintomi() !=null ? dest.getSintomi() : "");
		source.setOspedaleRicovero(dest.getOspedaleRicovero() !=null ? dest.getOspedaleRicovero() : "");
		source.setDataDimissioni(dest.getDataDimissioni() !=null ? dest.getDataDimissioni(): null);
		source.setDataInizioSint(dest.getDataInizioSint()!=null ? dest.getDataInizioSint(): null);
		source.setDataEvento(dest.getDataEvento() !=null ? dest.getDataEvento() : null);
		source.setIdTipoEvento(dest.getIdTipoEvento() !=null ? dest.getIdTipoEvento() : 0);
		source.setIdAreaa(dest.getIdArea()!=null ? dest.getIdArea() : 0);
		source.setNote(dest.getNote() !=null ? dest.getNote() : "");
		source.setDataPrevFineEvento(dest.getDataPrevFineEvento() !=null ? dest.getDataPrevFineEvento(): null);
		source.setIndirizzoDecorso(dest.getIndirizzoDecorso() !=null ? dest.getIndirizzoDecorso() : "");
		source.setDecorsoPresso(dest.getDecorsoPresso()!=null ? dest.getDecorsoPresso(): "");
		source.setComuneRicovero(dest.getComuneRicovero()!=null ? dest.getComuneRicovero().getNomeComune(): "");
		source.setEsitoDimissioni(dest.getEsitoDimissioni() != null ? dest.getEsitoDimissioni().getEsitoDim() : "");
		source.setRepartoRicovero(dest.getRepartoRicovero()!=null ? dest.getRepartoRicovero().getRepartoRicovero(): "");
		
		source.setDecodeTipoEvento(new ModelSoggettoDecodeTipoEventoDecodeTipoEventoMapping().from(dest.getDecodeTipoEvento()));
		source.setSintomo(new ModelSoggettoSintomoSintomoMapping().from(dest.getSintomo()));
		
		source.setArea(new ModelSoggettoAreaAreaMapping().from(dest.getArea()));
		source.setStruttura(new ModelUtenteElencoStrutturaStrutturaMapping().from(dest.getStruttura()));

	        

//	        "medico": "string",
//	        "tipoSoggetto": "string"
//	      }
		
		
		return source;
	}

}
