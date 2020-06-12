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
	public List<Scene> list() {
		if(!con.openConexion()) {
			return null;
		}
		// Se realiza la consulta en Jpql con NameQuery directamente desde la clase
		TypedQuery<Scene> query = con.getEm().createNamedQuery("Scene.findAll", Scene.class);
		//Se recogen los valores de la consulta.
		List<Scene> list = query.getResultList();
		return list;
	}

	@Override
	public Scene setScene(Scene scene) {
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
	public Scene delete(Scene scene) {
		if(!con.openConexion()) {
			return null;
		}
		EntityTransaction et = con.getEm().getTransaction();
		et.begin();
		Scene s = con.getEm().merge(scene);
		con.getEm().remove(s);
		et.commit();
		con.closeConexion();

		//Una vez persistido se me actualiza el objeto con su id, y podemos devolverlo
		System.out.println("DELETE: " + scene);
		return scene;
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