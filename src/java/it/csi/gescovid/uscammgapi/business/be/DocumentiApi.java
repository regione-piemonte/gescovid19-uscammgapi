/**********************************************
 * CSI PIEMONTE 
 **********************************************/
package it.csi.gescovid.uscammgapi.business.be;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.StreamingOutput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.csi.gescovid.uscammgapi.business.annotation.ApiResponsesDefault;

@Path("/documenti")
@Api(value = "documenti", produces = MediaType.APPLICATION_JSON)
@ApiResponsesDefault
public interface DocumentiApi  {
   
    @GET
    @Path("/{documento_id}")
    @ApiResponses(value = { 
    		@ApiResponse(code = 200, message = "Success", response = StreamingOutput.class)
    })
    public Response documentiDocumentoIdGet(
    		@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
    		@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
    		@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
    		@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
    		@HeaderParam("User-Agent") String userAgent,
    		
    		@PathParam("documento_id") String documentoId,
    		@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest );
}
