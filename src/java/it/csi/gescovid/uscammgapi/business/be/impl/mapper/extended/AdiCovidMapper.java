package it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTAdiCovid;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseCovidusTAdicovidMapper;

public interface AdiCovidMapper extends BaseCovidusTAdicovidMapper {
	
	
	@Select({ "select", "adicovid_id, adicovid_data_start, adicovid_data_end, adicovid_note, utente_operazione, ",
		"data_creazione, data_modifica, data_cancellazione", "from covidus_t_adicovid",
		"where utente_operazione = #{utenteOperazione,jdbcType=VARCHAR}"
	})
@Results({ @Result(column = "adicovid_id", property = "adicovidId", jdbcType = JdbcType.INTEGER, id = true),
		@Result(column = "adicovid_data_start", property = "adicovidDataStart", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "adicovid_data_end", property = "adicovidDataEnd", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "adicovid_note", property = "adicovidNote", jdbcType = JdbcType.VARCHAR),
		@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
		@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
List<CovidusTAdiCovid> selectAllByUtente(String utenteOperazione);
	
	@Select({ "select", "adicovid_id, adicovid_data_start, adicovid_data_end, adicovid_note, utente_operazione, ",
		"data_creazione, data_modifica, data_cancellazione", "from covidus_t_adicovid",
		"where adicovid_id = #{adicovidId,jdbcType=INTEGER} and utente_operazione = #{utenteOperazione,jdbcType=VARCHAR}" })
@Results({ @Result(column = "adicovid_id", property = "adicovidId", jdbcType = JdbcType.INTEGER, id = true),
		@Result(column = "adicovid_data_start", property = "adicovidDataStart", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "adicovid_data_end", property = "adicovidDataEnd", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "adicovid_note", property = "adicovidNote", jdbcType = JdbcType.VARCHAR),
		@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
		@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
	List<CovidusTAdiCovid> selectByPrimaryKeyAndUtente(@Param("adicovidId")Integer adicovidId,@Param("utenteOperazione") String utenteOperazione);

}
