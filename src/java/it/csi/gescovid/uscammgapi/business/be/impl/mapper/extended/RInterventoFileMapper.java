package it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusRInterventoFile;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseCovidusRInterventoFileMapper;

public interface RInterventoFileMapper extends BaseCovidusRInterventoFileMapper {

	@Update({ "update covidus_r_intervento_file", "set ", "data_cancellazione = now()",
			"where int_id = #{idIntervento,jdbcType=INTEGER}" })
	int logicDeleteByIdIntervento(Integer idIntervento);

	@Select({ "select", "int_file_id, int_id, file_id, utente_operazione, data_creazione, data_modifica, ",
			"data_cancellazione", "from covidus_r_intervento_file", "where int_id = #{idIntervento,jdbcType=INTEGER}" })
	@Results({ @Result(column = "int_file_id", property = "intFileId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "int_id", property = "intId", jdbcType = JdbcType.INTEGER),
			@Result(column = "file_id", property = "fileId", jdbcType = JdbcType.INTEGER),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
	CovidusRInterventoFile selectByIdIntervento(Integer idIntervento);

}
