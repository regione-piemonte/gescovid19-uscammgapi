package it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusRConsensoFarmacoFile;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseCovidusRConsensoFarmacoFileMapper;

public interface RConsensoFarmacoFileMapper extends BaseCovidusRConsensoFarmacoFileMapper {

	@Update({ "update covidus_r_consenso_farmaco_file", "set ",
		"data_cancellazione = now()",
		"where consfarm_id = #{idConsenso,jdbcType=INTEGER}" })
int logicDeleteByIdConsenso(Integer idConsenso);
	
	@Select({ "select", "consfarm_file_id, consfarm_id, file_id, utente_operazione, data_creazione, data_modifica, ",
		"data_cancellazione", "from covidus_r_consenso_farmaco_file",
		"where consfarm_id = #{consfarmId,jdbcType=INTEGER}" })
@Results({
		@Result(column = "consfarm_file_id", property = "consfarmFileId", jdbcType = JdbcType.INTEGER, id = true),
		@Result(column = "consfarm_id", property = "consfarmId", jdbcType = JdbcType.INTEGER),
		@Result(column = "file_id", property = "fileId", jdbcType = JdbcType.INTEGER),
		@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
		@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
CovidusRConsensoFarmacoFile selectByConsFarmId(Integer consfarmId);

	
}
