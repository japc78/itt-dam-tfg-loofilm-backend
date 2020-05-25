package model.persistent.dao;

import java.util.List;


/**
 * UserDaoInterface
 */

public interface UserAdminDao {
	/**
	 * Metodo que devuelve el listado de Usuarios
	 * @return
	 */
	List<UserAdminDao> list();

	/**
	 * Metodo para dar de alta un Usuario
	 * @param user Se le pasa por argumento un objeto de la clase Usuario
	 * @return Devuelve el id del Usuario añadido.
	 */
	String create(UserAdminDao user);

	/**
	 * Metodo para dar de alta un Usuario
	 * @param user Se le pasa por argumento un objeto de la clase Usuario
	 * @return Devuelve el id del Usuario añadido.
	 */
	String update(UserAdminDao user);

	/**
	 * Metodo para borrar un Usuario
	 * @param user Se le pasa por argumento un objeto de la clase Usuario
	 * @return Devuelve el id del Usuario borrado.
	 */
	String delete(UserAdminDao user);

	/**
	 * Metetodo que comprueba si existe un Usuario.
	 * @param user Se le pasa por argumento el Usuario.
	 * @return Devuelve el Usuario.
	 */
	UserAdminDao exists (UserAdminDao user);

}