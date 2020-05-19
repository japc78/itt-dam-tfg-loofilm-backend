package model.services;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import model.entities.User;
import model.persistence.daoImpl.UserDaoImpl;

public class LoginUser {
	private UserDaoImpl userDao = new UserDaoImpl();
	private char pass;

	public String login(User user, String pass) {
		System.out.println("Codigo: " + user.getId());
		if (userDao.exists(user) != null) {
			if (hashPass(pass).equals(user.getPass())) {
				return "ok-01";
			} else {
				return "er-01";
			}
		} else {
			return "er-02";
		}
	}

	/**
	 * Metodo que comprueba si el usuario existe en la base de datos
	 * @param p Se le pasa por argumento el producto.
	 * @return Devuelve true si el producto existe y false si no existe.
	 */
	private String hashPass(String pass) {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		return new String(md.digest(pass.getBytes());
	}
}