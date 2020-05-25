package model.persistent.dao;

import java.util.List;

import model.entities.County;

public interface CountyDao {
	/**
	 * Metodo que devuelve el listado de direcciones
	 * @return
	 */
	List<County> list();

	/**
	 * Metodo para dar de alta una Provincia o Estado de un Pais determinado
	 * @param county Se le pasa por argumento un objeto de la clase County, la Ciudad o estado.
 	 * @param county Se le pasa por argumento un objeto de la clase Country, el pais.
	 * @return Devuelve el id del Pais añadido.
	 */
	County create(County county);

	/**
	 * Metetodo que comprueba si existe una Provincia o Estado.
	 * @param county Se le pasa por argumento la Provincia o Estado.
	 * @return Devuelve el Provincia o Estado.
	 */
	County exists (County county);
}