package it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Medico;

public interface MedicoMapper {


   @Select({
       "select",
       "id_medico, cf_medico, codice_reg, cognome, nome",
       "from medico",
       "where cf_medico = #{codiceFiscale,jdbcType=VARCHAR}"
   })
   @Results({
       @Result(column="id_medico", property="idMedico", jdbcType=JdbcType.BIGINT, id=true),
       @Result(column="cf_medico", property="cfMedico", jdbcType=JdbcType.VARCHAR),
       @Result(column="codice_reg", property="codiceReg", jdbcType=JdbcType.VARCHAR),
       @Result(column="cognome", property="cognome", jdbcType=JdbcType.VARCHAR),
       @Result(column="nome", property="nome", jdbcType=JdbcType.VARCHAR)
   })
   Medico selectByCodiceFiscale(String codiceFiscale);
   

   @Select({
       "select",
       "medico.id_medico, cf_medico, codice_reg, cognome, nome",
       "from medico",
       " join r_medico_sogg_aura on r_medico_sogg_aura.id_medico = medico.id_medico ",
       "where id_aura_sogg = #{idAuraSogg,jdbcType=BIGINT} "
   })
   @Results({
       @Result(column="id_medico", property="idMedico", jdbcType=JdbcType.BIGINT, id=true),
       @Result(column="cf_medico", property="cfMedico", jdbcType=JdbcType.VARCHAR),
       @Result(column="codice_reg", property="codiceReg", jdbcType=JdbcType.VARCHAR),
       @Result(column="cognome", property="cognome", jdbcType=JdbcType.VARCHAR),
       @Result(column="nome", property="nome", jdbcType=JdbcType.VARCHAR)
   })
   List<Medico> selectByIdAuraSogg(Long idAuraSogg);
   
   

}
