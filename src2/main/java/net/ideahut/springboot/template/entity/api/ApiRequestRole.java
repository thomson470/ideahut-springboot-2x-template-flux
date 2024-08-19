package net.ideahut.springboot.template.entity.api;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Getter;
import lombok.Setter;
import net.ideahut.springboot.annotation.ApiExclude;
import net.ideahut.springboot.annotation.Audit;
import net.ideahut.springboot.api.entity.EntRequestRole;
import net.ideahut.springboot.api.entity.EntRequestRoleId;

@ApiExclude
@Audit
@Entity
@Table(name = "api_request_role")
@Setter
@Getter
@SuppressWarnings("serial")
public class ApiRequestRole extends EntRequestRole {
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
		name = "role_code", 
		nullable = false, 
		insertable = false, 
		updatable = false, 
		foreignKey = @ForeignKey(name = "fk_api_request_role__role")
	)
	private ApiRole role;

	public ApiRequestRole() {
		super();
	}

	public ApiRequestRole(EntRequestRoleId id) {
		super(id);
	}	
	
}
