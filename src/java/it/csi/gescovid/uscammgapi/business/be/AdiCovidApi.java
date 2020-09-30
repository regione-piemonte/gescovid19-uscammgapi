package it.csi.gescovid.uscammgapi.business.be;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
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
import it.csi.gescovid.uscammgapi.dto.ModelAdiCovid;
import it.csi.gescovid.uscammgapi.dto.Payload10;

@Path("/adicovid")
@Api(value = "adicovid", produces = MediaType.APPLICATION_JSON)
@ApiResponsesDefault
public interface AdiCovidApi {
	
	@GET
    @Produces({ "application/json" })
    @ApiResponses(value = { 
    		@ApiResponse(code = 200, message = "Success", response = ModelAdiCovid.class, responseContainer = "List")
    })
    public Response adiCovidGet(
    		@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
    		@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
    		@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
    		@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
    		@HeaderParam("User-Agent") String userAgent, 
    		@QueryParam("idAdiCovid") Integer idAdiCovid,

    		
    		@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest );


	@PUT
    @Path("/{adicovid_id}/chiudi-monitoraggio")
    @Produces({ "application/json" })
    @ApiResponses(value = { 
    		@ApiResponse(code = 200, message = "Success")
    })
    public Response adiCovidChiudiMonitoraggioPut(
    		@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
    		@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
    		@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
    		@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
    		@HeaderParam("User-Agent") String userAgent, 
    		
    		@PathParam("adicovid_id") Integer adicovidId, Payload10 payload,
    		@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest );

}
