package net.ideahut.springboot.template.entity.app;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Getter;
import lombok.Setter;
import net.ideahut.springboot.annotation.Audit;
import net.ideahut.springboot.entity.EntityAuditSoftDelete;

@Audit
@Entity
@Table(name = "menu")
@Setter
@Getter
@SuppressWarnings("serial")
public class Menu extends EntityAuditSoftDelete {

	@EmbeddedId
	@AttributeOverride(name = "menuCode", column = @Column(name = "menu_code", nullable = false, length = 64))
	@AttributeOverride(name = "menuType", column = @Column(name = "menu_type", nullable = false, length = 16)) 
	private MenuId id;
	
	@Column(name = "title", nullable = false, length = 100)
	private String title;
	
	@Column(name = "link", length = 100)
	private String link;
	
	@Column(name = "icon", length = 512)
	private String icon;
	
	@Lob
	//@Type(type = "org.hibernate.type.BinaryType")
	@Column(name = "description")
	private String description;
	
	@Column(name = "is_active", nullable = false, length = 1)
	private Character isActive;
	
	@Column(name = "seqno", nullable = false)
	private Long seqno;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JoinColumns(
		value = { 
			@JoinColumn(name = "parent_code", referencedColumnName = "menu_code", nullable = true, insertable = true, updatable = true),
			@JoinColumn(name = "parent_type", referencedColumnName = "menu_type", nullable = true, insertable = true, updatable = true) 
		},
		foreignKey = @ForeignKey(name = "fk_menu__parent")
	)
	private Menu parent;
	
	@Transient
	private List<Menu> children;
	
	public Menu() {}
	
	public Menu(MenuId id) {
		this.id = id;
	}
	
}
