package it.csi.gescovid.uscammgapi.business;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import it.csi.gescovid.uscammgapi.business.be.impl.AdiCovidApiServiceImpl;
import it.csi.gescovid.uscammgapi.business.be.impl.AdiCovidDettagliServiceImpl;
import it.csi.gescovid.uscammgapi.business.be.impl.ConsensiFarmaciApiServiceImpl;
import it.csi.gescovid.uscammgapi.business.be.impl.ConsensoTipiApiServiceImpl;
import it.csi.gescovid.uscammgapi.business.be.impl.CurrentUserApiServiceImpl;
import it.csi.gescovid.uscammgapi.business.be.impl.DiariApiServiceImpl;
import it.csi.gescovid.uscammgapi.business.be.impl.DiarioDettagliApiServiceImpl;
import it.csi.gescovid.uscammgapi.business.be.impl.DocumentiApiServiceImpl;
import it.csi.gescovid.uscammgapi.business.be.impl.FarmaciApiServiceImpl;
import it.csi.gescovid.uscammgapi.business.be.impl.MonitoraggioTipoApiServiceImpl;
import it.csi.gescovid.uscammgapi.business.be.impl.NotificaAzioniApiServiceImpl;
import it.csi.gescovid.uscammgapi.business.be.impl.NotificaEventiApiServiceImpl;
import it.csi.gescovid.uscammgapi.business.be.impl.NotificaPrioritaApiServiceImpl;
import it.csi.gescovid.uscammgapi.business.be.impl.NotificaTipiApiServiceImpl;
import it.csi.gescovid.uscammgapi.business.be.impl.NotificaUtenteTipiApiServiceImpl;
import it.csi.gescovid.uscammgapi.business.be.impl.NotificheApiServiceImpl;
import it.csi.gescovid.uscammgapi.business.be.impl.OssigenoterapieApiServiceImpl;
import it.csi.gescovid.uscammgapi.business.be.impl.PrescrizioneTipiApiServiceImpl;
import it.csi.gescovid.uscammgapi.business.be.impl.SchedeApiServiceImpl;
import it.csi.gescovid.uscammgapi.business.be.impl.SchedeStatiApiServiceImpl;
import it.csi.gescovid.uscammgapi.business.be.impl.SintomiApiServiceImpl;
import it.csi.gescovid.uscammgapi.business.be.impl.SoggettiApiServiceImpl;
import it.csi.gescovid.uscammgapi.business.be.impl.StruttureApiServiceImpl;
import it.csi.gescovid.uscammgapi.business.be.impl.UtentiApiServiceImpl;
import it.csi.gescovid.uscammgapi.util.SpringInjectorInterceptor;
import it.csi.gescovid.uscammgapi.util.SpringSupportedResource;

@ApplicationPath("restfacade/be")
public class UscammgapiRestApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<>();

	public UscammgapiRestApplication() {
		
		configureSwagger();

		singletons.add(new CurrentUserApiServiceImpl());
		singletons.add(new SoggettiApiServiceImpl());
		singletons.add(new SintomiApiServiceImpl());
		singletons.add(new PrescrizioneTipiApiServiceImpl());
		singletons.add(new DiarioDettagliApiServiceImpl());
		singletons.add(new SchedeApiServiceImpl());
		singletons.add(new SchedeStatiApiServiceImpl());
		singletons.add(new StruttureApiServiceImpl());
		singletons.add(new DiariApiServiceImpl());
		singletons.add(new UtentiApiServiceImpl());
		
		singletons.add(new ConsensiFarmaciApiServiceImpl());
		singletons.add(new OssigenoterapieApiServiceImpl());
		singletons.add(new ConsensoTipiApiServiceImpl());
		singletons.add(new FarmaciApiServiceImpl());
		singletons.add(new DocumentiApiServiceImpl());
		singletons.add(new NotificaTipiApiServiceImpl());
		singletons.add(new NotificaUtenteTipiApiServiceImpl());
		singletons.add(new NotificaEventiApiServiceImpl());
		singletons.add(new NotificaAzioniApiServiceImpl());
		singletons.add(new NotificaPrioritaApiServiceImpl());
		singletons.add(new NotificheApiServiceImpl());
		singletons.add(new MonitoraggioTipoApiServiceImpl());
		singletons.add(new AdiCovidDettagliServiceImpl());
		singletons.add(new AdiCovidApiServiceImpl());
		singletons.add(new SpringInjectorInterceptor());
		

		for (Object c : singletons) {
			if (c instanceof SpringSupportedResource) {
				SpringApplicationContextHelper.registerRestEasyController(c);
			}
		}
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
	
	private void configureSwagger() {

		classes.add(ApiListingResource.class);
		classes.add(SwaggerSerializers.class);

        BeanConfig config = new BeanConfig();
        config.setConfigId("gest-paz-api");
        config.setTitle("Interventi e diari pazienti");
        config.setVersion("v1");
        config.setContact("CSI Piemonte");
        config.setSchemes(new String[]{"http", "https"});
        config.setBasePath("/restfacade/be");
        config.setResourcePackage("it.csi.gescovid.uscammgapi.business.be");
        config.setDescription("API dell'applicazione per i Medici USCA.");
        config.setPrettyPrint(true);
        config.setScan(true);
    }

}
