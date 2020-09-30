package it.csi.gescovid.uscammgapi.business.be.impl.mapper.generated;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.Area;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface BaseAreaMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table area
	 * @mbg.generated
	 */
	@Delete({ "delete from area", "where id_area = #{idArea,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(Integer idArea);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table area
	 * @mbg.generated
	 */
	@Insert({ "insert into area (id_struttura, id_d_area, ", "nome, responsabile, ", "riferimento, stato_validita)",
			"values (#{idStruttura,jdbcType=VARCHAR}, #{idDArea,jdbcType=VARCHAR}, ",
			"#{nome,jdbcType=VARCHAR}, #{responsabile,jdbcType=VARCHAR}, ",
			"#{riferimento,jdbcType=VARCHAR}, #{statoValidita,jdbcType=VARCHAR})" })
	@Options(useGeneratedKeys = true, keyProperty = "idArea")
	int insert(Area record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table area
	 * @mbg.generated
	 */
	@Select({ "select", "id_area, id_struttura, id_d_area, nome, responsabile, riferimento, stato_validita",
			"from area", "where id_area = #{idArea,jdbcType=INTEGER}" })
	@Results({ @Result(column = "id_area", property = "idArea", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "id_struttura", property = "idStruttura", jdbcType = JdbcType.VARCHAR),
			@Result(column = "id_d_area", property = "idDArea", jdbcType = JdbcType.VARCHAR),
			@Result(column = "nome", property = "nome", jdbcType = JdbcType.VARCHAR),
			@Result(column = "responsabile", property = "responsabile", jdbcType = JdbcType.VARCHAR),
			@Result(column = "riferimento", property = "riferimento", jdbcType = JdbcType.VARCHAR),
			@Result(column = "stato_validita", property = "statoValidita", jdbcType = JdbcType.VARCHAR) })
	Area selectByPrimaryKey(Integer idArea);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table area
	 * @mbg.generated
	 */
	@Select({ "select", "id_area, id_struttura, id_d_area, nome, responsabile, riferimento, stato_validita",
			"from area" })
	@Results({ @Result(column = "id_area", property = "idArea", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "id_struttura", property = "idStruttura", jdbcType = JdbcType.VARCHAR),
			@Result(column = "id_d_area", property = "idDArea", jdbcType = JdbcType.VARCHAR),
			@Result(column = "nome", property = "nome", jdbcType = JdbcType.VARCHAR),
			@Result(column = "responsabile", property = "responsabile", jdbcType = JdbcType.VARCHAR),
			@Result(column = "riferimento", property = "riferimento", jdbcType = JdbcType.VARCHAR),
			@Result(column = "stato_validita", property = "statoValidita", jdbcType = JdbcType.VARCHAR) })
	List<Area> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table area
	 * @mbg.generated
	 */
	@Update({ "update area", "set id_struttura = #{idStruttura,jdbcType=VARCHAR},",
			"id_d_area = #{idDArea,jdbcType=VARCHAR},", "nome = #{nome,jdbcType=VARCHAR},",
			"responsabile = #{responsabile,jdbcType=VARCHAR},", "riferimento = #{riferimento,jdbcType=VARCHAR},",
			"stato_validita = #{statoValidita,jdbcType=VARCHAR}", "where id_area = #{idArea,jdbcType=INTEGER}" })
	int updateByPrimaryKey(Area record);
}