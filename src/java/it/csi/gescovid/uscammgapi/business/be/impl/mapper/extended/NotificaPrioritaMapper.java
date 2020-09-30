package it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.DNotificaPriorita;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseDNotificaPrioritaMapper;

public interface NotificaPrioritaMapper extends BaseDNotificaPrioritaMapper {

	@Select({ "select", "priorita_id, priorita_cod, priorita_desc, validita_inizio, validita_fine, utente_operazione, ",
			"data_creazione, data_modifica, data_cancellazione", "from d_notifica_priorita",
			"where data_cancellazione is null and  now() between validita_inizio and coalesce(validita_fine, to_timestamp('01/01/2999','dd/mm/yyyy'))" })
	@Results({ @Result(column = "priorita_id", property = "prioritaId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "priorita_cod", property = "prioritaCod", jdbcType = JdbcType.VARCHAR),
			@Result(column = "priorita_desc", property = "prioritaDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
	List<DNotificaPriorita> selectAllNotificaPrioritaValide();

	@Select({ "select", "priorita_id, priorita_cod, priorita_desc, validita_inizio, validita_fine, utente_operazione, ",
			"data_creazione, data_modifica, data_cancellazione", "from d_notifica_priorita",
			"where priorita_cod = #{priorita_cod,jdbcType=INTEGER}" })
	@Results({ @Result(column = "priorita_id", property = "prioritaId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "priorita_cod", property = "prioritaCod", jdbcType = JdbcType.VARCHAR),
			@Result(column = "priorita_desc", property = "prioritaDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
	List<DNotificaPriorita> selectNotificaPrioritaIdByCod(String priorita_cod);

}
