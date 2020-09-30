package it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDSintomo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusRDiarioDetSintomo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTDiario;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTDiarioDet;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.UtenteContatto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Utenti;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.DiarioExtDto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseCovidusTDiarioMapper;
import it.csi.gescovid.uscammgapi.dto.ModelDiario;
import it.csi.gescovid.uscammgapi.dto.ModelDiarioDettaglio;
import it.csi.gescovid.uscammgapi.dto.ModelDiarioDettaglioSintomo;

public interface DiariMapper extends BaseCovidusTDiarioMapper {
	

	
	//tabella diari
	@Select({ "select", "diario.dia_id, diario.id_soggetto, diario.utente_operazione, diario.id_profilo_operazione, diario.data_creazione, ",
		"diario.data_modifica, diario.data_cancellazione,",
		//diario dett
		"det.diadet_id, det.diadet_data, det.diadet_note, det.dia_id, det.int_id,  det.id_profilo_operazione, ",
		"det.data_creazione as dataCreazioneDet, det.data_modifica as dataModificeDet,",
		"det.utente_operazione as cfdetutenteoperazione,",
		//utente_contatto
		"cont.cf_utente as contCfUntente, cont.nome, cont.cognome, cont.telefono, cont.email,",
		//sintomi
		"sintomo.sin_id, sintomo.sin_cod, sintomo.sin_desc",
		"from covidus_t_diario diario",
		"inner join covidus_t_diario_det det on (diario.dia_id = det.dia_id)",
		"left join utente_contatto cont on (det.utente_operazione = cont.cf_utente )",
		"inner join covidus_r_diario_det_sintomo rsintomo on (det.diadet_id = rsintomo.diadet_id )",
		"inner join covidus_d_sintomo sintomo on (sintomo.sin_id = rsintomo.sin_id)",
		"where diario.data_cancellazione is null",
		"and det.data_cancellazione is null",
		"and rsintomo.data_cancellazione is null",
		"and sintomo.data_cancellazione is null",
		"and diario.id_soggetto =  #{idSoggetto,jdbcType=INTEGER}",
		"and now() between sintomo.validita_inizio and coalesce(sintomo.validita_fine, to_timestamp('01/01/2999','dd/mm/yyyy')) ",
		"order by det.diadet_id desc"})
	@Results({ @Result(column = "dia_id", property = "diaId", jdbcType = JdbcType.INTEGER, id = true),
		@Result(column = "id_soggetto", property = "idSoggetto", jdbcType = JdbcType.BIGINT),
		@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
		@Result(column = "id_profilo_operazione", property = "idProfiloOperazione", jdbcType = JdbcType.INTEGER),
		@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP),
		//diario dett
		@Result(column = "diadet_id", property = "diarioDet.diadetId", jdbcType = JdbcType.INTEGER, id = true),
		@Result(column = "diadet_data", property = "diarioDet.diadetData", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "diadet_note", property = "diarioDet.diadetNote", jdbcType = JdbcType.VARCHAR),
		@Result(column = "dia_id", property = "diarioDet.diaId", jdbcType = JdbcType.INTEGER),
		@Result(column = "int_id", property = "diarioDet.intId", jdbcType = JdbcType.INTEGER),
		@Result(column = "id_profilo_operazione", property = "diarioDet.idProfiloOperazione", jdbcType = JdbcType.INTEGER),
		@Result(column = "dataCreazioneDet", property = "diarioDet.dataCreazione", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "dataModificeDet", property = "diarioDet.dataModifica", jdbcType = JdbcType.TIMESTAMP),
		//utente_contatto
		@Result(column = "cfdetutenteoperazione", property = "diarioDet.utenteContatto.cfUtente", jdbcType = JdbcType.VARCHAR, id = true),
		@Result(column = "nome", property = "diarioDet.utenteContatto.nome", jdbcType = JdbcType.VARCHAR),
		@Result(column = "cognome", property = "diarioDet.utenteContatto.cognome", jdbcType = JdbcType.VARCHAR),
		@Result(column = "telefono", property = "diarioDet.utenteContatto.telefono", jdbcType = JdbcType.VARCHAR),
		@Result(column = "email", property = "diarioDet.utenteContatto.email", jdbcType = JdbcType.VARCHAR), 
		//sintomi
		@Result(column = "diadet_id", property = "sintomo.diarioDetId", jdbcType = JdbcType.INTEGER, id = true),
		@Result(column = "sin_id", property = "sintomo.sinId", jdbcType = JdbcType.INTEGER, id = true),
		@Result(column = "sin_cod", property = "sintomo.sinCod", jdbcType = JdbcType.VARCHAR),
		@Result(column = "sin_desc", property = "sintomo.sinDesc", jdbcType = JdbcType.VARCHAR)
		
		})
	List<DiarioExtDto> selectAllDiariPerSoggetto(@Param("idSoggetto")Integer idSoggetto);
	
	
	@Select({ "select", "dia_id, id_soggetto, utente_operazione, id_profilo_operazione, data_creazione, ",
		"data_modifica, data_cancellazione", "from covidus_t_diario", "where id_soggetto =  #{idSoggetto,jdbcType=INTEGER}",
		"and data_cancellazione is null"})
	@Results({ @Result(column = "dia_id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
		@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP) })
	List<ModelDiario> selectDiariPerIdSoggetto(@Param("idSoggetto")Integer idSoggetto);
	
	
	//select diaridett
	@Select({ "select",
		//diario dett
		"det.diadet_id, det.diadet_data, det.diadet_note,",
		" det.dia_id, det.int_id,  det.id_profilo_operazione, ",
		"det.data_creazione as dataCreazioneDet, det.data_modifica as dataModificeDet,",
		"det.adicovid_id,",
		//utente
		"utenti.cf_utente, utenti.id_asr, utenti.id_laboratorio,",
		//utente_contatto
		"cont.cf_utente as contCfUntente, cont.nome, cont.cognome, cont.telefono, cont.email",
		//sintomi
		"from covidus_t_diario_det det",
		"inner join utenti utenti on(det.utente_operazione = utenti.cf_utente)",
		"left join utente_contatto cont on (utenti.cf_utente = cont.cf_utente )",
		"where ",
		"det.data_cancellazione is null",
	"and det.dia_id =  #{diaId,jdbcType=INTEGER}"})
	@Results({ @Result(column = "diadet_id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
		@Result(column = "diadet_data", property = "data", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "diadet_note", property = "note", jdbcType = JdbcType.VARCHAR),
		@Result(column = "adicovid_id", property = "idAdiCovid", jdbcType = JdbcType.INTEGER),
		@Result(column = "dia_id", property = "diarioId", jdbcType = JdbcType.INTEGER),
		@Result(column = "dataCreazioneDet", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "dataModificeDet", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "int_id",  property = "interventoId", jdbcType = JdbcType.VARCHAR),
		//utente
		@Result(column = "cf_utente", property = "autore.codiceFiscale", jdbcType = JdbcType.VARCHAR),
		@Result(column = "nome", property = "autore.nome", jdbcType = JdbcType.VARCHAR),
		@Result(column = "cognome", property = "autore.cognome", jdbcType = JdbcType.VARCHAR),
		@Result(column = "telefono", property = "autore.telefono", jdbcType = JdbcType.VARCHAR),
		@Result(column = "email", property = "autore.mail", jdbcType = JdbcType.VARCHAR) })
	List<ModelDiarioDettaglio> selectDiariDettagliPerIdDiario(@Param("diaId")Integer diaId);

	//select sintomi dett
	@Select({ "select",
		"sintomo.sin_id, sintomo.sin_cod, sintomo.sin_desc,",
		"sintomo.sin_misurabile, sintomo.sin_unita_misura, rsintomo.sin_note, rsintomo.sin_valore",
		"from ",
		"covidus_r_diario_det_sintomo rsintomo",
		"inner join covidus_d_sintomo sintomo on (sintomo.sin_id = rsintomo.sin_id)",
		"where ",
		"rsintomo.data_cancellazione is null",
		"and sintomo.data_cancellazione is null",
		"and rsintomo.diadet_id =  #{diadetId,jdbcType=INTEGER}",
		"and now() between sintomo.validita_inizio and coalesce(sintomo.validita_fine, to_timestamp('01/01/2999','dd/mm/yyyy')) "})
	@Results({ @Result(column = "sin_id", property = "id", jdbcType = JdbcType.INTEGER ),
	@Result(column = "sin_cod", property = "codice", jdbcType = JdbcType.VARCHAR),
	@Result(column = "sin_desc", property = "nome", jdbcType = JdbcType.VARCHAR),
	@Result(column = "sin_misurabile", property = "misurabile", jdbcType = JdbcType.BOOLEAN),
	@Result(column = "sin_unita_misura", property = "unitaMisura", jdbcType = JdbcType.VARCHAR),
	@Result(column = "sin_note", property = "note", jdbcType = JdbcType.VARCHAR),
	@Result(column = "sin_valore", property = "valore", jdbcType = JdbcType.NUMERIC) })
	List<ModelDiarioDettaglioSintomo> selectSintomiPerIdDettaglioDett(@Param("diadetId")Integer diadetId);
	
}
