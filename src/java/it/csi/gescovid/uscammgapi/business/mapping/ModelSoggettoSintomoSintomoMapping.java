package it.csi.gescovid.uscammgapi.business.mapping;

import java.math.BigDecimal;

import it.csi.gescovid.uscammgapi.business.be.SintomiApi;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Ente;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Sintomo;
import it.csi.gescovid.uscammgapi.dto.ModelEnte;
import it.csi.gescovid.uscammgapi.dto.ModelSoggettoSintomo;

public class ModelSoggettoSintomoSintomoMapping extends BaseMapper<ModelSoggettoSintomo, Sintomo> {

	@Override
	public Sintomo to(ModelSoggettoSintomo source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelSoggettoSintomo from(Sintomo dest) {
		if(dest == null) {
			return null;
		}
		
		ModelSoggettoSintomo source = new ModelSoggettoSintomo();
		source.setIdSintomo(dest.getIdSintomo()!=null ? dest.getIdSintomo().intValue(): 0);
		source.setIdDecorso(dest.getIdDecorso()!=null ? dest.getIdDecorso().intValue(): 0);
		source.setTemperatura(dest.getTemperatura()!=null ? dest.getTemperatura(): new BigDecimal(0));
		source.setFlgDispnea(dest.getFlgDispnea()!=null ? dest.getFlgDispnea(): "");
		source.setFlgGusto(dest.getFlgGusto()!=null ? dest.getFlgGusto(): "");
		source.setFlgOlfatto(dest.getFlgOlfatto() !=null ? dest.getFlgOlfatto() : "");
		source.setFlgTosse(dest.getFlgTosse()!=null ? dest.getFlgTosse(): "");
		source.setFlgDoloriMusc(dest.getFlgDoloriMusc() !=null ? dest.getFlgDoloriMusc(): "");
		source.setFlgStanchezza(dest.getFlgStanchezza() !=null ? dest.getFlgStanchezza() : "");
		source.setFlgCongiuntivite(dest.getFlgCongiuntivite() !=null ? dest.getFlgCongiuntivite(): "");
		source.setFlgDiarrea(dest.getFlgDiarrea() !=null ? dest.getFlgDiarrea(): "");
		source.setFlgRaffreddore(dest.getFlgRaffreddore() !=null ? dest.getFlgRaffreddore(): "");
		
		source.setFlgCefalea(dest.getFlgCefalea() != null ? dest.getFlgCefalea() : "");
		source.setFlgFaringodinia(dest.getFlgFaringodinia() != null ? dest.getFlgFaringodinia() : "");
		
		source.setNoteSintomo(dest.getNoteSintomo() != null ? dest.getNoteSintomo() : "");
		

	
		return source;
		
	}

}
