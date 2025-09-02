package net.ideahut.springboot.template.entity.app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Getter;
import lombok.Setter;
import net.ideahut.springboot.annotation.Audit;
import net.ideahut.springboot.entity.EntityAudit;

@Audit
@Entity
@Table(name = "user_detail")
@Setter
@Getter
@SuppressWarnings("serial")
public class UserDetail extends EntityAudit {

	@Id
	@Column(name = "user_id", unique = true, nullable = false, length = 64)
	private String userId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(
		name = "user_id",
		insertable = false, 
		updatable = false, 
		foreignKey = @ForeignKey(name = "fk_user_detail__user")
	)
	private User user;
	
	@Column(name = "fullname", nullable = false)
	private String fullname;
	
	@Column(name = "gender", length = 1)
	private Character gender; // Constants.Profile.Gender
	
	@Column(name = "description")
	private String description;
	
	public UserDetail() {}
	
	public UserDetail(String userId) {
		this.userId = userId;
	}

}
