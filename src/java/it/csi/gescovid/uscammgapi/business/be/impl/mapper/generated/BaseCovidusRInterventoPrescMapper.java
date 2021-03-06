package it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusRInterventoPresc;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface BaseCovidusRInterventoPrescMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_r_intervento_presc
	 * @mbg.generated
	 */
	@Delete({ "delete from covidus_r_intervento_presc", "where intpresc_id = #{intprescId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer intprescId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_r_intervento_presc
	 * @mbg.generated
	 */
	@Insert({ "insert into covidus_r_intervento_presc (int_id, presc_tipo_id, ", "prescrizione, utente_operazione, ",
			"data_creazione, data_modifica, ", "data_cancellazione, farm_id, ", "oss_id, valore, farm_consegnato, ",
			"farm_consegna_data, farm_consegna_utente)",
			"values (#{intId,jdbcType=INTEGER}, #{prescTipoId,jdbcType=INTEGER}, ",
			"#{prescrizione,jdbcType=VARCHAR}, #{utenteOperazione,jdbcType=VARCHAR}, ",
			"#{dataCreazione,jdbcType=TIMESTAMP}, #{dataModifica,jdbcType=TIMESTAMP}, ",
			"#{dataCancellazione,jdbcType=TIMESTAMP}, #{farmId,jdbcType=INTEGER}, ",
			"#{ossId,jdbcType=INTEGER}, #{valore,jdbcType=VARCHAR}, #{farmConsegnato,jdbcType=BIT}, ",
			"#{farmConsegnaData,jdbcType=TIMESTAMP}, #{farmConsegnaUtente,jdbcType=VARCHAR})" })
	@Options(useGeneratedKeys = true, keyProperty = "intprescId")
	int insert(CovidusRInterventoPresc record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_r_intervento_presc
	 * @mbg.generated
	 */
	@Select({ "select", "intpresc_id, int_id, presc_tipo_id, prescrizione, utente_operazione, data_creazione, ",
			"data_modifica, data_cancellazione, farm_id, oss_id, valore, farm_consegnato, ",
			"farm_consegna_data, farm_consegna_utente", "from covidus_r_intervento_presc",
			"where intpresc_id = #{intprescId,jdbcType=INTEGER}" })
	@Results({ @Result(column = "intpresc_id", property = "intprescId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "int_id", property = "intId", jdbcType = JdbcType.INTEGER),
			@Result(column = "presc_tipo_id", property = "prescTipoId", jdbcType = JdbcType.INTEGER),
			@Result(column = "prescrizione", property = "prescrizione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "farm_id", property = "farmId", jdbcType = JdbcType.INTEGER),
			@Result(column = "oss_id", property = "ossId", jdbcType = JdbcType.INTEGER),
			@Result(column = "valore", property = "valore", jdbcType = JdbcType.VARCHAR),
			@Result(column = "farm_consegnato", property = "farmConsegnato", jdbcType = JdbcType.BIT),
			@Result(column = "farm_consegna_data", property = "farmConsegnaData", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "farm_consegna_utente", property = "farmConsegnaUtente", jdbcType = JdbcType.VARCHAR) })
	CovidusRInterventoPresc selectByPrimaryKey(Integer intprescId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_r_intervento_presc
	 * @mbg.generated
	 */
	@Select({ "select", "intpresc_id, int_id, presc_tipo_id, prescrizione, utente_operazione, data_creazione, ",
			"data_modifica, data_cancellazione, farm_id, oss_id, valore, farm_consegnato, ",
			"farm_consegna_data, farm_consegna_utente", "from covidus_r_intervento_presc" })
	@Results({ @Result(column = "intpresc_id", property = "intprescId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "int_id", property = "intId", jdbcType = JdbcType.INTEGER),
			@Result(column = "presc_tipo_id", property = "prescTipoId", jdbcType = JdbcType.INTEGER),
			@Result(column = "prescrizione", property = "prescrizione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "farm_id", property = "farmId", jdbcType = JdbcType.INTEGER),
			@Result(column = "oss_id", property = "ossId", jdbcType = JdbcType.INTEGER),
			@Result(column = "valore", property = "valore", jdbcType = JdbcType.VARCHAR),
			@Result(column = "farm_consegnato", property = "farmConsegnato", jdbcType = JdbcType.BIT),
			@Result(column = "farm_consegna_data", property = "farmConsegnaData", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "farm_consegna_utente", property = "farmConsegnaUtente", jdbcType = JdbcType.VARCHAR) })
	List<CovidusRInterventoPresc> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_r_intervento_presc
	 * @mbg.generated
	 */
	@Update({ "update covidus_r_intervento_presc", "set int_id = #{intId,jdbcType=INTEGER},",
			"presc_tipo_id = #{prescTipoId,jdbcType=INTEGER},", "prescrizione = #{prescrizione,jdbcType=VARCHAR},",
			"utente_operazione = #{utenteOperazione,jdbcType=VARCHAR},",
			"data_creazione = #{dataCreazione,jdbcType=TIMESTAMP},",
			"data_modifica = #{dataModifica,jdbcType=TIMESTAMP},",
			"data_cancellazione = #{dataCancellazione,jdbcType=TIMESTAMP},", "farm_id = #{farmId,jdbcType=INTEGER},",
			"oss_id = #{ossId,jdbcType=INTEGER},", "valore = #{valore,jdbcType=VARCHAR},",
			"farm_consegnato = #{farmConsegnato,jdbcType=BIT},",
			"farm_consegna_data = #{farmConsegnaData,jdbcType=TIMESTAMP},",
			"farm_consegna_utente = #{farmConsegnaUtente,jdbcType=VARCHAR}",
			"where intpresc_id = #{intprescId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(CovidusRInterventoPresc record);
}