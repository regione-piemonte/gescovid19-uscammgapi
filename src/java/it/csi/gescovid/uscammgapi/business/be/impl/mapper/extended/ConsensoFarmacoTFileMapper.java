package it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTConsensoFarmaco;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTFile;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseCovidusTFileMapper;

public interface ConsensoFarmacoTFileMapper extends BaseCovidusTFileMapper {
	
	
	@Select({			
		"select " , 
		"	   c.file_id, c.file_name, c.file_size,  c.file_tipo_id,  c.file_note " + 
		"   from ", 
		"     covidus_t_file c, covidus_r_consenso_farmaco_file r, covidus_t_consenso_farmaco f " , 
		"   where " ,
		"     f.consfarm_id = r.consfarm_id and " , 
		"     r.file_id = c.file_id and  " , 
		"     f.consfarm_id = #{consensoFarmacoId,jdbcType=INTEGER} ",
		"     and c.data_cancellazione is null and r.data_cancellazione is null and f.data_cancellazione is null"
		})
	@Results({ 
		@Result(column = "file_id", property = "fileId", jdbcType = JdbcType.INTEGER, id = true),
		@Result(column = "file_name", property = "fileName", jdbcType = JdbcType.VARCHAR),
		@Result(column = "file_size", property = "fileSize", jdbcType = JdbcType.DECIMAL),
		@Result(column = "file_tipo_id", property = "fileType", jdbcType = JdbcType.INTEGER),
		@Result(column = "file_note", property = "fileNote", jdbcType = JdbcType.VARCHAR)
	})
	List<CovidusTFile> selectInfoConsensiTFileByIdConsensoFarmaco(@Param("consensoFarmacoId") Integer consensoFarmacoId);
	
	@Update({ "update covidus_t_consenso_farmaco", "set id_soggetto = #{idSoggetto,jdbcType=BIGINT},",
		"cons_tipo_id = #{consTipoId,jdbcType=INTEGER},", "farm_id = #{farmId,jdbcType=INTEGER},",
		"consfarm_data = #{consfarmData,jdbcType=TIMESTAMP},",
		"utente_operazione = #{utenteOperazione,jdbcType=VARCHAR},",
		"data_creazione = #{dataCreazione,jdbcType=TIMESTAMP},",
		"data_modifica = #{dataModifica,jdbcType=TIMESTAMP},",
		"data_cancellazione = #{dataCancellazione,jdbcType=TIMESTAMP}",
		"where consfarm_id = #{consfarmId,jdbcType=INTEGER}" })
int logicDeleteByPrimaryKey(CovidusTConsensoFarmaco record);
}
