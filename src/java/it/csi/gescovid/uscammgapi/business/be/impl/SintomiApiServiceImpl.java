package it.csi.gescovid.uscammgapi.business.be.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;

import it.csi.gescovid.uscammgapi.business.be.SintomiApi;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDSintomo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.SintomiMapper;
import it.csi.gescovid.uscammgapi.dto.ModelSintomo;
import it.csi.gescovid.uscammgapi.exception.RESTException;
import it.csi.gescovid.uscammgapi.util.CaConstants;
import it.csi.gescovid.uscammgapi.util.CaRet;
import it.csi.gescovid.uscammgapi.util.LogUtil;

public class SintomiApiServiceImpl extends RESTBaseService implements SintomiApi {

	@Autowired
	SintomiMapper sintomiMapper;

	LogUtil log = new LogUtil(this.getClass());

	@Override
	public Response sintomiGet(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String userAgent, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		String methodName = "sintomiGet";
		log.info(methodName, "BEGIN");
		try {
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);

			List<CovidusDSintomo> lista = sintomiMapper.selectAll();
			logAudit(httpHeaders, "select", "covidus_d_sintomo", "selectAll");

			// List<ModelDiarioDettaglioSintomo> listaSintomo = new
			// ModelDiarioDettaglioSintomoCovidusDSintomoMapping().fromList(lista);

			List<ModelSintomo> elencoSintomi = new ArrayList<ModelSintomo>();

			Iterator<CovidusDSintomo> iterator = lista.iterator();
			while (iterator.hasNext()) {
				CovidusDSintomo next = iterator.next();

				ModelSintomo modelSintomo = new ModelSintomo();
				modelSintomo.setCodice(next.getSinCod());
				modelSintomo.setId(next.getSinId());
				modelSintomo.setMisurabile(next.getSinMisurabile());
				modelSintomo.setNome(next.getSinDesc());
				modelSintomo.setUnitaMisura(next.getSinUnitaMisura());

				elencoSintomi.add(modelSintomo);
			}

			return Response.ok().entity(elencoSintomi).build();

		} catch (RESTException e) {
			log.error(methodName, " schedaStatiGet ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, "schedaStatiGet ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}
	}

}
