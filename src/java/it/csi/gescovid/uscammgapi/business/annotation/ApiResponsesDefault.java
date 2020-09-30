package it.csi.gescovid.uscammgapi.business.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import it.csi.gescovid.uscammgapi.dto.Errore;



/**
 * Response di defult per le API
 * 
 * @author domenico.lisi
 *
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@io.swagger.annotations.ApiResponses(
		value = { 
//				@io.swagger.annotations.ApiResponse(code = 200, message = "Success"),
//				@io.swagger.annotations.ApiResponse(code = 201, message = "Created"),
				
				@io.swagger.annotations.ApiResponse(code = 400, message = "Bad request, ricontrollare parametri in input", response = Errore.class),
		        @io.swagger.annotations.ApiResponse(code = 401, message = "Utente non autorizzato a compiere l'operazione", response = Errore.class),
		        @io.swagger.annotations.ApiResponse(code = 404, message = "Risorsa non trovata", response = Errore.class),
		        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Server Error", response = Errore.class)
		 }
)
public @interface ApiResponsesDefault {

}
