package it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDFarmaco;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface BaseCovidusDFarmacoMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_d_farmaco
	 * @mbg.generated
	 */
	@Delete({ "delete from covidus_d_farmaco", "where farm_id = #{farmId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer farmId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_d_farmaco
	 * @mbg.generated
	 */
	@Insert({ "insert into covidus_d_farmaco (farm_nome, farm_desc, ", "farm_consenso_necessario, presc_tipo_id, ",
			"utente_operazione, validita_inizio, ", "validita_fine, data_creazione, ",
			"data_modifica, data_cancellazione)",
			"values (#{farmNome,jdbcType=VARCHAR}, #{farmDesc,jdbcType=VARCHAR}, ",
			"#{farmConsensoNecessario,jdbcType=BIT}, #{prescTipoId,jdbcType=INTEGER}, ",
			"#{utenteOperazione,jdbcType=VARCHAR}, #{validitaInizio,jdbcType=TIMESTAMP}, ",
			"#{validitaFine,jdbcType=TIMESTAMP}, #{dataCreazione,jdbcType=TIMESTAMP}, ",
			"#{dataModifica,jdbcType=TIMESTAMP}, #{dataCancellazione,jdbcType=TIMESTAMP})" })
	@Options(useGeneratedKeys = true, keyProperty = "farmId")
	int insert(CovidusDFarmaco record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_d_farmaco
	 * @mbg.generated
	 */
	@Select({ "select", "farm_id, farm_nome, farm_desc, farm_consenso_necessario, presc_tipo_id, utente_operazione, ",
			"validita_inizio, validita_fine, data_creazione, data_modifica, data_cancellazione",
			"from covidus_d_farmaco", "where farm_id = #{farmId,jdbcType=INTEGER}" })
	@Results({ @Result(column = "farm_id", property = "farmId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "farm_nome", property = "farmNome", jdbcType = JdbcType.VARCHAR),
			@Result(column = "farm_desc", property = "farmDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "farm_consenso_necessario", property = "farmConsensoNecessario", jdbcType = JdbcType.BIT),
			@Result(column = "presc_tipo_id", property = "prescTipoId", jdbcType = JdbcType.INTEGER),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
	CovidusDFarmaco selectByPrimaryKey(Integer farmId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_d_farmaco
	 * @mbg.generated
	 */
	@Select({ "select", "farm_id, farm_nome, farm_desc, farm_consenso_necessario, presc_tipo_id, utente_operazione, ",
			"validita_inizio, validita_fine, data_creazione, data_modifica, data_cancellazione",
			"from covidus_d_farmaco" })
	@Results({ @Result(column = "farm_id", property = "farmId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "farm_nome", property = "farmNome", jdbcType = JdbcType.VARCHAR),
			@Result(column = "farm_desc", property = "farmDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "farm_consenso_necessario", property = "farmConsensoNecessario", jdbcType = JdbcType.BIT),
			@Result(column = "presc_tipo_id", property = "prescTipoId", jdbcType = JdbcType.INTEGER),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
	List<CovidusDFarmaco> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_d_farmaco
	 * @mbg.generated
	 */
	@Update({ "update covidus_d_farmaco", "set farm_nome = #{farmNome,jdbcType=VARCHAR},",
			"farm_desc = #{farmDesc,jdbcType=VARCHAR},",
			"farm_consenso_necessario = #{farmConsensoNecessario,jdbcType=BIT},",
			"presc_tipo_id = #{prescTipoId,jdbcType=INTEGER},",
			"utente_operazione = #{utenteOperazione,jdbcType=VARCHAR},",
			"validita_inizio = #{validitaInizio,jdbcType=TIMESTAMP},",
			"validita_fine = #{validitaFine,jdbcType=TIMESTAMP},",
			"data_creazione = #{dataCreazione,jdbcType=TIMESTAMP},",
			"data_modifica = #{dataModifica,jdbcType=TIMESTAMP},",
			"data_cancellazione = #{dataCancellazione,jdbcType=TIMESTAMP}",
			"where farm_id = #{farmId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(CovidusDFarmaco record);
}