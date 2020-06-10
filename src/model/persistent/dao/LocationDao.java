package model.persistent.dao;

import java.util.List;

import model.entities.City;
import model.entities.Country;
import model.entities.County;
import model.entities.Location;

public interface LocationDao {
	/**
	 * Metodo que devuelve el listado de Localizacions
	 * @return
	 */
	List<Object[]> list();

	/**
	 * Metodo que devuelve un listado de Localizaciones activas por Provincia y Pais para el Select del Crear Escena.
	 * @return Array de objetos id, nombre, provincia, pais
	 */
	List<Object[]> listSelect2();

	/**
	 * Metodo para dar de alta y modificar una Localizacion
	 * @param location Se le pasa por argumento un objeto de la clase Location
	 * @param city Se le pasa por argumento un objeto de la clase City
	 * @param county Se le pasa por argumento un objeto de la clase County
	 * @param country Se le pasa por argumento un objeto de la clase Country
	 * @return
	 */
	Location setLocation(Location location, City city, County county, Country country);

	/**
	 * Metodo para dar de modificar datos de una localizacion
	 * @param location Se le pasa por argumento un objeto de la clase Location
	 * @return
	 */
	Location setLocation(Location location);

	/**
	 * Metetodos que comprueba si existe una Localizacion
	 * @param id Se le pasa por argumento el id.
	 * @return Devuelve el objeto encontrado
	 */
	public Location find(int id);

	/**
	 * Metodo para borrar una Localizacion
	 * @param location Se le pasa por argumento un objeto de la clase Location
	 * @return Devuelve el id de la Localizacion eliminada.
	 */
	Location delete(Location location);


	/**
	 * Metetodo que comprueba si existe un Localizacion.
	 * @param location Se le pasa por argumento el Localizacion.
	 * @return Devuelve el Localizacion.
	 */
	Location exists (Location location);

}