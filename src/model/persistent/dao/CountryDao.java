package model.persistent.dao;

import java.util.List;

import model.entities.Country;

public interface CountryDao {
	/**
	 * Metodo que devuelve el listado de direcciones
	 * @return
	 */
	List<Country> list();

	/**
	 * Metodo para dar de alta un Pais
	 * @param country Se le pasa por argumento un objeto de la clase Country
	 * @return Devuelve el id del Pais añadido.
	 */
	Country create(Country country);

	/**
	 * Metetodo que comprueba si existe un Pais.
	 * @param country Se le pasa por argumento el Pais.
	 * @return Devuelve el Pais.
	 */
	Country exists (Country country);
}