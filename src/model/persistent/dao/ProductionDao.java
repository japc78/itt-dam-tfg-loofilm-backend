package model.persistent.dao;

import java.util.List;

import model.entities.Production;

public interface ProductionDao {
	/**
	 * Metodo que devuelve el listado de Producciones
	 * @return Retora un listado de producciones con los siguiente informacion id, imagen, nombre, año, tipo y el numero de escenas de la produccion.
	 */
	List<Object[]> list();

	/**
	 * Metodo que devuelve un listado de Producciones series o films activas.
	 * @return Array de objetos id, nombre, año, tipo
	 */
	List<Object[]> listSelect2();

	/**
	 * Metodo para dar de alta una Produccion
	 * @param production Se le pasa por argumento un objeto de la clase Production
	 * @return Devuelve el la Produccion añadida.
	 */
	Production create(Production production);

	/**
	 * Metodo para modificar una Produccion
	 * @param production Se le pasa por argumento un objeto de la clase Productionn
	 * @return Devuelve la Produccion modificada.
	 */
	Production update(Production production);

	/**
	 * Metodo para borrar una Produccion
	 * @param production Se le pasa por argumento un objeto de la clase Production
	 * @return Devuelve el objeto del tipo Production eliminado.
	 */
	Production delete(Production production);


	/**
	 * Metetodos que comprueba si existe una Produccion
	 * @param id Se le pasa por argumento el id.
	 * @return Devuelve el objeto encontrado
	 */
	Production find(int id);

	/**
	 * Metetodo que comprueba si existe un Produccion.
	 * @param production Se le pasa por argumento el Produccion.
	 * @return Devuelve el Produccion.
	 */
	Production exists (Production production);
}