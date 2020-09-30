/**********************************************
 * CSI PIEMONTE 
 **********************************************/
package it.csi.gescovid.uscammgapi.business.be;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.jboss.resteasy.annotations.GZIP;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.csi.gescovid.uscammgapi.business.annotation.ApiResponsesDefault;
import it.csi.gescovid.uscammgapi.dto.ModelSoggetto;

@Path("/soggetti")
@Api(value = "Soggetti", produces = MediaType.APPLICATION_JSON)
@ApiResponsesDefault
public interface SoggettiApi  {
   
    @GET
    @Path("/{soggetto_id}")
    @Produces({ "application/json" })
    @GZIP
    @ApiResponses(value = { 
    		@ApiResponse(code = 200, message = "Success", response = ModelSoggetto.class)
    })
    public Response soggettiSoggettoIdGet(
    		@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
    		@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
    		@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
    		@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
    		@HeaderParam("User-Agent") String userAgent, 
    		
    		@PathParam("soggetto_id") Integer soggettoId,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );
    
    @GET
    @Path("/by-cf/{codice_fiscale}")
    @Produces({ "application/json" })
    @GZIP
    @ApiResponses(value = { 
    		@ApiResponse(code = 200, message = "Success", response = ModelSoggetto.class)
    })
    public Response soggettiSoggettoCfGet(
    		@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
    		@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
    		@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
    		@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
    		@HeaderParam("User-Agent") String userAgent, 
    		
    		@PathParam("codice_fiscale") String codiceFiscale,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );


    @GET
    @Path("/by-nome-cognome/{nome}/{cognome}/{dataNascita}")
    @Produces({ "application/json" })
    @GZIP
    @ApiResponses(value = { 
    		@ApiResponse(code = 200, message = "Success", response = ModelSoggetto.class)
    })
    public Response soggettiSoggettoNomeCognomeGet(
    		@ApiParam(required = true) @HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
    		@ApiParam(required = true) @HeaderParam("X-Applicazione-Codice") String xApplicazioneCodice,
    		@ApiParam(required = true) @HeaderParam("X-Request-Id") String xRequestId,
    		@ApiParam(required = true) @HeaderParam("X-Forwarded-For") String xForwardedFor,
    		@HeaderParam("User-Agent") String userAgent, 
    		
    		@ApiParam(required = true) @PathParam("nome") String nome,
    		@ApiParam(required = true) @PathParam("cognome") String cognome,
    		@ApiParam(required = true) @PathParam("dataNascita") String dataNascita,
    		@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );

}
