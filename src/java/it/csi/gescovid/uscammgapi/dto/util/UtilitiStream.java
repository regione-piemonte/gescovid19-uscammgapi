package it.csi.gescovid.uscammgapi.dto.util;

import java.util.List;
import java.util.stream.Collectors;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDSintomo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Profilo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.DiarioDetExtDto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.DiarioExtDto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.SintomoExtDto;
import it.csi.gescovid.uscammgapi.business.mapping.ModelDiarioDettaglioDiarioDetExtDtoMapping;
import it.csi.gescovid.uscammgapi.business.mapping.ModelDiarioDettaglioSintomoCovidusDSintomoMapping;
import it.csi.gescovid.uscammgapi.business.mapping.ModelDiarioDiarioExtDtoMapping;
import it.csi.gescovid.uscammgapi.business.mapping.ModelSintomoCovidusDSintomoMapping;
import it.csi.gescovid.uscammgapi.dto.ModelDiario;
import it.csi.gescovid.uscammgapi.dto.ModelDiarioDettaglio;

public class UtilitiStream {
	
	
	public static boolean verificaProfili(List<Profilo> elencoProfiliDB, String xApplicazioneCodice) {
		return elencoProfiliDB.stream().anyMatch(c -> (c != null && xApplicazioneCodice.equalsIgnoreCase(c.getNomeProfilo())));
	}
	
	public static List<ModelDiario> listaDiariDistinct(List<DiarioExtDto> listaDiari){
		
		List<DiarioExtDto> diariDistinct = listaDiari.stream().distinct().collect(Collectors.toList());
		
		List<DiarioDetExtDto> listaDettagli = listaDiari.stream().map(c -> c.getDiarioDet()).collect(Collectors.toList());
		
		List<DiarioDetExtDto> listaDettagliDistinct = listaDettagli.stream().distinct().collect(Collectors.toList());  
		
		List<SintomoExtDto> sintomi = listaDiari.stream().map(c -> c.getSintomo()).collect(Collectors.toList()); 
		
		
		//mi costruisco la lista dei dettagli corretta
		List<ModelDiarioDettaglio> listaModelDiarioDett = new ModelDiarioDettaglioDiarioDetExtDtoMapping().fromList(listaDettagliDistinct);
		
		listaModelDiarioDett.stream().forEach(c -> {
			List<SintomoExtDto> listaSintomi =  sintomi.stream().filter(s -> s.getDiarioDetId().equals(c.getId())).collect(Collectors.toList());
			c.setSintomi(new ModelSintomoCovidusDSintomoMapping().fromList(listaSintomi));
		});
		
		
		
		List<ModelDiario> listaModelDiario = new ModelDiarioDiarioExtDtoMapping().fromList(diariDistinct);
		listaModelDiario.stream().forEach(c -> { 
			List<ModelDiarioDettaglio> listaDettagli2 = listaModelDiarioDett.stream().filter(d -> d.getDiarioId().equals(c.getId())).collect(Collectors.toList());
			c.setDettagli(listaDettagli2 );
		} );
		
		
		return listaModelDiario;
	}
}
