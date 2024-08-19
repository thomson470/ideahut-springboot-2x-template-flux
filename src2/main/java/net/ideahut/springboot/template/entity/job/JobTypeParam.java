package net.ideahut.springboot.template.entity.job;

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
import net.ideahut.springboot.job.entity.EntTypeParam;
import net.ideahut.springboot.job.entity.EntTypeParamId;

@ApiExclude
@Audit
@Entity
@Table(name = "job_type_param")
@Setter
@Getter
@SuppressWarnings("serial")
public class JobTypeParam extends EntTypeParam {

	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
		name = "type_id", 
		nullable = false, 
		insertable = false, 
		updatable = false, 
		foreignKey = @ForeignKey(name = "fk_job_type_parameter__type")
	)
	private JobType type;
	
	public JobTypeParam() {
		super();
	}

	public JobTypeParam(EntTypeParamId id) {
		super(id);
	}
	
}
