package it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Struttura;



public interface UtenteStrutturaMapper {



	@Select({ "select", 
			"struttura.id_struttura, struttura.id_ente, nome, natura",
			"from struttura",
			"join r_utente_struttura on r_utente_struttura.id_struttura = struttura.id_struttura",
			"where r_utente_struttura.cf_utente = #{codiceFiscale,jdbcType=VARCHAR}" })
	@Results({ @Result(column = "id_struttura", property = "idStruttura", jdbcType = JdbcType.VARCHAR, id = true),
		@Result(column = "id_ente", property = "idEnte", jdbcType = JdbcType.INTEGER),
		@Result(column = "nome", property = "nome", jdbcType = JdbcType.VARCHAR),
		@Result(column = "natura", property = "natura", jdbcType = JdbcType.VARCHAR) })
	List<Struttura> selectElencoStrutturaProfiloByCodiceFiscale(String codiceFiscale);


	
	@Select({ "select distinct",
		"struttura.id_struttura, struttura.id_ente, struttura.nome, natura",
		"from struttura",
		"join ente  on ente.id_ente= struttura.id_ente",
		"join  r_utente_ente on r_utente_ente.id_ente = ente.id_ente",
		"join area on area.id_struttura = struttura.id_struttura",
		"join covidus_r_app_struttura rapp on (struttura.id_struttura = rapp.id_struttura)",
		"where r_utente_ente.cf_utente = #{codiceFiscale,jdbcType=VARCHAR}",
		"and rapp.data_cancellazione is null",
		"and  now() between rapp.validita_inizio and coalesce(rapp.validita_fine, to_timestamp('01/01/2999','dd/mm/yyyy'))",
		"and (area.stato_validita='ATTIVO' or area.stato_validita is null)"})
	@Results({ @Result(column = "id_struttura", property = "idStruttura", jdbcType = JdbcType.VARCHAR, id = true),
	@Result(column = "id_ente", property = "idEnte", jdbcType = JdbcType.INTEGER),
	@Result(column = "nome", property = "nome", jdbcType = JdbcType.VARCHAR),
	@Result(column = "natura", property = "natura", jdbcType = JdbcType.VARCHAR) })
	List<Struttura> selectElencoStrutturaDaEnteProfiloByCodiceFiscale(String cfUtente);
	
	
	
	
	
	@Select({ "select distinct " + 
			"struttura.id_struttura, struttura.id_ente, struttura.nome, natura " + 
			"from struttura " + 
			"join covidus_r_app_struttura rapp on (struttura.id_struttura = rapp.id_struttura) " + 
			"join r_utente_struttura rutente on (rutente.id_struttura = struttura.id_struttura) " + 
			"join utenti utenti on (rutente.cf_utente = utenti.cf_utente) " + 
			"where " + 
			"rapp.data_cancellazione is null " + 
			"and utenti.cf_utente = #{codiceFiscale,jdbcType=VARCHAR}"})
	@Results({ @Result(column = "id_struttura", property = "idStruttura", jdbcType = JdbcType.VARCHAR, id = true),
	@Result(column = "id_ente", property = "idEnte", jdbcType = JdbcType.INTEGER),
	@Result(column = "nome", property = "nome", jdbcType = JdbcType.VARCHAR),
	@Result(column = "natura", property = "natura", jdbcType = JdbcType.VARCHAR) })
	List<Struttura> selectElencoStrutturaByCodiceFiscale(String cfUtente);
	

}