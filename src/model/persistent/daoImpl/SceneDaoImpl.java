package model.persistent.daoImpl;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.entities.Scene;
import model.persistent.connection.Conexion;
import model.persistent.dao.SceneDao;

public class SceneDaoImpl implements SceneDao {
	Conexion con = new Conexion();

	@Override
	public List<Object[]> list() {
		if(!con.openConexion()) {
			return null;
		}
		// Se crea la consulta
		String jpql = "SELECT s.id, s.name, p.name, p.type, l.name, ci.city, s.active FROM Scene s "
				+ "JOIN Production p "
				+ "JOIN Location l "
				+ "JOIN l.city ci "
				+ "WHERE s.location = l AND s.production = p "
				+ "ORDER BY s.id DESC";

		TypedQuery<Object[]> query = con.getEm().createQuery(jpql, Object[].class);

		//Se recogen los valores de la consulta.
		List<Object[]> list = query.getResultList();
		return list;
	}

	@Override
	public Scene create(Scene scene) {
		if(!con.openConexion()) {
			return null;
		}
		EntityTransaction et = con.getEm().getTransaction();
		et.begin();
		con.getEm().merge(scene);
		et.commit();
		con.closeConexion();

		//Una vez persistido se me actualiza el objeto con su id, y podemos devolverlo
		return scene;
	}

	@Override
	public Scene update(Scene scene) {
		return create(scene);
	}

	@Override
	public String delete(Scene scene) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Scene find(int id) {
		if(!con.openConexion()) {
			return null;
		}
		return con.getEm().find(Scene.class, id);
	}

	@Override
	public Scene exists(Scene scene) {
		if(!con.openConexion()) {
			return null;
		}
		List<Scene> list = con.getEm().createNamedQuery("Scene.findAll", Scene.class).getResultList();

		for (Scene l : list) {
			if(l.equals(scene)) return l;
		}
		return null;
	}
}