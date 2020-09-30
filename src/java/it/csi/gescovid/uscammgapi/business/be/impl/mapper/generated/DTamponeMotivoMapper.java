package it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.TamponeMotivo;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface DTamponeMotivoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_tampone_motivo
     *
     * @mbg.generated
     */
    @Delete({
        "delete from d_tampone_motivo",
        "where tampone_motivo_id = #{tamponeMotivoId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer tamponeMotivoId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_tampone_motivo
     *
     * @mbg.generated
     */
    @Insert({
        "insert into d_tampone_motivo (tampone_motivo_cod, tampone_motivo_desc, ",
        "validita_inizio, validita_fine, ",
        "utente_operazione, data_creazione, ",
        "data_modifica, data_cancellazione)",
        "values (#{tamponeMotivoCod,jdbcType=VARCHAR}, #{tamponeMotivoDesc,jdbcType=VARCHAR}, ",
        "#{validitaInizio,jdbcType=TIMESTAMP}, #{validitaFine,jdbcType=TIMESTAMP}, ",
        "#{utenteOperazione,jdbcType=VARCHAR}, #{dataCreazione,jdbcType=TIMESTAMP}, ",
        "#{dataModifica,jdbcType=TIMESTAMP}, #{dataCancellazione,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys=true,keyProperty="tamponeMotivoId")
    int insert(TamponeMotivo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_tampone_motivo
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "tampone_motivo_id, tampone_motivo_cod, tampone_motivo_desc, validita_inizio, ",
        "validita_fine, utente_operazione, data_creazione, data_modifica, data_cancellazione",
        "from d_tampone_motivo",
        "where tampone_motivo_id = #{tamponeMotivoId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="tampone_motivo_id", property="tamponeMotivoId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="tampone_motivo_cod", property="tamponeMotivoCod", jdbcType=JdbcType.VARCHAR),
        @Result(column="tampone_motivo_desc", property="tamponeMotivoDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_modifica", property="dataModifica", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP)
    })
    TamponeMotivo selectByPrimaryKey(Integer tamponeMotivoId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_tampone_motivo
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "tampone_motivo_id, tampone_motivo_cod, tampone_motivo_desc, validita_inizio, ",
        "validita_fine, utente_operazione, data_creazione, data_modifica, data_cancellazione",
        "from d_tampone_motivo"
    })
    @Results({
        @Result(column="tampone_motivo_id", property="tamponeMotivoId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="tampone_motivo_cod", property="tamponeMotivoCod", jdbcType=JdbcType.VARCHAR),
        @Result(column="tampone_motivo_desc", property="tamponeMotivoDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_modifica", property="dataModifica", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TamponeMotivo> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d_tampone_motivo
     *
     * @mbg.generated
     */
    @Update({
        "update d_tampone_motivo",
        "set tampone_motivo_cod = #{tamponeMotivoCod,jdbcType=VARCHAR},",
          "tampone_motivo_desc = #{tamponeMotivoDesc,jdbcType=VARCHAR},",
          "validita_inizio = #{validitaInizio,jdbcType=TIMESTAMP},",
          "validita_fine = #{validitaFine,jdbcType=TIMESTAMP},",
          "utente_operazione = #{utenteOperazione,jdbcType=VARCHAR},",
          "data_creazione = #{dataCreazione,jdbcType=TIMESTAMP},",
          "data_modifica = #{dataModifica,jdbcType=TIMESTAMP},",
          "data_cancellazione = #{dataCancellazione,jdbcType=TIMESTAMP}",
        "where tampone_motivo_id = #{tamponeMotivoId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TamponeMotivo record);
}