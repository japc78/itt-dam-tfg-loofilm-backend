package model.persistent.dao;

import java.util.List;

import model.entities.Scene;

public interface SceneDao {
	/**
	 * Metodo que devuelve el listado de Escenas
	 * @return Retora un listado de escenas con los siguiente informacion id, imagen, nombre, Escena, tipo y localizacion.
	 */
	List<Scene> list();

	/**
	 * Metodo para dar de alta y actualizar una Escena
	 * @param scene Se le pasa por argumento un objeto de la clase Scene
	 * @return Devuelve el id de la Escena añadida.
	 */
	Scene setScene(Scene scene);

	/**
	 * Metodo para borrar una Escena
	 * @param scene Se le pasa por argumento un objeto de la clase Scene
	 * @return Devuelve el objeto del tipo Scene eliminado.
	 */
	Scene delete(Scene scene);

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