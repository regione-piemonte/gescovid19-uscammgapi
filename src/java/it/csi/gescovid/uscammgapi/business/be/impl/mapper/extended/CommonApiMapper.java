package it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.InformazioniUtenteCustomDto;

public interface CommonApiMapper {

	@Select({
		"with mu as (",
		"select",
		"	a.cf_utente,",
		"	c.nome_profilo,",
		"	e.id_struttura,",
		"	e.nome nome_struttura,",
		"	e.natura natura_struttura,",
		"	f.nome nome_ente, f.id_ente id_ente ",
		"from",
		"	utenti a,",
		"	r_utente_profilo b,",
		"	profilo c,",
		"	r_utente_struttura d,",
		"	struttura e,",
		"	covidus_r_app_struttura cras,",
		"	covid_d_applicativo cda,",
		"	ente f,  ",
		"	medico_usca h",
		"where",
		"	a.cf_utente = b.cf_utente",
		"	and b.id_profilo = c.id_profilo",
		"	and c.nome_profilo in ('MED USCA', 'MED EMERGENZA', 'MED CONT ASS')",
		"	and d.cf_utente = a.cf_utente",
		"	and e.id_struttura = cras.id_struttura",
		"	and cras.app_id = cda.app_id",
		"	and e.id_struttura = d.id_struttura",
		"	and e.id_ente = f.id_ente",
		"	and h.cf_medico = a.cf_utente )",
		"select",
		"	mu.cf_utente utente_cf,",
		"	mu.nome_profilo profilo_nome,",
		"	mu.id_struttura struttura_id,",
		"	mu.nome_struttura struttura_nome,",
		"	mu.natura_struttura struttura_natura,",
		"	mu.nome_ente ente_nome, mu.id_ente,",
		"	g.nome utente_nome,",
		"	g.cognome utente_cognome,",
		"	g.telefono utente_telefono,",
		"	g.email utente_email",
		"from",
		"	mu",
		"left join utente_contatto g on",
		"	g.cf_utente = mu.cf_utente",
		"where",
	      "	mu.cf_utente = #{codFiscale,jdbcType=VARCHAR}"
		})
		@Results({
			@Result(column = "utente_cf", property = "utenteCf", jdbcType = JdbcType.VARCHAR),
			@Result(column = "profilo_nome", property = "profiloNome", jdbcType = JdbcType.VARCHAR),
			@Result(column = "struttura_id", property = "strutturaId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "struttura_nome", property = "strutturaNome", jdbcType = JdbcType.VARCHAR),
			@Result(column = "struttura_natura", property = "strutturaNatura", jdbcType = JdbcType.VARCHAR),
			@Result(column = "ente_nome", property = "enteNome", jdbcType = JdbcType.VARCHAR),
			@Result(column = "id_ente", property = "enteId", jdbcType = JdbcType.INTEGER),
			@Result(column = "utente_nome", property = "utenteNome", jdbcType = JdbcType.VARCHAR),
			@Result(column = "utente_cognome", property = "utenteCognome", jdbcType = JdbcType.VARCHAR),
			@Result(column = "utente_telefono", property = "utenteTelefono", jdbcType = JdbcType.VARCHAR),
			@Result(column = "utente_email", property = "utenteEmail", jdbcType = JdbcType.VARCHAR),
		})
		List<InformazioniUtenteCustomDto> selectInformazioniUtente(@Param("codFiscale") String codFiscale);

}
