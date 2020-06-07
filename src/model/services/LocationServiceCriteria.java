package model.services;

import java.util.List;

import javax.persistence.Tuple;

import model.persistent.daoImpl.LocationDaoImplCriteria;

public class LocationServiceCriteria {
	private LocationDaoImplCriteria loDao = new LocationDaoImplCriteria();
		/**
	 * Listado de localizaciones
	 * @return Una coleccion de Arrays.
	 * Id, imagen, nombre, provincia, pais, numero de producciones, estado
	 */
	// public List<Tuple> list() {
	// 	return loDao.listTuple();
	// }

		/**
	 * Listado de localizaciones
	 * @return Una coleccion de Arrays.
	 * Id, imagen, nombre, provincia, pais, numero de producciones, estado
	 */
	public List<Object[]> list() {
		return loDao.list();
	}
}