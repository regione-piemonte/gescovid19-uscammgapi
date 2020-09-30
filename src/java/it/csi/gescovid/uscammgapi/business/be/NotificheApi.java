/**********************************************
 * CSI PIEMONTE 
 **********************************************/
package it.csi.gescovid.uscammgapi.business.be;

import javax.servlet.http.HttpServletRequest;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.csi.gescovid.uscammgapi.business.annotation.ApiResponsesDefault;
import it.csi.gescovid.uscammgapi.dto.Payload5;
import it.csi.gescovid.uscammgapi.dto.Payload6;
import it.csi.gescovid.uscammgapi.dto.Payload7;

@Path("/notifiche")
@Api(value = "notifiche", produces = MediaType.APPLICATION_JSON)
@ApiResponsesDefault
public interface NotificheApi  {
   
    @GET
    @Produces({ "application/json" })
    @ApiResponses(value = { 
    		@ApiResponse(code = 200, message = "Success")
    })
    public Response notificheGet(
    		@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
    		@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
    		@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
    		@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
    		@HeaderParam("User-Agent") String userAgent,
    		
    		//@QueryParam("struttura") Integer struttura,
    		//@QueryParam("priorita") String priorita, 
    		//@QueryParam("soggetto") Integer soggetto, 
    		@QueryParam("idEnte") Integer idEnte,
    		@QueryParam("struttura") String struttura,
    		@QueryParam("tipoUtenteMitt") String tipoUtenteMitt,
    		@QueryParam("tipoUtenteDest") String tipoUtenteDest,
    		@QueryParam("cfUtenteDestinatario") String cfUtenteDestinatario,
    		
    		
    		@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );
    
    
    @GET
    @Path("count")
    @Produces({ "application/json" })
    @ApiResponses(value = { 
    		@ApiResponse(code = 200, message = "Success")
    })
    public Response notificheCountGet(
    		@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
    		@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
    		@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
    		@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
    		@HeaderParam("User-Agent") String userAgent,
    		
    		//@QueryParam("struttura") Integer struttura,
    		//@QueryParam("priorita") String priorita, 
    		//@QueryParam("soggetto") Integer soggetto, 
    		@QueryParam("idEnte") Integer idEnte,
    		@QueryParam("struttura") String struttura,
    		@QueryParam("tipoUtenteMitt") String tipoUtenteMitt,
    		@QueryParam("tipoUtenteDest") String tipoUtenteDest,
    		@QueryParam("cfUtenteDestinatario") String cfUtenteDestinatario,
    		@QueryParam("eventoCodeIn") String eventoCodeInParam,
    		@QueryParam("eventoCodeNotIn") String eventoCodeNotInParam,
    		@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );
    
    @GET
    @Path("count-by-tipo")
    @Produces({ "application/json" })
    @ApiResponses(value = { 
    		@ApiResponse(code = 200, message = "Success")
    })
    public Response notificheCountByTipoGet(
    		@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
    		@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
    		@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
    		@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
    		@HeaderParam("User-Agent") String userAgent,
    		
    		//@QueryParam("struttura") Integer struttura,
    		//@QueryParam("priorita") String priorita, 
    		//@QueryParam("soggetto") Integer soggetto, 
    		@QueryParam("idEnte") Integer idEnte,
    		@QueryParam("struttura") String struttura,
    		@QueryParam("tipoUtenteMitt") String tipoUtenteMitt,
    		@QueryParam("tipoUtenteDest") String tipoUtenteDest,
    		@QueryParam("cfUtenteDestinatario") String cfUtenteDestinatario,
    		@QueryParam("tipoCodeIn") String tipoCodeInParam,
    		@QueryParam("tipoCodeNotIn") String tipoCodeNotInParam,    		
    		@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );
    
   
    @POST
    @Produces({ "application/json" })
    @ApiResponses(value = { 
    		@ApiResponse(code = 201, message = "Created")
    })
    public Response notifichePost(
    		@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
    		@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
    		@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
    		@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
    		@HeaderParam("User-Agent") String userAgent,
    		
    		Payload5 payload,
    		@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

    
    @PUT
    @Path("/{notifica_id}/azione")
    @Produces({ "application/json" })
    @ApiResponses(value = { 
    		@ApiResponse(code = 200, message = "Success")
    })
    public Response notificaIdAzionePut(
    		@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
    		@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
    		@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
    		@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
    		@HeaderParam("User-Agent") String userAgent,
    		
    		@PathParam("notifica_id") Integer notificaId,
    		Payload6 payload,
    		
    		@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );
    
    
    @PUT
    @Path("/presa-visione")
    @Produces({ "application/json" })
    @ApiResponses(value = { 
    		@ApiResponse(code = 200, message = "Success")
    })
    public Response notifichePresaVisionePut(
    		@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
    		@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
    		@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
    		@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
    		@HeaderParam("User-Agent") String userAgent,
    		Payload7 payload,
    		@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );
}
