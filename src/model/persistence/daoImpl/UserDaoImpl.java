package model.persistence.daoImpl;

import java.util.List;

import model.entities.User;
import model.persistence.connection.Conexion;
import model.persistence.dao.UserDao;

public class UserDaoImpl implements UserDao {
	Conexion con = new Conexion();

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String create(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User exists(User u) {
		if(!con.openConexion()) {
			return null;
		}
		// Se busca el usuario con el metodo Find.
		User user = con.getEm().find(User.class, u.getEmail());
		return user;
	}

}