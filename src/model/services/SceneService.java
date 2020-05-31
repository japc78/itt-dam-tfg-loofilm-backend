package model.services;

import java.util.List;

import model.entities.Scene;
import model.persistent.daoImpl.SceneDaoImpl;

public class SceneService {
	SceneDaoImpl sDao = new SceneDaoImpl();

	/**
	 * Metodo que devuelve el listado de Escenas
	 * @return Retora un listado de escenas con los siguiente informacion id, imagen, nombre, Escena, tipo y localizacion.
	 */
	public List<Object[]> list() {
		return sDao.list();
	}

	/**
	 * Metodo que para el alta de de una escena
	 * @param s Del tipo Scene.
	 * @return Retorna ER-P01 si ya hay un elmento igual en la BD y OK-P01 si el producto se
	 *         ha dado de alta correctamente.
	 */
	public String add(Scene s) {
		if (!exists(s)) {
			sDao.create(s);
			return "OK-S00";
		} else if (exists(s)) {
			return "ER-S01";
		} else {
			return "ER-S00";
		}
	}


	public String toggleCheck(int id, boolean active) {
		if(sDao.find(id) != null) {
			Scene s = new Scene();
			s = sDao.find(id);
			s.setActive(active);
			sDao.update(s);
			return "OK-TC01";
		} else {
			return "ER-TC01";
		}
	}

	/**
	 * Metodo que comprueba si la scena pasada por parametro existe.
	 * @param s Del tipo Scene.
	 * @return Devuelve true si existe y false si no existe.
	 */
	private boolean exists(Scene s) {
		if (sDao.exists(s) != null) {
			return true;
		} else {
			return false;
		}
	}
}