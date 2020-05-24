package model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the users database table.
 *
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = -2540658346732983080L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private int id;

	private boolean active;

	@Temporal(TemporalType.DATE)
	private Date birthdate;

	private Timestamp createDate;

	private String email;

	private String lastname;

	private String name;

	private String pass;

	private int postalcode;

	private String street;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="addressId")
	private Address address;

	//bi-directional one-to-one association to UsersAdmin
	@OneToOne(mappedBy="user")
	private UsersAdmin usersAdmin;

	//bi-directional many-to-one association to Visited
	@OneToMany(mappedBy="user")
	private List<Visited> visiteds;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getPostalcode() {
		return this.postalcode;
	}

	public void setPostalcode(int postalcode) {
		this.postalcode = postalcode;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public UsersAdmin getUsersAdmin() {
		return this.usersAdmin;
	}

	public void setUsersAdmin(UsersAdmin usersAdmin) {
		this.usersAdmin = usersAdmin;
	}

	public List<Visited> getVisiteds() {
		return this.visiteds;
	}

	public void setVisiteds(List<Visited> visiteds) {
		this.visiteds = visiteds;
	}

	public Visited addVisited(Visited visited) {
		getVisiteds().add(visited);
		visited.setUser(this);

		return visited;
	}

	public Visited removeVisited(Visited visited) {
		getVisiteds().remove(visited);
		visited.setUser(null);

		return visited;
	}

}