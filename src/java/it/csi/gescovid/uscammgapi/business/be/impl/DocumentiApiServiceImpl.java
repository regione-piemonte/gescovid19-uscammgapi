package it.csi.gescovid.uscammgapi.business.be.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.StreamingOutput;

import org.springframework.beans.factory.annotation.Autowired;

import com.certicom.security.pkix.Extension;

import it.csi.gescovid.uscammgapi.business.be.DocumentiApi;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTFile;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended.CovidusTFileMapper;
import it.csi.gescovid.uscammgapi.exception.RESTException;
import it.csi.gescovid.uscammgapi.util.CaConstants;
import it.csi.gescovid.uscammgapi.util.CaRet;
import it.csi.gescovid.uscammgapi.util.LogUtil;

public class DocumentiApiServiceImpl extends RESTBaseService implements DocumentiApi {
	
	@Autowired
	CovidusTFileMapper tFileMapper;
	
	LogUtil log =  new LogUtil(this.getClass());



	@Override
	public Response documentiDocumentoIdGet(String shibIdentitaCodiceFiscale, String xApplicazioneCodice,
			String xRequestId, String xForwardedFor, String userAgent, String documentoId,
			SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		String methodName = "documentiDocumentoIdGet";
		log.info(methodName, "BEGIN");
		try {
			checkNotNull(shibIdentitaCodiceFiscale, CaConstants.IDENTITA_OBBLIGATORIA);
			checkNotNull(xApplicazioneCodice, CaConstants.APPLICATION_ID_OBBLIGATORIO);
			checkNotNull(documentoId, "DocumentoId non valorizzato");
			
			logAudit(httpHeaders, "select", "covidus_t_file", methodName);
			
			CovidusTFile tfile = tFileMapper.selectByDocId(Integer.parseInt(documentoId));
			String mineType = tfile.getFileType();
			
			if(mineType == null || mineType.isEmpty() || !mineType.contains("/")) {
				
				// desumo il minetype
				String filename = tfile.getFileName();
				
				String extension = "";
				
				String[] sub = filename.split(Pattern.quote("."));
				if(sub.length  == 2) {
					extension = sub[1];
				}else {
					// sono nel caso in cui ho nel nome file un '.'
					int index = sub.length;
					extension = sub[index-1];
				}
				
				
				boolean isMineTypeText = extension.equalsIgnoreCase("txt") || extension.equalsIgnoreCase("html") || extension.equalsIgnoreCase("csv") || extension.equalsIgnoreCase("rtf");
				boolean isMineTypeImage = extension.equalsIgnoreCase("gif") || 
												extension.equalsIgnoreCase("jpeg") || extension.equalsIgnoreCase("jpg") ||
														extension.equalsIgnoreCase("png") || extension.equalsIgnoreCase("tiff") || extension.contains("icon");

				boolean isMineTypeApplication = extension.equalsIgnoreCase("pdf") || extension.contains("xls") || extension.contains("doc") || extension.equalsIgnoreCase("odt") || extension.equalsIgnoreCase("xml");
				if(isMineTypeText) mineType = "text/";
				if(isMineTypeImage) mineType = "image/";
				if(isMineTypeApplication) mineType = "application/";
				
			}
				
			// Gestione file
			StreamingOutput output = new StreamingOutput() {
			    @Override
			    public void write(OutputStream out) throws IOException, WebApplicationException {  
			       
			    	//File file = new File(tfile.getFileName());
			    	//out = new FileOutputStream(file);
			    	//out.write(tfile.getFileSize().intValue());
			    	
			    	byte[] data = new byte[tfile.getFileSize().intValue()];
			    	data = tfile.getFile();
			    	out.write(data);
			    	
			    	out.flush();
                    out.close();

			    }   
			};
			
			//return Response.ok(output).header("Content-Disposition", "attachment; filename=\"" + tfile.getFileName() + "\"").build();			
			return Response.ok(output).header("Content-Disposition", "attachment; filename=\"" + tfile.getFileName() + "\"").header("Content-Type", mineType).build();
			//return Response.ok(null).build();
			
		}  catch (RESTException e) {
			log.error(methodName, " documentiDocumentoIdGet ERROR RESTException", e);
			return e.getResponse();
		} catch (Exception e) {
			log.error(methodName, " documentiDocumentoIdGet ERROR Exception", e);
			return CaRet.internalServerErrResponse();
		}
	}

	

}
