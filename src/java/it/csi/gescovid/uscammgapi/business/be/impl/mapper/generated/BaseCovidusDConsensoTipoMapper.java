package it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDConsensoTipo;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface BaseCovidusDConsensoTipoMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_d_consenso_tipo
	 * @mbg.generated
	 */
	@Delete({ "delete from covidus_d_consenso_tipo", "where cons_tipo_id = #{consTipoId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer consTipoId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_d_consenso_tipo
	 * @mbg.generated
	 */
	@Insert({ "insert into covidus_d_consenso_tipo (cons_tipo_cod, cons_tipo_desc, ",
			"validita_inizio, validita_fine, ", "utente_operazione, data_creazione, ",
			"data_modifica, data_cancellazione)",
			"values (#{consTipoCod,jdbcType=VARCHAR}, #{consTipoDesc,jdbcType=VARCHAR}, ",
			"#{validitaInizio,jdbcType=TIMESTAMP}, #{validitaFine,jdbcType=TIMESTAMP}, ",
			"#{utenteOperazione,jdbcType=VARCHAR}, #{dataCreazione,jdbcType=TIMESTAMP}, ",
			"#{dataModifica,jdbcType=TIMESTAMP}, #{dataCancellazione,jdbcType=TIMESTAMP})" })
	@Options(useGeneratedKeys = true, keyProperty = "consTipoId")
	int insert(CovidusDConsensoTipo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_d_consenso_tipo
	 * @mbg.generated
	 */
	@Select({ "select", "cons_tipo_id, cons_tipo_cod, cons_tipo_desc, validita_inizio, validita_fine, ",
			"utente_operazione, data_creazione, data_modifica, data_cancellazione", "from covidus_d_consenso_tipo",
			"where cons_tipo_id = #{consTipoId,jdbcType=INTEGER}" })
	@Results({ @Result(column = "cons_tipo_id", property = "consTipoId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "cons_tipo_cod", property = "consTipoCod", jdbcType = JdbcType.VARCHAR),
			@Result(column = "cons_tipo_desc", property = "consTipoDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
	CovidusDConsensoTipo selectByPrimaryKey(Integer consTipoId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_d_consenso_tipo
	 * @mbg.generated
	 */
	@Select({ "select", "cons_tipo_id, cons_tipo_cod, cons_tipo_desc, validita_inizio, validita_fine, ",
			"utente_operazione, data_creazione, data_modifica, data_cancellazione", "from covidus_d_consenso_tipo" })
	@Results({ @Result(column = "cons_tipo_id", property = "consTipoId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "cons_tipo_cod", property = "consTipoCod", jdbcType = JdbcType.VARCHAR),
			@Result(column = "cons_tipo_desc", property = "consTipoDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
	List<CovidusDConsensoTipo> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_d_consenso_tipo
	 * @mbg.generated
	 */
	@Update({ "update covidus_d_consenso_tipo", "set cons_tipo_cod = #{consTipoCod,jdbcType=VARCHAR},",
			"cons_tipo_desc = #{consTipoDesc,jdbcType=VARCHAR},",
			"validita_inizio = #{validitaInizio,jdbcType=TIMESTAMP},",
			"validita_fine = #{validitaFine,jdbcType=TIMESTAMP},",
			"utente_operazione = #{utenteOperazione,jdbcType=VARCHAR},",
			"data_creazione = #{dataCreazione,jdbcType=TIMESTAMP},",
			"data_modifica = #{dataModifica,jdbcType=TIMESTAMP},",
			"data_cancellazione = #{dataCancellazione,jdbcType=TIMESTAMP}",
			"where cons_tipo_id = #{consTipoId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(CovidusDConsensoTipo record);
}