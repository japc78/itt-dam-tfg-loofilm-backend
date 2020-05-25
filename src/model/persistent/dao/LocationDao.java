package model.persistent.dao;

import java.util.List;

import model.entities.Location;

public interface LocationDao {
	/**
	 * Metodo que devuelve el listado de Localizacions
	 * @return
	 */
	List<Location> list();

	/**
	 * Metodo para dar de alta una Localizacion
	 * @param location Se le pasa por argumento un objeto de la clase Location
	 * @return Devuelve el id de la Localizacion añadida.
	 */
	Integer create(Location location);

	/**
	 * Metodo para modificar una Localizacion
	 * @param location Se le pasa por argumento un objeto de la clase Locationn
	 * @return Devuelve el id de la Localizacion modificada.
	 */
	Integer update(Location location);

	/**
	 * Metodo para borrar una Localizacion
	 * @param location Se le pasa por argumento un objeto de la clase Location
	 * @return Devuelve el id de la Localizacion eliminada.
	 */
	Integer delete(Location location);


	/**
	 * Metetodo que comprueba si existe un Localizacion.
	 * @param location Se le pasa por argumento el Localizacion.
	 * @return Devuelve el Localizacion.
	 */
	Location exists (Location location);
}