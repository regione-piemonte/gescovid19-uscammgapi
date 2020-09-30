package it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.UtenteContatto;
import it.csi.gescovid.uscammgapi.dto.ModelUtenteContatto;

public interface UtentiApiMapper {

	@Select({
		"select",
		"cf_utente, nome, cognome, telefono, email",
		"from utente_contatto",
		"where cf_utente = #{cfUtente,jdbcType=VARCHAR}"
	})
	@Results({
		@Result(column = "cf_utente", property = "codiceFiscale", jdbcType = JdbcType.VARCHAR, id = true),
		@Result(column = "nome", property = "nome", jdbcType = JdbcType.VARCHAR),
		@Result(column = "cognome", property = "cognome", jdbcType = JdbcType.VARCHAR),
		@Result(column = "telefono", property = "telefono", jdbcType = JdbcType.VARCHAR),
		@Result(column = "email", property = "email", jdbcType = JdbcType.VARCHAR)
	})
	ModelUtenteContatto selectModelUtenteContattoByPrimaryKey(String cfUtente);

	@Select({
		"select", 
		"cf_utente, nome, cognome, telefono, email", 
		"from utente_contatto",
		"where cf_utente = #{cfUtente,jdbcType=VARCHAR}"
	})
	@Results({ @Result(column = "cf_utente", property = "cfUtente", jdbcType = JdbcType.VARCHAR, id = true),
		@Result(column = "nome", property = "nome", jdbcType = JdbcType.VARCHAR),
		@Result(column = "cognome", property = "cognome", jdbcType = JdbcType.VARCHAR),
		@Result(column = "telefono", property = "telefono", jdbcType = JdbcType.VARCHAR),
		@Result(column = "email", property = "email", jdbcType = JdbcType.VARCHAR) })
	UtenteContatto selectUtenteContattoByPrimaryKey(String cfUtente);
	
	@Update({
		"update utente_contatto",
		 "set nome = #{nome,jdbcType=VARCHAR},",
		 "    cognome = #{cognome,jdbcType=VARCHAR},",
		 "    telefono = #{telefono,jdbcType=VARCHAR},",
		 "    email = #{email,jdbcType=VARCHAR}",
		"where cf_utente = #{cfUtente,jdbcType=VARCHAR}"
	})
	int updateUtenteContattoByCodiceFiscale(UtenteContatto record);
	
	
	
	@Insert({ "insert into utente_contatto (cf_utente, nome, cognome, ", "telefono, email)",
		"values (#{cfUtente,jdbcType=VARCHAR}," ,
		"        #{nome,jdbcType=VARCHAR}, ",
		" 		 #{cognome,jdbcType=VARCHAR}, ",
		"        #{telefono,jdbcType=VARCHAR}, ",
		" 	     #{email,jdbcType=VARCHAR} ",
		")" })
	int insert(UtenteContatto record);

}
