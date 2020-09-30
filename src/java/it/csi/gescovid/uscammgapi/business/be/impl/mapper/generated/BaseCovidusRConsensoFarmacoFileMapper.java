package it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusRConsensoFarmacoFile;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface BaseCovidusRConsensoFarmacoFileMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_r_consenso_farmaco_file
	 * @mbg.generated
	 */
	@Delete({ "delete from covidus_r_consenso_farmaco_file",
			"where consfarm_file_id = #{consfarmFileId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer consfarmFileId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_r_consenso_farmaco_file
	 * @mbg.generated
	 */
	@Insert({ "insert into covidus_r_consenso_farmaco_file (consfarm_id, file_id, ",
			"utente_operazione, data_creazione, ", "data_modifica, data_cancellazione)",
			"values (#{consfarmId,jdbcType=INTEGER}, #{fileId,jdbcType=INTEGER}, ",
			"#{utenteOperazione,jdbcType=VARCHAR}, #{dataCreazione,jdbcType=TIMESTAMP}, ",
			"#{dataModifica,jdbcType=TIMESTAMP}, #{dataCancellazione,jdbcType=TIMESTAMP})" })
	@Options(useGeneratedKeys = true, keyProperty = "consfarmFileId")
	int insert(CovidusRConsensoFarmacoFile record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_r_consenso_farmaco_file
	 * @mbg.generated
	 */
	@Select({ "select", "consfarm_file_id, consfarm_id, file_id, utente_operazione, data_creazione, data_modifica, ",
			"data_cancellazione", "from covidus_r_consenso_farmaco_file",
			"where consfarm_file_id = #{consfarmFileId,jdbcType=INTEGER}" })
	@Results({
			@Result(column = "consfarm_file_id", property = "consfarmFileId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "consfarm_id", property = "consfarmId", jdbcType = JdbcType.INTEGER),
			@Result(column = "file_id", property = "fileId", jdbcType = JdbcType.INTEGER),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
	CovidusRConsensoFarmacoFile selectByPrimaryKey(Integer consfarmFileId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_r_consenso_farmaco_file
	 * @mbg.generated
	 */
	@Select({ "select", "consfarm_file_id, consfarm_id, file_id, utente_operazione, data_creazione, data_modifica, ",
			"data_cancellazione", "from covidus_r_consenso_farmaco_file" })
	@Results({
			@Result(column = "consfarm_file_id", property = "consfarmFileId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "consfarm_id", property = "consfarmId", jdbcType = JdbcType.INTEGER),
			@Result(column = "file_id", property = "fileId", jdbcType = JdbcType.INTEGER),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
	List<CovidusRConsensoFarmacoFile> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_r_consenso_farmaco_file
	 * @mbg.generated
	 */
	@Update({ "update covidus_r_consenso_farmaco_file", "set consfarm_id = #{consfarmId,jdbcType=INTEGER},",
			"file_id = #{fileId,jdbcType=INTEGER},", "utente_operazione = #{utenteOperazione,jdbcType=VARCHAR},",
			"data_creazione = #{dataCreazione,jdbcType=TIMESTAMP},",
			"data_modifica = #{dataModifica,jdbcType=TIMESTAMP},",
			"data_cancellazione = #{dataCancellazione,jdbcType=TIMESTAMP}",
			"where consfarm_file_id = #{consfarmFileId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(CovidusRConsensoFarmacoFile record);
}