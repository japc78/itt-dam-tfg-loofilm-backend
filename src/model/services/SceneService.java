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
	public List<Scene> list() {
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
	 * Metodo que busca una escena por su id.
	 * @param id Del tipo entero positivo.
	 * @return Devuelve un objeto del tipo Scene.
	 */
	public Scene find(int id) {
		return sDao.find(id);
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

	/**
	 * Metodo que elimina una escena. Se le pasa como argumento la escena a borrar.
	 * @param p Objeto del tipo Scene.
	 * @return
	 */
	public String remove(int id) {
		// Se comprueba si la localizacion existe.
		if (find(id) != null) {
			sDao.delete(find(id));
			return "OK-S01";
		} else {
			return "ER-S01";
		}
	}
}