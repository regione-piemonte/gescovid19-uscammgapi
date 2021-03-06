package it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDInterventoTipo;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.annotations.Options;

public interface BaseCovidusDInterventoTipoMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_d_intervento_tipo
	 * @mbg.generated
	 */
	@Delete({ "delete from covidus_d_intervento_tipo", "where int_tipo_id = #{intTipoId,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer intTipoId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_d_intervento_tipo
	 * @mbg.generated
	 */
	@Insert({ "insert into covidus_d_intervento_tipo (int_tipo_cod, int_tipo_desc, ",
			"validita_inizio, validita_fine, ", "utente_operazione, data_creazione, ",
			"data_modifica, data_cancellazione)",
			"values (#{intTipoCod,jdbcType=VARCHAR}, #{intTipoDesc,jdbcType=VARCHAR}, ",
			"#{validitaInizio,jdbcType=TIMESTAMP}, #{validitaFine,jdbcType=TIMESTAMP}, ",
			"#{utenteOperazione,jdbcType=VARCHAR}, #{dataCreazione,jdbcType=TIMESTAMP}, ",
			"#{dataModifica,jdbcType=TIMESTAMP}, #{dataCancellazione,jdbcType=TIMESTAMP})" })
	@Options(useGeneratedKeys = true, keyProperty = "intTipoId")
	int insert(CovidusDInterventoTipo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_d_intervento_tipo
	 * @mbg.generated
	 */
	@Select({ "select", "int_tipo_id, int_tipo_cod, int_tipo_desc, validita_inizio, validita_fine, utente_operazione, ",
			"data_creazione, data_modifica, data_cancellazione", "from covidus_d_intervento_tipo",
			"where int_tipo_id = #{intTipoId,jdbcType=INTEGER}" })
	@Results({ @Result(column = "int_tipo_id", property = "intTipoId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "int_tipo_cod", property = "intTipoCod", jdbcType = JdbcType.VARCHAR),
			@Result(column = "int_tipo_desc", property = "intTipoDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
	CovidusDInterventoTipo selectByPrimaryKey(Integer intTipoId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_d_intervento_tipo
	 * @mbg.generated
	 */
	@Select({ "select", "int_tipo_id, int_tipo_cod, int_tipo_desc, validita_inizio, validita_fine, utente_operazione, ",
			"data_creazione, data_modifica, data_cancellazione", "from covidus_d_intervento_tipo" })
	@Results({ @Result(column = "int_tipo_id", property = "intTipoId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "int_tipo_cod", property = "intTipoCod", jdbcType = JdbcType.VARCHAR),
			@Result(column = "int_tipo_desc", property = "intTipoDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
	List<CovidusDInterventoTipo> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table covidus_d_intervento_tipo
	 * @mbg.generated
	 */
	@Update({ "update covidus_d_intervento_tipo", "set int_tipo_cod = #{intTipoCod,jdbcType=VARCHAR},",
			"int_tipo_desc = #{intTipoDesc,jdbcType=VARCHAR},",
			"validita_inizio = #{validitaInizio,jdbcType=TIMESTAMP},",
			"validita_fine = #{validitaFine,jdbcType=TIMESTAMP},",
			"utente_operazione = #{utenteOperazione,jdbcType=VARCHAR},",
			"data_creazione = #{dataCreazione,jdbcType=TIMESTAMP},",
			"data_modifica = #{dataModifica,jdbcType=TIMESTAMP},",
			"data_cancellazione = #{dataCancellazione,jdbcType=TIMESTAMP}",
			"where int_tipo_id = #{intTipoId,jdbcType=INTEGER}" })
	int updateByPrimaryKey(CovidusDInterventoTipo record);
}