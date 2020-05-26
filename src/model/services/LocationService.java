package model.services;

import java.util.List;

import model.entities.Location;
import model.persistent.daoImpl.LocationDaoImpl;

public class LocationService {
	private LocationDaoImpl loDao = new LocationDaoImpl();

	public List<Location> list() {
		return loDao.list();
	}

	/**
	 * Metodo que para el alta de de una Localidad
	 *
	 * @param l Se le pasa por argumento la localidad a dar de alta.
	 * @return Retorna er-01 si el codigo introudcido no es correcto, er-02 si el
	 *         hay un producto con el mismo código, er-03 si el precio es igual a 0,
	 *         er-04 si el campo descripción está vacio, y ok-01 si el producto se
	 *         ha dado de alta correctamente.
	 */
	public String add(Location l) {
		System.out.println("Localition: " + l.toString());

		//Se comprueba si existe.
		if (!exists(l)) {
			loDao.create(l);
			return "OK-L01";
		} else {
			// Tanto la Address como la Localizacion existen.
			return "ER-L01";
		}
	}

	/**
	 * Metodo que comprueba si la Localización a introducir ya se encuentra en la
	 * BBDD.
	 *
	 * @param l Se le pasa por argumento la localidad.
	 * @return Devuelve true si el producto existe y false si no existe.
	 */
	private boolean exists(final Location l) {
		if (loDao.exists(l) != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo que elimina los () de la cadena de String de Coordeandas
	 *
	 * @param gps String de las coordeanas
	 * @return String con la coordenadas sin () para especificar las coordenadas.
	 */
	public String gpsFormat(final String gps) {
		return gps.replaceAll("[()]", "");
	}
}