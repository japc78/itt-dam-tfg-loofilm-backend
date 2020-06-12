package model.persistent.daoImpl;

import java.util.List;

import javax.persistence.TypedQuery;

import model.entities.ScenesMedia;
import model.persistent.connection.Conexion;
import model.persistent.dao.ScenesMediaDao;

public class ScenesMediaDaoImpl implements ScenesMediaDao {
	Conexion con = new Conexion();

	@Override
	public List<ScenesMedia> list() {
		if(!con.openConexion()) {
			return null;
		}
		TypedQuery<ScenesMedia> query = con.getEm().createNamedQuery("ScenesMedia.findAll", ScenesMedia.class);
		return query.getResultList();
	}

	@Override
	public ScenesMedia existsImage(String image) {
		if(!con.openConexion()) {
			return null;
		}
		List<ScenesMedia> list = con.getEm().createNamedQuery("ScenesMedia.findAll", ScenesMedia.class).getResultList();

		for (ScenesMedia l : list) {
			if(l.equals(new ScenesMedia(image))) return l;
		}
		return null;
	}
}
