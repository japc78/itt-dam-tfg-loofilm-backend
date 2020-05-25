package model.services;

import model.entities.Country;
import model.entities.County;
import model.persistent.daoImpl.CountyDaoImpl;

public class CountyService {
	CountyDaoImpl cd = new CountyDaoImpl();

	public County add (County county, Country country) {
		if (exists(county)) {
			return county;
		} else {
			county.setCountry(country);
			System.out.println("CountyService: " + county);
			return cd.create(county);
		}
	}

	public boolean exists(County county) {
		if(cd.exists(county) != null) {
			return true;
		} else {
			return false;
		}
	}
}