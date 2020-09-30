package it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended;

import org.apache.ibatis.annotations.Update;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseCovidusTInterventoMapper;

public interface InterventoMapper extends BaseCovidusTInterventoMapper{
	
	
	@Update({ "update covidus_t_intervento", "set ",
		"data_cancellazione = now()",
		"where int_id = #{intIntervento,jdbcType=INTEGER}" })
int logicDeleteByPrimaryKey(Integer idIntervento);
	
	
	
	
}
