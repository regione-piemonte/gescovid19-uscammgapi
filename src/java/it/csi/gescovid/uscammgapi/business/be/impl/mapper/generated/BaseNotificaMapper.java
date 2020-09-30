package it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Soggetto;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Notifica;

public interface BaseNotificaMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table notifica
	 * @mbg.generated
	 */
	@Delete({ "delete from notifica", "where not_id = #{notId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer notId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table notifica
	 * @mbg.generated
	 */
	@Insert({ "insert into notifica (not_data_notifica, not_data_presa_visione, ",
			"not_testo_request, not_testo_response, ", "id_soggetto, cf_utente_richiesta, ",
			"cf_utente_presa_vis, cf_utente_dest, ", "id_ente, id_struttura, ", "priorita_id, not_tipo_id, ",
			"not_ev_id, not_az_id, ", "not_ut_tipo_id, utente_operazione, ", "data_creazione, data_modifica, ",
			"data_cancellazione, not_ut_tipo_id_dest)",
			"values (#{notDataNotifica,jdbcType=TIMESTAMP}, #{notDataPresaVisione,jdbcType=TIMESTAMP}, ",
			"#{notTestoRequest,jdbcType=VARCHAR}, #{notTestoResponse,jdbcType=VARCHAR}, ",
			"#{idSoggetto,jdbcType=INTEGER}, #{cfUtenteRichiesta,jdbcType=VARCHAR}, ",
			"#{cfUtentePresaVis,jdbcType=VARCHAR}, #{cfUtenteDest,jdbcType=VARCHAR}, ",
			"#{idEnte,jdbcType=INTEGER}, #{idStruttura,jdbcType=VARCHAR}, ",
			"#{prioritaId,jdbcType=INTEGER}, #{notTipoId,jdbcType=INTEGER}, ",
			"#{notEvId,jdbcType=INTEGER}, #{notAzId,jdbcType=INTEGER}, ",
			"#{notUtTipoId,jdbcType=INTEGER}, #{utenteOperazione,jdbcType=VARCHAR}, ",
			"#{dataCreazione,jdbcType=TIMESTAMP}, #{dataModifica,jdbcType=TIMESTAMP}, ",
			"#{dataCancellazione,jdbcType=TIMESTAMP}, #{notUtTipoIdDest,jdbcType=INTEGER})" })
	@Options(useGeneratedKeys = true, keyProperty = "notId")
	int insert(Notifica record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table notifica
	 * @mbg.generated
	 */
	@Select({ "select", "not_id, not_data_notifica, not_data_presa_visione, not_testo_request, not_testo_response, ",
			"id_soggetto, cf_utente_richiesta, cf_utente_presa_vis, cf_utente_dest, id_ente, ",
			"id_struttura, priorita_id, not_tipo_id, not_ev_id, not_az_id, not_ut_tipo_id, ",
			"utente_operazione, data_creazione, data_modifica, data_cancellazione, not_ut_tipo_id_dest",
			"from notifica", "where not_id = #{notId,jdbcType=INTEGER}" })
	@Results({ @Result(column = "not_id", property = "notId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "not_data_notifica", property = "notDataNotifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "not_data_presa_visione", property = "notDataPresaVisione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "not_testo_request", property = "notTestoRequest", jdbcType = JdbcType.VARCHAR),
			@Result(column = "not_testo_response", property = "notTestoResponse", jdbcType = JdbcType.VARCHAR),
			@Result(column = "id_soggetto", property = "idSoggetto", jdbcType = JdbcType.INTEGER),
			@Result(column = "cf_utente_richiesta", property = "cfUtenteRichiesta", jdbcType = JdbcType.VARCHAR),
			@Result(column = "cf_utente_presa_vis", property = "cfUtentePresaVis", jdbcType = JdbcType.VARCHAR),
			@Result(column = "cf_utente_dest", property = "cfUtenteDest", jdbcType = JdbcType.VARCHAR),
			@Result(column = "id_ente", property = "idEnte", jdbcType = JdbcType.INTEGER),
			@Result(column = "id_struttura", property = "idStruttura", jdbcType = JdbcType.VARCHAR),
			@Result(column = "priorita_id", property = "prioritaId", jdbcType = JdbcType.INTEGER),
			@Result(column = "not_tipo_id", property = "notTipoId", jdbcType = JdbcType.INTEGER),
			@Result(column = "not_ev_id", property = "notEvId", jdbcType = JdbcType.INTEGER),
			@Result(column = "not_az_id", property = "notAzId", jdbcType = JdbcType.INTEGER),
			@Result(column = "not_ut_tipo_id", property = "notUtTipoId", jdbcType = JdbcType.INTEGER),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "not_ut_tipo_id_dest", property = "notUtTipoIdDest", jdbcType = JdbcType.INTEGER) })
	Notifica selectByPrimaryKey(Integer notId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table notifica
	 * @mbg.generated
	 */
	@Select({ "select", "not_id, not_data_notifica, not_data_presa_visione, not_testo_request, not_testo_response, ",
			"id_soggetto, cf_utente_richiesta, cf_utente_presa_vis, cf_utente_dest, id_ente, ",
			"id_struttura, priorita_id, not_tipo_id, not_ev_id, not_az_id, not_ut_tipo_id, ",
			"utente_operazione, data_creazione, data_modifica, data_cancellazione, not_ut_tipo_id_dest",
			"from notifica" })
	@Results({ @Result(column = "not_id", property = "notId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "not_data_notifica", property = "notDataNotifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "not_data_presa_visione", property = "notDataPresaVisione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "not_testo_request", property = "notTestoRequest", jdbcType = JdbcType.VARCHAR),
			@Result(column = "not_testo_response", property = "notTestoResponse", jdbcType = JdbcType.VARCHAR),
			@Result(column = "id_soggetto", property = "idSoggetto", jdbcType = JdbcType.INTEGER),
			@Result(column = "cf_utente_richiesta", property = "cfUtenteRichiesta", jdbcType = JdbcType.VARCHAR),
			@Result(column = "cf_utente_presa_vis", property = "cfUtentePresaVis", jdbcType = JdbcType.VARCHAR),
			@Result(column = "cf_utente_dest", property = "cfUtenteDest", jdbcType = JdbcType.VARCHAR),
			@Result(column = "id_ente", property = "idEnte", jdbcType = JdbcType.INTEGER),
			@Result(column = "id_struttura", property = "idStruttura", jdbcType = JdbcType.VARCHAR),
			@Result(column = "priorita_id", property = "prioritaId", jdbcType = JdbcType.INTEGER),
			@Result(column = "not_tipo_id", property = "notTipoId", jdbcType = JdbcType.INTEGER),
			@Result(column = "not_ev_id", property = "notEvId", jdbcType = JdbcType.INTEGER),
			@Result(column = "not_az_id", property = "notAzId", jdbcType = JdbcType.INTEGER),
			@Result(column = "not_ut_tipo_id", property = "notUtTipoId", jdbcType = JdbcType.INTEGER),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "not_ut_tipo_id_dest", property = "notUtTipoIdDest", jdbcType = JdbcType.INTEGER) })
	List<Notifica> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table notifica
	 * @mbg.generated
	 */
	@Update({ "update notifica", "set not_data_notifica = #{notDataNotifica,jdbcType=TIMESTAMP},",
			"not_data_presa_visione = #{notDataPresaVisione,jdbcType=TIMESTAMP},",
			"not_testo_request = #{notTestoRequest,jdbcType=VARCHAR},",
			"not_testo_response = #{notTestoResponse,jdbcType=VARCHAR},",
			"id_soggetto = #{idSoggetto,jdbcType=INTEGER},",
			"cf_utente_richiesta = #{cfUtenteRichiesta,jdbcType=VARCHAR},",
			"cf_utente_presa_vis = #{cfUtentePresaVis,jdbcType=VARCHAR},",
			"cf_utente_dest = #{cfUtenteDest,jdbcType=VARCHAR},", "id_ente = #{idEnte,jdbcType=INTEGER},",
			"id_struttura = #{idStruttura,jdbcType=VARCHAR},", "priorita_id = #{prioritaId,jdbcType=INTEGER},",
			"not_tipo_id = #{notTipoId,jdbcType=INTEGER},", "not_ev_id = #{notEvId,jdbcType=INTEGER},",
			"not_az_id = #{notAzId,jdbcType=INTEGER},", "not_ut_tipo_id = #{notUtTipoId,jdbcType=INTEGER},",
			"utente_operazione = #{utenteOperazione,jdbcType=VARCHAR},",
			"data_creazione = #{dataCreazione,jdbcType=TIMESTAMP},",
			"data_modifica = #{dataModifica,jdbcType=TIMESTAMP},",
			"data_cancellazione = #{dataCancellazione,jdbcType=TIMESTAMP},",
			"not_ut_tipo_id_dest = #{notUtTipoIdDest,jdbcType=INTEGER}", "where not_id = #{notId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(Notifica record);
}