package model.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import model.entities.User;
import model.persistence.daoImpl.UserDaoImpl;

/**
 * Gestor de Login [ara administradores.
 */

public class LoginUser  {
	private UserDaoImpl userDao = new UserDaoImpl();

	/**
	 * Metodo que se encarga de validar el usuario en el Login de la App
	 * @param user Es un objeto de tipo user,
	 * @param pass Es un tipo String que se recoge del formulario y se compara con el pass del usuario
	 * @return
	 * @throws NoSuchAlgorithmException
	 */

	public String loginAdmin(User user, String pass) throws NoSuchAlgorithmException {
		System.out.println("LUA Email: " + user.getEmail());
		System.out.println("LUA Pass: " + pass);
		System.out.println("LUA HashPass: " + hashPass(pass));
		System.out.println("LUA UserPass: " + userDao.loginAdmin(user).getPass());

		if (userDao.loginAdmin(user) != null) {
			if (hashPass(pass).equals(userDao.loginAdmin(user).getPass())) {
				return "ok-01";
			} else {
				return "er-02";
			}
		} else {
			return "er-01";
		}
	}

	/**
	 * Metodo que realiza un hash de sha256 a un string dado por parametros.
	 *
	 * @param pass Cadena de String.
	 * @return Retorna el hash del String dado por parametros.
	 * @throws NoSuchAlgorithmException
	 */
	private String hashPass(String pass) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		return new String(md.digest(pass.getBytes()));
	}
}