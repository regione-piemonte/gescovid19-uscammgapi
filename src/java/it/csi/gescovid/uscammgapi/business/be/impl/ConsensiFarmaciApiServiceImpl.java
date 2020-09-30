package it.csi.gescovid.uscammgapi.business.be.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import it.csi.gescovid.uscammgapi.business.be.ConsensiFarmaciApi;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDConsensoTipo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDFarmaco;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTConsensoFarmaco;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTFile;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.ConsensiFarmaciMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.ConsensoFarmacoTFileMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.ConsensoTipoMapper;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.FarmacoTipoMapper;
import it.csi.gescovid.uscammgapi.business.mapping.ModelConsensoFarmacoCovidusTConsensoFarmacoMapping;
import it.csi.gescovid.uscammgapi.business.mapping.ModelConsensoTipoCovidusDConsensoTipoMapping;
import it.csi.gescovid.uscammgapi.business.mapping.ModelDocumentoCovidusTFileMapping;
import it.csi.gescovid.uscammgapi.business.mapping.ModelFarmacoCovidusDFarmacoMapping;
import it.csi.gescovid.uscammgapi.dto.ModelConsensoFarmaco;
import it.csi.gescovid.uscammgapi.dto.ModelConsensoTipo;
import it.csi.gescovid.uscammgapi.dto.ModelDocumento;
import it.csi.gescovid.uscammgapi.dto.ModelFarmaco;
import it.csi.gescovid.uscammgapi.exception.ErroreBuilder;
import it.csi.gescovid.uscammgapi.exception.RESTException;
import it.csi.gescovid.uscammgapi.util.CaConstants;
import it.csi.gescovid.uscammgapi.util.CaRet;
import it.csi.gescovid.uscammgapi.util.LogUtil;

public class ConsensiFarmaciApiServiceImpl extends RESTBaseService implements ConsensiFarmaciApi {
	
	@Autowired
	ConsensiFarmaciMapper consensiFarmaciMapper;
	
	@Autowired
	ConsensoFarmacoTFileMapper consensoFarmacoTFileMapper;
	
	@Autowired
	FarmacoTipoMapper farmacoTipoMapper;
	
	@Autowired
	ConsensoTipoMapper consensoTipoMapper;
	
	LogUtil log =  new LogUtil(this.getClass());


	@Override
	public Response consensiFarmaciGet(String shibIdentitaCodiceFiscale, String xApplicazioneCodice, String xRequestId,
			String xForwardedFor, String userAgent, Integer soggetto, Integer farmaco, Integer tipo,
			SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		
		String methodName = "consensiFarmaciGet";
		log.info(methodName, "BEGIN");
		try {
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			
			logAudit(httpHeaders, "select", "covidus_t_consenso_farmaco", methodName);
			
			List<CovidusTConsensoFarmaco> listaConsensiFarmaci =  consensiFarmaciMapper.selectConsensiByFiltro(soggetto, farmaco, tipo);
			
			List<ModelConsensoFarmaco> listaConsensiFarmaciRitorno = new ArrayList<>();
			
			if(listaConsensiFarmaci!=null && !listaConsensiFarmaci.isEmpty()) {
			
				for (CovidusTConsensoFarmaco covidusTConsensoFarmaco : listaConsensiFarmaci) {
					
					ModelConsensoFarmaco consensoFarmaco = new ModelConsensoFarmacoCovidusTConsensoFarmacoMapping().from(covidusTConsensoFarmaco);
					
					// Carico il farmaco e il tipo consenso
					CovidusDFarmaco dfarmaco = farmacoTipoMapper.selectByFarmaid(covidusTConsensoFarmaco.getFarmId());
					ModelFarmaco mfarmaco = new ModelFarmacoCovidusDFarmacoMapping().from(dfarmaco);
					consensoFarmaco.setFarmaco(mfarmaco);
					
					CovidusDConsensoTipo dconsensotipo = consensoTipoMapper.selectByPrimaryKey(covidusTConsensoFarmaco.getConsTipoId());
					ModelConsensoTipo tipoconsenso = new ModelConsensoTipoCovidusDConsensoTipoMapping().from(dconsensotipo);
					consensoFarmaco.setTipo(tipoconsenso);
					
					// Carico i docs
					List<CovidusTFile> tfiles = consensoFarmacoTFileMapper.selectInfoConsensiTFileByIdConsensoFarmaco(covidusTConsensoFarmaco.getConsfarmId());
					List<ModelDocumento> documenti = new ArrayList<>();
					
					if(tfiles!=null && !tfiles.isEmpty()) {
						
						for (CovidusTFile covidusTFile : tfiles) {
							ModelDocumento documento = new ModelDocumentoCovidusTFileMapping().from(covidusTFile);
							documenti.add(documento);						
						}
						
						consensoFarmaco.setDocumenti(documenti);
					}
									
					listaConsensiFarmaciRitorno.add(consensoFarmaco);
				}
			}
			
			return Response.ok(listaConsensiFarmaciRitorno).build();
			
		}  catch (RESTException e) {
			log.error(methodName, " consensiFarmaciGet ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, " consensiFarmaciGet ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}
	}

	

}
