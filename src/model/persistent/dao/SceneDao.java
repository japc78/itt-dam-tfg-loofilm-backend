package model.persistent.dao;

import java.util.List;

import model.entities.Scene;

public interface SceneDao {
	/**
	 * Metodo que devuelve el listado de Escenas
	 * @return Retora un listado de escenas con los siguiente informacion id, imagen, nombre, Escena, tipo y localizacion.
	 */
	List<Object[]> list();

	/**
	 * Metodo para dar de alta una Escena
	 * @param scene Se le pasa por argumento un objeto de la clase Scene
	 * @return Devuelve el id de la Escena añadida.
	 */
	Scene create(Scene scene);

	/**
	 * Metodo para modificar una Escena
	 * @param scene Se le pasa por argumento un objeto de la clase Scenen
	 * @return Devuelve la Escena modificada.
	 */
	Scene update(Scene scene);

	/**
	 * Metodo para borrar una Escena
	 * @param scene Se le pasa por argumento un objeto de la clase Scene
	 * @return Devuelve el id de la Escena eliminada.
	 */
	String delete(Scene scene);

	/**
	 * Metetodos que comprueba si existe una Escena
	 * @param scene Se le pasa por argumento el id objeto.
	 * @return Devuelve el objeto encontrado
	 */
	Scene find(int id);


	/**
	 * Metetodo que comprueba si existe un Escena.
	 * @param scene Se le pasa por argumento el Escena.
	 * @return Devuelve el Escena.
	 */
	Scene exists (Scene scene);
}