package model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to Country
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="countryCode")
	private Country country;

	//bi-directional many-to-one association to County
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="countyId")
	private County county;

	//bi-directional many-to-one association to City
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="cityId")
	private City city;

	//bi-directional many-to-one association to Location
	@OneToMany(mappedBy="address")
	private List<Location> locations;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="address")
	private List<User> users;

	public Address() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public County getCounty() {
		return this.county;
	}

	public void setCounty(County county) {
		this.county = county;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Location> getLocations() {
		return this.locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public Location addLocation(Location location) {
		getLocations().add(location);
		location.setAddress(this);

		return location;
	}

	public Location removeLocation(Location location) {
		getLocations().remove(location);
		location.setAddress(null);

		return location;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setAddress(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setAddress(null);

		return user;
	}

}