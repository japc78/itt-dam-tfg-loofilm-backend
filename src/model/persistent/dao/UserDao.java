package model.persistent.dao;

import java.util.List;

import model.entities.User;

/**
 * UserDaoInterface
 */

public interface UserDao {
	/**
	 * Metodo que devuelve el listado de Usuarios
	 * @return
	 */
	List<User> list();

	/**
	 * Metodo para dar de alta un Usuario
	 * @param user Se le pasa por argumento un objeto de la clase Usuario
	 * @return Devuelve el id del Usuario añadido.
	 */
	String create(User user);

	/**
	 * Metodo para dar de alta un Usuario
	 * @param user Se le pasa por argumento un objeto de la clase Usuario
	 * @return Devuelve el id del Usuario añadido.
	 */
	String update(User user);

	/**
	 * Metodo para borrar un Usuario
	 * @param user Se le pasa por argumento un objeto de la clase Usuario
	 * @return Devuelve el id del Usuario borrado.
	 */
	String delete(User user);

	/**
	 * Metetodo que valida el login de los administradores.
	 * @param user Se le pasa por argumento el Usuario.
	 * @return Devuelve el Usuario.
	 */
	User loginAdmin (User user);


	/**
	 * Metetodo que valida el login de los usuarios.
	 * @param user Se le pasa por argumento el Usuario.
	 * @return Devuelve el Usuario.
	 */
	User login (User user);


	/**
	 * Metetodo que comprueba si existe un Usuario.
	 * @param user Se le pasa por argumento el Usuario.
	 * @return Devuelve el Usuario.
	 */
	User exists (User user);
}