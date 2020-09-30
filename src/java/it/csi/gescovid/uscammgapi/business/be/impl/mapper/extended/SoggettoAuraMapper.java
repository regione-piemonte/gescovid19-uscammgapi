package it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.SoggettoAura;

public interface SoggettoAuraMapper {



	@Select({ "select", "id_soggetto, id_aura", 
		" from r_soggetto_aura" ,
		" where id_soggetto = #{idSoggetto,jdbcType=BIGINT}"
		})
	@Results({ @Result(column = "id_soggetto", property = "idSoggetto", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "id_aura", property = "idAura", jdbcType = JdbcType.BIGINT, id = true) })
	List<SoggettoAura> selectByIdSoggetto(@Param("idSoggetto") Long idSoggetto);

	
}
