package model.services;

import model.entities.Country;
import model.entities.County;
import model.persistent.daoImpl.CountyDaoImpl;

public class CountyService {
	CountyDaoImpl cd = new CountyDaoImpl();

	public County add (County county, Country country) {
		county.setCountry(country);
		if (exists(county)) {
			System.out.println("Existe CountyService - Country: " + county.toString());
			return county;
		} else {
			System.out.println("No existe CountyService: " + county.toString());
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