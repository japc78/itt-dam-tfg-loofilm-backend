package model.persistent.daoImpl;

import java.util.List;

import javax.persistence.EntityTransaction;

import model.entities.Scene;
import model.persistent.connection.Conexion;
import model.persistent.dao.SceneDao;

public class SceneDaoImpl implements SceneDao {
	Conexion con = new Conexion();

	@Override
	public List<Object[]> list() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Scene scene) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Scene find(Scene scene) {
		if(!con.openConexion()) {
			return null;
		}
		return con.getEm().find(Scene.class, scene.getId());
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