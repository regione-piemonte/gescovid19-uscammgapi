package it.csi.gescovid.uscammgapi.business.mapping;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.TestCovid;
import it.csi.gescovid.uscammgapi.dto.ModelSoggettoTestCovid;

public class ModelSoggettoTestCovidTestCovidMapping extends BaseMapper<ModelSoggettoTestCovid, TestCovid> {

	@Override
	public TestCovid to(ModelSoggettoTestCovid source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelSoggettoTestCovid from(TestCovid dest) {
		if(dest == null) {
			return null;
		}
		ModelSoggettoTestCovid source = new ModelSoggettoTestCovid();
		source.setIdTestCovid(dest.getIdTestCovid()!=null ? dest.getIdTestCovid().intValue(): 0);
		source.setTestCovid(dest.getTestCovid()!=null ? dest.getTestCovid(): "");
		return source;
		
	}

}
