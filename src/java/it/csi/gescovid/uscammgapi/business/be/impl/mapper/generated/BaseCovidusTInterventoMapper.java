package it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTIntervento;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface BaseCovidusTInterventoMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_t_intervento
	 * @mbg.generated
	 */
	@Delete({ "delete from covidus_t_intervento", "where int_id = #{intId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer intId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_t_intervento
	 * @mbg.generated
	 */
	@Insert({ "insert into covidus_t_intervento (int_data, int_desc, ", "int_azione_intrapresa, sch_id, ",
			"int_tipo_id, az_id, ", "utente_operazione, data_creazione, ", "data_modifica, data_cancellazione)",
			"values (#{intData,jdbcType=TIMESTAMP}, #{intDesc,jdbcType=VARCHAR}, ",
			"#{intAzioneIntrapresa,jdbcType=VARCHAR}, #{schId,jdbcType=INTEGER}, ",
			"#{intTipoId,jdbcType=INTEGER}, #{azId,jdbcType=INTEGER}, ",
			"#{utenteOperazione,jdbcType=VARCHAR}, #{dataCreazione,jdbcType=TIMESTAMP}, ",
			"#{dataModifica,jdbcType=TIMESTAMP}, #{dataCancellazione,jdbcType=TIMESTAMP})" })
	@Options(useGeneratedKeys = true, keyProperty = "intId")
	int insert(CovidusTIntervento record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_t_intervento
	 * @mbg.generated
	 */
	@Select({ "select", "int_id, int_data, int_desc, int_azione_intrapresa, sch_id, int_tipo_id, az_id, ",
			"utente_operazione, data_creazione, data_modifica, data_cancellazione", "from covidus_t_intervento",
			"where int_id = #{intId,jdbcType=INTEGER}" })
	@Results({ @Result(column = "int_id", property = "intId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "int_data", property = "intData", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "int_desc", property = "intDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "int_azione_intrapresa", property = "intAzioneIntrapresa", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sch_id", property = "schId", jdbcType = JdbcType.INTEGER),
			@Result(column = "int_tipo_id", property = "intTipoId", jdbcType = JdbcType.INTEGER),
			@Result(column = "az_id", property = "azId", jdbcType = JdbcType.INTEGER),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
	CovidusTIntervento selectByPrimaryKey(Integer intId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_t_intervento
	 * @mbg.generated
	 */
	@Select({ "select", "int_id, int_data, int_desc, int_azione_intrapresa, sch_id, int_tipo_id, az_id, ",
			"utente_operazione, data_creazione, data_modifica, data_cancellazione", "from covidus_t_intervento" })
	@Results({ @Result(column = "int_id", property = "intId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "int_data", property = "intData", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "int_desc", property = "intDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "int_azione_intrapresa", property = "intAzioneIntrapresa", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sch_id", property = "schId", jdbcType = JdbcType.INTEGER),
			@Result(column = "int_tipo_id", property = "intTipoId", jdbcType = JdbcType.INTEGER),
			@Result(column = "az_id", property = "azId", jdbcType = JdbcType.INTEGER),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
	List<CovidusTIntervento> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_t_intervento
	 * @mbg.generated
	 */
	@Update({ "update covidus_t_intervento", "set int_data = #{intData,jdbcType=TIMESTAMP},",
			"int_desc = #{intDesc,jdbcType=VARCHAR},",
			"int_azione_intrapresa = #{intAzioneIntrapresa,jdbcType=VARCHAR},", "sch_id = #{schId,jdbcType=INTEGER},",
			"int_tipo_id = #{intTipoId,jdbcType=INTEGER},", "az_id = #{azId,jdbcType=INTEGER},",
			"utente_operazione = #{utenteOperazione,jdbcType=VARCHAR},",
			"data_creazione = #{dataCreazione,jdbcType=TIMESTAMP},",
			"data_modifica = #{dataModifica,jdbcType=TIMESTAMP},",
			"data_cancellazione = #{dataCancellazione,jdbcType=TIMESTAMP}",
			"where int_id = #{intId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(CovidusTIntervento record);
}