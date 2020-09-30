package it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Struttura;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.StrutturaEnteExtDto;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseStrutturaMapper;

public interface StrutturaUscaMapper extends BaseStrutturaMapper {
	
	@Select({ "select", "str.id_struttura, str.id_ente, str.nome, natura,",
		 		"ente.id_ente as idEnte, ente.nome as nomeEnte, tot_posti_target",
		"from covidus_r_app_struttura rapp",
		"inner join struttura str on (rapp.id_struttura = str.id_struttura)",
		"inner join ente ente on (str.id_ente = ente.id_ente) ",
		"where data_cancellazione is null",
		"and now() between validita_inizio and coalesce(validita_fine, to_timestamp('01/01/2999','dd/mm/yyyy'))"})
		
	@Results({ @Result(column = "id_struttura", property = "idStruttura", jdbcType = JdbcType.VARCHAR, id = true),
			@Result(column = "id_ente", property = "idEnte", jdbcType = JdbcType.INTEGER),
			@Result(column = "nome", property = "nome", jdbcType = JdbcType.VARCHAR),
			@Result(column = "natura", property = "natura", jdbcType = JdbcType.VARCHAR),
			@Result(column = "idEnte", property = "ente.idEnte", jdbcType = JdbcType.INTEGER),
			@Result(column = "nomeEnte", property = "ente.nome", jdbcType = JdbcType.VARCHAR),
			@Result(column = "tot_posti_target", property = "ente.totPostiTarget", jdbcType = JdbcType.INTEGER)})
/*			
			@Result(column = "nomeEnte", property = "nomeEnte", jdbcType = JdbcType.VARCHAR),
			@Result(column = "tot_posti_target", property = "totPostiTarget", jdbcType = JdbcType.INTEGER)})*/
	List<StrutturaEnteExtDto> selectAllStruttureUsca();
	

}
