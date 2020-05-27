package model.persistent.daoImpl;

import java.util.List;

import javax.persistence.EntityTransaction;

import model.entities.City;
import model.persistent.connection.Conexion;
import model.persistent.dao.CityDao;

public class CityDaoImpl implements CityDao {
	Conexion con = new Conexion();

	@Override
	public List<City> list() {
		if(!con.openConexion()) {
			return null;
		}
		return con.getEm().createNamedQuery("City.findAll", City.class).getResultList();
	}

	@Override
	public City create(City city) {
		if (!con.openConexion()) {
			return null;
		}

		System.out.println("CityDao: " + city);
		EntityTransaction et = con.getEm().getTransaction();
		et.begin();
		con.getEm().persist(city);
		et.commit();
		con.closeConexion();

		// Una vez persistido se me actualiza el objeto con su id, y podemos devolverlo
		return city;
	}


	@Override
	public City exists(City city) {
		if(!con.openConexion()) {
			return null;
		}
		List<City> list = list();
		for (City c : list) {
			if(c.equals(city)) return c;
		}
		return null;
	}


	// @Override
	// public City exists(City city) {
	// 	if(!con.openConexion()) {
	// 		return null;
	// 	}
	// 	List<City> listcity = list();
	// 	for (City a : listcity) {
	// 		if(a.equals(city)) {
	// 			return a;
	// 		}
	// 	}
	// 	return null;
	// }


	// @Override
	// public City exists(City city) {
	// 	if (!con.openConexion()) {
	// 		return null;
	// 	}
	// 	// Preparacion consulta con JPQL
	// 	String sql = "SELECT c FROM City c WHERE c.city = ?1 AND c.county = ?2";
	// 	TypedQuery<City> query = con.getEm().createQuery(sql, City.class);
	// 	query.setParameter(1, city.getCity());
	// 	query.setParameter(2, city.getCounty());
	// 	// System.out.println("CNTYDAO:" + query.getSingleResult().toString());
	// 	try {
	// 		// Se retorna el usuario si existe.
	// 		return query.getSingleResult();
	// 	} catch (NoResultException e) {
	// 		return null;
	// 	}
	// }
}