package model.services;

import model.entities.Country;
import model.persistent.daoImpl.CountryDaoImpl;

public class CountryService {
	CountryDaoImpl cd = new CountryDaoImpl();

	public Country add (Country country) {
		if (cd.exists(country) != null) {
			return country;
		} else {
			return cd.create(country);
		}
	}

	public boolean exists(Country country) {
		if(cd.exists(country) != null) {
			return true;
		} else {
			return false;
		}
	}
}