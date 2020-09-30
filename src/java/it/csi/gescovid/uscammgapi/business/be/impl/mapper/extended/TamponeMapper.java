package it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.ElencoTampone;



public interface TamponeMapper {

	
    @Select({
       " select * from ( select ", 
       "    tampone.id_tampone, id_soggetto,tampone.id_laboratorio, ", 
       "    criterio_epidemiologico_covid19, tampone.id_test_covid, data_test, ", 
       "    tampone.id_ris_tamp,tampone_autorizzato, ", 
       "    data_inserimento_richiesta,data_ultima_modifica, utente_ultima_modifica, ", 
       "    laboratorio.descrizione laboratorio_descrizione,laboratorio.sigla_laboratorio sigla_laboratorio, ", 
       "    laboratorio.capacita_giornaliera capacita_giornaliera, ", 
       "    medico_richiedente, ", 
       "    contatto_richiedente, ", 
       "    test_covid.test_covid, ", 
       "    ris_tampone.risultato_tampone, ", 
       "    d_tampone_motivo.tampone_motivo_id, ", 
       "    d_tampone_motivo.tampone_motivo_cod , ", 
       "    d_tampone_motivo.tampone_motivo_desc ", 
       " from ", 
       "    tampone ", 
       " left join laboratorio on ", 
       "    tampone.id_laboratorio = laboratorio.id_laboratorio ", 
       " left join test_covid on ", 
       "    tampone.id_test_covid = test_covid.id_test_covid ", 
       " left join ris_tampone on ", 
       "    tampone.id_ris_tamp = ris_tampone.id_ris_tamp ", 
       " left join d_tampone_motivo on ", 
       "    tampone.tampone_motivo_id = d_tampone_motivo.tampone_motivo_id ", 
       " where ", 
       "    id_soggetto = #{idSoggetto,jdbcType=BIGINT}     ", 
       " UNION ", 
       "  select null, id_soggetto, null, 'Referto in corso di abbinamento alla richiesta', ", 
       "   null, trunc(ref.effectivetime_value), ", 
       "  decode(ref.value_code,'P','2','N','4')::integer, null, null, null, NULL, ref_test.descr_struttura, null, ", 
       "  null, null, NULL, NULL, ", 
       "   decode(ref.value_code,'P','POSITIVO','N','NEGATIVO'), ", 
       "  null,null,null ", 
       "  from dmarefcovid_l_elaborazione_referto dler , dmarefcovid_t_referto_det ref , ", 
       "  dmarefcovid_t_referto ref_test , soggetto x ", 
       "  where dler.elabdet_scarto = true ", 
       "  and ref.intfrdet_id=dler.intfrdet_id ", 
       "  and ref.value_code in ('P','N') ", 
       "  and ref.id_messaggio= ref_test.id_messaggio ", 
       "  and x.codice_fiscale = ref_test.codfisc    ", 
       "  and x.id_soggetto = #{idSoggetto,jdbcType=BIGINT}     ", 
       "  and not exists ( ", 
       "       select 1 from tampone a ", 
       "       where a.id_soggetto = x.id_soggetto ", 
       "       and trunc(a.data_test) = trunc(ref.effectivetime_value) ", 
       "       and decode(ref.value_code,'P','2','N','4')::integer = a.id_ris_tamp ", 
       "    ) ", 
       " UNION ", 
       "   select null, id_soggetto, null, 'Referto in corso di abbinamento alla richiesta', ", 
       "   null, trunc(ref.effectivetime_value), ", 
       "  decode(ref.value_code,'P','2','N','4')::integer, null, null, null, NULL, ref_test.descr_struttura, null, ", 
       "  null, null, NULL, NULL, ", 
       "   decode(ref.value_code,'P','POSITIVO','N','NEGATIVO'), ", 
       "  null,null,null ", 
       "  from dmarefcovid_l_elaborazione_referto dler , dmarefcovid_t_referto_det ref , ", 
       "  dmarefcovid_t_referto ref_test , soggetto x ", 
       "  where dler.elabdet_scarto = true ", 
       "  and ref.intfrdet_id=dler.intfrdet_id ", 
       "  and ref.value_code in ('P','N') ", 
       "  and ref.id_messaggio= ref_test.id_messaggio ", 
       "  and ( ", 
       "         x.codice_fiscale <> ref_test.codfisc ", 
       "         and x.cognome = ref_test.cognome ", 
       "         and x.nome = ref_test.nome ", 
       "         and trunc(x.data_nascita) = trunc(ref_test.datanascita) ", 
       "          ", 
       "       )   ", 
       "  and x.id_soggetto = #{idSoggetto,jdbcType=BIGINT}     ", 
       "  and not exists ( ", 
       "       select 1 from tampone a ", 
       "       where a.id_soggetto = x.id_soggetto ", 
       "       and trunc(a.data_test) = trunc(ref.effectivetime_value) ", 
       "       and decode(ref.value_code,'P','2','N','4')::integer = a.id_ris_tamp ", 
       "    ) ) as risultati" + 
       " order by id_tampone desc"
    })
    @Results({
        @Result(column="id_tampone", property="idTampone", jdbcType=JdbcType.BIGINT),
        @Result(column="id_soggetto", property="idSoggetto", jdbcType=JdbcType.BIGINT),
        @Result(column="id_laboratorio", property="idLaboratorio", jdbcType=JdbcType.BIGINT),
        @Result(column="criterio_epidemiologico_covid19", property="criterioEpidemiologicoCovid19", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_test_covid", property="idTestCovid", jdbcType=JdbcType.BIGINT),
        @Result(column="data_test", property="dataTest", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="id_ris_tamp", property="idRisTamp", jdbcType=JdbcType.BIGINT),
        @Result(column="medico_richiedente", property="medicoRichiedente", jdbcType=JdbcType.VARCHAR),
        @Result(column="contatto_richiedente", property="contattoRichiedente", jdbcType=JdbcType.VARCHAR),
        @Result(column="tampone_autorizzato", property="tamponeAutorizzato", jdbcType=JdbcType.VARCHAR),
		@Result(column = "data_inserimento_richiesta", property = "dataInserimentoRichiesta", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "data_ultima_modifica", property = "dataUltimaModifica", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "utente_ultima_modifica", property = "utenteUltimaModifica", jdbcType = JdbcType.VARCHAR),
        @Result(column="id_laboratorio", property="laboratorio.idLaboratorio", jdbcType=JdbcType.BIGINT),
        @Result(column="laboratorio_descrizione", property="laboratorio.descrizione", jdbcType=JdbcType.VARCHAR),
        @Result(column="sigla_laboratorio", property="laboratorio.siglaLaboratorio", jdbcType=JdbcType.VARCHAR),
        @Result(column="capacita_giornaliera", property="laboratorio.capacitaGiornaliera", jdbcType=JdbcType.BIGINT),
        @Result(column="id_test_covid", property="testCovid.idTestCovid", jdbcType=JdbcType.BIGINT),
        @Result(column="test_covid", property="testCovid.testCovid", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_ris_tamp", property="risTampone.idRisTamp", jdbcType=JdbcType.BIGINT),
        @Result(column="risultato_tampone", property="risTampone.risultatoTampone", jdbcType=JdbcType.VARCHAR),
        @Result(column="tampone.tampone_motivo_id", property="tamponeMotivo.tamponeMotivoId", jdbcType=JdbcType.BIGINT),
        @Result(column="tampone_motivo_cod", property="tamponeMotivo.tamponeMotivoCod", jdbcType=JdbcType.VARCHAR),
        @Result(column="tampone_motivo_desc", property="tamponeMotivo.tamponeMotivoDesc", jdbcType=JdbcType.VARCHAR)
    })
    List<ElencoTampone> selectForElencoByIdSoggetto(Long idSoggetto);
	
    
    
    
}
