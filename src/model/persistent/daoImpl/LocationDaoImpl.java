package model.persistent.daoImpl;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import model.entities.City;
import model.entities.Country;
import model.entities.County;
import model.entities.Location;
import model.entities.Production;
import model.persistent .dao.LocationDao;
import model.persistent .connection.Conexion;

public class LocationDaoImpl implements LocationDao {
	Conexion con = new Conexion();

	@Override
	public List<Object[]> list() {
		if(!con.openConexion()) {
			return null;
		}
		// String sql = "SELECT l.id, l.name, l.createDate, c.name, COUNT(p)  FROM Location l JOIN  WHERE l.gps = ?";

		// Preparacion consulta con JPQL
		String sql = "SELECT l.id, l.name, l.createDate, c.name " +
						"FROM Location l JOIN County co ON l.city = co." +
						"JOIN ci.County co JOIN co.Country";
		// List<Object[]> result = con.getEm().createQuery(sql).getResultList();
		String sqlCount = ("SELECT COUNT(p) FROM Production p WHERE");

		TypedQuery<Object[]> query = con.getEm().createQuery(sql, Object[].class);

		List<Object[]> list = query.getResultList();

		return list;
	}

	@Override
	public Location create(Location location, City city, County county, Country country) {
		if(!con.openConexion()) {
			return null;
		}
		EntityTransaction et = con.getEm().getTransaction();
		et.begin();
		con.getEm().merge(country);
		country.getCounties().add(county);
		county.getCities().add(city);
		con.getEm().merge(location);
		et.commit();
		con.closeConexion(); 

		//Una vez persistido se me actualiza el objeto con su id, y podemos devolverlo
		return location;
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
	public Location find(Location location) {
		if(!con.openConexion()) {
			return null;
		}
		return con.getEm().find(Location.class, location.getId());
	}

	@Override
	public Location exists(Location location) {
		if(!con.openConexion()) {
			return null;
		}
		List<Location> list = con.getEm().createNamedQuery("Location.findAll", Location.class).getResultList();

		for (Location l : list) {
			if(l.equals(location)) return l;
		}
		return null;
	}
}