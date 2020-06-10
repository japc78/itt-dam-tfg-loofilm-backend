package model.services;

import java.util.List;

import model.entities.LocationsMedia;
import model.persistent.daoImpl.LocationsMediaDaoImpl;

public class LocationsMediaService {
	private LocationsMediaDaoImpl lmDao = new LocationsMediaDaoImpl();


	/**
	 * Metodo que devuelve el listado de LocationMedia(imagenes asociadas a Localizaciones)
	 * @return
	 */
	public List<LocationsMedia> list() {
		return lmDao.list();
	}

	/**
	 * Metodo que comprueba si existe una imagen de una localizacion en el servidor.
	 * @param image Del tripo String se le pasa el nombre de la imagen
	 * @return Retorna true si hay una imagen con el mismo nombre.
	 */
	public boolean existsImage(String image) {
		if (lmDao.existsImage(image)!= null) {
			return true;
		} else {
			return false;
		}
	}
}