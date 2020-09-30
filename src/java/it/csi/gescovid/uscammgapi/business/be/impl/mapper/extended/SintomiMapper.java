package it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDSintomo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseCovidusDSintomoMapper;

public interface SintomiMapper extends BaseCovidusDSintomoMapper {
	
	@Select({ "select", 
		"sin_id, sin_cod, sin_desc, utente_operazione, validita_inizio, validita_fine, ",
		"data_creazione, data_modifica, data_cancellazione, sin_misurabile, sin_unita_misura",
		"from covidus_d_sintomo",
		"where data_cancellazione is null and now() between validita_inizio and coalesce(validita_fine, to_timestamp('01/01/2999','dd/mm/yyyy'))"})
	@Results({ @Result(column = "sin_id", property = "sinId", jdbcType = JdbcType.INTEGER, id = true),
		@Result(column = "sin_cod", property = "sinCod", jdbcType = JdbcType.VARCHAR),
		@Result(column = "sin_desc", property = "sinDesc", jdbcType = JdbcType.VARCHAR),
		@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
		@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "sin_misurabile", property = "sinMisurabile", jdbcType = JdbcType.BOOLEAN),
		@Result(column = "sin_unita_misura", property = "sinUnitaMisura", jdbcType = JdbcType.VARCHAR) })
	List<CovidusDSintomo> selectAll();

}
