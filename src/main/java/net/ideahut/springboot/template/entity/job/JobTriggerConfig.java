package net.ideahut.springboot.template.entity.job;

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
import net.ideahut.springboot.job.entity.EntTriggerConfig;
import net.ideahut.springboot.job.entity.EntTriggerConfigId;

@ApiExclude
@Audit
@Entity
@Table(name = "job_trigger_config")
@Setter
@Getter
@SuppressWarnings("serial")
public class JobTriggerConfig extends EntTriggerConfig {
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
		name = "trigger_id", 
		nullable = false, 
		insertable = false, 
		updatable = false, 
		foreignKey = @ForeignKey(name = "fk_job_trigger_config__trigger")
	)
	private JobTrigger jobTrigger;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(
		value = {
			@JoinColumn(name = "type_id", referencedColumnName = "type_id", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "name", referencedColumnName = "name", nullable = false, insertable = false, updatable = false)
		},
		foreignKey = @ForeignKey(name = "fk_job_trigger_config__type_parameter")
	)
	private JobTypeParam jobTypeParam;
	

	public JobTriggerConfig() {
		super();
	}

	public JobTriggerConfig(EntTriggerConfigId id, String value) {
		super(id, value);
	}

	public JobTriggerConfig(EntTriggerConfigId id) {
		super(id);
	}
	
}
