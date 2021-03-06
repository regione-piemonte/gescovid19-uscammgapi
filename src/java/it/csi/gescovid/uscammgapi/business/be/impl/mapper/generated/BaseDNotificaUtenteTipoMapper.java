package it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.DNotificaUtenteTipo;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface BaseDNotificaUtenteTipoMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table d_notifica_utente_tipo
	 * @mbg.generated
	 */
	@Delete({ "delete from d_notifica_utente_tipo", "where not_ut_tipo_id = #{notUtTipoId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer notUtTipoId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table d_notifica_utente_tipo
	 * @mbg.generated
	 */
	@Insert({ "insert into d_notifica_utente_tipo (not_ut_tipo_cod, not_ut_tipo_desc, ",
			"validita_inizio, validita_fine, ", "utente_operazione, data_creazione, ",
			"data_modifica, data_cancellazione)",
			"values (#{notUtTipoCod,jdbcType=VARCHAR}, #{notUtTipoDesc,jdbcType=VARCHAR}, ",
			"#{validitaInizio,jdbcType=TIMESTAMP}, #{validitaFine,jdbcType=TIMESTAMP}, ",
			"#{utenteOperazione,jdbcType=VARCHAR}, #{dataCreazione,jdbcType=TIMESTAMP}, ",
			"#{dataModifica,jdbcType=TIMESTAMP}, #{dataCancellazione,jdbcType=TIMESTAMP})" })
	@Options(useGeneratedKeys = true, keyProperty = "notUtTipoId")
	int insert(DNotificaUtenteTipo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table d_notifica_utente_tipo
	 * @mbg.generated
	 */
	@Select({ "select", "not_ut_tipo_id, not_ut_tipo_cod, not_ut_tipo_desc, validita_inizio, validita_fine, ",
			"utente_operazione, data_creazione, data_modifica, data_cancellazione", "from d_notifica_utente_tipo",
			"where not_ut_tipo_id = #{notUtTipoId,jdbcType=INTEGER}" })
	@Results({ @Result(column = "not_ut_tipo_id", property = "notUtTipoId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "not_ut_tipo_cod", property = "notUtTipoCod", jdbcType = JdbcType.VARCHAR),
			@Result(column = "not_ut_tipo_desc", property = "notUtTipoDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
	DNotificaUtenteTipo selectByPrimaryKey(Integer notUtTipoId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table d_notifica_utente_tipo
	 * @mbg.generated
	 */
	@Select({ "select", "not_ut_tipo_id, not_ut_tipo_cod, not_ut_tipo_desc, validita_inizio, validita_fine, ",
			"utente_operazione, data_creazione, data_modifica, data_cancellazione", "from d_notifica_utente_tipo" })
	@Results({ @Result(column = "not_ut_tipo_id", property = "notUtTipoId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "not_ut_tipo_cod", property = "notUtTipoCod", jdbcType = JdbcType.VARCHAR),
			@Result(column = "not_ut_tipo_desc", property = "notUtTipoDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
	List<DNotificaUtenteTipo> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table d_notifica_utente_tipo
	 * @mbg.generated
	 */
	@Update({ "update d_notifica_utente_tipo", "set not_ut_tipo_cod = #{notUtTipoCod,jdbcType=VARCHAR},",
			"not_ut_tipo_desc = #{notUtTipoDesc,jdbcType=VARCHAR},",
			"validita_inizio = #{validitaInizio,jdbcType=TIMESTAMP},",
			"validita_fine = #{validitaFine,jdbcType=TIMESTAMP},",
			"utente_operazione = #{utenteOperazione,jdbcType=VARCHAR},",
			"data_creazione = #{dataCreazione,jdbcType=TIMESTAMP},",
			"data_modifica = #{dataModifica,jdbcType=TIMESTAMP},",
			"data_cancellazione = #{dataCancellazione,jdbcType=TIMESTAMP}",
			"where not_ut_tipo_id = #{notUtTipoId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(DNotificaUtenteTipo record);
}