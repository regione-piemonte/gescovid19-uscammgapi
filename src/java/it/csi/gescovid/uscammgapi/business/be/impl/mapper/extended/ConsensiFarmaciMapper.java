package it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusRConsensoFarmacoFile;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTConsensoFarmaco;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseCovidusTConsensoFarmacoMapper;

public interface ConsensiFarmaciMapper extends BaseCovidusTConsensoFarmacoMapper {
	
	
	@Select({"<script>",			
		"select consfarm_id, consfarm_data, id_soggetto, farm_id, cons_tipo_id ", 
		" from covidus_t_consenso_farmaco where data_cancellazione is null ",
		//"<if test='soggettoId != null or farmacoId != null or tipoConsensoId != null' >",
			//"<where>",
			"<if test='soggettoId != null'> and id_soggetto=#{soggettoId,jdbcType=BIGINT} </if> ",
			"<if test='farmacoId != null'> and farm_id=#{farmacoId,jdbcType=BIGINT} </if> ",
			"<if test='tipoConsensoId != null'> and cons_tipo_id=#{tipoConsensoId,jdbcType=BIGINT} </if>",
			//"</where>",
		//" </if>",
		"</script>"
		})
	@Results({ 
		@Result(column = "consfarm_id", property = "consfarmId", jdbcType = JdbcType.INTEGER, id = true),
		@Result(column = "consfarm_data", property = "consfarmData", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "id_soggetto", property = "idSoggetto", jdbcType = JdbcType.BIGINT),
		@Result(column = "farm_id", property = "farmId", jdbcType = JdbcType.INTEGER),
		@Result(column = "cons_tipo_id", property = "consTipoId", jdbcType = JdbcType.INTEGER)
	})
	List<CovidusTConsensoFarmaco> selectConsensiByFiltro(@Param("soggettoId") Integer soggettoId, @Param("farmacoId") Integer farmacoId, @Param("tipoConsensoId") Integer tipoConsensoId);
	
	
	
	@Select({ "select", "consfarm_id, id_soggetto, cons_tipo_id, farm_id, consfarm_data, utente_operazione, ",
		"data_creazione, data_modifica, data_cancellazione", "from covidus_t_consenso_farmaco",
		"where farm_id = #{farmId,jdbcType=INTEGER} and data_cancellazione is null" })
	@Results({ @Result(column = "consfarm_id", property = "consfarmId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "id_soggetto", property = "idSoggetto", jdbcType = JdbcType.BIGINT),
			@Result(column = "cons_tipo_id", property = "consTipoId", jdbcType = JdbcType.INTEGER),
			@Result(column = "farm_id", property = "farmId", jdbcType = JdbcType.INTEGER),
			@Result(column = "consfarm_data", property = "consfarmData", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
	CovidusTConsensoFarmaco selectConsensoByFarmId(Integer farmId);
	
	
	@Insert({ "insert into covidus_r_consenso_farmaco_file (consfarm_id, file_id, ",
		"utente_operazione, data_creazione, data_modifica) ",
		"values (#{consfarmId,jdbcType=INTEGER}, #{fileId,jdbcType=INTEGER}, ",
		"#{utenteOperazione,jdbcType=VARCHAR}, now(), ",
		"now())" })
	@Options(useGeneratedKeys = true, keyProperty = "consfarmFileId")
	int insertRConsensoFarmacoFile(CovidusRConsensoFarmacoFile record);
	
	@Update({ "update covidus_t_consenso_farmaco", "set ",
		"data_cancellazione = now()",
		"where consfarm_id = #{consfarmId,jdbcType=INTEGER}" })
int logicDeleteByPrimaryKey(Integer consFarmId);
	
	
}
