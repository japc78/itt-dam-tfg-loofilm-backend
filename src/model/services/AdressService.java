package model.services;

import model.entities.Adress;
import model.entities.Country;
import model.persistent.daoImpl.AdressDaoImpl;
import model.persistent.daoImpl.CityDaoImpl;
import model.persistent.daoImpl.CountryDaoImpl;
import model.persistent.daoImpl.CountyDaoImpl;

public class AdressService {
	AdressDaoImpl adressDao = new AdressDaoImpl();
	CountyDaoImpl countyDao = new CountyDaoImpl();
	CityDaoImpl cityDao = new CityDaoImpl();
	CountryDaoImpl countryDao = new CountryDaoImpl();

	public Adress add (Adress a) {
		if (adressDao.exists(a) != null) {
			System.out.println(a);
			return a;

		} else if (cityDao.exists(a.getCity()) != null) {
			System.out.println(a);
			return adressDao.create(a);

		} else if (countyDao.exists(a.getCounty()) != null) {
			a.setCity(cityDao.create(a.getCity(), a.getCounty()));
			return adressDao.create(a);

		} else if (countyDao.exists(a.getCounty()) != null) {
			a.setCounty(countyDao.create(a.getCounty(), a.getCountry()));
			a.setCity(cityDao.create(a.getCity(), a.getCounty()));
			return adressDao.create(a);

		} else {
			a.setCountry(countryDao.create(a.getCountry()));
			System.out.println("AdressService 4: " + a.getCountry());
			a.setCounty(countyDao.create(a.getCounty(), a.getCountry()));
			System.out.println("AdressService 4: " + a.getCounty());
			a.setCity(cityDao.create(a.getCity(), a.getCounty()));
			System.out.println("AdressService 4: " + a.getCity());
			return adressDao.create(a);
		}
	}
}