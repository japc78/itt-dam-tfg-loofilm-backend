package model.services;

import java.util.List;

import model.entities.City;
import model.entities.Country;
import model.entities.County;
import model.entities.Location;
import model.entities.LocationsMedia;
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
	 * @param l Del tipo Location.
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
			loDao.setLocation(l,city,county, country);
			return "OK-L00";
		} else {
			// Tanto la Address como la Localizacion existen.
			return "ER-L00";
		}
	}

	/**
	 * Metodo que actualiza una Localizcacion. Se le pasa como argumento el del tipo Location con los datos a actualziar.
	 * @param l Objeto del tipo Location.
	 * @return
	 */
	public String update(Location l, City city, County county, Country country) {
		// Se comprueba si la localizacion existe.
		if (exists(l)) {
			if (countryDao.exists(country) != null) country = countryDao.exists(country);
			county.setCountry(country);
			if (countyDao.exists(county) != null) county = countyDao.exists(county);
			city.setCounty(county);
			if (cityDao.exists(city) != null) {
				city = cityDao.exists(city);
				l.setCity(city);
			};
			loDao.setLocation(l,city,county, country);
			return "OK-L01";
		} else {
			// Tanto la Address como la Localizacion existen.
			return "ER-L01";
		}
	}

	/**
	 * Metodo que activa o desactiva una localizacion.
	 * @param id de tipo Integer, es el id del elemento a activar.
	 * @param active Del tipo boolean, el estado true o false.
	 * @return
	 */
	public String toggleCheck(int id, boolean active) {
		if(loDao.find(id) != null) {
			Location l = new Location();
			l = loDao.find(id);
			l.setActive(active);
			loDao.setLocation(l);
			return "OK-TC01";
		} else {
			return "ER-TC01";
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
	 * Metodo que elimina una lozalizacion. Se le pasa como argumento la localizacion a borrar.
	 * @param l Objeto del tipo Location.
	 * @return
	 */
	public String remove(int id) {
		// Se comprueba si la localizacion existe.
		if (find(id) != null) {
			loDao.delete(find(id));
			return "OK-L01";
		} else {
			return "ER-L01";
		}
	}
}