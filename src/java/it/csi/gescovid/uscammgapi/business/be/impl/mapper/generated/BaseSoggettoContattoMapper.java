package it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.SoggettoContatto;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface BaseSoggettoContattoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table r_soggetto_contatti
     *
     * @mbg.generated
     */
    @Delete({
        "delete from r_soggetto_contatti",
        "where id_soggetto_contatti = #{idSoggettoContatti,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer idSoggettoContatti);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table r_soggetto_contatti
     *
     * @mbg.generated
     */
    @Insert({
        "insert into r_soggetto_contatti (id_soggetto_contatti, id_soggetto_da, ",
        "id_soggetto_a, note_contatto, ",
        "id_decorso, contatto_tipo_id, ",
        "validita_inizio, validita_fine, ",
        "utente_operazione, data_creazione, ",
        "data_modifca, data_cancellazione)",
        "values (#{idSoggettoContatti,jdbcType=INTEGER}, #{idSoggettoDa,jdbcType=BIGINT}, ",
        "#{idSoggettoA,jdbcType=BIGINT}, #{noteContatto,jdbcType=VARCHAR}, ",
        "#{idDecorso,jdbcType=BIGINT}, #{contattoTipoId,jdbcType=BIGINT}, ",
        "#{validitaInizio,jdbcType=TIMESTAMP}, #{validitaFine,jdbcType=TIMESTAMP}, ",
        "#{utenteOperazione,jdbcType=VARCHAR}, #{dataCreazione,jdbcType=TIMESTAMP}, ",
        "#{dataModifca,jdbcType=TIMESTAMP}, #{dataCancellazione,jdbcType=TIMESTAMP})"
    })
    int insert(SoggettoContatto record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table r_soggetto_contatti
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id_soggetto_contatti, id_soggetto_da, id_soggetto_a, note_contatto, id_decorso, ",
        "contatto_tipo_id, validita_inizio, validita_fine, utente_operazione, data_creazione, ",
        "data_modifca, data_cancellazione",
        "from r_soggetto_contatti",
        "where id_soggetto_contatti = #{idSoggettoContatti,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id_soggetto_contatti", property="idSoggettoContatti", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="id_soggetto_da", property="idSoggettoDa", jdbcType=JdbcType.BIGINT),
        @Result(column="id_soggetto_a", property="idSoggettoA", jdbcType=JdbcType.BIGINT),
        @Result(column="note_contatto", property="noteContatto", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_decorso", property="idDecorso", jdbcType=JdbcType.BIGINT),
        @Result(column="contatto_tipo_id", property="contattoTipoId", jdbcType=JdbcType.BIGINT),
        @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_modifca", property="dataModifca", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP)
    })
    SoggettoContatto selectByPrimaryKey(Integer idSoggettoContatti);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table r_soggetto_contatti
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id_soggetto_contatti, id_soggetto_da, id_soggetto_a, note_contatto, id_decorso, ",
        "contatto_tipo_id, validita_inizio, validita_fine, utente_operazione, data_creazione, ",
        "data_modifca, data_cancellazione",
        "from r_soggetto_contatti"
    })
    @Results({
        @Result(column="id_soggetto_contatti", property="idSoggettoContatti", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="id_soggetto_da", property="idSoggettoDa", jdbcType=JdbcType.BIGINT),
        @Result(column="id_soggetto_a", property="idSoggettoA", jdbcType=JdbcType.BIGINT),
        @Result(column="note_contatto", property="noteContatto", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_decorso", property="idDecorso", jdbcType=JdbcType.BIGINT),
        @Result(column="contatto_tipo_id", property="contattoTipoId", jdbcType=JdbcType.BIGINT),
        @Result(column="validita_inizio", property="validitaInizio", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="validita_fine", property="validitaFine", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utente_operazione", property="utenteOperazione", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_creazione", property="dataCreazione", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_modifca", property="dataModifca", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data_cancellazione", property="dataCancellazione", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SoggettoContatto> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table r_soggetto_contatti
     *
     * @mbg.generated
     */
    @Update({
        "update r_soggetto_contatti",
        "set id_soggetto_da = #{idSoggettoDa,jdbcType=BIGINT},",
          "id_soggetto_a = #{idSoggettoA,jdbcType=BIGINT},",
          "note_contatto = #{noteContatto,jdbcType=VARCHAR},",
          "id_decorso = #{idDecorso,jdbcType=BIGINT},",
          "contatto_tipo_id = #{contattoTipoId,jdbcType=BIGINT},",
          "validita_inizio = #{validitaInizio,jdbcType=TIMESTAMP},",
          "validita_fine = #{validitaFine,jdbcType=TIMESTAMP},",
          "utente_operazione = #{utenteOperazione,jdbcType=VARCHAR},",
          "data_creazione = #{dataCreazione,jdbcType=TIMESTAMP},",
          "data_modifca = #{dataModifca,jdbcType=TIMESTAMP},",
          "data_cancellazione = #{dataCancellazione,jdbcType=TIMESTAMP}",
        "where id_soggetto_contatti = #{idSoggettoContatti,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SoggettoContatto record);
}