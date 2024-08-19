package net.ideahut.springboot.template.entity.api;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import net.ideahut.springboot.annotation.ApiExclude;
import net.ideahut.springboot.annotation.Audit;
import net.ideahut.springboot.api.entity.EntRole;

@ApiExclude
@Audit
@Entity
@Table(name = "api_role")
@Setter
@Getter
@SuppressWarnings("serial")
public class ApiRole extends EntRole {

	public ApiRole() {
		super();
	}

	public ApiRole(String roleCode) {
		super(roleCode);
	}
	
}
