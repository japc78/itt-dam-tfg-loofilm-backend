package model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the countries database table.
 * 
 */
@Entity
@Table(name="countries")
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String countryCode;

	private String country;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="country")
	private List<Address> addresses;

	//bi-directional many-to-one association to County
	@OneToMany(mappedBy="country")
	private List<County> counties;

	public Country() {
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setCountry(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setCountry(null);

		return address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		return true;
	}

	public List<County> getCounties() {
		return this.counties;
	}

	public void setCounties(List<County> counties) {
		this.counties = counties;
	}

	public County addCounty(County county) {
		getCounties().add(county);
		county.setCountry(this);

		return county;
	}

	public County removeCounty(County county) {
		getCounties().remove(county);
		county.setCountry(null);

		return county;
	}

}