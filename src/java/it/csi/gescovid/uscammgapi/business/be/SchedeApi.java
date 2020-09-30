/**********************************************
 * CSI PIEMONTE 
 **********************************************/
package it.csi.gescovid.uscammgapi.business.be;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.StreamingOutput;

import org.jboss.resteasy.annotations.GZIP;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;
import it.csi.gescovid.uscammgapi.business.annotation.ApiResponsesDefault;
import it.csi.gescovid.uscammgapi.dto.ModelInterventoAzione;
import it.csi.gescovid.uscammgapi.dto.ModelInterventoTipo;
import it.csi.gescovid.uscammgapi.dto.ModelScheda;
import it.csi.gescovid.uscammgapi.dto.Payload;
import it.csi.gescovid.uscammgapi.dto.Payload1;
import it.csi.gescovid.uscammgapi.dto.Payload2;
import it.csi.gescovid.uscammgapi.dto.Payload8;

@Path("/schede")
@Api(value = "schede", produces = MediaType.APPLICATION_JSON)
@ApiResponsesDefault
public interface SchedeApi  {
   
    @GET
    @Produces({ "application/json" })
    @GZIP
    @ApiResponses(value = { 
    		@ApiResponse(code = 200, message = "Success", response = ModelScheda.class, responseContainer = "List")
    })
    public Response schedeGet(
    		@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
    		@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
    		@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
    		@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
    		@HeaderParam("User-Agent") String userAgent, 
    		
    		@QueryParam("soggetto") Integer soggetto, @QueryParam("stati") String stati,
    		@QueryParam("medico") String medico,
    		
    		//filtri
    		@QueryParam("idMonitoraggioTipo") String idMonitoraggioTipo,
    		@QueryParam("filter") String filter,
    		@QueryParam("idStruttura") String idStrutturaStr,
    		@QueryParam("codSchStato") String codSchStato,
    		
    		//Paginazione
			@QueryParam("orderby") String orderby, 
			@QueryParam("rowPerPage") Long rowPerPage,
			@QueryParam("pageNumber") Long pageNumber,
			@QueryParam("descending") String descendingStr,
			
    		@Context SecurityContext securityContext,
    		@Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );
   
    @POST
    @Produces({ "application/json" })
    @ApiResponses(value = { 
    		@ApiResponse(code = 201, message = "Created", response = ModelScheda.class, responseHeaders = {@ResponseHeader(name = "Rows-Number", description = "Numero totale elementi", response = long.class)})
    })

    public Response schedePost(
    		@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
    		@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
    		@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
    		@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
    		@HeaderParam("User-Agent") String userAgent, 
    		
    		Payload payload,
    		@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );
    
    
    @GET
    @Path("/{scheda_id}/intervento-azioni")
    @Produces({ "application/json" })
    @ApiResponses(value = { 
    		@ApiResponse(code = 200, message = "Success", response = ModelInterventoAzione.class, responseContainer = "List")
    })

    public Response schedeSchedaIdInterventoAzioniGet(
    		@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
    		@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
    		@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
    		@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
    		@HeaderParam("User-Agent") String userAgent, 
    		
    		@PathParam("scheda_id") Integer schedaId,
    		@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );
    
    
    @POST
    @Path("/{scheda_id}/intervento")
    @Produces({ "application/json" })
    @ApiResponses(value = { 
    		@ApiResponse(code = 201, message = "Created", response = ModelScheda.class)
    })

    public Response schedeSchedaIdInterventoPost(
    		@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
    		@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
    		@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
    		@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
    		@HeaderParam("User-Agent") String userAgent, 
    		
    		@PathParam("scheda_id") Integer schedaId, Payload2 payload,
    		@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest );
    
    
    @GET
    @Path("/{scheda_id}/intervento-tipi")
    @Produces({ "application/json" })
    @ApiResponses(value = { 
    		@ApiResponse(code = 200, message = "Success", response = ModelInterventoTipo.class, responseContainer = "List")
    })
    public Response schedeSchedaIdInterventoTipiGet(@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
    		@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
    		@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
    		@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
    		@HeaderParam("User-Agent") String userAgent, 
    		
    		@PathParam("scheda_id") Integer schedaId,
    		@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );
    @PUT
    @Path("/{scheda_id}/stato")
    @Produces({ "application/json" })
    @ApiResponses(value = { 
    		@ApiResponse(code = 200, message = "Success", response = ModelScheda.class)
    })
    public Response schedeSchedaIdStatoPut(
    		@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
    		@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
    		@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
    		@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
    		@HeaderParam("User-Agent") String userAgent,
    		
    		
    		@PathParam("scheda_id") Integer schedaId,
    		@ApiParam(required = true) Payload1 payload,
    		@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );
    
    
    
    @PUT
    @Path("/{scheda_id}/visibilita")
    @Produces({ "application/json" })
    @ApiResponses(value = { 
    		@ApiResponse(code = 200, message = "Success", response = ModelScheda.class)
    })

    public Response schedeFlagVisibilitaPut(
    		@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
    		@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
    		@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
    		@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
    		@HeaderParam("User-Agent") String userAgent, 
    		@PathParam("scheda_id") Integer schedaId,
    		Payload payload,
    		@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );
    
    
    @PUT
    @Path("/{scheda_id}/terapiaCronica")
    @Produces({ "application/json" })
    @ApiResponses(value = { 
    		@ApiResponse(code = 200, message = "Success", response = ModelScheda.class)
    })

    public Response schedeTerapiaCronicaPut(
    		@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
    		@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
    		@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
    		@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
    		@HeaderParam("User-Agent") String userAgent, 
    		@PathParam("scheda_id") Integer schedaId,
    		Payload payload,
    		@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );
    
    @DELETE
    @Path("/interventi/{id_intervento}")
    @Produces({ "application/json" })
    @ApiResponses(value = { 
    		@ApiResponse(code = 200, message = "Success")
    })

    public Response schedeDeleteIntervento(
    		@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
    		@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
    		@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
    		@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
    		@HeaderParam("User-Agent") String userAgent, 
    		@PathParam("id_intervento") Integer idIntervento,
    		@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );
    
    
    
    
    @PUT
    @Path("/{scheda_id}/monitoraggio-tipo")
    @Produces({ "application/json" })
    @ApiResponses(value = { 
    		@ApiResponse(code = 200, message = "Success", response = ModelScheda.class)
    })

    public Response schedeMonitoraggioTipoPut(
    		@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
    		@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
    		@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
    		@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
    		@HeaderParam("User-Agent") String userAgent, 
    		@PathParam("scheda_id") Integer schedaId,
    		@ApiParam(required = true) Payload8 payload,
    		@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest ); 


    @GET
    @Path("/report/xlsx")
	@Produces({ "application/xlsx" })
    @ApiResponses(value = { 
    		@ApiResponse(code = 200, message = "Success", response = StreamingOutput.class)
    })
    public Response schedeGetXlsx(@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
    		@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
    		@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
    		@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
    		@HeaderParam("User-Agent") String userAgent, 
    		
    		@QueryParam("stati") String stati,
    		@ApiParam(required = true) @QueryParam("strutture") String strutture,
    		@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );


}
