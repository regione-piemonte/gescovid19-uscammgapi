package it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.DNotificaAzione;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseDNotificaAzioneMapper;

public interface NotificaAzioneMapper extends BaseDNotificaAzioneMapper {

	@Select({ "select", "not_az_id, not_az_cod, not_az_desc, validita_inizio, validita_fine, utente_operazione, ",
		"data_creazione, data_modifica, data_cancellazione", "from d_notifica_azione",
		"where data_cancellazione is null and  now() between validita_inizio and coalesce(validita_fine, to_timestamp('01/01/2999','dd/mm/yyyy'))"
	})
@Results({ @Result(column = "not_az_id", property = "notAzId", jdbcType = JdbcType.INTEGER, id = true),
		@Result(column = "not_az_cod", property = "notAzCod", jdbcType = JdbcType.VARCHAR),
		@Result(column = "not_az_desc", property = "notAzDesc", jdbcType = JdbcType.VARCHAR),
		@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
		@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
List<DNotificaAzione> selectAllNotificaAzioniValide();
	
	@Select({ "select", "not_az_id, not_az_cod, not_az_desc, validita_inizio, validita_fine, utente_operazione, ",
		"data_creazione, data_modifica, data_cancellazione", "from d_notifica_azione",
		"where not_az_cod = #{notAzCod,jdbcType=INTEGER}"
	})
@Results({ @Result(column = "not_az_id", property = "notAzId", jdbcType = JdbcType.INTEGER, id = true),
		@Result(column = "not_az_cod", property = "notAzCod", jdbcType = JdbcType.VARCHAR),
		@Result(column = "not_az_desc", property = "notAzDesc", jdbcType = JdbcType.VARCHAR),
		@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
		@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
List<DNotificaAzione> selectNotificaAzioniIdByCod(String notAzCod);

	
}


