package it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.DNotificaTipo;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface BaseDNotificaTipoMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table d_notifica_tipo
	 * @mbg.generated
	 */
	@Delete({ "delete from d_notifica_tipo", "where not_tipo_id = #{notTipoId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer notTipoId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table d_notifica_tipo
	 * @mbg.generated
	 */
	@Insert({ "insert into d_notifica_tipo (not_tipo_cod, not_tipo_desc, ", "validita_inizio, validita_fine, ",
			"utente_operazione, data_creazione, ", "data_modifica, data_cancellazione)",
			"values (#{notTipoCod,jdbcType=VARCHAR}, #{notTipoDesc,jdbcType=VARCHAR}, ",
			"#{validitaInizio,jdbcType=TIMESTAMP}, #{validitaFine,jdbcType=TIMESTAMP}, ",
			"#{utenteOperazione,jdbcType=VARCHAR}, #{dataCreazione,jdbcType=TIMESTAMP}, ",
			"#{dataModifica,jdbcType=TIMESTAMP}, #{dataCancellazione,jdbcType=TIMESTAMP})" })
	@Options(useGeneratedKeys = true, keyProperty = "notTipoId")
	int insert(DNotificaTipo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table d_notifica_tipo
	 * @mbg.generated
	 */
	@Select({ "select", "not_tipo_id, not_tipo_cod, not_tipo_desc, validita_inizio, validita_fine, utente_operazione, ",
			"data_creazione, data_modifica, data_cancellazione", "from d_notifica_tipo",
			"where not_tipo_id = #{notTipoId,jdbcType=INTEGER}" })
	@Results({ @Result(column = "not_tipo_id", property = "notTipoId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "not_tipo_cod", property = "notTipoCod", jdbcType = JdbcType.VARCHAR),
			@Result(column = "not_tipo_desc", property = "notTipoDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
	DNotificaTipo selectByPrimaryKey(Integer notTipoId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table d_notifica_tipo
	 * @mbg.generated
	 */
	@Select({ "select", "not_tipo_id, not_tipo_cod, not_tipo_desc, validita_inizio, validita_fine, utente_operazione, ",
			"data_creazione, data_modifica, data_cancellazione", "from d_notifica_tipo" })
	@Results({ @Result(column = "not_tipo_id", property = "notTipoId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "not_tipo_cod", property = "notTipoCod", jdbcType = JdbcType.VARCHAR),
			@Result(column = "not_tipo_desc", property = "notTipoDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
	List<DNotificaTipo> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table d_notifica_tipo
	 * @mbg.generated
	 */
	@Update({ "update d_notifica_tipo", "set not_tipo_cod = #{notTipoCod,jdbcType=VARCHAR},",
			"not_tipo_desc = #{notTipoDesc,jdbcType=VARCHAR},",
			"validita_inizio = #{validitaInizio,jdbcType=TIMESTAMP},",
			"validita_fine = #{validitaFine,jdbcType=TIMESTAMP},",
			"utente_operazione = #{utenteOperazione,jdbcType=VARCHAR},",
			"data_creazione = #{dataCreazione,jdbcType=TIMESTAMP},",
			"data_modifica = #{dataModifica,jdbcType=TIMESTAMP},",
			"data_cancellazione = #{dataCancellazione,jdbcType=TIMESTAMP}",
			"where not_tipo_id = #{notTipoId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(DNotificaTipo record);
}