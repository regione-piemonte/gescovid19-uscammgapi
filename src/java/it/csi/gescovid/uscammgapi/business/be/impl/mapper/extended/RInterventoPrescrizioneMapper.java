package it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusRInterventoPresc;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseCovidusRInterventoPrescMapper;

public interface RInterventoPrescrizioneMapper extends BaseCovidusRInterventoPrescMapper {
	
	@Update({ "update covidus_r_intervento_presc", "set ",
		"data_cancellazione = now ()",
		"where int_id = #{idIntervento,jdbcType=INTEGER}" })
int logicDeleteByIdIntervento(Integer idIntervento);
	
	
	@Select({ "select", "intpresc_id, int_id, presc_tipo_id, prescrizione, utente_operazione, data_creazione, ",
		"data_modifica, data_cancellazione, farm_id, oss_id, valore, farm_consegnato, ",
		"farm_consegna_data, farm_consegna_utente", "from covidus_r_intervento_presc",
		"where int_id = #{idIntervento,jdbcType=INTEGER}" })
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
List<CovidusRInterventoPresc> selectByIdIntervento(Integer idIntervento);

}
