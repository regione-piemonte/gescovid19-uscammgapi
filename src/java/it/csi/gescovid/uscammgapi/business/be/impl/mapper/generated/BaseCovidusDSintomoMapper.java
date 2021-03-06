package it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDSintomo;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface BaseCovidusDSintomoMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_d_sintomo
	 * @mbg.generated
	 */
	@Delete({ "delete from covidus_d_sintomo", "where sin_id = #{sinId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer sinId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_d_sintomo
	 * @mbg.generated
	 */
	@Insert({ "insert into covidus_d_sintomo (sin_cod, sin_desc, ", "utente_operazione, validita_inizio, ",
			"validita_fine, data_creazione, ", "data_modifica, data_cancellazione, ",
			"sin_misurabile, sin_unita_misura)", "values (#{sinCod,jdbcType=VARCHAR}, #{sinDesc,jdbcType=VARCHAR}, ",
			"#{utenteOperazione,jdbcType=VARCHAR}, #{validitaInizio,jdbcType=TIMESTAMP}, ",
			"#{validitaFine,jdbcType=TIMESTAMP}, #{dataCreazione,jdbcType=TIMESTAMP}, ",
			"#{dataModifica,jdbcType=TIMESTAMP}, #{dataCancellazione,jdbcType=TIMESTAMP}, ",
			"#{sinMisurabile,jdbcType=BIT}, #{sinUnitaMisura,jdbcType=VARCHAR})" })
	@Options(useGeneratedKeys = true, keyProperty = "sinId")
	int insert(CovidusDSintomo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_d_sintomo
	 * @mbg.generated
	 */
	@Select({ "select", "sin_id, sin_cod, sin_desc, utente_operazione, validita_inizio, validita_fine, ",
			"data_creazione, data_modifica, data_cancellazione, sin_misurabile, sin_unita_misura",
			"from covidus_d_sintomo", "where sin_id = #{sinId,jdbcType=INTEGER}" })
	@Results({ @Result(column = "sin_id", property = "sinId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "sin_cod", property = "sinCod", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sin_desc", property = "sinDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "sin_misurabile", property = "sinMisurabile", jdbcType = JdbcType.BIT),
			@Result(column = "sin_unita_misura", property = "sinUnitaMisura", jdbcType = JdbcType.VARCHAR) })
	CovidusDSintomo selectByPrimaryKey(Integer sinId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_d_sintomo
	 * @mbg.generated
	 */
	@Select({ "select", "sin_id, sin_cod, sin_desc, utente_operazione, validita_inizio, validita_fine, ",
			"data_creazione, data_modifica, data_cancellazione, sin_misurabile, sin_unita_misura",
			"from covidus_d_sintomo" })
	@Results({ @Result(column = "sin_id", property = "sinId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "sin_cod", property = "sinCod", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sin_desc", property = "sinDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "sin_misurabile", property = "sinMisurabile", jdbcType = JdbcType.BIT),
			@Result(column = "sin_unita_misura", property = "sinUnitaMisura", jdbcType = JdbcType.VARCHAR) })
	List<CovidusDSintomo> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_d_sintomo
	 * @mbg.generated
	 */
	@Update({ "update covidus_d_sintomo", "set sin_cod = #{sinCod,jdbcType=VARCHAR},",
			"sin_desc = #{sinDesc,jdbcType=VARCHAR},", "utente_operazione = #{utenteOperazione,jdbcType=VARCHAR},",
			"validita_inizio = #{validitaInizio,jdbcType=TIMESTAMP},",
			"validita_fine = #{validitaFine,jdbcType=TIMESTAMP},",
			"data_creazione = #{dataCreazione,jdbcType=TIMESTAMP},",
			"data_modifica = #{dataModifica,jdbcType=TIMESTAMP},",
			"data_cancellazione = #{dataCancellazione,jdbcType=TIMESTAMP},",
			"sin_misurabile = #{sinMisurabile,jdbcType=BIT},", "sin_unita_misura = #{sinUnitaMisura,jdbcType=VARCHAR}",
			"where sin_id = #{sinId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(CovidusDSintomo record);
}