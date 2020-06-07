package model.persistent.daoImpl;

import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import model.entities.City;
import model.entities.Country;
import model.entities.County;
import model.entities.Location;
import model.entities.Production;
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
		// + "(SELECT COUNT(p) FROM Production p JOIN p.scenes s WHERE l = s.location), "
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


		Subquery<Long> countProduction = innerCriteriaQuery.subquery(Long.class);
		Root<Production> sqCountProduction = countProduction.from(Production.class);
		Join<Object, Object> joinScenes = sqCountProduction.join("scenes");

		countProduction.select(cb.count(sqCountProduction)).where(cb.equal(joinScenes.get("location"), rootLocation));


		innerCriteriaQuery.multiselect(
			rootLocation.get("id"),
			rootLocation.get("name"),
			joinCity.get("city"),
			joinCounty.get("county"),
			joinCountry.get("country"),
			countProduction
			);


		TypedQuery<Tuple> query = con.getEm().createQuery(innerCriteriaQuery);

		//Se recogen los valores de la consulta.
		List<Tuple> list = query.getResultList();
		return list;
	}

	@Override
	public List<Object[]> list() {
		if (!con.openConexion()) {
			return null;
		}

		// Se crea la consulta
		// String jpql = "SELECT l.id, l.name, ci.city, co.county, c.country, "
		// + "(SELECT COUNT(p) FROM Production p JOIN p.scenes s WHERE l = s.location), "
		// + "l.active, "
		// + "(SELECT lm.filename FROM l.locationsMedias lm LIMIT 1)"
		// + "FROM Location l JOIN l.city ci "
		// + "JOIN ci.county co JOIN co.country c "
		// + "ORDER BY l.id DESC";

		CriteriaBuilder cb = con.getEm().getCriteriaBuilder();
		CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
		Root<Location> location = cq.from(Location.class);
		Join<Object, Object> city = location.join("city");
		Join<Object, Object> county = city.join("county");
		Join<Object, Object> country = county.join("country");


		Subquery<Long> countProduction = cq.subquery(Long.class);
		Path<Production> production = cq.from(Production.class);
		Path<Object> scenes = production.get("scenes");

		countProduction
			.select(cb.count(production))
			.where(cb.equal(scenes.get("location"), location));


		cq.multiselect(
			location.get("id"),
			location.get("name"),
			city.get("city"),
			county.get("county"),
			country.get("country"),
			cb.count(countProduction)
			);


		TypedQuery<Object[]> query = con.getEm().createQuery(cq);

		//Se recogen los valores de la consulta.
		List<Object[]> list = query.getResultList();
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
}