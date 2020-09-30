package it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDPrescTipo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseCovidusDPrescTipoMapper;

public interface PrescTipoMapper extends BaseCovidusDPrescTipoMapper {
	
	@Select({ "select", "presc_tipo_id, presc_tipo_cod, presc_tipo_desc, validita_inizio, validita_fine, ",
		"utente_operazione, data_creazione, data_modifica, data_cancellazione", "from covidus_d_presc_tipo",
		"where data_cancellazione is null",
		"and now() between validita_inizio and coalesce(validita_fine, to_timestamp('01/01/2999','dd/mm/yyyy'))"})
	@Results({ @Result(column = "presc_tipo_id", property = "prescTipoId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "presc_tipo_cod", property = "prescTipoCod", jdbcType = JdbcType.VARCHAR),
			@Result(column = "presc_tipo_desc", property = "prescTipoDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
	List<CovidusDPrescTipo> selectAll();

}
