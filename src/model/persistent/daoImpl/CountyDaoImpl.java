package model.persistent.daoImpl;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.entities.County;
import model.persistent.connection.Conexion;
import model.persistent.dao.CountyDao;

public class CountyDaoImpl implements CountyDao {
	Conexion con = new Conexion();

	@Override
	public List<County> list() {
		if(!con.openConexion()) {
			return null;
		}
		//Se usa JPQL para la consulta.
		TypedQuery<County> query = con.getEm().createNamedQuery("County.findAll", County.class);
		List<County> listCounty = query.getResultList();
		return listCounty;
	}

	@Override
	public County create(County county) {
		if (!con.openConexion()) {
			return null;
		}
		EntityTransaction et = con.getEm().getTransaction();
		et.begin();
		System.out.println("DaoCountyCreateBefore: "+ county);
		con.getEm().persist(county);
		et.commit();
		System.out.println("DaoCountyCreateAfter: "+ county);

		con.closeConexion();

		// Una vez persistido se me actualiza el objeto con su id, y podemos devolverlo
		return county;
	}


	@Override
	public County exists(County county) {
		if(!con.openConexion()) {
			return null;
		}
		System.out.println("DaoCounty: "+ con.getEm().contains(county));
		return con.getEm().contains(county) ? county : null;
	}

	// @Override
	// public County exists(County county) {
	// 	if (!con.openConexion()) {
	// 		return null;
	// 	}
	// 	// Preparacion consulta con JPQL
	// 	String sql = "SELECT c FROM County c WHERE c.county = ?1 AND c.country = ?2";
	// 	TypedQuery<County> query = con.getEm().createQuery(sql, County.class);
	// 	query.setParameter(1, county.getCounty());
	// 	query.setParameter(2, county.getCountry());
	// 	// System.out.println("CNTYDAO:" + query.getSingleResult().toString());
	// 	try {
	// 		// Se retorna el usuario si existe.
	// 		return query.getSingleResult();
	// 	} catch (NoResultException e) {
	// 		return null;
	// 	}
	// }


}