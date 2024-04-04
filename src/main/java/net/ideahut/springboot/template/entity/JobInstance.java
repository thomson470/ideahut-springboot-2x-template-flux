package net.ideahut.springboot.template.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import net.ideahut.springboot.annotation.Audit;
import net.ideahut.springboot.entity.EntityAudit;

@Audit
@Entity
@Table(name = "job_instance")
@Setter
@Getter
@SuppressWarnings("serial")
public class JobInstance extends EntityAudit {

	@Id
	@Column(name = "instance_id", unique = true, nullable = false, length = 100)
	private String instanceId;
	
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	
	@Column(name = "base_url", nullable = false)
	private String baseUrl;
	
	@Column(name = "auth_header")
	private String authHeader;
	
	@Column(name = "description")
	private String description;
	
	public JobInstance() {}
	
	public JobInstance(String instanceId) {
		this.instanceId = instanceId;
	}
	
}
