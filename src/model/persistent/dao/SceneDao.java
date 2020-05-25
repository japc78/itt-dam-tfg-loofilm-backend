package model.persistent.dao;

import java.util.List;

import model.entities.Scene;

public interface SceneDao {
	/**
	 * Metodo que devuelve el listado de Escenas
	 * @return
	 */
	List<Scene> list();

	/**
	 * Metodo para dar de alta una Escena
	 * @param scene Se le pasa por argumento un objeto de la clase Scene
	 * @return Devuelve el id de la Escena añadida.
	 */
	String create(Scene scene);

	/**
	 * Metodo para modificar una Escena
	 * @param scene Se le pasa por argumento un objeto de la clase Scenen
	 * @return Devuelve el id de la Escena modificada.
	 */
	String update(Scene scene);

	/**
	 * Metodo para borrar una Escena
	 * @param scene Se le pasa por argumento un objeto de la clase Scene
	 * @return Devuelve el id de la Escena eliminada.
	 */
	String delete(Scene scene);


	/**
	 * Metetodo que comprueba si existe un Escena.
	 * @param scene Se le pasa por argumento el Escena.
	 * @return Devuelve el Escena.
	 */
	Scene exists (Scene scene);
}