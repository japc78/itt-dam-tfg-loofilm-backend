package model.services;

import java.util.List;

import model.entities.Production;
import model.persistent.daoImpl.ProducctionDaoImpl;

public class ProductionService {
	ProducctionDaoImpl pDao = new ProducctionDaoImpl();

	/**
	 * Metodo que devuelve el listado de Producciones
	 * @return Retora un listado de producciones con los siguiente informacion id, imagen, nombre, año, tipo y el numero de escenas de la produccion.
	 */
	public List<Object[]> list() {
		return pDao.list();
	}

	/**
	 * Metodo que para el alta de de una produccion
	 * @param p Del tipo Production.
	 * @return Retorna ER-P01 si ya hay un elmento igual en la BD y OK-P01 si el producto se
	 *         ha dado de alta correctamente.
	 */
	public String add(Production p) {
		if (!exists(p)) {
			pDao.create(p);
			return "OK-P00";
		} else {
			return "ER-P01";
		}
	}

	/**
	 * Metodo que busca una producion por su id.
	 * @param id Del tipo entero positivo.
	 * @return Devuelve un objeto del tipo Production.
	 */
	public Production find(int id) {
		return pDao.find(id);
	}

	/**
	 * Metodo que comprueba si la Produccion pasada por parametro existe.
	 * @param p Del tipo Production.
	 * @return Devuelve true si existe y false si no existe.
	 */
	private boolean exists(Production p) {
		if (pDao.exists(p) != null) {
			return true;
		} else {
			return false;
		}
	}
}