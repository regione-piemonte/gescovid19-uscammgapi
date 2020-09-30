package it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDFarmaco;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDOssigenoTerapia;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseCovidusDOssigenoTerapiaMapper;

public interface OssigenoterapiaTipoMapper extends BaseCovidusDOssigenoTerapiaMapper {
	
	
	@Select({ "select", "oss_id, oss_nome, oss_desc, presc_tipo_id, utente_operazione, validita_inizio, ",
		"validita_fine, data_creazione, data_modifica, data_cancellazione", "from covidus_d_ossigeno_terapia ", 
		"where data_cancellazione is null and  now() between validita_inizio and coalesce(validita_fine, to_timestamp('01/01/2999','dd/mm/yyyy'))"})
	@Results({ @Result(column = "oss_id", property = "ossId", jdbcType = JdbcType.INTEGER, id = true),
		@Result(column = "oss_nome", property = "ossNome", jdbcType = JdbcType.VARCHAR),
		@Result(column = "oss_desc", property = "ossDesc", jdbcType = JdbcType.VARCHAR),
		@Result(column = "presc_tipo_id", property = "prescTipoId", jdbcType = JdbcType.INTEGER),
		@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
		@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
	List<CovidusDOssigenoTerapia> selectAllOssigenoterapiaTipoValidi();
	
}
