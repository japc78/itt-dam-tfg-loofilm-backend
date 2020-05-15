package model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the visited database table.
 * 
 */
@Entity
@NamedQuery(name="Visited.findAll", query="SELECT v FROM Visited v")
public class Visited implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VisitedPK id;

	private Timestamp createDate;

	//bi-directional many-to-one association to Location
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="locationId")
	private Location location;

	//bi-directional many-to-one association to User
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="userId")
	private User user;

	public Visited() {
	}

	public VisitedPK getId() {
		return this.id;
	}

	public void setId(VisitedPK id) {
		this.id = id;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}