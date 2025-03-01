package net.ideahut.springboot.template.entity.app;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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
import net.ideahut.springboot.entity.EntityBase;

@Entity
@Table(name = "user_favorite")
@Setter
@Getter
@SuppressWarnings("serial")
public class UserFavorite extends EntityBase {

	@EmbeddedId
	@AttributeOverride(name = "userId", column = @Column(name = "user_id", nullable = false, length = 64))
	@AttributeOverride(name = "otherId", column = @Column(name = "other_id", nullable = false, length = 64)) 
	private UserFavoriteId id;
	
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
		name = "user_id", 
		nullable = false, 
		insertable = false, 
		updatable = false, 
		foreignKey = @ForeignKey(name = "fk_user_favorite__user")
	)
	private User user;
	
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
		name = "other_id", 
		nullable = false, 
		insertable = false, 
		updatable = false, 
		foreignKey = @ForeignKey(name = "fk_user_favorite__other")
	)
	private User other;
	
	@Column(name = "created_on", nullable = false)
	private Long createdOn;
	
	public UserFavorite() {}
	
	public UserFavorite(UserFavoriteId id) {
		this.id = id;
	}
	
}
