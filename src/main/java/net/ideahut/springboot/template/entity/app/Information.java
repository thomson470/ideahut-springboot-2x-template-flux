package net.ideahut.springboot.template.entity.app;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import net.ideahut.springboot.annotation.Audit;
import net.ideahut.springboot.annotation.IdPrefix;
import net.ideahut.springboot.entity.EntityAudit;
import net.ideahut.springboot.generator.OdtIdGenerator;

@Audit
@Entity
@Table(name = "information")
@IdPrefix("INF")
@Setter
@Getter
@SuppressWarnings("serial")
public class Information extends EntityAudit {

	@Id
	@GeneratedValue(generator = OdtIdGenerator.NAME)
	@GenericGenerator(name = OdtIdGenerator.NAME, strategy = OdtIdGenerator.STRATEGY)
	@Column(name = "information_id", unique = true, nullable = false, length = 64)
	private String informationId;
	
	@Column(name = "title", nullable = false, length = 100)
	private String title;
	
	@Column(name = "image", nullable = false, length = 512)
	private String image;
	
	@Column(name = "description")
	private String description;
	
	@Lob
	//@Type(type = DataType.Name.Binary)
	//@Type(type = DataType.Name.Text)
	@Column(name = "content")
	private String content;
	
	@Column(name = "url", length = 2048)
	private String url;
	
	@Column(name = "is_external", nullable = false, length = 1)
	private Character isExternal;
	
	@Column(name = "is_active", nullable = false, length = 1)
	private Character isActive;
	
	@Column(name = "seqno", nullable = false)
	private Long seqno;
	
	@Transient
	private List<InformationLink> links;
	
	@Transient
	@JsonIgnore
	private byte[] imageBytes;
	
	public Information() {}
	
	public Information(String informationId) {
		this.informationId = informationId;
	}
	
}
