package net.ideahut.springboot.template.entity.app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Getter;
import lombok.Setter;
import net.ideahut.springboot.annotation.Audit;
import net.ideahut.springboot.entity.EntityAudit;
import net.ideahut.springboot.generator.OdtIdGenerator;

@Audit
@Entity
@Table(name = "information_link")
@Setter
@Getter
@SuppressWarnings("serial")
public class InformationLink extends EntityAudit {

	@Id
	@GeneratedValue(generator = OdtIdGenerator.NAME)
	@GenericGenerator(name = OdtIdGenerator.NAME, strategy = OdtIdGenerator.STRATEGY)
	@Column(name = "link_id", unique = true, nullable = false, length = 64)
	private String linkId;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "information_id", nullable = false, foreignKey = @ForeignKey(name = "fk_information_link__information"))
	private Information information;
	
	@Column(name = "label", nullable = false, length = 100)
	private String label;
	
	@Column(name = "code", nullable = false, length = 16)
	private String code;
	
	@Lob
	//@Type(type = "org.hibernate.type.BinaryType")
	@Column(name = "target", nullable = false)
	private String target;
	
	@Column(name = "seqno", nullable = false)
	private Long seqno;
	
	public InformationLink() {}
	
	public InformationLink(String linkId) {
		this.linkId = linkId;
	}
	
}
