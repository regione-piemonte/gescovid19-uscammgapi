package it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusRAppStruttura;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface BaseCovidusRAppStrutturaMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_r_app_struttura
	 * @mbg.generated
	 */
	@Delete({ "delete from covidus_r_app_struttura", "where appstr_id = #{appstrId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer appstrId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_r_app_struttura
	 * @mbg.generated
	 */
	@Insert({ "insert into covidus_r_app_struttura (app_id, id_struttura, ", "validita_inizio, validita_fine, ",
			"utente_operazione, data_creazione, ", "data_modifica, data_cancellazione)",
			"values (#{appId,jdbcType=INTEGER}, #{idStruttura,jdbcType=VARCHAR}, ",
			"#{validitaInizio,jdbcType=TIMESTAMP}, #{validitaFine,jdbcType=TIMESTAMP}, ",
			"#{utenteOperazione,jdbcType=VARCHAR}, #{dataCreazione,jdbcType=TIMESTAMP}, ",
			"#{dataModifica,jdbcType=TIMESTAMP}, #{dataCancellazione,jdbcType=TIMESTAMP})" })
	@Options(useGeneratedKeys = true, keyProperty = "appstrId")
	int insert(CovidusRAppStruttura record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_r_app_struttura
	 * @mbg.generated
	 */
	@Select({ "select", "appstr_id, app_id, id_struttura, validita_inizio, validita_fine, utente_operazione, ",
			"data_creazione, data_modifica, data_cancellazione", "from covidus_r_app_struttura",
			"where appstr_id = #{appstrId,jdbcType=INTEGER}" })
	@Results({ @Result(column = "appstr_id", property = "appstrId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "app_id", property = "appId", jdbcType = JdbcType.INTEGER),
			@Result(column = "id_struttura", property = "idStruttura", jdbcType = JdbcType.VARCHAR),
			@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
	CovidusRAppStruttura selectByPrimaryKey(Integer appstrId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_r_app_struttura
	 * @mbg.generated
	 */
	@Select({ "select", "appstr_id, app_id, id_struttura, validita_inizio, validita_fine, utente_operazione, ",
			"data_creazione, data_modifica, data_cancellazione", "from covidus_r_app_struttura" })
	@Results({ @Result(column = "appstr_id", property = "appstrId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "app_id", property = "appId", jdbcType = JdbcType.INTEGER),
			@Result(column = "id_struttura", property = "idStruttura", jdbcType = JdbcType.VARCHAR),
			@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
	List<CovidusRAppStruttura> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_r_app_struttura
	 * @mbg.generated
	 */
	@Update({ "update covidus_r_app_struttura", "set app_id = #{appId,jdbcType=INTEGER},",
			"id_struttura = #{idStruttura,jdbcType=VARCHAR},",
			"validita_inizio = #{validitaInizio,jdbcType=TIMESTAMP},",
			"validita_fine = #{validitaFine,jdbcType=TIMESTAMP},",
			"utente_operazione = #{utenteOperazione,jdbcType=VARCHAR},",
			"data_creazione = #{dataCreazione,jdbcType=TIMESTAMP},",
			"data_modifica = #{dataModifica,jdbcType=TIMESTAMP},",
			"data_cancellazione = #{dataCancellazione,jdbcType=TIMESTAMP}",
			"where appstr_id = #{appstrId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(CovidusRAppStruttura record);
}