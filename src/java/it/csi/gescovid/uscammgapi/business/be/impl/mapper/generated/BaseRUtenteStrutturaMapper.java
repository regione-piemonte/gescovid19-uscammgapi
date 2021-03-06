package it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.RUtenteStruttura;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface BaseRUtenteStrutturaMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table r_utente_struttura
	 * @mbg.generated
	 */
	@Delete({ "delete from r_utente_struttura", "where cf_utente = #{cfUtente,jdbcType=VARCHAR}",
			"and id_struttura = #{idStruttura,jdbcType=VARCHAR}" })
	int deleteByPrimaryKey(@Param("cfUtente") String cfUtente, @Param("idStruttura") String idStruttura);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table r_utente_struttura
	 * @mbg.generated
	 */
	@Insert({ "insert into r_utente_struttura (cf_utente, id_struttura)",
			"values (#{cfUtente,jdbcType=VARCHAR}, #{idStruttura,jdbcType=VARCHAR})" })
	int insert(RUtenteStruttura record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table r_utente_struttura
	 * @mbg.generated
	 */
	@Select({ "select", "cf_utente, id_struttura", "from r_utente_struttura" })
	@Results({ @Result(column = "cf_utente", property = "cfUtente", jdbcType = JdbcType.VARCHAR, id = true),
			@Result(column = "id_struttura", property = "idStruttura", jdbcType = JdbcType.VARCHAR, id = true) })
	List<RUtenteStruttura> selectAll();
}