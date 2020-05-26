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
			System.out.println("CountyService - Country: " + county.toString());
			county.setCountry(country);
			System.out.println("CountyServiceAqui: " + county.toString()); 
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