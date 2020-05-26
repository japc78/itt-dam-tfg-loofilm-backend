package model.persistent.daoImpl;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.entities.Location;
import model.persistent .dao.LocationDao;
import model.persistent .connection.Conexion;

public class LocationDaoImpl implements LocationDao {
	Conexion con = new Conexion();

	@Override
	public List<Location> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer create(Location location) {
		if(!con.openConexion()) {
			return null;
		}

		EntityTransaction et = con.getEm().getTransaction();
		et.begin();
		con.getEm().persist(location);
		et.commit();
		con.closeConexion();

		//Una vez persistido se me actualiza el objeto con su id, y podemos devolverlo
		return location.getId();
	}

	@Override
	public Integer update(Location location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(Location location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location exists(Location location) {
		if(!con.openConexion()) {
			return null;
		}
		if(!con.openConexion()) {
			return null;
		}
		return con.getEm().contains(location) ? location : null;
	}
}