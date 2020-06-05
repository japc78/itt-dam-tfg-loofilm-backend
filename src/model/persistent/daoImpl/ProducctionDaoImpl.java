package model.persistent.daoImpl;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.entities.Production;
import model.persistent.connection.Conexion;
import model.persistent.dao.ProductionDao;

public class ProducctionDaoImpl implements ProductionDao {
	Conexion con = new Conexion();

	@Override
	public List<Object[]> list() {
		if(!con.openConexion()) {
			return null;
		}
		// Se crea la consulta
		String jpql = "SELECT p.id, p.name, p.year, p.type, "
				+ "(SELECT COUNT(s) FROM Scene s WHERE s.production = p), p.active "
				+ "FROM Production p "
				+ "ORDER BY p.id DESC";

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
		String jpql = "SELECT p.id, p.name, p.year, p.type FROM Production p WHERE p.active = 1";

		TypedQuery<Object[]> query = con.getEm().createQuery(jpql, Object[].class);

		//Se recogen los valores de la consulta.
		List<Object[]> list = query.getResultList();
		return list;
	}

	@Override
	public Production create(Production production) {
		if(!con.openConexion()) {
			return null;
		}
		EntityTransaction et = con.getEm().getTransaction();
		et.begin();
		con.getEm().merge(production);
		et.commit();
		con.closeConexion();

		//Una vez persistido se me actualiza el objeto con su id, y podemos devolverlo
		return production;
	}

	@Override
	public Production update(Production production) {
		return create(production);
	}

	@Override
	public Production delete(Production production) {
		if(!con.openConexion()) {
			return null;
		}
		EntityTransaction et = con.getEm().getTransaction();
		et.begin();
		Production p = con.getEm().merge(production);
		con.getEm().remove(p);
		et.commit();
		con.closeConexion();

		//Una vez persistido se me actualiza el objeto con su id, y podemos devolverlo
		System.out.println("DELETE: " + production);
		return production;
	}

	@Override
	public Production find(int id) {
		if(!con.openConexion()) {
			return null;
		}
		return con.getEm().find(Production.class, id);
	}

	@Override
	public Production exists(Production production) {
		if(!con.openConexion()) {
			return null;
		}
		List<Production> list = con.getEm().createNamedQuery("Production.findAll", Production.class).getResultList();

		for (Production l : list) {
			if(l.equals(production)) return l;
		}
		return null;
	}
}