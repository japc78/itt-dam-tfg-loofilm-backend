package model.persistent.daoImpl;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import model.entities.County;
import model.entities.Location;
import model.entities.Production;
import model.persistent .dao.LocationDao;
import model.persistent .connection.Conexion;

public class LocationDaoImpl implements LocationDao {
	Conexion con = new Conexion();

	@Override
	public List<Object> list() {
		if(!con.openConexion()) {
			return null;
		}

		// Creamo una fabria para criteria
		CriteriaBuilder cb = con.getEm().getCriteriaBuilder();

		// tipo de dato a devolver Lista, objeto de configuracion. Config Query
		CriteriaQuery<Location> configConsulta = cb.createQuery(Location.class);
		CriteriaQuery<Object> query = cb.createQuery(Object.class);
		// Punto de partida de la consulta Root
		Root<Location> raizLocation = configConsulta.from(Location.class);
		Join<Object, Object> joinCounty = raizLocation.join("cityId");
		Join<Object, Object> joinCountry = joinCounty.join("countryCode");

		query.multiselect(raizLocation.get("id"), raizLocation.get("name"), raizLocation.get("createDate"))
			.where(cb.equal(joinCounty.get("countryCode"), joinCountry.get("countryCode")));

		List<Object> list = con.getEm().createQuery(query).getResultList();
		return list;

		// Preparacion consulta con JPQL
		// String sql = "SELECT l.id, l.name, l.createDate FROM Location l WHERE l.gps = ?";
		// List<Object[]> result = con.getEm().createQuery(sql).getResultList();

		// TypedQuery<Location> query = con.getEm().createQuery(sql, Location.class);
		// query.setParameter(1,location.getGps());

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
		List<Location> list = con.getEm().createNamedQuery("Location.findAll", Location.class).getResultList();
		;
		for (Location l : list) {
			if(l.equals(location)) return l;
		}
		return null;
		// System.out.println("LocationDao: " + con.getEm().contains(location));
		// return con.getEm().contains(location) ? location : null;

		// Preparacion consulta con JPQL
		// String sql = "SELECT l FROM Location l WHERE l.gps = ?";
		// TypedQuery<Location> query = con.getEm().createQuery(sql, Location.class);
		// query.setParameter(1,location.getGps());

		// List<Location> locations = query.getResultList();
		// for (Location l : locations) {
		// 	if (l.equals(location)) {
		// 		return l;
		// 	}
		// }
		// return null;
	}
}