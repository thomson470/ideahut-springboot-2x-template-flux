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
import net.ideahut.springboot.api.entity.EntCrudRole;
import net.ideahut.springboot.api.entity.EntCrudRoleId;

@ApiExclude
@Audit
@Entity
@Table(name = "api_crud_role")
@Setter
@Getter
@SuppressWarnings("serial")
public class ApiCrudRole extends EntCrudRole {

	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
		name = "role_code", 
		nullable = false, 
		insertable = false, 
		updatable = false, 
		foreignKey = @ForeignKey(name = "fk_api_crud_role__role")
	)
	private ApiRole role;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
		name = "crud_code", 
		nullable = false, 
		insertable = false, 
		updatable = false, 
		foreignKey = @ForeignKey(name = "fk_api_crud_role__crud")
	)
	private ApiCrud crud;
	
	public ApiCrudRole() {}
	
	public ApiCrudRole(EntCrudRoleId id) {
		super(id);
	}
	
}
