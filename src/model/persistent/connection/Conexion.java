package model.persistent.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Clase que establece conexion con la BBDD.
 */
public class Conexion {
	private EntityManager em;

	/**
	 * Metodo que establece conexion con la BBDD.
	 * @return Retorna true si la conexion es satisfactoria, false si ha habido algun problema de conexion.
	 */
	public boolean openConexion() {
		try {
			EntityManagerFactory factoria = Persistence.createEntityManagerFactory("loofilm"); 
			em = factoria.createEntityManager();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Metodo que cierra la conexion con la BBDD
	 * @return Retorna true si la conexion se ha cerrado satisfactoriamente, false si ha habido algun problema al cerrar la conexion.
	 */
	public boolean closeConexion() {
		try {
			em.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * EntityMananer de la conexion.
	 * @return the em
	 */
	public EntityManager getEm() {
		return em;
	}

	/**
	 * @param em the em to set
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}
}
