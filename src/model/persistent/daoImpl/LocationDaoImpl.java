package model.persistent.daoImpl;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.entities.City;
import model.entities.Country;
import model.entities.County;
import model.entities.Location;
import model.persistent .dao.LocationDao;
import model.persistent .connection.Conexion;

public class LocationDaoImpl implements LocationDao {
	Conexion con = new Conexion();

	@Override
	public List<Object[]> list() {
		if(!con.openConexion()) {
			return null;
		}

		// Se crea la consulta
		String jpql = "SELECT l.id, l.name, ci.city, co.county, c.country, "
				+ "(SELECT COUNT(p) FROM Production p JOIN p.scenes s WHERE l = s.location), l.active "
				+ "FROM Location l JOIN l.city ci "
				+ "JOIN ci.county co JOIN co.country c "
				+ "ORDER BY l.id DESC";
		TypedQuery<Object[]> query = con.getEm().createQuery(jpql, Object[].class);

		//Se recogen los valores de la consulta.
		List<Object[]> list = query.getResultList();
		return list;
	}

	@Override
	public List<Object[]> listSelect2() {
		if(!con.openConexion()) {
			return null;
		}

		// Se crea la consulta
		String jpql = "SELECT l.id, l.name, co.county, c.country "
				+ "FROM Location l JOIN l.city ci "
				+ "JOIN ci.county co JOIN co.country c "
				+ "WHERE l.active = 1";
		TypedQuery<Object[]> query = con.getEm().createQuery(jpql, Object[].class);

		//Se recogen los valores de la consulta.
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
		city.setCounty(county);
		location.setCity(city);
		con.getEm().merge(location);
		et.commit();
		con.closeConexion();

		//Una vez persistido se me actualiza el objeto con su id, y podemos devolverlo
		return location;
	}

	@Override
	public Location update(Location location) {
		if(!con.openConexion()) {
			return null;
		}
		EntityTransaction et = con.getEm().getTransaction();
		et.begin();
		con.getEm().merge(location);
		et.commit();
		con.closeConexion();

		//Una vez persistido se me actualiza el objeto con su id, y podemos devolverlo
		return location;
	}

	@Override
	public Integer delete(Location location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location find(int id) {
		if(!con.openConexion()) {
			return null;
		}
		return con.getEm().find(Location.class, id);
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