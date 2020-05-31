package model.services;

import java.util.List;

import model.entities.City;
import model.entities.Country;
import model.entities.County;
import model.entities.Location;
import model.persistent.daoImpl.CityDaoImpl;
import model.persistent.daoImpl.CountryDaoImpl;
import model.persistent.daoImpl.CountyDaoImpl;
import model.persistent.daoImpl.LocationDaoImpl;

public class LocationService {
	private LocationDaoImpl loDao = new LocationDaoImpl();
	private CityDaoImpl cityDao = new CityDaoImpl();
	private CountryDaoImpl countryDao = new CountryDaoImpl();
	private CountyDaoImpl countyDao = new CountyDaoImpl();


	/**
	 * Listado de localizaciones
	 * @return Una coleccion de Arrays.
	 * Id, imagen, nombre, provincia, pais, numero de producciones, estado
	 */
	public List<Object[]> list() {
		return loDao.list();
	}

	/**
	 * Listado de localizaciones para el Select de Crear Scena
	 * @return Una coleccion de Arrays.
	 * Id, nombre, provincia, pais
	 */
	public List<Object[]> listSelect2() {
		return loDao.listSelect2();
	}

	/**
	 * Metodo que para el alta de de una localizacion
	 * @param p Del tipo Location.
	 * @param city Del tipo City. La ciudad a la que pertecene la localizacion.
	 * @param county Del tipo County. La provincia o estado al que pertence la ciudad de la Localizacion.
	 * @param country Del tipo Country. El pais al que pertenece la provincia a la que pertenece la Localiacion.
	 * @return Retorna ER-P01 si ya hay un elmento igual en la BD y OK-P01 si el producto se
	 *         ha dado de alta correctamente.
	 */
	public String add(Location l, City city, County county, Country country) {
		// Se añade a la provincia el pais.

		// Se comprueba si la localizacion existe.
		if (!exists(l)) {
			if (countryDao.exists(country) != null) country = countryDao.exists(country);
			county.setCountry(country);
			if (countyDao.exists(county) != null) county = countyDao.exists(county);
			city.setCounty(county);
			if (cityDao.exists(city) != null) {
				city = cityDao.exists(city);
				l.setCity(city);
			};
			loDao.create(l,city,county, country);
			return "OK-L00";
		} else {
			// Tanto la Address como la Localizacion existen.
			return "ER-L01";
		}
	}

	/**
	 * Metodo que busca una localizacion por su id.
	 * @param id Del tipo entero positivo.
	 * @return Devuelve un objeto del tipo Location.
	 */
	public Location find(int id) {
		return loDao.find(id);
	}

	/**
	 * Metodo que comprueba si la Localizacion pasada por parametro existe.
	 * @param l Del tipo Location.
	 * @return Devuelve true si existe y false si no existe.
	 */
	private boolean exists(Location l) {
		if (loDao.exists(l) != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo que elimina los () de la cadena de String de Coordeandas
	 *
	 * @param gps String de las coordeanas
	 * @return String con la coordenadas sin () para especificar las coordenadas.
	 */
	public String gpsFormat(final String gps) {
		return gps.replaceAll("[()]", "");
	}
}