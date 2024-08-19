package net.ideahut.springboot.template.entity.api;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Getter;
import lombok.Setter;
import net.ideahut.springboot.annotation.ApiExclude;
import net.ideahut.springboot.annotation.Audit;
import net.ideahut.springboot.api.entity.EntCrudAction;
import net.ideahut.springboot.api.entity.EntCrudActionId;

@ApiExclude
@Audit
@Entity
@Table(name = "api_crud_action")
@Setter
@Getter
@SuppressWarnings("serial")
public class ApiCrudAction extends EntCrudAction {
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(
		value = {
			@JoinColumn(name = "role_code", referencedColumnName = "role_code", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "crud_code", referencedColumnName = "crud_code", nullable = false, insertable = false, updatable = false)
		},
		foreignKey = @ForeignKey(
			name = "fk_api_crud_action__permission"
			//foreignKeyDefinition = "FOREIGN KEY (role_code, crud_code) REFERENCES api_crud_role ON UPDATE CASCADE"
		)
	)
	private ApiCrudRole permission;

	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
		name = "role_code", 
		nullable = false, 
		insertable = false, 
		updatable = false, 
		foreignKey = @ForeignKey(
			name = "fk_api_crud_action__role"
			//foreignKeyDefinition = "FOREIGN KEY (role_code) REFERENCES api_role ON UPDATE CASCADE"
		)
	)
	private ApiRole role;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
		name = "crud_code", 
		nullable = false, 
		insertable = false, 
		updatable = false, 
		foreignKey = @ForeignKey(name = "fk_api_crud_action__crud")
	)
	private ApiCrud crud;
	
	public ApiCrudAction() {
		super();
	}

	public ApiCrudAction(EntCrudActionId id) {
		super(id);
	}
	
}
