package it.csi.gescovid.uscammgapi.business.be.impl.mapper.extended;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import it.csi.gescovid.uscammgapi.business.be.impl.mapper.dto.custom.Audit;

public interface AuditMapper {

	@Insert({ "insert into \"COVID19_audit\" (datetime, ip, \"user\", \"table\", action, description)",
			"values (NOW(), #{ip,jdbcType=VARCHAR}, #{user,jdbcType=VARCHAR}, #{table,jdbcType=VARCHAR}, ",
			"#{action,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR})" })
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(Audit audit);

}