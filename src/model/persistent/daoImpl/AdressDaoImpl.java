package model.persistent.daoImpl;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.entities.Adress;
import model.entities.City;
import model.entities.Country;
import model.entities.County;
import model.persistent.connection.Conexion;
import model.persistent.dao.AdressDao;

public class AdressDaoImpl implements AdressDao {
	Conexion con = new Conexion();

	@Override
	public List<Adress> list() {
		if(!con.openConexion()) {
			return null;
		}
		//Se usa JPQL para la consulta.
		TypedQuery<Adress> query = con.getEm().createNamedQuery("Adress.findAll", Adress.class);
		List<Adress> listAdress = query.getResultList();
		return listAdress;
	}

	@Override
	public Adress create(Adress address) {
		if (!con.openConexion()) {
			return null;
		}
		EntityTransaction et = con.getEm().getTransaction();
		et.begin();
		con.getEm().merge(address);
		et.commit();
		con.closeConexion();
		// Una vez persistido se me actualiza el objeto con su id, y podemos devolverlo
		return address;
	}

	@Override
	public Adress create(Country country, County county, City city) {
		// if(!con.openConexion()) {
		// return null;
		// }
		// Adress a = new Adress();
		// EntityTransaction et = con.getEm().getTransaction();
		// et.begin();
		// con.getEm().merge(address);
		// et.commit();
		// con.closeConexion();
		// Adress a = new Adress();
		// //Una vez persistido se me actualiza el objeto con su id, y podemos
		// devolverlo
		// return a;
		return null;
	}

	@Override
	public Integer delete(Integer id) {
		if (!con.openConexion()) {
			return null;
		}

		EntityTransaction et = con.getEm().getTransaction();
		et.begin();
		con.getEm().remove(id);
		et.commit();
		con.closeConexion();

		// Una vez eliminado se devuelve el id del objeto eliminado
		return id;
	}

	// @Override
	// public Adress exists(Adress adress) {
	// 	if(!con.openConexion()) {
	// 		return null;
	// 	}

	// 	// Preparacion consulta con JPQL
	// 	String sql = "SELECT a FROM Adress a WHERE a.country = ?1 AND a.county = ?2 AND a.city = ?3";
	// 	TypedQuery<Adress> query = con.getEm().createQuery(sql, Adress.class);
	// 	query.setParameter(1,adress.getCountry().getCountryCode());
	// 	query.setParameter(2,adress.getCounty().getCounty());
	// 	query.setParameter(3,adress.getCity().getId());
	// 	System.out.println("AddressDAO:" + query.getSingleResult().toString());
	// 	try {
	// 		// Se retorna el usuario si existe.
	// 		return query.getSingleResult();
	// 	} catch (NoResultException  e) {
	// 		return null;
	// 	}
	// }

	@Override
	public Adress exists(Adress adress) {
		if(!con.openConexion()) {
			return null;
		}
		return con.getEm().contains(adress) ? adress : null;
	}
}