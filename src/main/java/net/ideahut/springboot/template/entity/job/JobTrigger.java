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
import net.ideahut.springboot.job.entity.EntTrigger;

@ApiExclude
@Audit
@Entity
@Table(name = "job_trigger")
@Setter
@Getter
@SuppressWarnings("serial")
public class JobTrigger extends EntTrigger {
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
		name = "group_id", 
		nullable = false, 
		insertable = false,
		updatable = false,
		foreignKey = @ForeignKey(name = "fk_job_trigger__group")
	)
	private JobGroup jobGroup;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
		name = "type_id", 
		nullable = false, 
		insertable = false,
		updatable = false,
		foreignKey = @ForeignKey(name = "fk_job_trigger__type")
	)
	private JobType jobType;
	
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
		name = "instance_id",
		insertable = false,
		updatable = false,
		foreignKey = @ForeignKey(name = "fk_job_trigger__instance")
	)
	private JobInstance jobInstance;
	

	public JobTrigger() {
		super();
	}

	public JobTrigger(String triggerId) {
		super(triggerId);
	}
	
}
