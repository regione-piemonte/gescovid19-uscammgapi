package it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTFile;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseCovidusTFileMapper;

public interface CovidusTFileMapper extends BaseCovidusTFileMapper{


	@Select({ "select", "file_id, file_name, file_size, file_type, file_tipo_id, file_code, file_note, ",
			"utente_operazione, data_creazione, data_modifica, data_cancellazione, file", "from covidus_t_file",
			"where file_id = #{fileId,jdbcType=INTEGER}" })
	@Results({ @Result(column = "file_id", property = "fileId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "file_name", property = "fileName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "file_size", property = "fileSize", jdbcType = JdbcType.NUMERIC),
			@Result(column = "file_type", property = "fileType", jdbcType = JdbcType.VARCHAR),
			@Result(column = "file_tipo_id", property = "fileTipoId", jdbcType = JdbcType.INTEGER),
			@Result(column = "file_code", property = "fileCode", jdbcType = JdbcType.VARCHAR),
			@Result(column = "file_note", property = "fileNote", jdbcType = JdbcType.VARCHAR),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "file", property = "file", jdbcType = JdbcType.BINARY) })
	CovidusTFile selectByDocId(Integer fileId);


	@Select({ "select a.file_id, a.file_name, a.file_size, a.file_note, a.file_tipo_id ", 
			" from covidus_t_file a, covidus_r_scheda_file b",
			" where a.file_id= b.file_id ", 
			" and b.sch_id = #{schedaid,jdbcType=INTEGER} and b.data_cancellazione is null " })
	@Results({ @Result(column = "file_id", property = "fileId", jdbcType = JdbcType.INTEGER, id = true),
		@Result(column = "file_name", property = "fileName", jdbcType = JdbcType.VARCHAR),
		@Result(column = "file_size", property = "fileSize", jdbcType = JdbcType.NUMERIC),
		@Result(column = "file_note", property = "fileNote", jdbcType = JdbcType.VARCHAR),
		@Result(column = "file_tipo_id", property = "fileTipoId", jdbcType = JdbcType.INTEGER)})
	List<CovidusTFile> selectFileByRSchedaId(Integer schedaid);	
	
	
	
	@Select({ "select a.file_id, a.file_name, a.file_size, a.file_note, a.file_tipo_id ", 
		" from covidus_t_file a, covidus_r_intervento_file b",
		" where a.file_id= b.file_id ", 
		" and b.int_id = #{interventoId,jdbcType=INTEGER} and b.data_cancellazione is null " })
	@Results({ @Result(column = "file_id", property = "fileId", jdbcType = JdbcType.INTEGER, id = true),
		@Result(column = "file_name", property = "fileName", jdbcType = JdbcType.VARCHAR),
		@Result(column = "file_size", property = "fileSize", jdbcType = JdbcType.NUMERIC),
		@Result(column = "file_note", property = "fileNote", jdbcType = JdbcType.VARCHAR),
		@Result(column = "file_tipo_id", property = "fileTipoId", jdbcType = JdbcType.INTEGER)})
	List<CovidusTFile> selectFileByRInterventoId(Integer interventoId);	
	
	@Update({ "update covidus_t_file", "set ",
		"data_cancellazione = now()",
		"where file_id = #{idFile,jdbcType=INTEGER}" })
int logicDeleteByPrimaryKey(Integer idFile);
}