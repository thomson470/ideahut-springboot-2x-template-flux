package net.ideahut.springboot.template.entity.api;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import net.ideahut.springboot.annotation.ApiExclude;
import net.ideahut.springboot.annotation.Audit;
import net.ideahut.springboot.api.entity.EntCrud;

@ApiExclude
@Audit
@Entity
@Table(name = "api_crud")
@Setter
@Getter
@SuppressWarnings("serial")
public class ApiCrud extends EntCrud {

	public ApiCrud() {
		super();
	}

	public ApiCrud(String crudCode) {
		super(crudCode);
	}
	
}
