package model.persistent.dao;

import java.util.List;

import model.entities.LocationsMedia;

public interface LocationsMediaDao {
	/**
	 * Metodo que devuelve el listado de LocationMedia(imagenes asociadas a Localizaciones)
	 * @return
	 */
	List<LocationsMedia> list();

	/**
	 * Metodo que comprueba si existe una imagen de una localizacion en el servidor.
	 * @param image Del tripo String se le pasa el nombre de la imagen
	 * @return Retorna true si hay una imagen con el mismo nombre.
	 */
	LocationsMedia existsImage(String image);
}