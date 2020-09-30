package it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusRDiarioDetSintomo;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface BaseCovidusRDiarioDetSintomoMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_r_diario_det_sintomo
	 * @mbg.generated
	 */
	@Delete({ "delete from covidus_r_diario_det_sintomo", "where diadetsin_id = #{diadetsinId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer diadetsinId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_r_diario_det_sintomo
	 * @mbg.generated
	 */
	@Insert({ "insert into covidus_r_diario_det_sintomo (diadet_id, sin_id, ", "utente_operazione, data_creazione, ",
			"data_modifica, data_cancellazione, ", "id_profilo_operazione, sin_note, ", "sin_valore)",
			"values (#{diadetId,jdbcType=INTEGER}, #{sinId,jdbcType=INTEGER}, ",
			"#{utenteOperazione,jdbcType=VARCHAR}, #{dataCreazione,jdbcType=TIMESTAMP}, ",
			"#{dataModifica,jdbcType=TIMESTAMP}, #{dataCancellazione,jdbcType=TIMESTAMP}, ",
			"#{idProfiloOperazione,jdbcType=INTEGER}, #{sinNote,jdbcType=VARCHAR}, ",
			"#{sinValore,jdbcType=NUMERIC})" })
	@Options(useGeneratedKeys = true, keyProperty = "diadetsinId")
	int insert(CovidusRDiarioDetSintomo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_r_diario_det_sintomo
	 * @mbg.generated
	 */
	@Select({ "select", "diadetsin_id, diadet_id, sin_id, utente_operazione, data_creazione, data_modifica, ",
			"data_cancellazione, id_profilo_operazione, sin_note, sin_valore", "from covidus_r_diario_det_sintomo",
			"where diadetsin_id = #{diadetsinId,jdbcType=INTEGER}" })
	@Results({ @Result(column = "diadetsin_id", property = "diadetsinId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "diadet_id", property = "diadetId", jdbcType = JdbcType.INTEGER),
			@Result(column = "sin_id", property = "sinId", jdbcType = JdbcType.INTEGER),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "id_profilo_operazione", property = "idProfiloOperazione", jdbcType = JdbcType.INTEGER),
			@Result(column = "sin_note", property = "sinNote", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sin_valore", property = "sinValore", jdbcType = JdbcType.NUMERIC) })
	CovidusRDiarioDetSintomo selectByPrimaryKey(Integer diadetsinId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_r_diario_det_sintomo
	 * @mbg.generated
	 */
	@Select({ "select", "diadetsin_id, diadet_id, sin_id, utente_operazione, data_creazione, data_modifica, ",
			"data_cancellazione, id_profilo_operazione, sin_note, sin_valore", "from covidus_r_diario_det_sintomo" })
	@Results({ @Result(column = "diadetsin_id", property = "diadetsinId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "diadet_id", property = "diadetId", jdbcType = JdbcType.INTEGER),
			@Result(column = "sin_id", property = "sinId", jdbcType = JdbcType.INTEGER),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "id_profilo_operazione", property = "idProfiloOperazione", jdbcType = JdbcType.INTEGER),
			@Result(column = "sin_note", property = "sinNote", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sin_valore", property = "sinValore", jdbcType = JdbcType.NUMERIC) })
	List<CovidusRDiarioDetSintomo> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_r_diario_det_sintomo
	 * @mbg.generated
	 */
	@Update({ "update covidus_r_diario_det_sintomo", "set diadet_id = #{diadetId,jdbcType=INTEGER},",
			"sin_id = #{sinId,jdbcType=INTEGER},", "utente_operazione = #{utenteOperazione,jdbcType=VARCHAR},",
			"data_creazione = #{dataCreazione,jdbcType=TIMESTAMP},",
			"data_modifica = #{dataModifica,jdbcType=TIMESTAMP},",
			"data_cancellazione = #{dataCancellazione,jdbcType=TIMESTAMP},",
			"id_profilo_operazione = #{idProfiloOperazione,jdbcType=INTEGER},",
			"sin_note = #{sinNote,jdbcType=VARCHAR},", "sin_valore = #{sinValore,jdbcType=NUMERIC}",
			"where diadetsin_id = #{diadetsinId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(CovidusRDiarioDetSintomo record);
}