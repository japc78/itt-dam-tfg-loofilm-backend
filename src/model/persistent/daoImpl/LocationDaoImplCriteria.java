package model.persistent.daoImpl;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import model.entities.City;
import model.entities.Country;
import model.entities.County;
import model.entities.Location;
import model.entities.Scene;
import model.persistent.connection.Conexion;
import model.persistent.dao.LocationDao;

public class LocationDaoImplCriteria implements LocationDao {
	Conexion con = new Conexion();

	@Override
	public List<Tuple> listTuple() {
		if (!con.openConexion()) {
			return null;
		}

		// Se crea la consulta
		// String jpql = "SELECT l.id, l.name, ci.city, co.county, c.country, "
		// + "(SELECT COUNT(p) FROM Production p JOIN p.scenes s WHERE l = s.location),
		// "
		// + "l.active, "
		// + "(SELECT lm.filename FROM l.locationsMedias lm LIMIT 1)"
		// + "FROM Location l JOIN l.city ci "
		// + "JOIN ci.county co JOIN co.country c "
		// + "ORDER BY l.id DESC";

		CriteriaBuilder cb = con.getEm().getCriteriaBuilder();
		CriteriaQuery<Tuple> innerCriteriaQuery = cb.createTupleQuery();
		Root<Location> rootLocation = innerCriteriaQuery.from(Location.class);
		Join<Object, Object> joinCity = rootLocation.join("city");
		Join<Object, Object> joinCounty = joinCity.join("county");
		Join<Object, Object> joinCountry = joinCounty.join("country");

		innerCriteriaQuery.multiselect(
			rootLocation.get("id"),
			rootLocation.get("name"),
			joinCity.get("city"),
			joinCounty.get("county"),
			joinCountry.get("country")
			);

		Subquery<Integer> counScenes = innerCriteriaQuery.subquery(Integer.class);
		Root<Scene> sqCountScenes = counScenes.from(Scene.class);
		counScenes.select(cb.count(sqCountScenes)).where(cb.equal(sqCountScenes, rootLocation));

		TypedQuery<Tuple> query = con.getEm().createQuery(innerCriteriaQuery);

		//Se recogen los valores de la consulta.
		List<Tuple> list = query.getResultList();
		return list;
	}

	@Override
	public List<Object[]> listSelect2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location create(Location location, City city, County county, Country country) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location update(Location location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location delete(Location location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location exists(Location location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> list() {
		// TODO Auto-generated method stub
		return null;
	}

}