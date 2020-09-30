package it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.DNotificaUtenteTipo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseDNotificaUtenteTipoMapper;

public interface NotificaUtenteTipoMapper extends BaseDNotificaUtenteTipoMapper {

	@Select({ "select", "not_ut_tipo_id, not_ut_tipo_cod, not_ut_tipo_desc, validita_inizio, validita_fine, ",
			"utente_operazione, data_creazione, data_modifica, data_cancellazione", "from d_notifica_utente_tipo",
			"where data_cancellazione is null and  now() between validita_inizio and coalesce(validita_fine, to_timestamp('01/01/2999','dd/mm/yyyy'))" })
	@Results({ @Result(column = "not_ut_tipo_id", property = "notUtTipoId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "not_ut_tipo_cod", property = "notUtTipoCod", jdbcType = JdbcType.VARCHAR),
			@Result(column = "not_ut_tipo_desc", property = "notUtTipoDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
	List<DNotificaUtenteTipo> selectAllNotificaUtenteTipiValidi();

	@Select({ "select", "not_ut_tipo_id, not_ut_tipo_cod, not_ut_tipo_desc, validita_inizio, validita_fine, ",
			"utente_operazione, data_creazione, data_modifica, data_cancellazione", "from d_notifica_utente_tipo",
			"where not_ut_tipo_cod = #{not_ut_tipo_cod,jdbcType=VARCHAR}" })
	@Results({ @Result(column = "not_ut_tipo_id", property = "notUtTipoId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "not_ut_tipo_cod", property = "notUtTipoCod", jdbcType = JdbcType.VARCHAR),
			@Result(column = "not_ut_tipo_desc", property = "notUtTipoDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
	List<DNotificaUtenteTipo> selectNotificaUtenteTipoIdByCod(String not_ut_tipo_cod);
}
