package it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.CovidusTAdiCovidDet;
import it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated.BaseCovidusTAdicovidDetMapper;

public interface AdiCovidDetMapper extends BaseCovidusTAdicovidDetMapper{
	
	@Select({ "select", "adicovid_det_id, adicovid_det_data, adicovid_det_note, adicovid_id, utente_operazione, ",
		"data_creazione, data_modifica, data_cancellazione", "from covidus_t_adicovid_det",
		"where adicovid_id = #{idAdiCovid,jdbcType=INTEGER}" })
@Results({ @Result(column = "adicovid_det_id", property = "adicovidDetId", jdbcType = JdbcType.INTEGER, id = true),
		@Result(column = "adicovid_det_data", property = "adicovidDetData", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "adicovid_det_note", property = "adicovidDetNote", jdbcType = JdbcType.VARCHAR),
		@Result(column = "adicovid_id", property = "adicovidId", jdbcType = JdbcType.INTEGER),
		@Result(column = "utente_operazione", property = "utenteOperazione", jdbcType = JdbcType.VARCHAR),
		@Result(column = "data_creazione", property = "dataCreazione", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "data_modifica", property = "dataModifica", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "data_cancellazione", property = "dataCancellazione", jdbcType = JdbcType.TIMESTAMP) })
List<CovidusTAdiCovidDet> selectByIdAdiCovid(Integer idAdiCovid);
	

}
