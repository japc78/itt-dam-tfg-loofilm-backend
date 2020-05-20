package model.persistence.daoImpl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

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
	public User exists(User user) {
		if(!con.openConexion()) {
			return null;
		}
		// Se busca el usuario con el metodo Find.
		User u = con.getEm().find(User.class, user.getId());
		return u;
	}

	@Override
	public User loginAdmin(User user) {
		if(!con.openConexion()) {
			return null;
		}
		// Preparacion consulta con JPQL
		String sql = "SELECT u FROM User u WHERE u.email = ?1";
		TypedQuery<User> query = con.getEm().createQuery(sql, User.class);
		query.setParameter(1,user.getEmail());
		try {
			// Se retorna el usuario si existe.
			return query.getSingleResult();
		} catch (NoResultException  e) {
			return null;
		}
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return null;
	}
}