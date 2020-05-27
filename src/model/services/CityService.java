package model.services;

import model.entities.City;
import model.entities.County;
import model.persistent.daoImpl.CityDaoImpl;

public class CityService {
	CityDaoImpl cd = new CityDaoImpl();

	public City add (City city, County county) {
		city.setCounty(county);
		if (cd.exists(city) != null) {
			return city;
		} else {
			System.out.println("CityService: " + city);
			return cd.create(city);
		}
	}

	public boolean exists(City city) {
		if(cd.exists(city) != null) {
			return true;
		} else {
			return false;
		}
	}
}