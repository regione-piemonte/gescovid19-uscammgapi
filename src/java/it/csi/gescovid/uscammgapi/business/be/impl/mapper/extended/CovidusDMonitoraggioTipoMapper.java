package it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusDMonitoraggioTipo;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.DNotificaAzione;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseCovidusDMonitoraggioTipoMapper;

public interface CovidusDMonitoraggioTipoMapper extends BaseCovidusDMonitoraggioTipoMapper {

	@Select({ "select monitoraggio_tipo_id, monitoraggio_tipo_cod, monitoraggio_tipo_desc ",
			"from covidus_d_monitoraggio_tipo " ,
			"	where data_cancellazione is null and   " ,
			"	now() between validita_inizio and coalesce(validita_fine, to_timestamp('01/01/2999','dd/mm/yyyy'))"
	})
	@Results({
		@Result(column = "monitoraggio_tipo_id", property = "monitoraggioTipoId", jdbcType = JdbcType.INTEGER, id = true),
		@Result(column = "monitoraggio_tipo_cod", property = "monitoraggioTipoCod", jdbcType = JdbcType.VARCHAR),
		@Result(column = "monitoraggio_tipo_desc", property = "monitoraggioTipoDesc", jdbcType = JdbcType.VARCHAR)
		 })
	List<CovidusDMonitoraggioTipo> selectAllMonitoraggioTipiValidi();
	
	
}
