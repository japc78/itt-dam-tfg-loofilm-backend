package model.persistent.dao;

import java.util.List;
import model.entities.City;

public interface CityDao {
	/**
	 * Metodo que devuelve el listado de direcciones
	 * @return
	 */
	List<City> list();

	/**
	 * Metodo para dar de alta una Ciudad
	 * @param city Se le pasa por argumento un objeto de la clase City
	 * @return Devuelve el id de la Ciudad añadida.
	 */
	City create(City city);

	/**
	 * Metetodo que comprueba si existe un Ciudad.
	 * @param city Se le pasa por argumento la Ciudad.
	 * @return Devuelve la Ciudad.
	 */
	City exists (City city);
}