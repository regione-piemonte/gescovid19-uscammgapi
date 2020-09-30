package it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Profilo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.UserLogged;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.extended.UtentiExt;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseUtentiMapper;

public interface UtentiMapper extends BaseUtentiMapper {
    @Select({
    	"SELECT utenti.cf_utente, ente.id_ente, ente.nome",
    	"FROM utenti, r_utente_ente, ente",
    	"where utenti.cf_utente=r_utente_ente.cf_utente",
    	"and r_utente_ente.id_ente=ente.id_ente",
    	"and utenti.cf_utente = #{cfUtente,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="cf_utente", property="cfUtente", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="id_ente", property="id", jdbcType=JdbcType.BIGINT),
        @Result(column="nome", property="nome", jdbcType=JdbcType.BIGINT)
    })
    UtentiExt selectInfoEnte(String cfUtente);

    @Select({
        "SELECT profilo.id_profilo, nome_profilo",
        "FROM profilo, utenti, r_utente_profilo",
        "where utenti.cf_utente = #{cfUtente,jdbcType=VARCHAR}",
        "and r_utente_profilo.id_profilo = profilo.id_profilo",
        "and utenti.cf_utente=r_utente_profilo.cf_utente"
    })
    @Results({
        @Result(column="id_profilo", property="idProfilo", jdbcType=JdbcType.BIGINT),
        @Result(column="nome_profilo", property="nomeProfilo", jdbcType=JdbcType.VARCHAR)
    })
    List<Profilo> selectElencoProfili(String cfUtente);
    
    
    
    @Select({
        "select utenti.cf_utente, utenti.id_asr, utenti.id_laboratorio, " +
        "asr.descrizione asr_descrizione, laboratorio.descrizione laboratorio_descrizione " + 
        "from utenti "
        + "LEFT join asr on utenti.id_asr = asr.id_asr "
        + "LEFT join  laboratorio on utenti.id_laboratorio = laboratorio.id_laboratorio " + 
        "where " + 
        "cf_utente=#{codiceFiscale,jdbcType=VARCHAR} "
    })
    @Results({
        @Result(column="cf_utente", property="cfUtente", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_asr", property="idAsr", jdbcType=JdbcType.BIGINT),
        @Result(column="id_laboratorio", property="idLaboratorio", jdbcType=JdbcType.BIGINT),
        @Result(column="id_asr", property="asr.idAsr", jdbcType=JdbcType.BIGINT),
        @Result(column="asr_descrizione", property="asr.descrizione", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_laboratorio", property="laboratorio.idLaboratorio", jdbcType=JdbcType.BIGINT),
        @Result(column="laboratorio_descrizione", property="laboratorio.descrizione", jdbcType=JdbcType.VARCHAR)

    })
    UserLogged selectByCf(String codiceFiscale);

    
	@Select({
	    "select " + 
	    "	a.cf_utente cf_utente, " + 
	    "	d.nome utente_nome, " + 
	    "	d.cognome utente_cognome, " + 
	    "	d.telefono utente_telefono, " + 
	    "	d.email utente_email " + 
	    "from utenti a left join utente_contatto d on a.cf_utente = d.cf_utente " + 
	    //"	r_utente_profilo b, " + 
	    //"	profilo c " + 
	    "where a.cf_utente = #{codiceFiscale,jdbcType=VARCHAR}" 
	    //"	a.cf_utente = b.cf_utente " + 
	    //"	and b.id_profilo = c.id_profilo " + 
	    //"	and c.nome_profilo in ('MED USCA') " + 
	})
	@Results({
	    @Result(column="cf_utente", property="cfUtente", jdbcType=JdbcType.VARCHAR),
	    @Result(column="utente_nome", property="nome", jdbcType=JdbcType.VARCHAR),
	    @Result(column="utente_cognome", property="cognome",  jdbcType=JdbcType.VARCHAR),
	    @Result(column="utente_telefono", property="telefono", jdbcType=JdbcType.VARCHAR),
	    @Result(column="utente_email", property="email", jdbcType=JdbcType.VARCHAR)
	})
	UserLogged selectInfoUtenteLoggedByCf(String codiceFiscale);
	
	
}