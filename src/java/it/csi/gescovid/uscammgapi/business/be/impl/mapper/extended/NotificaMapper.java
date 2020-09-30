package it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Notifica;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.extended.NotificaExt;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseNotificaMapper;

public interface NotificaMapper extends BaseNotificaMapper {

	@Select({ "<script>", "select",
			"not_id, not_data_notifica, not_data_presa_visione, not_testo_request, not_testo_response, ",
			"id_soggetto, cf_utente_richiesta, cf_utente_presa_vis, cf_utente_dest, id_ente, ",
			"id_struttura, priorita_id, not_tipo_id, not_ev_id, not_az_id, not_ut_tipo_id, ",
			"utente_operazione, data_creazione, data_modifica, data_cancellazione, not_ut_tipo_id_dest",
			"from notifica", 
			"<where>",
			"<if test='cfUtenteDestinatario != null'> cf_utente_dest=#{cfUtenteDestinatario,jdbcType=BIGINT} </if> ",
			"<if test='cfUtenteRichiedente != null'> and cf_utente_richiesta=#{cfUtenteRichiedente,jdbcType=BIGINT} </if> ",
			"<if test='enteId != null'> and id_ente=#{enteId,jdbcType=BIGINT} </if> ",
			"<if test='struttura != null'> and id_struttura in (${struttura}) </if> ",
			"<if test='tipoUtenteMitt != null'> and not_ut_tipo_id=#{tipoUtenteMitt,jdbcType=BIGINT} </if> ",
			"<if test='tipoUtenteDest != null'> and not_ut_tipo_id_dest=#{tipoUtenteDest,jdbcType=BIGINT} </if> ", "</where>",
			"order by not_data_notifica desc",
			"</script>" })
	@Results({ @Result(column = "not_id", property = "notId", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "not_data_notifica", property = "notDataNotifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "not_data_presa_visione", property = "notDataPresaVisione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "not_testo_request", property = "notTestoRequest", jdbcType = JdbcType.VARCHAR),
			@Result(column = "not_testo_response", property = "notTestoResponse", jdbcType = JdbcType.VARCHAR),
			@Result(column = "id_soggetto", property = "idSoggetto", jdbcType = JdbcType.INTEGER),
			@Result(column = "cf_utente_richiesta", property = "cfUtenteRichiesta", jdbcType = JdbcType.VARCHAR),
			@Result(column = "cf_utente_presa_vis", property = "cfUtentePresaVis", jdbcType = JdbcType.VARCHAR),
			@Result(column = "cf_utente_dest", property = "cfUtenteDest", jdbcType = JdbcType.VARCHAR),
			@Result(column = "id_ente", property = "idEnte", jdbcType = JdbcType.INTEGER),
			@Result(column = "id_struttura", property = "idStruttura", jdbcType = JdbcType.VARCHAR),
			@Result(column = "priorita_id", property = "prioritaId", jdbcType = JdbcType.INTEGER),
			@Result(column = "not_tipo_id", property = "notTipoId", jdbcType = JdbcType.INTEGER),
			@Result(column = "not_ev_id", property = "notEvId", jdbcType = JdbcType.INTEGER),
			@Result(column = "not_az_id", property = "notAzId", jdbcType = JdbcType.INTEGER),
			@Result(column = "not_ut_tipo_id", property = "notUtTipoId", jdbcType = JdbcType.INTEGER),
			@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
			@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "not_ut_tipo_id_dest", property = "notUtTipoIdDest", jdbcType = JdbcType.INTEGER) })

	List<Notifica> selectNotificheByFiltroOLD(@Param("cfUtenteDestinatario")String cfUtenteDestinatario, @Param("cfUtenteRichiedente") String cfUtenteRichiedente, 
			@Param("tipoUtenteMitt")Integer tipoUtenteMitt, @Param("tipoUtenteDest")Integer tipoUtenteDest,
			@Param("enteId") Integer enteId, @Param("struttura") String struttura);
	
	
	static final String NOTIFICHE_CON_MEDICI_DELEGANTI = "with medicotitolato as ( " + 
			"with med as ( " + 
			"select tb.id_soggetto,tb.id_aura_sogg,tb.wt,rank() over(partition by tb.id_soggetto order by tb.wt, tb.ordine),tb.id_medico " + 
			"From ( " + 
			"with " + 
			"aa as ( select b.id_soggetto,a.id_aura_sogg,'AA'::text wt,rank() over(partition by b.id_soggetto order by a.data_scelta desc) as ordine " + 
			",a.id_medico from r_medico_sogg_aura a,r_soggetto_aura b " + 
			"where b.id_aura =a.id_aura_sogg " + 
			"and a.data_revoca is null " + 
			"), " + 
			"bb as (select c.id_soggetto,d.id_aura,'BB'::text wt,rank() over(partition by c.id_soggetto order by c.id_medico desc) as ordine, " + 
			"c.id_medico from r_medico_soggetto c left join r_soggetto_aura d on " + 
			"d.id_soggetto=c.id_soggetto " + 
			") " + 
			"select * from aa " + 
			"union " + 
			"select * from bb order by 1, 3, 4) as tb) " + 
			"select " + 
			"a.iD_soggetto,b.* from med a, medico b where " + 
			"rank =1 and b.id_medico=a.id_medico), " + 
			"t_notifica as (select * from notifica a where 1=1" + 
				"<if test='tipoUtenteMitt != null'> and a.not_ut_tipo_id=#{tipoUtenteMitt,jdbcType=BIGINT} </if> " +
				"<if test='tipoUtenteDest != null'> and a.not_ut_tipo_id_dest=#{tipoUtenteDest,jdbcType=BIGINT} </if>  "+
			"), " + 
			"t_d_notifica_priorita as (select * from d_notifica_priorita a where a.data_cancellazione is null), " + 
			"t_d_notifica_tipo as (select * from d_notifica_tipo a where a.data_cancellazione is null), " + 
			"t_d_notifica_evento as (select * from d_notifica_evento a where a.data_cancellazione is null), " + 
			"t_d_notifica_azione as (select * from d_notifica_azione a where a.data_cancellazione is null), " + 
			"t_d_notifica_utente_tipo as (select * from d_notifica_utente_tipo a where a.data_cancellazione is null) " + 
			"select " + 
			"a.CF_UTENTE_DEST, " + 
			"a.not_id, " + 
			"a.not_data_notifica, " + 
			"a.not_data_presa_visione, " + 
			"a.not_testo_request, " + 
			"a.not_testo_response, " + 
			"a.id_soggetto, " + 
			"s.nome, " + 
			"s.cognome, " + 
			"s.codice_fiscale, " + 
			"a.cf_utente_richiesta, " + 
			"a.cf_utente_presa_vis, " + 
			"a.cf_utente_dest, " + 
			"a.id_ente, " + 
			"a.id_struttura, " + 
			"b.priorita_id, " + 
			"b.priorita_cod, " + 
			"b.priorita_desc, " + 
			"c.not_tipo_id, " + 
			"c.not_tipo_cod, " + 
			"c.not_tipo_desc, " + 
			"d.not_ev_id, " + 
			"d.not_ev_cod, " + 
			"d.not_ev_desc, " + 
			"e.not_az_id, " + 
			"e.not_az_cod, " + 
			"e.not_az_desc, " + 
			"f.not_ut_tipo_id, " + 
			"f.not_ut_tipo_cod, " + 
			"f.not_ut_tipo_desc, " + 
			"a.utente_operazione, " + 
			"a.data_creazione, " + 
			"a.data_modifica, " + 
			"a.data_cancellazione, " + 
			"a.not_ut_tipo_id_dest, " + 
			"g.not_ut_tipo_cod utenteTipoCodDest, " + 
			"g.not_ut_tipo_desc utenteTipoDescDest, " + 
			"u.cf_utente contatto_cf, " + 
			"u.nome contatto_nome, " + 
			"u.cognome contatto_cognome, " + 
			"u.email contatto_email, " + 
			"u.telefono contatto_telefono, " + 
			"medt.id_medico, " + 
			"medt.cf_medico, " + 
			"medt.codice_reg, " + 
			"medt.cognome medico_cognome, " + 
			"medt.nome medico_nome " + 
			"from t_notifica a " + 
			"left join t_d_notifica_priorita b " + 
			"on a.priorita_id=b.priorita_id " + 
			"left join t_d_notifica_tipo c " + 
			"on a.not_tipo_id=c.not_tipo_id " + 
			"left join t_d_notifica_evento d " + 
			"on a.not_ev_id=d.not_ev_id " + 
			"left join t_d_notifica_azione e " + 
			"on a.not_az_id=e.not_az_id " + 
			"left join t_d_notifica_utente_tipo f " + 
			"on a.not_ut_tipo_id=f.not_ut_tipo_id " + 
			"left join t_d_notifica_utente_tipo g " + 
			"on a.not_ut_tipo_id_dest=g.not_ut_tipo_id " + 
			"left join utente_contatto u " + 
			"on a.cf_utente_richiesta=u.cf_utente " + 
			"left join soggetto s " + 
			"on a.id_soggetto=s.id_soggetto " + 
			"left join medicotitolato medt on medt.id_soggetto=a.id_soggetto " + 
			"where  1=1 "+
			"<if test='cfUtenteRichiedente != null'> "+
			"and       "+
			"	( a.cf_utente_richiesta = #{cfUtenteRichiedente,jdbcType=VARCHAR}    "+
			"		or a.cf_utente_richiesta in (select z.cf_medico from r_medico_medico y, medico x, medico z where x.id_medico=y.id_medico_delegato   "+
			"		and z.id_medico=y.id_medico_delegante    "+
			"		and x.cf_medico= #{cfUtenteRichiedente,jdbcType=VARCHAR} "+
			"		and y.data_cancellazione is null    "+
			"		and now() between y.validita_inizio and coalesce(y.validita_fine, to_timestamp('01/01/2999','dd/mm/yyyy'))" +
			"	))" +
			"</if>  "+
			"<if test='cfUtenteDestinatario != null'> "
			+ "	and ( a.cf_utente_dest = #{cfUtenteDestinatario,jdbcType=VARCHAR}     "
			+ "		or a.cf_utente_dest in (select z.cf_medico from r_medico_medico y, medico x, medico z where x.id_medico=y.id_medico_delegato   "
			+ "		and z.id_medico=y.id_medico_delegante   " 
			+ "		and x.cf_medico= #{cfUtenteDestinatario,jdbcType=VARCHAR} "
			+ "		and y.data_cancellazione is null "
			+ "		and now() between y.validita_inizio and coalesce(y.validita_fine, to_timestamp('01/01/2999','dd/mm/yyyy'))" 
			+ "		)) " 
			+ "</if> "+
			"<if test='enteId != null'> and a.id_ente=#{enteId,jdbcType=BIGINT} </if> "+
			"<if test='struttura != null'> and a.id_struttura in (${struttura}) </if> "+
			"order by a.not_data_notifica " + 
			"desc";

	static final String NOTIFICHE_CON_MEDICI_DELEGANTI_OLD = "with medicotitolato as ( "+
	"with med as ( "+
	"	select tb.id_soggetto, tb.id_aura_sogg, "+
	"		   tb.wt, "+
	"          rank() over (partition by tb.id_soggetto order by tb.wt,tb.ordine), " +
	"          tb.id_medico From ( " +
	"				with aa as ( "+
	"					select b.id_soggetto, a.id_aura_sogg , 'aa'::text wt, rank() over (partition by b.id_soggetto order by a.data_scelta desc) as ordine, a.id_medico "+
	"					from r_medico_sogg_aura a,r_soggetto_aura b  " +
	"					where b.id_aura=a.id_aura_sogg and a.data_revoca is null   "+
	"					order by b.id_soggetto, ordine)    "+
	", bb as (    "+
	"select c.id_soggetto, d.id_aura, 'bb'::text wt, rank() over (partition by c.id_soggetto order by c.id_medico desc) as ordine,c.id_medico  "+
	"from r_medico_soggetto c left join r_soggetto_aura d  "+
	"on d.id_soggetto=c.id_soggetto         "+
	"order by c.id_soggetto, ordine)     "+
	"select * from aa       "+
	"union                   "+
	"select * from bb    "+
	"order by 1,3,4     "+
	") as tb      "+
	") select     "+
	"a.iD_soggetto,  "+
	"b.* from med a, medico b where rank=1    "+
	"and b.id_medico=a.id_medico)  "+
	"select  "+
	"a.not_id, a.not_data_notifica, a.not_data_presa_visione, a.not_testo_request, a.not_testo_response,  "+
	"a.id_soggetto, s.nome, s.cognome, s.codice_fiscale,   "+
	"a.cf_utente_richiesta, a.cf_utente_presa_vis, a.cf_utente_dest, a.id_ente,  "+
	"a.id_struttura,    "+
	"b.priorita_id, b.priorita_cod, b.priorita_desc,  "+
	"c.not_tipo_id, c.not_tipo_cod, c.not_tipo_desc,  "+
	"d.not_ev_id, d.not_ev_cod, d.not_ev_desc,        "+
	"e.not_az_id, e.not_az_cod, e.not_az_desc,        "+
	"f.not_ut_tipo_id, f.not_ut_tipo_cod, f.not_ut_tipo_desc, "+
	"a.utente_operazione,   "+
	"a.data_creazione,  "+
	"a.data_modifica, a.data_cancellazione,  "+
	"a.not_ut_tipo_id_dest, g.not_ut_tipo_cod utenteTipoCodDest, g.not_ut_tipo_desc utenteTipoDescDest,  "+
	"u.cf_utente contatto_cf, u.nome contatto_nome, u.cognome contatto_cognome, u.email contatto_email, u.telefono contatto_telefono,  "+
	"medt.id_medico,  "+
	"medt.cf_medico,  "+
	"medt.codice_reg, "+
	"medt.cognome  medico_cognome,"+
	"medt.nome  medico_nome "+
	"from notifica a    "+
	"left join d_notifica_priorita b on a.priorita_id = b.priorita_id            "+
	"left join d_notifica_tipo c on a.not_tipo_id = c.not_tipo_id                "+
	"left join d_notifica_evento d on a.not_ev_id = d.not_ev_id                  "+
	"left join d_notifica_azione e on a.not_az_id = e.not_az_id                  "+
	"left join d_notifica_utente_tipo f on a.not_ut_tipo_id = f.not_ut_tipo_id   "+
	"left join d_notifica_utente_tipo g on a.not_ut_tipo_id_dest = g.not_ut_tipo_id "+
	"left join utente_contatto u on a.cf_utente_richiesta = u.cf_utente  "+
	"left join soggetto s on a.id_soggetto = s.id_soggetto  "+
	"left join medicotitolato medt on medt.id_soggetto=a.id_soggetto  "+
	"where  "+
	"b.data_cancellazione is NULL "+
	"and c.data_cancellazione is null   "+
	"and d.data_cancellazione is null   "+
	//"and f.data_cancellazione is null   "+
	//"and g.data_cancellazione is null   "+
	"<if test='cfUtenteRichiedente != null'> "+
	"and       "+
	"	( a.cf_utente_richiesta = #{cfUtenteRichiedente,jdbcType=VARCHAR}    "+
	"		or a.cf_utente_richiesta in (select z.cf_medico from r_medico_medico y, medico x, medico z where x.id_medico=y.id_medico_delegato   "+
	"		and z.id_medico=y.id_medico_delegante    "+
	"		and x.cf_medico= #{cfUtenteRichiedente,jdbcType=VARCHAR} "+
	"		and y.data_cancellazione is null    "+
	"		and now() between y.validita_inizio and coalesce(y.validita_fine, to_timestamp('01/01/2999','dd/mm/yyyy'))" +
	"	))" +
	"</if>  "+
	"<if test='cfUtenteDestinatario != null'> "
	//+ " and a.cf_utente_dest=#{cfUtenteDestinatario,jdbcType=VARCHAR} " +
	+ "	and ( a.cf_utente_dest = #{cfUtenteDestinatario,jdbcType=VARCHAR}     "
	+ "		or a.cf_utente_dest in (select z.cf_medico from r_medico_medico y, medico x, medico z where x.id_medico=y.id_medico_delegato   "
	+ "		and z.id_medico=y.id_medico_delegante   " 
	+ "		and x.cf_medico= #{cfUtenteDestinatario,jdbcType=VARCHAR} "
	+ "		and y.data_cancellazione is null "
	+ "		and now() between y.validita_inizio and coalesce(y.validita_fine, to_timestamp('01/01/2999','dd/mm/yyyy'))" 
	+ "		)) " 
	+ "</if> "+
	"<if test='enteId != null'> and a.id_ente=#{enteId,jdbcType=BIGINT} </if> "+
	"<if test='struttura != null'> and a.id_struttura in (${struttura}) </if> "+
	"<if test='tipoUtenteMitt != null'> and a.not_ut_tipo_id=#{tipoUtenteMitt,jdbcType=BIGINT} </if> " +
	"<if test='tipoUtenteDest != null'> and a.not_ut_tipo_id_dest=#{tipoUtenteDest,jdbcType=BIGINT} </if>  "+
	" order by a.not_data_notifica desc" ;


	
	/**
	 * Nuova query ottimizzata
	 * @param cfUtenteDestinatario
	 * @param cfUtenteRichiedente
	 * @param tipoUtenteMitt
	 * @param tipoUtenteDest
	 * @param enteId
	 * @param struttura
	 * @param eventoCodeIn
	 * @param eventoCodeNotIn
	 * @return
	 */
	@Select({ "<script>", NOTIFICHE_CON_MEDICI_DELEGANTI ,
//		"select ",
//		"a.not_id, a.not_data_notifica, a.not_data_presa_visione, a.not_testo_request, a.not_testo_response,   ",
//		"a.id_soggetto, s.nome, s.cognome, s.codice_fiscale,                                                   ",
//		"a.cf_utente_richiesta, a.cf_utente_presa_vis, a.cf_utente_dest, a.id_ente,                            ",
//		"a.id_struttura,                                                                                       ",
//		"b.priorita_id, b.priorita_cod, b.priorita_desc,                                                       ",
//		"c.not_tipo_id, c.not_tipo_cod, c.not_tipo_desc,                                                       ",
//		"d.not_ev_id, d.not_ev_cod, d.not_ev_desc,                                                             ",
//		"e.not_az_id, e.not_az_cod, e.not_az_desc,                                                             ",
//		"f.not_ut_tipo_id, f.not_ut_tipo_cod, f.not_ut_tipo_desc,                                              ",
//		"a.utente_operazione,                                                                                  ",
//		"a.data_creazione,                                                                                     ",
//		"a.data_modifica, a.data_cancellazione,                                                                ",
//		"a.not_ut_tipo_id_dest, g.not_ut_tipo_cod utenteTipoCodDest, g.not_ut_tipo_desc utenteTipoDescDest,    ",
//		"u.cf_utente contatto_cf, u.nome contatto_nome, u.cognome contatto_cognome, u.email contatto_email, u.telefono contatto_telefono  ",
//		" from notifica a", 
//		" left join d_notifica_priorita b on a.priorita_id = b.priorita_id					    ",
//		" left join d_notifica_tipo c on a.not_tipo_id = c.not_tipo_id                          ",
//		" left join d_notifica_evento d on a.not_ev_id = d.not_ev_id                            ",
//		" left join d_notifica_azione e on a.not_az_id = e.not_az_id                            ",
//		" left join d_notifica_utente_tipo f on a.not_ut_tipo_id = f.not_ut_tipo_id             ",
//		" left join d_notifica_utente_tipo g on a.not_ut_tipo_id_dest = g.not_ut_tipo_id        ",
//		" left join utente_contatto u on a.cf_utente_richiesta = u.cf_utente                    ",
//		" left join soggetto s on a.id_soggetto = s.id_soggetto                                 ",
//		"<where>",
//		"<if test='cfUtenteDestinatario != null'> a.cf_utente_dest=#{cfUtenteDestinatario,jdbcType=BIGINT} </if> ",
//		"<if test='cfUtenteRichiedente != null'> and a.cf_utente_richiesta=#{cfUtenteRichiedente,jdbcType=BIGINT} </if> ",
//		"<if test='enteId != null'> and a.id_ente=#{enteId,jdbcType=BIGINT} </if> ",
//		"<if test='struttura != null'> and a.id_struttura in (${struttura}) </if> ",
//		"<if test='tipoUtenteMitt != null'> and a.not_ut_tipo_id=#{tipoUtenteMitt,jdbcType=BIGINT} </if> ",
//		"<if test='tipoUtenteDest != null'> and a.not_ut_tipo_id_dest=#{tipoUtenteDest,jdbcType=BIGINT} </if> ", "</where>",
//		"order by a.not_data_notifica desc",
		"</script>" })
		@Results({ @Result(column = "not_id", property = "notId", jdbcType = JdbcType.INTEGER, id = true),
		@Result(column = "not_data_notifica", property = "notDataNotifica", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "not_data_presa_visione", property = "notDataPresaVisione", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "not_testo_request", property = "notTestoRequest", jdbcType = JdbcType.VARCHAR),
		@Result(column = "not_testo_response", property = "notTestoResponse", jdbcType = JdbcType.VARCHAR),
		@Result(column = "id_soggetto", property = "idSoggetto", jdbcType = JdbcType.INTEGER),
		//s.nome, s.cognome, s.codice_fiscale
		@Result(column = "nome", property = "soggetto.nome", jdbcType = JdbcType.VARCHAR),
		@Result(column = "cognome", property = "soggetto.cognome", jdbcType = JdbcType.VARCHAR),
		@Result(column = "codice_fiscale", property = "soggetto.codiceFiscale", jdbcType = JdbcType.VARCHAR),
		
		// dNotificaPriorita --> "b.priorita_id, b.priorita_cod, b.priorita_desc,
		@Result(column = "priorita_id", property = "dNotificaPriorita.prioritaId", jdbcType = JdbcType.INTEGER),
		@Result(column = "priorita_cod", property = "dNotificaPriorita.prioritaCod", jdbcType = JdbcType.VARCHAR),
		@Result(column = "priorita_desc", property = "dNotificaPriorita.prioritaDesc", jdbcType = JdbcType.VARCHAR),
		
		// dNotificaTipo --> "c.not_tipo_id, c.not_tipo_cod, c.not_tipo_desc,
		@Result(column = "not_tipo_id", property = "dNotificaTipo.notTipoId", jdbcType = JdbcType.INTEGER),
		@Result(column = "not_tipo_cod", property = "dNotificaTipo.notTipoCod", jdbcType = JdbcType.VARCHAR),
		@Result(column = "not_tipo_desc", property = "dNotificaTipo.notTipoDesc", jdbcType = JdbcType.VARCHAR),
		
		// dNotificaEvento --> "d.not_ev_id, d.not_ev_cod, d.not_ev_desc,		
		@Result(column = "not_ev_id", property = "dNotificaEvento.notEvId", jdbcType = JdbcType.INTEGER),
		@Result(column = "not_ev_cod", property = "dNotificaEvento.notEvCod", jdbcType = JdbcType.VARCHAR),
		@Result(column = "not_ev_desc", property = "dNotificaEvento.notEvDesc", jdbcType = JdbcType.VARCHAR),
		
		// dNotificaAzione --> "e.not_az_id, e.not_az_cod, e.not_az_desc, 
		@Result(column = "not_az_id", property = "dNotificaAzione.notAzId", jdbcType = JdbcType.INTEGER),
		@Result(column = "not_az_cod", property = "dNotificaAzione.notAzCod", jdbcType = JdbcType.VARCHAR),
		@Result(column = "not_az_desc", property = "dNotificaAzione.notAzDesc", jdbcType = JdbcType.VARCHAR),
		
		// dNotificaUtenteTipo --> "f.not_ut_tipo_id, f.not_ut_tipo_cod, f.not_ut_tipo_desc,  
		@Result(column = "not_ut_tipo_id", property = "dNotificaUtenteTipo.notUtTipoId", jdbcType = JdbcType.INTEGER),
		@Result(column = "not_ut_tipo_cod", property = "dNotificaUtenteTipo.notUtTipoCod", jdbcType = JdbcType.VARCHAR),
		@Result(column = "not_ut_tipo_desc", property = "dNotificaUtenteTipo.notUtTipoDesc", jdbcType = JdbcType.VARCHAR),
		
		// dNotificaUtenteTipoDest --> g.not_ut_tipo_id,g.not_ut_tipo_cod,g.not_ut_tipo_desc
		@Result(column = "not_ut_tipo_id_dest", property = "dNotificaUtenteTipoDest.notUtTipoId", jdbcType = JdbcType.INTEGER),
		@Result(column = "utenteTipoCodDest", property = "dNotificaUtenteTipoDest.notUtTipoCod", jdbcType = JdbcType.VARCHAR),
		@Result(column = "utenteTipoDescDest", property = "dNotificaUtenteTipoDest.notUtTipoDesc", jdbcType = JdbcType.VARCHAR),
		
		@Result(column = "cf_utente_richiesta", property = "cfUtenteRichiesta", jdbcType = JdbcType.VARCHAR),
		@Result(column = "cf_utente_presa_vis", property = "cfUtentePresaVis", jdbcType = JdbcType.VARCHAR),
		@Result(column = "cf_utente_dest", property = "cfUtenteDest", jdbcType = JdbcType.VARCHAR),
		@Result(column = "id_ente", property = "idEnte", jdbcType = JdbcType.INTEGER),
		@Result(column = "id_struttura", property = "idStruttura", jdbcType = JdbcType.VARCHAR),
		
		// "u.nome, u.cognome, u.email, u.telefono
		@Result(column = "contatto_cf", property = "utenteContatto.cfUtente", jdbcType = JdbcType.VARCHAR),
		@Result(column = "contatto_nome", property = "utenteContatto.nome", jdbcType = JdbcType.VARCHAR),
		@Result(column = "contatto_cognome", property = "utenteContatto.cognome", jdbcType = JdbcType.VARCHAR),
		@Result(column = "contatto_email", property = "utenteContatto.email", jdbcType = JdbcType.VARCHAR),
		@Result(column = "contatto_telefono", property = "utenteContatto.telefono", jdbcType = JdbcType.VARCHAR),
		
		@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
		@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP),
		// Aggiunte le info del medico titolato
		@Result(column = "id_medico", property = "medico.idMedico", jdbcType = JdbcType.BIGINT),
		@Result(column = "cf_medico", property = "medico.cfMedico", jdbcType = JdbcType.VARCHAR),
		@Result(column = "codice_reg", property = "medico.codiceReg", jdbcType = JdbcType.VARCHAR),
		@Result(column = "medico_cognome", property = "medico.cognome", jdbcType = JdbcType.VARCHAR),
		@Result(column = "medico_nome", property = "medico.nome", jdbcType = JdbcType.VARCHAR)	
		 })
	List<NotificaExt> selectNotificheByFiltro(@Param("cfUtenteDestinatario")String cfUtenteDestinatario, @Param("cfUtenteRichiedente") String cfUtenteRichiedente, 
		@Param("tipoUtenteMitt")Integer tipoUtenteMitt, @Param("tipoUtenteDest")Integer tipoUtenteDest,
		@Param("enteId") Integer enteId, @Param("struttura") String struttura);
	
	
	
	@Select({ "<script>", 
		"select ",
		"a.not_id, a.not_data_notifica, a.not_data_presa_visione, a.not_testo_request, a.not_testo_response,   ",
		"a.id_soggetto, s.nome, s.cognome, s.codice_fiscale,                                                   ",
		"a.cf_utente_richiesta, a.cf_utente_presa_vis, a.cf_utente_dest, a.id_ente,                            ",
		"a.id_struttura,                                                                                       ",
		"b.priorita_id, b.priorita_cod, b.priorita_desc,                                                       ",
		"c.not_tipo_id, c.not_tipo_cod, c.not_tipo_desc,                                                       ",
		"d.not_ev_id, d.not_ev_cod, d.not_ev_desc,                                                             ",
		"e.not_az_id, e.not_az_cod, e.not_az_desc,                                                             ",
		"f.not_ut_tipo_id, f.not_ut_tipo_cod, f.not_ut_tipo_desc,                                              ",
		"a.utente_operazione,                                                                                  ",
		"a.data_creazione,                                                                                     ",
		"a.data_modifica, a.data_cancellazione,                                                                ",
		"a.not_ut_tipo_id_dest, g.not_ut_tipo_cod utenteTipoCodDest, g.not_ut_tipo_desc utenteTipoDescDest,    ",
		"u.cf_utente contatto_cf, u.nome contatto_nome, u.cognome contatto_cognome, u.email contatto_email, u.telefono contatto_telefono  ",
		" from notifica a", 
		" left join d_notifica_priorita b on a.priorita_id = b.priorita_id					    ",
		" left join d_notifica_tipo c on a.not_tipo_id = c.not_tipo_id                          ",
		" left join d_notifica_evento d on a.not_ev_id = d.not_ev_id                            ",
		" left join d_notifica_azione e on a.not_az_id = e.not_az_id                            ",
		" left join d_notifica_utente_tipo f on a.not_ut_tipo_id = f.not_ut_tipo_id             ",
		" left join d_notifica_utente_tipo g on a.not_ut_tipo_id_dest = g.not_ut_tipo_id        ",
		" left join utente_contatto u on a.cf_utente_richiesta = u.cf_utente                    ",
		" left join soggetto s on a.id_soggetto = s.id_soggetto                                 ",
		"<where>",
		"<if test='cfUtenteDestinatario != null'> a.cf_utente_dest=#{cfUtenteDestinatario,jdbcType=BIGINT} </if> ",
		"<if test='cfUtenteRichiedente != null'> and a.cf_utente_richiesta=#{cfUtenteRichiedente,jdbcType=BIGINT} </if> ",
		"<if test='enteId != null'> and a.id_ente=#{enteId,jdbcType=BIGINT} </if> ",
		"<if test='struttura != null'> and a.id_struttura in (${struttura}) </if> ",
		"<if test='tipoUtenteMitt != null'> and a.not_ut_tipo_id=#{tipoUtenteMitt,jdbcType=BIGINT} </if> ",
		"<if test='tipoUtenteDest != null'> and a.not_ut_tipo_id_dest=#{tipoUtenteDest,jdbcType=BIGINT} </if> ", "</where>",
		"order by a.not_data_notifica desc",
		"</script>" })
		@Results({ @Result(column = "not_id", property = "notId", jdbcType = JdbcType.INTEGER, id = true),
		@Result(column = "not_data_notifica", property = "notDataNotifica", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "not_data_presa_visione", property = "notDataPresaVisione", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "not_testo_request", property = "notTestoRequest", jdbcType = JdbcType.VARCHAR),
		@Result(column = "not_testo_response", property = "notTestoResponse", jdbcType = JdbcType.VARCHAR),
		@Result(column = "id_soggetto", property = "idSoggetto", jdbcType = JdbcType.INTEGER),
		//s.nome, s.cognome, s.codice_fiscale
		@Result(column = "nome", property = "soggetto.nome", jdbcType = JdbcType.VARCHAR),
		@Result(column = "cognome", property = "soggetto.cognome", jdbcType = JdbcType.VARCHAR),
		@Result(column = "codice_fiscale", property = "soggetto.codiceFiscale", jdbcType = JdbcType.VARCHAR),
		
		// dNotificaPriorita --> "b.priorita_id, b.priorita_cod, b.priorita_desc,
		@Result(column = "priorita_id", property = "dNotificaPriorita.prioritaId", jdbcType = JdbcType.INTEGER),
		@Result(column = "priorita_cod", property = "dNotificaPriorita.prioritaCod", jdbcType = JdbcType.VARCHAR),
		@Result(column = "priorita_desc", property = "dNotificaPriorita.prioritaDesc", jdbcType = JdbcType.VARCHAR),
		
		// dNotificaTipo --> "c.not_tipo_id, c.not_tipo_cod, c.not_tipo_desc,
		@Result(column = "not_tipo_id", property = "dNotificaTipo.notTipoId", jdbcType = JdbcType.INTEGER),
		@Result(column = "not_tipo_cod", property = "dNotificaTipo.notTipoCod", jdbcType = JdbcType.VARCHAR),
		@Result(column = "not_tipo_desc", property = "dNotificaTipo.notTipoDesc", jdbcType = JdbcType.VARCHAR),
		
		// dNotificaEvento --> "d.not_ev_id, d.not_ev_cod, d.not_ev_desc,		
		@Result(column = "not_ev_id", property = "dNotificaEvento.notEvId", jdbcType = JdbcType.INTEGER),
		@Result(column = "not_ev_cod", property = "dNotificaEvento.notEvCod", jdbcType = JdbcType.VARCHAR),
		@Result(column = "not_ev_desc", property = "dNotificaEvento.notEvDesc", jdbcType = JdbcType.VARCHAR),
		
		// dNotificaAzione --> "e.not_az_id, e.not_az_cod, e.not_az_desc, 
		@Result(column = "not_az_id", property = "dNotificaAzione.notAzId", jdbcType = JdbcType.INTEGER),
		@Result(column = "not_az_cod", property = "dNotificaAzione.notAzCod", jdbcType = JdbcType.VARCHAR),
		@Result(column = "not_az_desc", property = "dNotificaAzione.notAzDesc", jdbcType = JdbcType.VARCHAR),
		
		// dNotificaUtenteTipo --> "f.not_ut_tipo_id, f.not_ut_tipo_cod, f.not_ut_tipo_desc,  
		@Result(column = "not_ut_tipo_id", property = "dNotificaUtenteTipo.notUtTipoId", jdbcType = JdbcType.INTEGER),
		@Result(column = "not_ut_tipo_cod", property = "dNotificaUtenteTipo.notUtTipoCod", jdbcType = JdbcType.VARCHAR),
		@Result(column = "not_ut_tipo_desc", property = "dNotificaUtenteTipo.notUtTipoDesc", jdbcType = JdbcType.VARCHAR),
		
		// dNotificaUtenteTipoDest --> g.not_ut_tipo_id,g.not_ut_tipo_cod,g.not_ut_tipo_desc
		@Result(column = "not_ut_tipo_id_dest", property = "dNotificaUtenteTipoDest.notUtTipoId", jdbcType = JdbcType.INTEGER),
		@Result(column = "utenteTipoCodDest", property = "dNotificaUtenteTipoDest.notUtTipoCod", jdbcType = JdbcType.VARCHAR),
		@Result(column = "utenteTipoDescDest", property = "dNotificaUtenteTipoDest.notUtTipoDesc", jdbcType = JdbcType.VARCHAR),
		
		@Result(column = "cf_utente_richiesta", property = "cfUtenteRichiesta", jdbcType = JdbcType.VARCHAR),
		@Result(column = "cf_utente_presa_vis", property = "cfUtentePresaVis", jdbcType = JdbcType.VARCHAR),
		@Result(column = "cf_utente_dest", property = "cfUtenteDest", jdbcType = JdbcType.VARCHAR),
		@Result(column = "id_ente", property = "idEnte", jdbcType = JdbcType.INTEGER),
		@Result(column = "id_struttura", property = "idStruttura", jdbcType = JdbcType.VARCHAR),
		
		// "u.nome, u.cognome, u.email, u.telefono
		@Result(column = "contatto_cf", property = "utenteContatto.cfUtente", jdbcType = JdbcType.VARCHAR),
		@Result(column = "contatto_nome", property = "utenteContatto.nome", jdbcType = JdbcType.VARCHAR),
		@Result(column = "contatto_cognome", property = "utenteContatto.cognome", jdbcType = JdbcType.VARCHAR),
		@Result(column = "contatto_email", property = "utenteContatto.email", jdbcType = JdbcType.VARCHAR),
		@Result(column = "contatto_telefono", property = "utenteContatto.telefono", jdbcType = JdbcType.VARCHAR),
		
		@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
		@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP)
		// Aggiunte le info del medico titolato
//		@Result(column = "id_medico", property = "medico.idMedico", jdbcType = JdbcType.BIGINT),
//		@Result(column = "cf_medico", property = "medico.cfMedico", jdbcType = JdbcType.VARCHAR),
//		@Result(column = "codice_reg", property = "medico.codiceReg", jdbcType = JdbcType.VARCHAR),
//		@Result(column = "medico_cognome", property = "medico.cognome", jdbcType = JdbcType.VARCHAR),
//		@Result(column = "medico_nome", property = "medico.nome", jdbcType = JdbcType.VARCHAR)	
		 })
	List<NotificaExt> selectNotificheByFiltroSisp(@Param("cfUtenteDestinatario")String cfUtenteDestinatario, @Param("cfUtenteRichiedente") String cfUtenteRichiedente, 
		@Param("tipoUtenteMitt")Integer tipoUtenteMitt, @Param("tipoUtenteDest")Integer tipoUtenteDest,
		@Param("enteId") Integer enteId, @Param("struttura") String struttura);
	
	
	
	@Select({ "<script>", 
		"select count(*) as num ",
		"from notifica n",
		"left join d_notifica_evento dne on n.not_ev_id = dne.not_ev_id",
		"<where>",
		" n.not_data_presa_visione is null ",
		"   <if test='cfUtenteDestinatario != null'> cf_utente_dest=#{cfUtenteDestinatario,jdbcType=BIGINT} </if> ",
		"   <if test='cfUtenteRichiedente != null'> and cf_utente_richiesta=#{cfUtenteRichiedente,jdbcType=BIGINT} </if> ",
		"   <if test='enteId != null'> and id_ente=#{enteId,jdbcType=BIGINT} </if> ",
		"   <if test='struttura != null'> and id_struttura in (${struttura}) </if> ",
		"   <if test='tipoUtenteMitt != null'> and not_ut_tipo_id=#{tipoUtenteMitt,jdbcType=BIGINT} </if> ",
		"   <if test='tipoUtenteDest != null'> and not_ut_tipo_id_dest=#{tipoUtenteDest,jdbcType=BIGINT} </if> ", 
		"   <if test='eventoCodeIn != null'>    AND dne.not_ev_cod IN     (<foreach collection='eventoCodeIn'    item='eci'  separator=','>#{eci} </foreach>) </if> ",
		"   <if test='eventoCodeNotIn != null'> AND dne.not_ev_cod NOT IN (<foreach collection='eventoCodeNotIn' item='ecni' separator=','>#{ecni}</foreach>) </if> ", 
		"</where>",
		"</script>" })
	
	//@Result(column = "num", jdbcType = JdbcType.INTEGER)
	long countNotificheByFiltro(@Param("cfUtenteDestinatario")String cfUtenteDestinatario, @Param("cfUtenteRichiedente") String cfUtenteRichiedente, 
		@Param("tipoUtenteMitt")Integer tipoUtenteMitt, @Param("tipoUtenteDest")Integer tipoUtenteDest,
		@Param("enteId") Integer enteId, @Param("struttura") String struttura,  
		@Param("eventoCodeIn") List<String> eventoCodeIn, 
		@Param("eventoCodeNotIn") List<String> eventoCodeNotIn);
	
	
	@Select({ "<script>", 
		"select count(*) as num ",
		"from notifica a",
		"join d_notifica_tipo dnt on dnt.not_tipo_id = a.not_tipo_id ",
		"<where>",
		" a.not_data_presa_visione is null ",
		"  <if test='tipoUtenteMitt != null'> and a.not_ut_tipo_id=#{tipoUtenteMitt,jdbcType=BIGINT} </if>",
		"  <if test='tipoUtenteDest != null'> and a.not_ut_tipo_id_dest=#{tipoUtenteDest,jdbcType=BIGINT} </if>",
		"  <if test='cfUtenteDestinatario != null'> and a.cf_utente_dest=#{cfUtenteDestinatario,jdbcType=VARCHAR} </if> ",
		"  <if test='cfUtenteRichiedente != null'> and a.cf_utente_richiesta=#{cfUtenteRichiedente,jdbcType=VARCHAR} </if> ",
		"   <if test='enteId != null'> and a.id_ente=#{enteId,jdbcType=BIGINT} </if> ",
		"   <if test='struttura != null'> and a.id_struttura in (${struttura}) </if> ",
		"  <if test='tipoCodeIn != null'>    AND dnt.not_tipo_cod IN     (<foreach collection='tipoCodeIn'    item='eci'  separator=','>#{eci} </foreach>) </if> ",
		"  <if test='tipoCodeNotIn != null'> AND dnt.not_tipo_cod NOT IN (<foreach collection='tipoCodeNotIn' item='ecni' separator=','>#{ecni}</foreach>) </if> ",
		"</where>",
		"</script>" })
	long countNotificheByFiltroForTipo(@Param("cfUtenteDestinatario")String cfUtenteDestinatario,
			@Param("cfUtenteRichiedente")String cfUtenteRichiedente,
			@Param("tipoUtenteMitt")Integer tipoUtenteMitt, @Param("tipoUtenteDest")Integer tipoUtenteDest,
			@Param("enteId") Integer enteId, @Param("struttura") String struttura,
			@Param("tipoCodeIn") List<String> tipoCodeIn, 
			@Param("tipoCodeNotIn") List<String> tipoCodeNotIn);
	
	
	

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table notifica
	 * @mbg.generated
	 */
	@Update({ "update notifica", "set",
			"not_data_presa_visione = #{notDataPresaVisione,jdbcType=TIMESTAMP},",
			"not_testo_response = #{notTestoResponse,jdbcType=VARCHAR},",
			"cf_utente_presa_vis = #{cfUtentePresaVis,jdbcType=VARCHAR},",
			"data_modifica = #{dataModifica,jdbcType=TIMESTAMP}",
			"where not_id = #{notId,jdbcType=INTEGER}" })
	int updateByPrimaryKeyRidotta(Notifica record);
	
	
	
//	@Select({"select  case when",
//	    "(select 'OK'::text esito from notifica a",
//	    	    "where",
//	    	   " a.not_id = #{notId,jdbcType=INTEGER}",
//	    	    "and exists (",
//	    	     "  select 1 from tampone x",
//	    	      " where x.id_soggetto=a.id_soggetto",
//	    	       "and trunc(x.data_inserimento_richiesta) >= trunc(a.data_creazione)",
//	    	       "and  x.id_ris_tamp is not null",
//	    	    ") )='OK'",
//	    	     "then 'Tampone eseguito'",
//	    	   "when",
//	    	    "( select 'OK'::text esito from notifica a where",
//	    	     "a.not_id = #{notId,jdbcType=VARCHAR} ",
//	    	     "and exists (",
//	    	       "select 1 from tampone x",
//	    	       "where x.id_soggetto=a.id_soggetto",
//	    	       "and trunc(x.data_inserimento_richiesta) >= trunc(a.data_creazione)",
//	    	       "and x.id_ris_tamp is null",
//	    	    "))='OK'",
//	    	     "then 'Tampone in corso'",
//	    	    "else 'Tampone da richiedere'",
//	    	    "end as esito",
//	    	 "from dual"})
//	String getEsitoTampone(@Param("notId")Integer notId);
	
	
	
	@Select({"select " ,
			"  case when " ,
			"    ( select 'OK'::text esito from notifica a " ,
			"    where " ,
			"    a.not_id = #{notId,jdbcType=INTEGER} " , 
			"    and exists ( " ,
			"       select 1 from tampone x, ris_tampone y " ,
			"       where x.id_soggetto=a.id_soggetto " ,
			"       and trunc(x.data_test) >= trunc(a.data_creazione) ",  
			"       and  x.id_ris_tamp = y.id_ris_tamp " ,
			"       and y.risultato_tampone in ('POSITIVO','NEGATIVO')" , 
			"    ) )='OK'" ,
			"     then 'Tampone eseguito verificare esito'" , 
			"   when " ,
			"    ( select 'OK'::text esito from notifica a where " , 
			"     a.not_id = #{notId,jdbcType=INTEGER} " ,
			"     and exists ( " , 
			"       select 1 from tampone x " ,
			"       where x.id_soggetto=a.id_soggetto " , 
			"       and trunc(x.data_inserimento_richiesta) >= trunc(a.data_creazione) " ,
			"      ) " ,
			"    )='OK' " , 
			"     then 'Tampone richiesto e iter in corso' " ,			
			// Raffa 03/08/2020: su richiesta di Carlo e Guido si aggiunge condizione per gestire i tamponi 
			// che arrivano dalla procedura automatica (procedura di Vezzetti)
			" when ",
			" ( select 'OK'::text esito from notifica a where ",
			" 	a.not_id = #{notId,jdbcType=INTEGER} ",
			"	 and exists  ( ",
			" 		select 1 from notifica a, tampone t, ris_tampone y ",
			" 			where a.cf_utente_richiesta = 'Proc. automa' ",
			" 			and t.id_soggetto = a.id_soggetto ",
			" 			and t.id_ris_tamp is not null ",
			" 			and t.id_ris_tamp = y.id_ris_tamp ",
			" 			and y.risultato_tampone in ('POSITIVO','NEGATIVO') ) ",
			" )='OK' ",
			" then 'Tampone eseguito verificare esito'  ",
			"    else 'Tampone da richiedere' " ,
			"    END as esito " ,
			" from dual "})
	String getEsitoTampone(@Param("notId")Integer notId);
	
	
	
	
}
