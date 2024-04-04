package net.ideahut.springboot.template.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;
import net.ideahut.springboot.annotation.Audit;
import net.ideahut.springboot.entity.EntityAudit;

@Audit
@Entity
@Table(name = "sysparam")
@Setter
@Getter
@SuppressWarnings("serial")
public class SysParam extends EntityAudit {
	
	@EmbeddedId
	@AttributeOverride(name = "sysCode", column = @Column(name = "sys_code", nullable = false))
	@AttributeOverride(name = "paramCode", column = @Column(name = "param_code", nullable = false)) 
	private SysParamId id;
	
	@Column(name = "description")
	private String description;
	
	@Type(type = "org.hibernate.type.TextType")
	@Column(name = "value")
	private String value;
	
	@Lob
	@Column(name = "bytes")
	private byte[] bytes;
	
	public SysParam() {}
	
	public SysParam(SysParamId id) {
		this.id = id;
	}
	
}
