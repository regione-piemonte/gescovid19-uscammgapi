/**********************************************
 * CSI PIEMONTE 
 **********************************************/
package it.csi.gescovid.uscammgapi.business.be;

import it.csi.gescovid.uscammgapi.business.annotation.ApiResponsesDefault;
import it.csi.gescovid.uscammgapi.dto.*;

import java.util.List;
import java.util.Map;

import java.io.InputStream;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.SecurityContext;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.validation.constraints.*;

@Path("/diari")
@Api(value = "diari", produces = MediaType.APPLICATION_JSON)
@ApiResponsesDefault
public interface DiariApi  {
   
    @GET
    @Produces({ "application/json" })
    @ApiResponses(value = { 
    		@ApiResponse(code = 200, message = "Success", response = ModelDiario.class, responseContainer = "List")
    })
    public Response diariGet(
    		@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
    		@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
    		@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
    		@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
    		@HeaderParam("User-Agent") String userAgent, 
    		
    		@QueryParam("soggetto") Integer soggetto,
    		@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest );
}
