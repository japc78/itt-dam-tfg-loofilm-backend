package model.persistent.daoImpl;

import java.util.List;

import javax.persistence.EntityTransaction;

import model.entities.Country;
import model.persistent.connection.Conexion;
import model.persistent.dao.CountryDao;

public class CountryDaoImpl implements CountryDao {
	Conexion con = new Conexion();

	@Override
	public List<Country> list() {
		if(!con.openConexion()) {
			return null;
		}
		return con.getEm().createNamedQuery("Country.findAll", Country.class).getResultList();
	}

	@Override
	public Country create(Country country) {
		if (!con.openConexion()) {
			return null;
		}

		EntityTransaction et = con.getEm().getTransaction();
		et.begin();
		con.getEm().persist(country);
		et.commit();
		con.closeConexion();

		// Una vez persistido se me actualiza el objeto con su id, y podemos devolverlo
		return country;
	}

	@Override
	public Country exists(Country country) {
		if(!con.openConexion()) {
			return null;
		}
		return con.getEm().find(Country.class, country.getCountryCode());
	}

	// @Override
	// public Country exists(Country country) {
	// 	if (!con.openConexion()) {
	// 		return null;
	// 	}
	// 	// Preparacion consulta con JPQL
	// 	String sql = "SELECT c FROM Country c WHERE c.countryCode = ?1";
	// 	TypedQuery<Country> query = con.getEm().createQuery(sql, Country.class);
	// 	query.setParameter(1, country.getCountryCode());
	// 	// System.out.println("CNTRYDAO:" + query.getSingleResult().toString());
	// 	try {
	// 		// Se retorna el usuario si existe.
	// 		return query.getSingleResult();
	// 	} catch (NoResultException e) {
	// 		return null;
	// 	}
	// }


}