package model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the users_admin database table.
 *
 */
@Entity
@Table(name="users_admin")
@NamedQuery(name="UsersAdmin.findAll", query="SELECT u FROM UsersAdmin u")
public class UsersAdmin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;

	private boolean isSuper;

	//bi-directional one-to-one association to User
	@OneToOne(cascade={CascadeType.REMOVE})
	@JoinColumn(name="userId", referencedColumnName = "id", insertable = false, updatable = false)
	private User user;

	public UsersAdmin() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean getIsSuper() {
		return this.isSuper;
	}

	public void setIsSuper(boolean isSuper) {
		this.isSuper = isSuper; 
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}