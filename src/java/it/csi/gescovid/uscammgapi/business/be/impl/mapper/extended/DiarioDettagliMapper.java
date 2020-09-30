package it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDSintomo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusRDiarioDetSintomo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTDiario;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTDiarioDet;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseCovidusTDiarioDetMapper;
import it.csi.gescovid.uscammgapi.dto.ModelDiarioDettaglio;
import it.csi.gescovid.uscammgapi.dto.ModelDiarioDettaglioSintomo;

public interface DiarioDettagliMapper extends BaseCovidusTDiarioDetMapper {

		@Select({ "select", "dia_id, id_soggetto, utente_operazione, id_profilo_operazione, data_creazione, ",
			"data_modifica, data_cancellazione", "from covidus_t_diario", 
			"where data_cancellazione is null  ",
			"and id_soggetto = #{idSoggetto,jdbcType=INTEGER}" })
		@Results({ @Result(column = "dia_id", property = "diaId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "id_soggetto", property = "idSoggetto", jdbcType = JdbcType.BIGINT),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "id_profilo_operazione", property = "idProfiloOperazione", jdbcType = JdbcType.INTEGER),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
		List<CovidusTDiario>  selectListDiarioByIdSoggetto(Integer idSoggetto);

		
		@Insert({ "insert into covidus_t_diario (id_soggetto, utente_operazione, ",
			"id_profilo_operazione)",
			"values (#{idSoggetto,jdbcType=BIGINT}, #{utenteOperazione,jdbcType=VARCHAR}, ",
			"#{idProfiloOperazione,jdbcType=INTEGER})" })
		@Options(useGeneratedKeys = true, keyProperty = "diaId")
		int insertDiario(CovidusTDiario record);

		@Insert({ "insert into covidus_t_diario_det (diadet_data, diadet_note, ",
			"adicovid_id,", 
			"dia_id, int_id, utente_operazione, ",
			"id_profilo_operazione)",
			"values (#{diadetData,jdbcType=TIMESTAMP}, #{diadetNote,jdbcType=VARCHAR}, ",
			"#{adicovidId,jdbcType=INTEGER}, ",
			"#{diaId,jdbcType=INTEGER}, #{intId,jdbcType=INTEGER}, #{utenteOperazione,jdbcType=VARCHAR}, ",
			"#{idProfiloOperazione,jdbcType=INTEGER})" })
		@Options(useGeneratedKeys = true, keyProperty = "diadetId")
		int insert(CovidusTDiarioDet record);

		@Insert({ "insert into covidus_r_diario_det_sintomo (diadet_id, sin_id, ", 
			"sin_note, sin_valore,",
			"utente_operazione, ",
			"id_profilo_operazione)",
			"values (#{diadetId,jdbcType=INTEGER}, #{sinId,jdbcType=INTEGER}, ",
			"#{sinNote,jdbcType=VARCHAR}, #{sinValore,jdbcType=NUMERIC}, ",
			"#{utenteOperazione,jdbcType=VARCHAR}, ",
			"#{idProfiloOperazione,jdbcType=INTEGER})" })
		@Options(useGeneratedKeys = true, keyProperty = "diadetsinId")
		int insertRDiarioDetSintomo(CovidusRDiarioDetSintomo record);

		
		@Select({ "select",
			"diadet_id, diadet_data, diadet_note, adicovid_id, dia_id, int_id, utente_operazione, id_profilo_operazione, ",
			"data_creazione, data_modifica, data_cancellazione,", 
			"utente_contatto.nome, utente_contatto.cognome, utente_contatto.telefono, utente_contatto.email", 
			"from covidus_t_diario_det",
			"left join utente_contatto on utente_contatto.cf_utente = covidus_t_diario_det.utente_operazione",
			"where diadet_id = #{diadetId,jdbcType=INTEGER}", 
			"and data_cancellazione is null ",
			})
	@Results({ 
			@Result(column = "diadet_id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "diadet_data", property = "data", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "diadet_note", property = "note", jdbcType = JdbcType.VARCHAR),
			@Result(column = "adicovid_id", property = "idAdiCovid", jdbcType = JdbcType.BOOLEAN),
			@Result(column = "dia_id", property = "diarioId", jdbcType = JdbcType.INTEGER),
			@Result(column = "int_id", property = "interventoId", jdbcType = JdbcType.INTEGER),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),

			@Result(column = "utente_operazione", property = "autore.codiceFiscale", jdbcType = JdbcType.VARCHAR),
			@Result(column = "nome", property = "autore.nome", jdbcType = JdbcType.VARCHAR),
			@Result(column = "cognome", property = "autore.cognome", jdbcType = JdbcType.VARCHAR),
			@Result(column = "telefono", property = "autore.telefono", jdbcType = JdbcType.VARCHAR),
			@Result(column = "email", property = "autore.mail", jdbcType = JdbcType.VARCHAR),

			})
	ModelDiarioDettaglio selectModelDiarioDettaglioByPrimaryKey(Integer diadetId);

		@Select({ "select",
			"sintomo.sin_id, sintomo.sin_cod, sintomo.sin_desc, sintomo.utente_operazione, sintomo.validita_inizio, sintomo.validita_fine, ",
			"sintomo.data_creazione, sintomo.data_modifica, sintomo.data_cancellazione,", 
			"sintomo.sin_misurabile, sintomo.sin_unita_misura, rsintomo.sin_note, rsintomo.sin_valore",
			"from covidus_d_sintomo sintomo",
			"inner join covidus_r_diario_det_sintomo rsintomo on (sintomo.sin_id = rsintomo.sin_id )",
			"where ",
			" rsintomo.data_cancellazione is null",
			"and sintomo.data_cancellazione is null",
			"and now() between sintomo.validita_inizio and coalesce(sintomo.validita_fine, to_timestamp('01/01/2999','dd/mm/yyyy')) ",
			" and rsintomo.diadet_id = #{diadetId,jdbcType=INTEGER}"})
		@Results({ 
			@Result(column = "sin_id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "sin_cod", property = "codice", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sin_desc", property = "nome", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sin_misurabile", property = "misurabile", jdbcType = JdbcType.BOOLEAN),
			@Result(column = "sin_unita_misura", property = "unitaMisura", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sin_note", property = "note", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sin_valore", property = "valore", jdbcType = JdbcType.NUMERIC)
		})
		List<ModelDiarioDettaglioSintomo> selectSintomiByIdDiarioDett(Integer diadetId);

		
		@Update({ "update covidus_t_diario_det", "set ",
			"data_cancellazione = now()",
			 "where int_id = #{idIntervento,jdbcType=INTEGER}" })
	int logicDeleteByIdIntervento(Integer idIntervento);
}
