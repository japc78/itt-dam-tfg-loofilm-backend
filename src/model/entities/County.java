package model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the counties database table.
 * 
 */
@Entity
@Table(name="counties")
@NamedQuery(name="County.findAll", query="SELECT c FROM County c")
public class County implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String county;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="county")
	private List<Address> addresses;

	//bi-directional many-to-one association to City
	@OneToMany(mappedBy="county")
	private List<City> cities;

	//bi-directional many-to-one association to Country
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="countryCode")
	private Country country;

	public County() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCounty() {
		return this.county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setCounty(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setCounty(null);

		return address;
	}

	public List<City> getCities() {
		return this.cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public City addCity(City city) {
		getCities().add(city);
		city.setCounty(this);

		return city;
	}

	public City removeCity(City city) {
		getCities().remove(city);
		city.setCounty(null);

		return city;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}