package it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTAdiCovidDet;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface BaseCovidusTAdicovidDetMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_t_adicovid_det
	 * @mbg.generated
	 */
	@Delete({ "delete from covidus_t_adicovid_det", "where adicovid_det_id = #{adicovidDetId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer adicovidDetId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_t_adicovid_det
	 * @mbg.generated
	 */
	@Insert({ "insert into covidus_t_adicovid_det (adicovid_det_data, adicovid_det_note, ",
			"adicovid_id, utente_operazione, ", "data_creazione, data_modifica, ", "data_cancellazione)",
			"values (#{adicovidDetData,jdbcType=TIMESTAMP}, #{adicovidDetNote,jdbcType=VARCHAR}, ",
			"#{adicovidId,jdbcType=INTEGER}, #{utenteOperazione,jdbcType=VARCHAR}, ",
			"#{dataCreazione,jdbcType=TIMESTAMP}, #{dataModifica,jdbcType=TIMESTAMP}, ",
			"#{dataCancellazione,jdbcType=TIMESTAMP})" })
	@Options(useGeneratedKeys = true, keyProperty = "adicovidDetId")
	int insert(CovidusTAdiCovidDet record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_t_adicovid_det
	 * @mbg.generated
	 */
	@Select({ "select", "adicovid_det_id, adicovid_det_data, adicovid_det_note, adicovid_id, utente_operazione, ",
			"data_creazione, data_modifica, data_cancellazione", "from covidus_t_adicovid_det",
			"where adicovid_det_id = #{adicovidDetId,jdbcType=INTEGER}" })
	@Results({ @Result(column = "adicovid_det_id", property = "adicovidDetId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "adicovid_det_data", property = "adicovidDetData", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "adicovid_det_note", property = "adicovidDetNote", jdbcType = JdbcType.VARCHAR),
			@Result(column = "adicovid_id", property = "adicovidId", jdbcType = JdbcType.INTEGER),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
	CovidusTAdiCovidDet selectByPrimaryKey(Integer adicovidDetId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_t_adicovid_det
	 * @mbg.generated
	 */
	@Select({ "select", "adicovid_det_id, adicovid_det_data, adicovid_det_note, adicovid_id, utente_operazione, ",
			"data_creazione, data_modifica, data_cancellazione", "from covidus_t_adicovid_det" })
	@Results({ @Result(column = "adicovid_det_id", property = "adicovidDetId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "adicovid_det_data", property = "adicovidDetData", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "adicovid_det_note", property = "adicovidDetNote", jdbcType = JdbcType.VARCHAR),
			@Result(column = "adicovid_id", property = "adicovidId", jdbcType = JdbcType.INTEGER),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
	List<CovidusTAdiCovidDet> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_t_adicovid_det
	 * @mbg.generated
	 */
	@Update({ "update covidus_t_adicovid_det", "set adicovid_det_data = #{adicovidDetData,jdbcType=TIMESTAMP},",
			"adicovid_det_note = #{adicovidDetNote,jdbcType=VARCHAR},", "adicovid_id = #{adicovidId,jdbcType=INTEGER},",
			"utente_operazione = #{utenteOperazione,jdbcType=VARCHAR},",
			"data_creazione = #{dataCreazione,jdbcType=TIMESTAMP},",
			"data_modifica = #{dataModifica,jdbcType=TIMESTAMP},",
			"data_cancellazione = #{dataCancellazione,jdbcType=TIMESTAMP}",
			"where adicovid_det_id = #{adicovidDetId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(CovidusTAdiCovidDet record);
}