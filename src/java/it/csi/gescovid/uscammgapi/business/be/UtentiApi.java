/**********************************************
 * CSI PIEMONTE 
 **********************************************/
package it.csi.gescovid.uscammgapi.business.be;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
import it.csi.gescovid.uscammgapi.dto.ModelUtenteContatto;
import it.csi.gescovid.uscammgapi.dto.Payload4;

@Path("/utenti")
@Api(value = "Utenti", produces = MediaType.APPLICATION_JSON)
@ApiResponsesDefault
public interface UtentiApi  {
   
    @PUT
    @Path("/{utente_cf}/contatti")
    @Produces({ "application/json" })
    @ApiResponses(value = { 
    		@ApiResponse(code = 200, message = "Success", response = ModelUtenteContatto.class)
    })
    public Response utentiUtenteCfContattiPut(
    		
    		@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
    		@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
    		@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
    		@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
    		@HeaderParam("User-Agent") String userAgent, 
    		
    		@PathParam("utente_cf") String utenteCf, 
    		Payload4 payload,
    		
    		@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );
}
