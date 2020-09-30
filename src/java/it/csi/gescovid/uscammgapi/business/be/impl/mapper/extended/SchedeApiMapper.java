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

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDAzione;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDInterventoTipo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDSchedaStato;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusRInterventoPresc;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusRSchedaPresc;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusRSchedaStato;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTIntervento;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTScheda;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Medico;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.UtenteContatto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.ContatoreCustomDto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.CronologiaStatoCustomDto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.InterventoCustomDto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.PrescrizioneInterventoCustomDto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.PrescrizioneSchedaCustomDto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.SchedeCustomDto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseCovidusRSchedaPrescMapper;

public interface SchedeApiMapper extends BaseCovidusRSchedaPrescMapper {

	static final String SCHEDE = "select" + "	cts.sch_id id_scheda," + "	cts.sch_data data_scheda,"
			+ "	cts.sch_descrizione descrizione_scheda," + "	cts.sch_critica critica," + "	cts.richiesta_mmg, "
			+ "	cts.visibile_medico_emergenza," + "	cts.visibile_medico_continuita_ass,"
			+ "	cdss.sch_stato_cod stato_scheda_cod," + "	cdss.sch_stato_desc stato_scheda_desc," + "	s2.id_soggetto,"
			+ "	s2.codice_fiscale," + "	s2.nome nome_soggetto," + "	s2.cognome cognome_soggetto,"
			+ "	s2.data_nascita data_nascita_soggetto," + "	s2.email email_soggetto,"
			+ "	s2.telefono_recapito telefono_soggetto," + "	s2.asl_domicilio," + "	s2.asl_residenza,"
			+ "	s2.comune_domicilio_istat," + "	s2.comune_residenza_istat," + "	s2.indirizzo_domicilio,"
			+ "	s.id_struttura id_struttura," + "	s.nome nome_struttura," + "	s.natura natura_struttura,"
			+ "	e2.id_ente id_ente," + "	e2.nome nome_ente," + "	utenti.cf_utente cf_medico,"
			+ "	con.nome nome_medico," + "	con.cognome cognome_medico," + "	con.telefono telefono_medico,"
			+ "	con.email email_medico, sch_terapia_cronica, md.monitoraggio_tipo_id, md.monitoraggio_tipo_cod, md.monitoraggio_tipo_desc, "
			+ " count(*) over() as full_count "
			+ "   from covidus_t_scheda cts left join covidus_d_monitoraggio_tipo md on cts.monitoraggio_tipo_id = md.monitoraggio_tipo_id ,"
			+ "	struttura s," + "	ente e2," + "	soggetto s2," + "	covidus_r_scheda_stato crss,"
			+ "	covidus_d_scheda_stato cdss," + "	utenti"
			+ "	left join utente_contatto con on utenti.cf_utente = con.cf_utente " + " where"
			+ "	cts.id_struttura = s.id_struttura" + "	and s.id_ente = e2.id_ente"
			+ "	and cts.id_soggetto = s2.id_soggetto" + "	and cts.utente_operazione = utenti.cf_utente"
			+ "	and now() between crss.validita_inizio and coalesce(crss.validita_fine, to_timestamp('01/01/2999', 'dd/mm/yyyy'))"
			+ "	and cts.sch_id = crss.sch_id" + "	and crss.sch_stato_id = cdss.sch_stato_id"
			+ "	and cts.data_cancellazione is null"
			+ " 	<if test='richiesteMmg != null'> and cts.richiesta_mmg = #{richiesteMmg,jdbcType=BOOLEAN} </if>"
			+ " 	<if test='visibileMed118 != null'> and cts.visibile_medico_emergenza = #{visibileMed118,jdbcType=BOOLEAN} </if>"
			+ "   <if test='visibileMedCa != null'> and cts.visibile_medico_continuita_ass = #{visibileMedCa,jdbcType=BOOLEAN} </if>"
			+ " 	<if test='soggetto != null'> and s2.id_soggetto= #{soggetto,jdbcType=BIGINT} </if>"
			+ " 	<if test='strutture != null'> and s.id_struttura in (${strutture}) </if>"
			+ " 	<if test='stati != null'> and cdss.sch_stato_cod in (${stati}) </if>"
			+ " 	<if test='medico != null'> and utenti.cf_utente = #{medico,jdbcType=VARCHAR} </if>"
			+ " 	<if test='idMonitoraggioTipo != null'> and cts.monitoraggio_tipo_id = #{idMonitoraggioTipo,jdbcType=INTEGER} </if>"
			+ "     <if test='idStruttura != null'> AND s.id_struttura IN (<foreach collection='idStruttura'  item='idS' separator=','>#{idS,jdbcType=VARCHAR} </foreach>) </if>"
			+ " 	<if test='codSchStato != null'> and cdss.sch_stato_cod = #{codSchStato,jdbcType=INTEGER} </if>"
			+ "<if test='filter != null'> " +
    		"         AND ( " +
    		"             lower(s2.codice_fiscale)    like lower(#{filter,jdbcType=VARCHAR}) " +
    		"             OR lower(s2.nome)        like lower(#{filter,jdbcType=VARCHAR}) " +
    		"             OR lower(s2.cognome)           like lower(#{filter,jdbcType=VARCHAR}) " +
    		"             OR lower(codice_fiscale) like lower(#{filter,jdbcType=VARCHAR}) " +
    		"             OR lower(s2.indirizzo_domicilio) like lower(#{filter,jdbcType=VARCHAR}) "+
    		"             OR lower(con.cognome) like lower(#{filter,jdbcType=VARCHAR}) "+
    		"             OR lower(con.nome) like lower(#{filter,jdbcType=VARCHAR}) "+
    		"             " +
    		"         )" +
    		"     </if>" ;
	
	
	static final String SCHEDE_CON_MEDICI_DELEGANTI = "with medicotitolato as ( " +
	"	with med as ( " +
	"	select tb.id_soggetto, tb.id_aura_sogg, "+
	"	tb.wt, "+
	"	rank() over (partition by tb.id_soggetto order by tb.wt,tb.ordine), tb.id_medico From ( "+
	"		with aa as ( "+
	"			select b.id_soggetto, a.id_aura_sogg , 'aa'::text wt, rank() over (partition by b.id_soggetto order by a.data_scelta desc) as ordine, a.id_medico "+
	"			from r_medico_sogg_aura a,r_soggetto_aura b                  "+
	"			where b.id_aura=a.id_aura_sogg and a.data_revoca is null     "+
	"			order by b.id_soggetto, ordine)                              "+
	"			, bb as (                                                    "+
	"			select c.id_soggetto, d.id_aura, 'bb'::text wt, rank() over (partition by c.id_soggetto order by c.id_medico desc) as ordine,c.id_medico "+
	"			from r_medico_soggetto c left join r_soggetto_aura d "+
	"			on d.id_soggetto=c.id_soggetto                      "+
	"			order by c.id_soggetto, ordine)                     "+
	"			select * from aa                                    "+
	"			union                                               "+
	"			select * from bb                                    "+
	"			order by 1,3,4                                      "+
	"		) as tb                                                 "+
	"	) select                                                    "+
	"	a.iD_soggetto,                                              "+
	"	b.* from med a, medico b where rank=1                       "+
	"	and b.id_medico=a.id_medico)                                "+
	"	select cts.sch_id id_scheda, cts.sch_data data_scheda,      "+
	"	cts.sch_descrizione descrizione_scheda, cts.sch_critica critica, cts.richiesta_mmg,           "+
	"	cts.visibile_medico_emergenza, cts.visibile_medico_continuita_ass,                            "+
	"	cdss.sch_stato_cod stato_scheda_cod, cdss.sch_stato_desc stato_scheda_desc, s2.id_soggetto,   "+
	"	s2.codice_fiscale, s2.nome nome_soggetto, s2.cognome cognome_soggetto,                        "+
	"	s2.data_nascita data_nascita_soggetto, s2.email email_soggetto,                               "+
	"	s2.telefono_recapito telefono_soggetto, s2.asl_domicilio, s2.asl_residenza,                   "+
	"	s2.comune_domicilio_istat, s2.comune_residenza_istat, s2.indirizzo_domicilio,                 "+
	"	s.id_struttura id_struttura, s.nome nome_struttura, s.natura natura_struttura,                "+
	"	e2.id_ente id_ente, e2.nome nome_ente, utenti.cf_utente cf_medico,                            "+
	"	con.nome nome_medico, con.cognome cognome_medico, con.telefono telefono_medico,               "+
	"	con.email email_medico, sch_terapia_cronica, md.monitoraggio_tipo_id, md.monitoraggio_tipo_cod, md.monitoraggio_tipo_desc, "+
	"	medt.id_medico,      "+
	"	medt.cf_medico,      "+
	"	medt.codice_reg,     "+
	"	medt.cognome medico_cognome,        "+
	"	medt.nome medico_nome,           "+
	"	count(*) over() as full_count "+
	"	from covidus_t_scheda cts "+
	"		left join covidus_d_monitoraggio_tipo md on cts.monitoraggio_tipo_id = md.monitoraggio_tipo_id "+
	"		join struttura s on cts.id_struttura = s.id_struttura "+
	"		join ente e2 on s.id_ente = e2.id_ente "+
	"		join soggetto s2 on cts.id_soggetto = s2.id_soggetto "+
	"		join covidus_r_scheda_stato crss on cts.sch_id = crss.sch_id and now() "+
	"		between crss.validita_inizio and coalesce(crss.validita_fine,  to_timestamp('01/01/2999', 'dd/mm/yyyy')) "+
	"		join covidus_d_scheda_stato cdss on crss.sch_stato_id = cdss.sch_stato_id  "+
	"		join utenti on cts.utente_operazione = utenti.cf_utente                    "+
	"		left join utente_contatto con on utenti.cf_utente = con.cf_utente          "+
	"		left join medicotitolato medt on medt.id_soggetto=cts.id_soggetto          "+
	"	where   "+
	"		cts.data_cancellazione is null  "+
	"		and md.data_cancellazione is null  "+
	"		and crss.data_cancellazione is null "+
	"		and cdss.data_cancellazione is null "+
	"		<if test='medico != null'>   "+
	"			and (utenti.cf_utente = #{medico,jdbcType=VARCHAR}   " +
	"			or utenti.cf_utente in (select z.cf_medico from r_medico_medico y, medico x, medico z where x.id_medico=y.id_medico_delegato "+
	"			and z.id_medico=y.id_medico_delegante " +
	"			and x.cf_medico= #{medico,jdbcType=VARCHAR} and y.data_cancellazione is null " +
	"			and now() between y.validita_inizio and coalesce(y.validita_fine, to_timestamp('01/01/2999','dd/mm/yyyy')))) " +
	"		</if> "+
	"   <if test='richiesteMmg != null'> and cts.richiesta_mmg = #{richiesteMmg,jdbcType=BOOLEAN} </if>"+ 
	" 	<if test='visibileMed118 != null'> and cts.visibile_medico_emergenza = #{visibileMed118,jdbcType=BOOLEAN} </if>"+ 
	"   <if test='visibileMedCa != null'> and cts.visibile_medico_continuita_ass = #{visibileMedCa,jdbcType=BOOLEAN} </if>"+
	" 	<if test='soggetto != null'> and s2.id_soggetto= #{soggetto,jdbcType=BIGINT} </if>"+
	" 	<if test='strutture != null'> and s.id_struttura in (${strutture}) </if>"+
	" 	<if test='stati != null'> and cdss.sch_stato_cod in (${stati}) </if>"+
	" 	<if test='idMonitoraggioTipo != null'> and cts.monitoraggio_tipo_id = #{idMonitoraggioTipo,jdbcType=INTEGER} </if>"+ 
	"   <if test='idStruttura != null'> AND s.id_struttura IN (<foreach collection='idStruttura'  item='idS' separator=','>#{idS,jdbcType=VARCHAR} </foreach>) </if>"+ 
	" 	<if test='codSchStato != null'> and cdss.sch_stato_cod = #{codSchStato,jdbcType=INTEGER} </if>"+ 
	"   <if test='filter != null'> "+
    "         AND ( "+
    "             lower(s2.codice_fiscale)    like lower(#{filter,jdbcType=VARCHAR}) " +
    "             OR lower(s2.nome)        like lower(#{filter,jdbcType=VARCHAR}) " +
    "             OR lower(s2.cognome)           like lower(#{filter,jdbcType=VARCHAR}) "+
    "             OR lower(codice_fiscale) like lower(#{filter,jdbcType=VARCHAR}) " +
    "             OR lower(s2.indirizzo_domicilio) like lower(#{filter,jdbcType=VARCHAR}) "+
    "             OR lower(con.cognome) like lower(#{filter,jdbcType=VARCHAR}) "+ 
    "             OR lower(con.nome) like lower(#{filter,jdbcType=VARCHAR}) "+ 
    "             " +
    "         )" +
    "     </if> " ;
	

	//@Select({ "<script>", SCHEDE,
	@Select({ "<script>", SCHEDE_CON_MEDICI_DELEGANTI,
			// paginazione
			" <if test='oderByFiled != null'> order by ${oderByFiled} ${orderAscDesc} </if>",
			" <if test='limit !=-1'> offset #{offset,jdbcType=BIGINT} limit  #{limit,jdbcType=BIGINT}</if>",
			"</script>" })
	@Results({ @Result(column = "id_scheda", property = "idScheda", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "data_scheda", property = "dataScheda", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "descrizione_scheda", property = "descrizioneScheda", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sch_critica", property = "critica", jdbcType = JdbcType.BOOLEAN),
			@Result(column = "richiesta_mmg", property = "richiestaMmg", jdbcType = JdbcType.BOOLEAN),
			@Result(column = "visibile_medico_emergenza", property = "visibileMed118", jdbcType = JdbcType.BOOLEAN),
			@Result(column = "visibile_medico_continuita_ass", property = "visibileMedCa", jdbcType = JdbcType.BOOLEAN),
			@Result(column = "stato_scheda_cod", property = "statoSchedaCod", jdbcType = JdbcType.VARCHAR),
			@Result(column = "stato_scheda_desc", property = "statoSchedaDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "id_soggetto", property = "idSoggetto", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "codice_fiscale", property = "codiceFiscale", jdbcType = JdbcType.VARCHAR),
			@Result(column = "nome_soggetto", property = "nomeSoggetto", jdbcType = JdbcType.VARCHAR),
			@Result(column = "cognome_soggetto", property = "cognomeSoggetto", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_nascita_soggetto", property = "dataNascitaSoggetto", jdbcType = JdbcType.DATE),
			@Result(column = "email_soggetto", property = "emailSoggetto", jdbcType = JdbcType.VARCHAR),
			@Result(column = "telefono_soggetto", property = "telefonoSoggetto", jdbcType = JdbcType.VARCHAR),
			@Result(column = "asl_domicilio", property = "aslDomicilio", jdbcType = JdbcType.VARCHAR),
			@Result(column = "asl_residenza", property = "aslResidenza", jdbcType = JdbcType.VARCHAR),
			@Result(column = "comune_residenza_istat", property = "comuneResidenzaIstat", jdbcType = JdbcType.VARCHAR),
			@Result(column = "comune_domicilio_istat", property = "comuneDomicilioIstat", jdbcType = JdbcType.VARCHAR),
			@Result(column = "indirizzo_domicilio", property = "indirizzoDomicilio", jdbcType = JdbcType.VARCHAR),
			@Result(column = "id_struttura", property = "idStruttura", jdbcType = JdbcType.VARCHAR, id = true),
			@Result(column = "nome_struttura", property = "nomeStruttura", jdbcType = JdbcType.VARCHAR),
			@Result(column = "natura_struttura", property = "naturaStruttura", jdbcType = JdbcType.VARCHAR),
			@Result(column = "id_ente", property = "idEnte", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "nome_ente", property = "nomeEnte", jdbcType = JdbcType.VARCHAR),
			@Result(column = "cf_medico", property = "cfMedico", jdbcType = JdbcType.VARCHAR),
			@Result(column = "nome_medico", property = "nomeMedico", jdbcType = JdbcType.VARCHAR),
			@Result(column = "cognome_medico", property = "cognomeMedico", jdbcType = JdbcType.VARCHAR),
			@Result(column = "telefono_medico", property = "telefonoMedico", jdbcType = JdbcType.VARCHAR),
			@Result(column = "email_medico", property = "emailMedico", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sch_terapia_cronica", property = "schTerapiaCronica", jdbcType = JdbcType.VARCHAR),
			@Result(column = "monitoraggio_tipo_id", property = "monitoraggioTipo.monitoraggioTipoId", jdbcType = JdbcType.INTEGER),
			@Result(column = "monitoraggio_tipo_cod", property = "monitoraggioTipo.monitoraggioTipoCod", jdbcType = JdbcType.VARCHAR),
			@Result(column = "monitoraggio_tipo_desc", property = "monitoraggioTipo.monitoraggioTipoDesc", jdbcType = JdbcType.VARCHAR), 
			
			// Aggiunte le info del medico titolato
			@Result(column = "id_medico", property = "medico.idMedico", jdbcType = JdbcType.BIGINT),
			@Result(column = "cf_medico", property = "medico.cfMedico", jdbcType = JdbcType.VARCHAR),
			@Result(column = "codice_reg", property = "medico.codiceReg", jdbcType = JdbcType.VARCHAR),
			@Result(column = "medico_cognome", property = "medico.cognome", jdbcType = JdbcType.VARCHAR),
			@Result(column = "medico_nome", property = "medico.nome", jdbcType = JdbcType.VARCHAR),			
			@Result(column = "full_count", property = "totalCount", jdbcType = JdbcType.INTEGER)})
	List<SchedeCustomDto> selectElencoSchedePaged(@Param("soggetto") Integer soggetto,
			@Param("strutture") String strutture, @Param("stati") String stati, @Param("medico") String medico,
			@Param("visibileMed118") Boolean visibileMed118, @Param("visibileMedCa") Boolean visibileMedCa,
			@Param("richiesteMmg") Boolean richiesteMmg, @Param("idMonitoraggioTipo") Integer idMonitoraggioTipo,
			@Param("idStruttura") List<String> idStruttura,
			@Param("codSchStato") String codSchStato,
			@Param("filter") String filter,
			@Param("oderByFiled") String oderByFiled, @Param("orderAscDesc") String orderAscDesc,
			@Param("offset") Long offset, @Param("limit") Long limit);

	@Select({
	    	"<script>",
	    	" select count(*) from ( ",
	    	SCHEDE,
	    	" ) as count_table_inner",
	    	"</script>"
	    })
	    Long selectElencoSchedePagedCount(@Param("soggetto") Integer soggetto, @Param("strutture") String strutture,
				@Param("stati") String stati, @Param("medico") String medico,
				@Param("visibileMed118") Boolean visibileMed118, @Param("visibileMedCa") Boolean visibileMedCa,
				@Param("richiesteMmg") Boolean richiesteMmg,
	    @Param("idMonitoraggioTipo") Integer idMonitoraggioTipo,
		@Param("idStruttura") List<String> idStruttura,
		@Param("idSchStato") Integer idSchStato,
	    @Param("filter") String filter);
	    

	@Select({ "select",
			"sch_id, sch_data, sch_descrizione, sch_critica, id_soggetto, id_struttura, utente_operazione, ",
			"data_creazione, data_modifica, data_cancellazione, richiesta_mmg, ", "	visibile_medico_emergenza,",
			"	visibile_medico_continuita_ass, sch_terapia_cronica, monitoraggio_tipo_id ", "from covidus_t_scheda",
			"where sch_id = #{schId,jdbcType=INTEGER}" })
	@Results({ @Result(column = "sch_id", property = "schId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "sch_data", property = "schData", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "sch_descrizione", property = "schDescrizione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sch_critica", property = "schCritica", jdbcType = JdbcType.BIT),
			@Result(column = "id_soggetto", property = "idSoggetto", jdbcType = JdbcType.BIGINT),
			@Result(column = "id_struttura", property = "idStruttura", jdbcType = JdbcType.VARCHAR),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "richiesta_mmg", property = "richiestaMmg", jdbcType = JdbcType.BOOLEAN),
			@Result(column = "visibile_medico_emergenza", property = "visibileMedicoEmergenza", jdbcType = JdbcType.BOOLEAN),
			@Result(column = "visibile_medico_continuita_ass", property = "visibileMedicoContinuitaAss", jdbcType = JdbcType.BOOLEAN),
			@Result(column = "sch_terapia_cronica", property = "schTerapiaCronica", jdbcType = JdbcType.VARCHAR),
			@Result(column = "monitoraggio_tipo_id", property = "monitoraggioTipoId", jdbcType = JdbcType.INTEGER)
	})
	CovidusTScheda selectSchedaByPrimaryKey(Integer schId);

	@Select({ "select", "	cti.sch_id,", "	cti.int_id,", "	cti.int_data,", "	cti.int_desc,",
			"	cti.int_azione_intrapresa,", "	cda.az_id,", "	cda.az_cod,", "	cda.az_desc,", "	cdit.int_tipo_id,",
			"	cdit.int_tipo_cod,", "	cdit.int_tipo_desc, ", "   uc.nome , uc.cognome, ",
			"   uc.cf_utente , uc.telefono, uc.email ", "from", "	covidus_t_intervento cti",
			"	left join covidus_d_azione cda on cti.az_id = cda.az_id,", "	covidus_d_intervento_tipo cdit, ",
			"   utenti ut left join utente_contatto uc on ut.cf_utente = uc.cf_utente ", "where",
			"	cti.int_tipo_id = cdit.int_tipo_id", "	and cti.data_cancellazione is null",
			"   and cti.utente_operazione = ut.cf_utente ", "	and cti.sch_id = #{idScheda,jdbcType=BIGINT}" })
	@Results({ @Result(column = "id_scheda", property = "idScheda", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "int_id", property = "intId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "int_data", property = "intData", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "int_desc", property = "intDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "int_azione_intrapresa", property = "intAzioneIntrapresa", jdbcType = JdbcType.VARCHAR),
			@Result(column = "az_id", property = "azId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "az_cod", property = "azCod", jdbcType = JdbcType.VARCHAR),
			@Result(column = "az_desc", property = "azDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "int_tipo_id", property = "intTipoId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "int_tipo_cod", property = "intTipoCod", jdbcType = JdbcType.VARCHAR),
			@Result(column = "int_tipo_desc", property = "intTipoDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "nome", property = "medicoResponsabile.nome", jdbcType = JdbcType.VARCHAR),
			@Result(column = "cognome", property = "medicoResponsabile.cognome", jdbcType = JdbcType.VARCHAR),
			@Result(column = "cf_utente", property = "medicoResponsabile.cfUtente", jdbcType = JdbcType.VARCHAR),
			@Result(column = "telefono", property = "medicoResponsabile.telefono", jdbcType = JdbcType.VARCHAR),
			@Result(column = "email", property = "medicoResponsabile.email", jdbcType = JdbcType.VARCHAR) })
	List<InterventoCustomDto> selectInterventoByIdScheda(Integer idScheda);

	@Select({ "select", "	cti.sch_id,", "	cti.int_id,", "	cti.int_data,", "	cti.int_desc,",
			"	cti.int_azione_intrapresa,", "	cda.az_id,", "	cda.az_cod,", "	cda.az_desc,", "	cdit.int_tipo_id,",
			"	cdit.int_tipo_cod,", "	cdit.int_tipo_desc", "from", "	covidus_t_intervento cti",
			"	left join covidus_d_azione cda on cti.az_id = cda.az_id,", "	covidus_d_intervento_tipo cdit",
			"where", "	cti.int_tipo_id = cdit.int_tipo_id", "	and cti.data_cancellazione is null",
			"	and cti.int_id = #{idScheda,jdbcType=BIGINT}" })
	@Results({ @Result(column = "id_scheda", property = "idScheda", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "int_id", property = "intId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "int_data", property = "intData", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "int_desc", property = "intDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "int_azione_intrapresa", property = "intAzioneIntrapresa", jdbcType = JdbcType.VARCHAR),
			@Result(column = "az_id", property = "azId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "az_cod", property = "azCod", jdbcType = JdbcType.VARCHAR),
			@Result(column = "az_desc", property = "azDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "int_tipo_id", property = "intTipoId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "int_tipo_cod", property = "intTipoCod", jdbcType = JdbcType.VARCHAR),
			@Result(column = "int_tipo_desc", property = "intTipoDesc", jdbcType = JdbcType.VARCHAR) })
	InterventoCustomDto selectInterventoById(Integer intId);

	@Select({ "select", "	crsp.schpresc_id,", "	crsp.prescrizione,", "   crsp.valore, ",
			"   crsp.farm_consegnato, ", "   crsp.farm_consegna_data, ", "   f.farm_id,", "   f.farm_nome,",
			"   f.farm_desc,", "   f.presc_tipo_id as farmacoTipoId, ", "   f.farm_consenso_necessario,",
			"   o.oss_id, ", "   o.oss_nome, ", "   o.oss_desc,", "	cdpt.presc_tipo_id,", "	cdpt.presc_tipo_cod,",
			"	cdpt.presc_tipo_desc", "from", "	covidus_r_scheda_presc crsp ",
			"   	left join covidus_d_farmaco f on crsp.farm_id = f.farm_id ",
			"		left join covidus_d_ossigeno_terapia o on crsp.oss_id = o.oss_id, ", "	covidus_d_presc_tipo cdpt",
			"where", "	crsp.presc_tipo_id = cdpt.presc_tipo_id",
			"	and now() between cdpt.validita_inizio and coalesce(cdpt.validita_fine, to_timestamp('01/01/2999','dd/mm/yyyy'))",
			"	and crsp.data_cancellazione is null ", "	and cdpt.data_cancellazione is null",
			"	and crsp.sch_id = #{schId,jdbcType=INTEGER}" })
	@Results({ @Result(column = "schpresc_id", property = "schprescId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "prescrizione", property = "prescrizione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "valore", property = "valore", jdbcType = JdbcType.VARCHAR),
			@Result(column = "farm_consegnato", property = "farmConsegnato", jdbcType = JdbcType.BOOLEAN),
			@Result(column = "farm_consegna_data", property = "farmConsegnaData", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "farm_id", property = "farmaco.farmId", jdbcType = JdbcType.INTEGER),
			@Result(column = "farm_nome", property = "farmaco.farmNome", jdbcType = JdbcType.VARCHAR),
			@Result(column = "farm_desc", property = "farmaco.farmDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "farmacoTipoId", property = "farmaco.prescTipoId", jdbcType = JdbcType.INTEGER),
			@Result(column = "farm_consenso_necessario", property = "farmaco.farmConsensoNecessario", jdbcType = JdbcType.BOOLEAN),
			@Result(column = "oss_id", property = "ossigenoTerapia.ossId", jdbcType = JdbcType.INTEGER),
			@Result(column = "oss_nome", property = "ossigenoTerapia.ossNome", jdbcType = JdbcType.VARCHAR),
			@Result(column = "oss_desc", property = "ossigenoTerapia.ossDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "presc_tipo_id", property = "prescTipoId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "presc_tipo_cod", property = "prescTipoCod", jdbcType = JdbcType.VARCHAR),
			@Result(column = "presc_tipo_desc", property = "prescTipoDesc", jdbcType = JdbcType.VARCHAR) })
	List<PrescrizioneSchedaCustomDto> selectPrescrizioniByIdScheda(@Param("schId") Integer schId);

	@Select({ "select", "	crip.intpresc_id,", "	crip.prescrizione,", "	crip.farm_id,", "   f.farm_nome,",
			"   f.farm_desc, ", "   f.farm_consenso_necessario, ", "   f.presc_tipo_id, ", "	crip.oss_id,",
			"   o.oss_desc, ", "   o.oss_nome,", "   o.presc_tipo_id,", "	crip.valore,", "	crip.farm_consegnato,",
			"	crip.farm_consegna_data,", "	crip.farm_consegna_utente,", "	cdpt.presc_tipo_id,",
			"	cdpt.presc_tipo_cod,", "	cdpt.presc_tipo_desc", "from", "	covidus_r_intervento_presc crip ",
			"               left join covidus_d_farmaco f on crip.farm_id = f.farm_id ",
			"               left join covidus_d_ossigeno_terapia o on crip.oss_id = o.oss_id,",
			"	covidus_d_presc_tipo cdpt", "where", "	crip.presc_tipo_id = cdpt.presc_tipo_id",
			"	and now() between cdpt.validita_inizio and coalesce(cdpt.validita_fine, to_timestamp('01/01/2999','dd/mm/yyyy'))",
			"	and crip.data_cancellazione is null", "	and cdpt.data_cancellazione is null",
			"	and crip.int_id = #{idIntervento,jdbcType=INTEGER}" })
	@Results({ @Result(column = "intpresc_id", property = "intprescId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "prescrizione", property = "prescrizione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "valore", property = "valore", jdbcType = JdbcType.VARCHAR),
			@Result(column = "farm_consegnato", property = "farmConsegnato", jdbcType = JdbcType.BOOLEAN),
			@Result(column = "farm_consegna_data", property = "farmConsegnaData", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "farm_id", property = "farmaco.farmId", jdbcType = JdbcType.INTEGER),
			@Result(column = "farm_nome", property = "farmaco.farmNome", jdbcType = JdbcType.VARCHAR),
			@Result(column = "farm_desc", property = "farmaco.farmDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "farmacoTipoId", property = "farmaco.prescTipoId", jdbcType = JdbcType.INTEGER),
			@Result(column = "farm_consenso_necessario", property = "farmaco.farmConsensoNecessario", jdbcType = JdbcType.BOOLEAN),
			@Result(column = "oss_id", property = "ossigenoTerapia.ossId", jdbcType = JdbcType.INTEGER),
			@Result(column = "oss_nome", property = "ossigenoTerapia.ossNome", jdbcType = JdbcType.VARCHAR),
			@Result(column = "oss_desc", property = "ossigenoTerapia.ossDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "presc_tipo_id", property = "prescTipoId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "presc_tipo_cod", property = "prescTipoCod", jdbcType = JdbcType.VARCHAR),
			@Result(column = "presc_tipo_desc", property = "prescTipoDesc", jdbcType = JdbcType.VARCHAR) })
	List<PrescrizioneInterventoCustomDto> selectPrescrizioniInterventoByIdIntervento(
			@Param("idIntervento") Integer idIntervento);

	@Insert({ "insert into covidus_t_scheda (sch_data, sch_descrizione, ", "sch_critica, id_soggetto, ",
			"id_struttura, ", "utente_operazione, data_creazione, ", "data_modifica)",
			"values (now(), #{schDescrizione,jdbcType=VARCHAR}, ",
			"#{schCritica,jdbcType=BIT}, #{idSoggetto,jdbcType=BIGINT}, ", "#{idStruttura,jdbcType=VARCHAR}, ",
			"#{utenteOperazione,jdbcType=VARCHAR}, now(), now())" })
	@Options(useGeneratedKeys = true, keyProperty = "schId")
	int insertScheda(CovidusTScheda record);

	@Insert({ "insert into covidus_t_scheda (sch_data, sch_descrizione, ", "sch_critica, id_soggetto, ",
			"id_struttura, ", "utente_operazione, data_creazione, ",
			"data_modifica, richiesta_mmg, visibile_medico_emergenza, visibile_medico_continuita_ass, sch_terapia_cronica)",
			"values (#{schData,jdbcType=TIMESTAMP}, #{schDescrizione,jdbcType=VARCHAR}, ",
			"#{schCritica,jdbcType=BIT}, #{idSoggetto,jdbcType=BIGINT}, ", "#{idStruttura,jdbcType=VARCHAR}, ",
			"#{utenteOperazione,jdbcType=VARCHAR}, now(), now(), #{richiestaMmg,jdbcType=BIT},",
			"#{visibileMedicoEmergenza,jdbcType=BIT},  #{visibileMedicoContinuitaAss,jdbcType=BIT}, #{schTerapiaCronica, jdbcType=VARCHAR})" })
	@Options(useGeneratedKeys = true, keyProperty = "schId")
	int insertSchedaExt(CovidusTScheda record);

	@Select({ "select", "id_medico, cf_medico, codice_reg, cognome, nome", "from medico",
			"where cf_medico = #{idMedico,jdbcType=VARCHAR}" })
	@Results({ @Result(column = "cf_medico", property = "idMedico", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "cf_medico", property = "cfMedico", jdbcType = JdbcType.VARCHAR),
			@Result(column = "codice_reg", property = "codiceReg", jdbcType = JdbcType.VARCHAR),
			@Result(column = "cognome", property = "cognome", jdbcType = JdbcType.VARCHAR),
			@Result(column = "nome", property = "nome", jdbcType = JdbcType.VARCHAR) })
	Medico selectMedicoByCodFiscale(String cfMedico);

	@Insert({ "insert into covidus_r_scheda_presc (sch_id, presc_tipo_id, ", "prescrizione, utente_operazione, ",
			"data_creazione, data_modifica)", "values (#{schId,jdbcType=INTEGER}, #{prescTipoId,jdbcType=INTEGER}, ",
			"#{prescrizione,jdbcType=VARCHAR}, #{utenteOperazione,jdbcType=VARCHAR}, ", "now(), now())" })
	@Options(useGeneratedKeys = true, keyProperty = "schprescId")
	int insertRSchedaPrescr(CovidusRSchedaPresc record);

	@Insert({ "insert into covidus_r_scheda_presc (sch_id, presc_tipo_id, ", "prescrizione, utente_operazione, ",
			"data_creazione, data_modifica, ", "farm_id, ", "oss_id, valore ", " )",
			"values (#{schId,jdbcType=INTEGER}, #{prescTipoId,jdbcType=INTEGER}, ",
			"#{prescrizione,jdbcType=VARCHAR}, #{utenteOperazione,jdbcType=VARCHAR}, ", "now() , now(), ",
			"#{farmId,jdbcType=INTEGER}, ", "#{ossId,jdbcType=INTEGER}, #{valore,jdbcType=VARCHAR}  ", ")" })
	@Options(useGeneratedKeys = true, keyProperty = "schprescId")
	int insertRSchedaPrescrizione(CovidusRSchedaPresc record);

	@Insert({ "insert into covidus_r_intervento_presc (int_id, presc_tipo_id, ", "prescrizione, utente_operazione, ",
			"data_creazione, data_modifica )", "values (#{intId,jdbcType=INTEGER}, #{prescTipoId,jdbcType=INTEGER}, ",
			"#{prescrizione,jdbcType=VARCHAR}, #{utenteOperazione,jdbcType=VARCHAR}, ", "now(), now())" })
	@Options(useGeneratedKeys = true, keyProperty = "intprescId")
	int insertRInterventoPresc(CovidusRInterventoPresc record);

	@Insert({ "insert into covidus_r_intervento_presc (int_id, presc_tipo_id, ", "prescrizione, utente_operazione, ",
			"data_creazione, data_modifica, ", " farm_id, ", "oss_id, valore ", ")",
			"values (#{intId,jdbcType=INTEGER}, #{prescTipoId,jdbcType=INTEGER}, ",
			"#{prescrizione,jdbcType=VARCHAR}, #{utenteOperazione,jdbcType=VARCHAR}, ", "now(), now(), ",
			"#{farmId,jdbcType=INTEGER}, ", "#{ossId,jdbcType=INTEGER}, #{valore,jdbcType=VARCHAR} ", ")" })
	@Options(useGeneratedKeys = true, keyProperty = "intprescId")
	int insertRInterventoPrescrizione(CovidusRInterventoPresc record);

	@Select({ "select", "sch_stato_id, sch_stato_cod, sch_stato_desc, validita_inizio, validita_fine, ",
			"utente_operazione, data_creazione, data_modifica, data_cancellazione", "from covidus_d_scheda_stato",
			"where sch_stato_cod = #{schStatoCod,jdbcType=VARCHAR}",
			"and now() between validita_inizio and coalesce(validita_fine, to_timestamp('01/01/2999','dd/mm/yyyy'))",
			"and data_cancellazione is null" })
	@Results({ @Result(column = "sch_stato_id", property = "schStatoId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "sch_stato_cod", property = "schStatoCod", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sch_stato_desc", property = "schStatoDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
	CovidusDSchedaStato selectSchedaStatoByCodStato(String schStatoCod);

	@Insert({ "insert into covidus_r_scheda_stato (sch_id, sch_stato_id, ", "validita_inizio, ",
			"utente_operazione, id_profilo_operazione, ", "data_creazione, data_modifica)",
			"values (#{schId,jdbcType=INTEGER}, #{schStatoId,jdbcType=INTEGER}, ", "now(), ",
			"#{utenteOperazione,jdbcType=VARCHAR}, #{idProfiloOperazione,jdbcType=INTEGER}, ", "now(), now())" })
	@Options(useGeneratedKeys = true, keyProperty = "scarStatoId")
	int insertRSchedaStato(CovidusRSchedaStato record);

	@Update({ "update covidus_r_scheda_stato", "set sch_id = #{schId,jdbcType=INTEGER},",
			"sch_stato_id = #{schStatoId,jdbcType=INTEGER},", "validita_inizio = #{validitaInizio,jdbcType=TIMESTAMP},",
			"validita_fine = (now() - interval '1 millisecond'),",
			"utente_operazione = #{utenteOperazione,jdbcType=VARCHAR},",
			"id_profilo_operazione = #{idProfiloOperazione,jdbcType=INTEGER},",
			"data_creazione = #{dataCreazione,jdbcType=TIMESTAMP},",
			"data_modifica = #{dataModifica,jdbcType=TIMESTAMP},",
			"data_cancellazione = #{dataCancellazione,jdbcType=TIMESTAMP}",
			"where scar_stato_id = #{scarStatoId,jdbcType=INTEGER}" })
	int updateStatoPerChiusura(CovidusRSchedaStato record);

	@Select({ "select", "	cdss.sch_stato_id,", "	cdss.sch_stato_cod,", "	cdss.sch_stato_desc", "from",
			"	covidus_r_scheda_stato crss,", "	covidus_d_scheda_stato cdss", "where",
			"	crss.sch_stato_id = cdss.sch_stato_id", "	and crss.data_cancellazione is null",
			"	and cdss.data_cancellazione is null",
			"   and now() between crss.validita_inizio and coalesce(crss.validita_fine, to_timestamp('01/01/2999','dd/mm/yyyy'))",
			"	and crss.validita_fine is null", "	and crss.sch_id = #{schId,jdbcType=INTEGER}" })
	@Results({ @Result(column = "sch_stato_id", property = "schStatoId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "sch_stato_cod", property = "schStatoCod", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sch_stato_desc", property = "schStatoDesc", jdbcType = JdbcType.VARCHAR) })
	CovidusDSchedaStato selectStatoByIdScheda(@Param("schId") Integer schId);

	@Select({ "select", "scar_stato_id, sch_id, sch_stato_id, validita_inizio, validita_fine, utente_operazione, ",
			"id_profilo_operazione, data_creazione, data_modifica, data_cancellazione", "from covidus_r_scheda_stato",
			"where sch_id = #{idScheda,jdbcType=INTEGER}", "and validita_fine is null",
			"and data_cancellazione is null" })
	@Results({ @Result(column = "scar_stato_id", property = "scarStatoId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "sch_id", property = "schId", jdbcType = JdbcType.INTEGER),
			@Result(column = "sch_stato_id", property = "schStatoId", jdbcType = JdbcType.INTEGER),
			@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "id_profilo_operazione", property = "idProfiloOperazione", jdbcType = JdbcType.INTEGER),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
	CovidusRSchedaStato selectStatoValidoByIdScheda(Integer idScheda);

	@Insert({ "insert into covidus_t_intervento", " (int_data, int_desc, ", " int_azione_intrapresa, sch_id, ",
			" int_tipo_id, az_id, ", "utente_operazione, data_creazione, ", "data_modifica)",
			"values (#{intData,jdbcType=TIMESTAMP}, #{intDesc,jdbcType=VARCHAR}, ",
			"#{intAzioneIntrapresa,jdbcType=VARCHAR}, #{schId,jdbcType=INTEGER}, ",
			"#{intTipoId,jdbcType=INTEGER}, #{azId,jdbcType=INTEGER}, ",
			"#{utenteOperazione,jdbcType=VARCHAR}, now(), ", "now())" })
	@Options(useGeneratedKeys = true, keyProperty = "intId")
	int insertIntervento(CovidusTIntervento record);

	@Select({ "select", "	ut.cf_utente,", "	con.nome,", "	con.cognome,", "	con.telefono,", "	con.email",
			"from", "	utenti ut", "left outer join utente_contatto con on", "	ut.cf_utente = con.cf_utente", "where",
			"	ut.cf_utente = #{cfUtente, jdbcType = VARCHAR}" })
	@Results({ @Result(column = "cf_utente", property = "cfUtente", jdbcType = JdbcType.VARCHAR, id = true),
			@Result(column = "nome", property = "nome", jdbcType = JdbcType.VARCHAR),
			@Result(column = "cognome", property = "cognome", jdbcType = JdbcType.VARCHAR),
			@Result(column = "telefono", property = "telefono", jdbcType = JdbcType.VARCHAR),
			@Result(column = "email", property = "email", jdbcType = JdbcType.VARCHAR) })
	UtenteContatto selectUtenteContattoByCf(String cfUtente);

	@Select({ "select", "    count(1) occorrenze", "from", "	covidus_t_scheda cts,", "	soggetto s2,",
			"	covidus_r_scheda_stato crss,", "	covidus_d_scheda_stato cdss", "where",
			"	cts.id_soggetto = s2.id_soggetto",
			"	and now() between crss.validita_inizio and coalesce(crss.validita_fine, to_timestamp('01/01/2999', 'dd/mm/yyyy'))",
			"	and cts.sch_id = crss.sch_id", "	and crss.sch_stato_id = cdss.sch_stato_id",
			"	and cdss.sch_stato_cod in ('I', 'P')", "	and s2.id_soggetto = #{idSoggetto,jdbcType=INTEGER}" })
	@Results({ @Result(column = "occorrenze", property = "numero", jdbcType = JdbcType.INTEGER) })
	ContatoreCustomDto selectSchedeAttivePerSoggetto(Integer idSoggetto);

	@Select({ "select", "	crss.sch_id schedaId,", "	crss.validita_inizio dataInizio,",
			"	crss.validita_fine dataFine,", "	cdss.sch_stato_cod codiceStato,",
			"	cdss.sch_stato_desc descrizioneStato,", "	crss.utente_operazione codiceFiscale,", "	con.nome,",
			"	con.cognome,", "	con.telefono,", "	con.email", "from", "	covidus_r_scheda_stato crss",
			"left join covidus_d_scheda_stato cdss on", "	crss.sch_stato_id = cdss.sch_stato_id",
			"left join utenti ut on", "	crss.utente_operazione = ut.cf_utente", "left join utente_contatto con on",
			"	crss.utente_operazione = con.cf_utente", "where", "	crss.sch_id = #{idScheda,jdbcType=BIGINT}",
			"order by", "	scar_stato_id desc" })
	@Results({ @Result(column = "schedaId", property = "schedaId", jdbcType = JdbcType.INTEGER),
			@Result(column = "dataInizio", property = "dataInizio", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "dataFine", property = "dataFine", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "codiceStato", property = "codiceStato", jdbcType = JdbcType.VARCHAR),
			@Result(column = "descrizioneStato", property = "descrizioneStato", jdbcType = JdbcType.VARCHAR),
			@Result(column = "codiceFiscale", property = "codiceFiscale", jdbcType = JdbcType.VARCHAR),
			@Result(column = "nome", property = "nome", jdbcType = JdbcType.VARCHAR),
			@Result(column = "cognome", property = "cognome", jdbcType = JdbcType.VARCHAR),
			@Result(column = "telefono", property = "telefono", jdbcType = JdbcType.VARCHAR),
			@Result(column = "email", property = "email", jdbcType = JdbcType.VARCHAR) })
	List<CronologiaStatoCustomDto> selectCronologiaStatiByIdScheda(Integer idScheda);

	@Select({ "select", "	az_id,", "	az_cod,", "	az_desc,", "	validita_inizio,", "	validita_fine,",
			"	utente_operazione,", "	data_creazione,", "	data_modifica,", "	data_cancellazione", "from",
			"	covidus_d_azione", "where", "	data_cancellazione is null" })
	@Results({ @Result(column = "az_id", property = "azId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "az_cod", property = "azCod", jdbcType = JdbcType.VARCHAR),
			@Result(column = "az_desc", property = "azDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
	List<CovidusDAzione> selectAllDAzioni();

	@Select({ "select", "	int_tipo_id,", "	int_tipo_cod,", "	int_tipo_desc,", "	validita_inizio,",
			"	validita_fine,", "	utente_operazione,", "	data_creazione,", "	data_modifica,", "	data_cancellazione",
			"from", "	covidus_d_intervento_tipo", "where", "	data_cancellazione is null",
			"	and validita_fine is null" })
	@Results({ @Result(column = "int_tipo_id", property = "intTipoId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "int_tipo_cod", property = "intTipoCod", jdbcType = JdbcType.VARCHAR),
			@Result(column = "int_tipo_desc", property = "intTipoDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "validita_inizio", property = "validitaInizio", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "validita_fine", property = "validitaFine", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
	List<CovidusDInterventoTipo> selectAllDInterventoTipo();

	@Insert({ "insert into covidus_r_scheda_presc (sch_id, presc_tipo_id, ", "prescrizione, utente_operazione, ",
			"data_creazione, data_modifica, ", "data_cancellazione, farm_id, ", "oss_id, valore, farm_consegnato, ",
			"farm_consegna_data, farm_consegna_utente)",
			"values (#{schId,jdbcType=INTEGER}, #{prescTipoId,jdbcType=INTEGER}, ",
			"#{prescrizione,jdbcType=VARCHAR}, #{utenteOperazione,jdbcType=VARCHAR}, ",
			"#{dataCreazione,jdbcType=TIMESTAMP}, #{dataModifica,jdbcType=TIMESTAMP}, ",
			"#{dataCancellazione,jdbcType=TIMESTAMP}, #{farmId,jdbcType=INTEGER}, ",
			"#{ossId,jdbcType=INTEGER}, #{valore,jdbcType=VARCHAR}, #{farmConsegnato,jdbcType=BIT}, ",
			"#{farmConsegnaData,jdbcType=TIMESTAMP}, #{farmConsegnaUtente,jdbcType=VARCHAR})" })
	@Options(useGeneratedKeys = true, keyProperty = "schprescId")
	int insert(CovidusRSchedaPresc record);

	@Update({ "update covidus_t_scheda", "set",
			"visibile_medico_emergenza = #{visibileMedicoEmergenza,jdbcType=BOOLEAN},",
			"visibile_medico_continuita_ass = #{visibileMedicoContinuitaAss,jdbcType=BOOLEAN}",
			"where sch_id = #{schId,jdbcType=INTEGER}" })
	int updateSchedaVisibilita(CovidusTScheda record);

	@Update({ "update covidus_t_scheda", "set", "sch_terapia_cronica = #{schTerapiaCronica,jdbcType=VARCHAR}",
			"where sch_id = #{schId,jdbcType=INTEGER}" })
	int updateSchedaTerapiaCronica(CovidusTScheda record);

	@Update({ "update covidus_t_scheda", "set", "monitoraggio_tipo_id = #{monitoraggioTipoId,jdbcType=INTEGER}",
			"where sch_id = #{schId,jdbcType=INTEGER}" })
	int updateSchedaMonitoraggioTipo(CovidusTScheda record);

	@Select({
			"select distinct cts.* from covidus_t_scheda cts, covidus_r_scheda_stato crss , covidus_d_scheda_stato cdss",
			"where cts.sch_id = crss.sch_id  and crss.sch_stato_id = cdss.sch_stato_id and cdss.sch_stato_cod not in ('E','R')",
			"and cts.sch_id in(",
			"select cts2.sch_id from covidus_t_scheda cts2, covidus_t_intervento cti where cts2.sch_id = cti.sch_id and cti.int_id = #{idIntervento,jdbcType=VARCHAR})" })
	@Results({ @Result(column = "sch_id", property = "schId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "sch_data", property = "schData", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "sch_descrizione", property = "schDescrizione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sch_critica", property = "schCritica", jdbcType = JdbcType.BIT),
			@Result(column = "id_soggetto", property = "idSoggetto", jdbcType = JdbcType.BIGINT),
			@Result(column = "id_struttura", property = "idStruttura", jdbcType = JdbcType.VARCHAR),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "richiesta_mmg", property = "richiestaMmg", jdbcType = JdbcType.BIT),
			@Result(column = "visibile_medico_emergenza", property = "visibileMedicoEmergenza", jdbcType = JdbcType.BIT),
			@Result(column = "visibile_medico_continuita_ass", property = "visibileMedicoContinuitaAss", jdbcType = JdbcType.BIT),
			@Result(column = "sch_terapia_cronica", property = "schTerapiaCronica", jdbcType = JdbcType.VARCHAR) })
	CovidusTScheda selectSchedaAttivaByIdIntervento(Integer idIntervento);

	@Select({ "select * from covidus_t_intervento cti", "where int_data = ",
			"(select MAX(cti.int_data) from covidus_t_intervento cti where cti.sch_id = #{idScheda,jdbcType=INTEGER})" })
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
	CovidusTIntervento selectUltimoInterventoByScheda(Integer idScheda);

	/**
	 * Get Schede per estrazione xlxs
	 */
	@Select({ "<script>", " select", "	cts.sch_id id_scheda,", "	cts.sch_data data_scheda,",
			"	cts.sch_descrizione descrizione_scheda,", "	cts.sch_critica critica,", "	cts.richiesta_mmg, ",
			"	cts.visibile_medico_emergenza,", "	cts.visibile_medico_continuita_ass,",
			"	cdss.sch_stato_cod stato_scheda_cod,", "	cdss.sch_stato_desc stato_scheda_desc,",
			"	s2.id_soggetto,", "	s2.codice_fiscale,", "	s2.nome nome_soggetto,", "	s2.cognome cognome_soggetto,",
			"	s2.data_nascita data_nascita_soggetto,", "	s2.email email_soggetto,",
			"	s2.telefono_recapito telefono_soggetto,", "	s2.asl_domicilio,", "	s2.asl_residenza,",
			"	s2.comune_domicilio_istat,", "	s2.comune_residenza_istat,", "	s2.indirizzo_domicilio,",
			"   com.nome_comune nomeComune,", "	s.id_struttura id_struttura,", "	s.nome nome_struttura,",
			"	s.natura natura_struttura,", "	e2.id_ente id_ente,", "	e2.nome nome_ente,",
			"	utenti.cf_utente cf_medico,", "	con.nome nome_medico,", "	con.cognome cognome_medico,",
			"	con.telefono telefono_medico,",
			"	con.email email_medico, sch_terapia_cronica, md.monitoraggio_tipo_id, md.monitoraggio_tipo_cod, md.monitoraggio_tipo_desc ",
			"   from covidus_t_scheda cts left join covidus_d_monitoraggio_tipo md on cts.monitoraggio_tipo_id = md.monitoraggio_tipo_id ,",
			"	struttura s,", "	ente e2,",
			"	soggetto s2 left join comuni com on s2.comune_domicilio_istat = com.istat_comune,",
			"	covidus_r_scheda_stato crss,", "	covidus_d_scheda_stato cdss,", "	utenti",
			"		left join utente_contatto con on utenti.cf_utente = con.cf_utente", "where",
			"	cts.id_struttura = s.id_struttura", "	and s.id_ente = e2.id_ente",
			"	and cts.id_soggetto = s2.id_soggetto", "	and cts.utente_operazione = utenti.cf_utente",
			"	and now() between crss.validita_inizio and coalesce(crss.validita_fine, to_timestamp('01/01/2999', 'dd/mm/yyyy'))",
			"	and cts.sch_id = crss.sch_id", "	and crss.sch_stato_id = cdss.sch_stato_id",
			"	and cts.data_cancellazione is null",
			// " and utenti.cf_utente = #{codiceFiscale,jdbcType=VARCHAR} ",
			" 	<if test='strutture != null'> and s.id_struttura in (${strutture}) </if>",
			" 	<if test='stati != null'> and cdss.sch_stato_cod in (${stati}) </if>", "</script>" })
	@Results({ @Result(column = "id_scheda", property = "idScheda", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "data_scheda", property = "dataScheda", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "descrizione_scheda", property = "descrizioneScheda", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sch_critica", property = "critica", jdbcType = JdbcType.BOOLEAN),
			@Result(column = "richiesta_mmg", property = "richiestaMmg", jdbcType = JdbcType.BOOLEAN),
			@Result(column = "visibile_medico_emergenza", property = "visibileMed118", jdbcType = JdbcType.BOOLEAN),
			@Result(column = "visibile_medico_continuita_ass", property = "visibileMedCa", jdbcType = JdbcType.BOOLEAN),
			@Result(column = "stato_scheda_cod", property = "statoSchedaCod", jdbcType = JdbcType.VARCHAR),
			@Result(column = "stato_scheda_desc", property = "statoSchedaDesc", jdbcType = JdbcType.VARCHAR),
			@Result(column = "id_soggetto", property = "idSoggetto", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "codice_fiscale", property = "codiceFiscale", jdbcType = JdbcType.VARCHAR),
			@Result(column = "nome_soggetto", property = "nomeSoggetto", jdbcType = JdbcType.VARCHAR),
			@Result(column = "cognome_soggetto", property = "cognomeSoggetto", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_nascita_soggetto", property = "dataNascitaSoggetto", jdbcType = JdbcType.DATE),
			@Result(column = "email_soggetto", property = "emailSoggetto", jdbcType = JdbcType.VARCHAR),
			@Result(column = "telefono_soggetto", property = "telefonoSoggetto", jdbcType = JdbcType.VARCHAR),
			@Result(column = "asl_domicilio", property = "aslDomicilio", jdbcType = JdbcType.VARCHAR),
			@Result(column = "asl_residenza", property = "aslResidenza", jdbcType = JdbcType.VARCHAR),
			@Result(column = "comune_residenza_istat", property = "comuneResidenzaIstat", jdbcType = JdbcType.VARCHAR),
			@Result(column = "comune_domicilio_istat", property = "comuneDomicilioIstat", jdbcType = JdbcType.VARCHAR),
			@Result(column = "com.nome_comune", property = "comuneDescrizione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "indirizzo_domicilio", property = "indirizzoDomicilio", jdbcType = JdbcType.VARCHAR),
			@Result(column = "id_struttura", property = "idStruttura", jdbcType = JdbcType.VARCHAR, id = true),
			@Result(column = "nome_struttura", property = "nomeStruttura", jdbcType = JdbcType.VARCHAR),
			@Result(column = "natura_struttura", property = "naturaStruttura", jdbcType = JdbcType.VARCHAR),
			@Result(column = "id_ente", property = "idEnte", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "nome_ente", property = "nomeEnte", jdbcType = JdbcType.VARCHAR),
			@Result(column = "cf_medico", property = "cfMedico", jdbcType = JdbcType.VARCHAR),
			@Result(column = "nome_medico", property = "nomeMedico", jdbcType = JdbcType.VARCHAR),
			@Result(column = "cognome_medico", property = "cognomeMedico", jdbcType = JdbcType.VARCHAR),
			@Result(column = "telefono_medico", property = "telefonoMedico", jdbcType = JdbcType.VARCHAR),
			@Result(column = "email_medico", property = "emailMedico", jdbcType = JdbcType.VARCHAR),
			@Result(column = "email_medico", property = "emailMedico", jdbcType = JdbcType.VARCHAR),
			@Result(column = "email_medico", property = "emailMedico", jdbcType = JdbcType.VARCHAR),
			@Result(column = "email_medico", property = "emailMedico", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sch_terapia_cronica", property = "schTerapiaCronica", jdbcType = JdbcType.VARCHAR),
			@Result(column = "monitoraggio_tipo_id", property = "monitoraggioTipo.monitoraggioTipoId", jdbcType = JdbcType.INTEGER),
			@Result(column = "monitoraggio_tipo_cod", property = "monitoraggioTipo.monitoraggioTipoCod", jdbcType = JdbcType.VARCHAR),
			@Result(column = "monitoraggio_tipo_desc", property = "monitoraggioTipo.monitoraggioTipoDesc", jdbcType = JdbcType.VARCHAR) })
	List<SchedeCustomDto> elencoSchedeExcel(@Param("stati") String stati, @Param("strutture") String strutture,
			@Param("codiceFiscale") String codiceFiscale);

}
