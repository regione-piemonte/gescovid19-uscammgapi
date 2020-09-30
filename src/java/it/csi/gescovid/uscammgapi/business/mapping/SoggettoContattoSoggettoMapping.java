package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Soggetto;
import it.csi.gescovid.uscammgapi.dto.ModelSoggettoContatto;

public class SoggettoContattoSoggettoMapping extends BaseMapper<ModelSoggettoContatto, Soggetto> {

	@Override
	public Soggetto to(ModelSoggettoContatto source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelSoggettoContatto from(Soggetto dest) {
		if(dest == null) {
			return null;
		}
		ModelSoggettoContatto source = new ModelSoggettoContatto();

		source.setIdSoggetto(dest.getIdSoggetto() != null ? dest.getIdSoggetto().intValue(): 0);
        source.setCodiceFiscale(dest.getCodiceFiscale() !=null ? dest.getCodiceFiscale(): "");
        source.setCognome(dest.getCognome()!=null ? dest.getCognome(): "");
        source.setNome(dest.getNome()!=null ? dest.getNome(): "");
		source.setTelefonoRecapito(dest.getTelefonoRecapito() !=null ? dest.getTelefonoRecapito() : "");
		source.setDataNascita(dest.getDataNascita() !=null ? dest.getDataNascita(): null);
		
		source.setAslResidenza(dest.getAslResidenza() !=null ? dest.getAslResidenza() : "");
		source.setAslDomicilio(dest.getAslDomicilio() !=null ? dest.getAslDomicilio() : "");
		
		source.setEmail(dest.getEmail()!=null ? dest.getEmail(): "");
	
		return source;
	}

}
