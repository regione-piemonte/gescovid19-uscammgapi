package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.TamponeMotivo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.ElencoTampone;
import it.csi.gescovid.uscammgapi.dto.ModelSoggettoElencoTampone;

public class ModelSoggettoElencoTamponeElencoTamponeMapping extends BaseMapper<ModelSoggettoElencoTampone, ElencoTampone> {

	@Override
	public ElencoTampone to(ModelSoggettoElencoTampone source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelSoggettoElencoTampone from(ElencoTampone dest) {
		if(dest == null) {
			return null;
		}
		ModelSoggettoElencoTampone source = new ModelSoggettoElencoTampone();
		source.setIdTampone(dest.getIdTampone()!=null ? dest.getIdTampone().intValue() : 0);
		source.setIdSoggetto(dest.getIdSoggetto()!=null ? dest.getIdSoggetto().intValue(): 0);
		source.setIdLaboratorio(dest.getIdLaboratorio()!=null ? dest.getIdLaboratorio().intValue(): 0);
		source.setCriterioEpidemiologicoCovid19(dest.getCriterioEpidemiologicoCovid19()!=null ? dest.getCriterioEpidemiologicoCovid19(): "");
		source.setIdTestCovid(dest.getIdTestCovid()!=null ? dest.getIdTestCovid().intValue() : 0);
		source.setIdRisTamp(dest.getIdRisTamp()!=null ? dest.getIdRisTamp().intValue() : 0);
		source.setTamponeAutorizzato(dest.getTamponeAutorizzato()!=null ? dest.getTamponeAutorizzato() : "" );
		source.setDataInserimentoRichiesta(dest.getDataInserimentoRichiesta()!=null ? dest.getDataInserimentoRichiesta(): null);
		source.setDataUltimaModifica(dest.getDataUltimaModifica()!=null ? dest.getDataUltimaModifica() : null);
		source.setUtenteUltimaModifica(dest.getUtenteUltimaModifica()!=null ? dest.getUtenteUltimaModifica() : "");
		source.setDataTest(dest.getDataTest()!=null ? dest.getDataTest() : null);
        source.setMedicoRichiedente(dest.getMedicoRichiedente() !=null ? dest.getMedicoRichiedente() : "" );
		source.setContattoRichiedente(dest.getContattoRichiedente()!= null ? dest.getContattoRichiedente() : "");
        source.setRisTampone(dest.getRisTampone()!=null ? dest.getRisTampone().getRisultatoTampone(): "");
                
        source.setLaboratorio(new ModelLaboratorioLaboratorioMapping().from(dest.getLaboratorio()));
        source.setTestCovid(new ModelSoggettoTestCovidTestCovidMapping().from(dest.getTestCovid()));
        
        //Raffa 10-06-2020motivo tampone
        TamponeMotivo tamponeMotivo = new TamponeMotivo();
        if(dest.getTamponeMotivo()!=null) {
        	 source.setTamponeMotivo(dest.getTamponeMotivo());
	    }       
        
		return source;
	}

}
