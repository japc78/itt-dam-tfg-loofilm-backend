package model.persistent.daoImpl;

import java.util.List;

import javax.persistence.TypedQuery;

import model.entities.LocationsMedia;
import model.persistent.connection.Conexion;
import model.persistent.dao.LocationsMediaDao;

public class LocationsMediaDaoImpl implements LocationsMediaDao {
	Conexion con = new Conexion();

	@Override
	public List<LocationsMedia> list() {
		if(!con.openConexion()) {
			return null;
		}
		TypedQuery<LocationsMedia> query = con.getEm().createNamedQuery("LocationsMedia.findAll", LocationsMedia.class);
		return query.getResultList();
	}

	@Override
	public LocationsMedia existsImage(String image) {
		if(!con.openConexion()) {
			return null;
		}
		List<LocationsMedia> list = con.getEm().createNamedQuery("LocationsMedia.findAll", LocationsMedia.class).getResultList();

		for (LocationsMedia l : list) {
			if(l.equals(new LocationsMedia(image))) return l;
		}
		return null;
	}
}
