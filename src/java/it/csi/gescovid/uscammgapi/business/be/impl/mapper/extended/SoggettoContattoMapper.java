package it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.SoggettoContatto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseSoggettoContattoMapper;



public interface SoggettoContattoMapper extends BaseSoggettoContattoMapper {


	
	@Select({ 
		"<script>", 
		"select", "id_soggetto_contatti, id_soggetto_da, id_soggetto_a, note_contatto, id_decorso, ",
		"contatto_tipo_id, validita_inizio, validita_fine, utente_operazione, data_creazione, ",
		"data_modifca, data_cancellazione", 
		"from r_soggetto_contatti rsc",
		"where rsc.id_soggetto_contatti = rsc.id_soggetto_contatti",
		"<if test='idSoggettoDa != null'> and rsc.id_soggetto_da = #{idSoggettoDa,jdbcType=BIGINT} </if>",
		"<if test='idSoggettoA != null'> and rsc.id_soggetto_a = #{idSoggettoA,jdbcType=BIGINT} </if>",
		"</script>"
	
	})
	@Results({
			@Result(column = "id_soggetto_contatti", property = "idSoggettoContatti", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "id_soggetto_da", property = "idSoggettoDa", jdbcType = JdbcType.BIGINT),
			@Result(column = "id_soggetto_a", property = "idSoggettoA", jdbcType = JdbcType.BIGINT),
			@Result(column = "note_contatto", property = "noteContatto", jdbcType = JdbcType.VARCHAR),
			@Result(column = "id_decorso", property = "idDecorso", jdbcType = JdbcType.BIGINT),
			@Result(column = "contatto_tipo_id", property = "contattoTipoId", jdbcType = JdbcType.BIGINT),
			@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifca", property = "dataModifca", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
	List<SoggettoContatto> selectContattiDaA(@Param("idSoggettoDa") Long idSoggettoDa, @Param("idSoggettoA") Long idSoggettoA);
	
	

}
