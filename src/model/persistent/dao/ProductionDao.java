package model.persistent.dao;

import java.util.List;

import model.entities.Production;

public interface ProductionDao {
	/**
	 * Metodo que devuelve el listado de Producciones
	 * @return
	 */
	List<Production> list();

	/**
	 * Metodo para dar de alta una Produccion
	 * @param production Se le pasa por argumento un objeto de la clase Production
	 * @return Devuelve el id de la Produccion añadida.
	 */
	String create(Production production);

	/**
	 * Metodo para modificar una Produccion
	 * @param production Se le pasa por argumento un objeto de la clase Productionn
	 * @return Devuelve el id de la Produccion modificada.
	 */
	String update(Production production);

	/**
	 * Metodo para borrar una Produccion
	 * @param production Se le pasa por argumento un objeto de la clase Production
	 * @return Devuelve el id de la Produccion eliminada.
	 */
	String delete(Production production);


	/**
	 * Metetodo que comprueba si existe un Produccion.
	 * @param production Se le pasa por argumento el Produccion.
	 * @return Devuelve el Produccion.
	 */
	Production exists (Production production);
}