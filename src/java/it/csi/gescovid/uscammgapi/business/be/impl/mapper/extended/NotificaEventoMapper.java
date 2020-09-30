package it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.DNotificaEvento;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseDNotificaEventoMapper;

public interface NotificaEventoMapper extends BaseDNotificaEventoMapper {

	@Select({ "select", "not_ev_id, not_ev_cod, not_ev_desc, validita_inizio, validita_fine, utente_operazione, ",
			"data_creazione, data_modifica, data_cancellazione", "from d_notifica_evento",
			"where data_cancellazione is null and  now() between validita_inizio and coalesce(validita_fine, to_timestamp('01/01/2999','dd/mm/yyyy'))" })
	@Results({ @Result(column = "not_ev_id", property = "notEvId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "not_ev_cod", property = "notEvCod", jdbcType = JdbcType.VARCHAR),
			@Result(column = "not_ev_desc", property = "notEvDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
	List<DNotificaEvento> selectAllNotificaEventiValidi();

	@Select({ "select", "not_ev_id, not_ev_cod, not_ev_desc, validita_inizio, validita_fine, utente_operazione, ",
			"data_creazione, data_modifica, data_cancellazione", "from d_notifica_evento",
			"where not_ev_cod = #{notEvCod,jdbcType=INTEGER}" })
	@Results({ @Result(column = "not_ev_id", property = "notEvId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "not_ev_cod", property = "notEvCod", jdbcType = JdbcType.VARCHAR),
			@Result(column = "not_ev_desc", property = "notEvDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
	List<DNotificaEvento> selectNotificaEventoIdByCod(String notEvCod);

}
