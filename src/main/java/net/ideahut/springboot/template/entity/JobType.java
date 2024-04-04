package net.ideahut.springboot.template.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;
import net.ideahut.springboot.annotation.Audit;
import net.ideahut.springboot.entity.EntityAudit;
import net.ideahut.springboot.generator.HbmStringGenerator;

@Audit
@Entity
@Table(
	name = "job_type", 
	uniqueConstraints = @UniqueConstraint(
		columnNames = {"classname"}, 
		name = "uq_job_type__classname"
	)
)
@Setter
@Getter
@SuppressWarnings("serial")
public class JobType extends EntityAudit {

	@Id
	@GeneratedValue(generator = HbmStringGenerator.NAME)
	@GenericGenerator(name = HbmStringGenerator.NAME, strategy = HbmStringGenerator.STRATEGY)
	@Column(name = "type_id", unique = true, nullable = false, length = 64)
	private String typeId;
	
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	
	@Column(name = "classname", nullable = false)
	private String classname;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "is_single_run")
	private Character isSingleRun;
	
	@Column(name = "is_running")
	private Character isRunning;
	
	@Column(name = "is_save_result", nullable = false, length = 1)
	private Character isSaveResult;
	
	@Column(name = "last_run_time")
	private Long lastRunTime;
	
	@Type(type = "org.hibernate.type.TextType")
	@Column(name = "last_run_data")
	private String lastRunData;
	
	@Column(name = "last_run_trigger_id")
	private String lastRunTriggerId;
	
	@Transient
	private List<JobTypeParameter> parameters;
	
	@Transient
	private List<JobTrigger> triggers;
	
	public JobType() {}
	
	public JobType(String typeId) {
		this.typeId = typeId;
	}
	
}
