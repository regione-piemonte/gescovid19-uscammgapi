package it.csi.gescovid.uscammgapi.business.be;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
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
import it.csi.gescovid.uscammgapi.dto.ModelAdiCovidDettaglio;
import it.csi.gescovid.uscammgapi.dto.Payload9;

@Path("/adicovid-dettagli")
@Api(value = "adicovid-dettagli", produces = MediaType.APPLICATION_JSON)
@ApiResponsesDefault
public interface AdiCovidDettagliApi {
	
	

    @POST
    @Produces({ "application/json" })
    @ApiResponses(value = { 
    		@ApiResponse(code = 201, message = "Created", response = ModelAdiCovidDettaglio.class)
    })
    public Response adiCovidDettagliPost(
    		@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
    		@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
    		@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
    		@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
    		@HeaderParam("User-Agent") String userAgent,
    		@QueryParam("idAdiCovid") Integer idAdiCovid,

    		
    		
    		Payload9 payload,
    		@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

}
