package model.services;

import java.util.List;

import model.entities.ScenesMedia;
import model.persistent.daoImpl.ScenesMediaDaoImpl;

public class ScenesMediaService {
	private ScenesMediaDaoImpl smDao = new ScenesMediaDaoImpl();


	/**
	 * Metodo que devuelve el listado de ScenesMedia(imagenes asociadas a Scenas)
	 * @return
	 */
	public List<ScenesMedia> list() {
		return smDao.list();
	}

	/**
	 * Metodo que comprueba si existe una imagen de una scena en el servidor.
	 * @param image Del tripo String se le pasa el nombre de la imagen
	 * @return Retorna true si hay una imagen con el mismo nombre.
	 */
	public boolean existsImage(String image) {
		if (smDao.existsImage(image)!= null) {
			return true;
		} else {
			return false;
		}
	}
}