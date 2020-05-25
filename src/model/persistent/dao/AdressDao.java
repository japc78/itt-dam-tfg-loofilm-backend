package model.persistent.dao;

import java.util.List;

import model.entities.Adress;
import model.entities.City;
import model.entities.Country;
import model.entities.County;

public interface AdressDao {
	/**
	 * Metodo que devuelve el listado de direcciones
	 * @return
	 */
	List<Adress> list();


	/**
	 * Metodo para dar de alta una direción del tipo Pais, Provincia o Estado, Ciudad.
	 * @param country Se le pasa por argumento un objeto de la clase Address
	 * @return Devuelve el objeto añadido.
	 */
	Adress create(Adress address);

	/**
	 * Metodo para dar de alta una direción del tipo Pais, Provincia o Estado, Ciudad.
	 * @param country Se le pasa por argumento un objeto de la clase Address
	 * @return Devuelve el objeto añadido.
	 */
	Adress create(Country country, County county, City city);

	/**
	 * Metodo para borrar una una direción del tipo Pais, Provincia o Estado, Ciudad.
	 * @param city Se le pasa por argumento el id del objeto Address
	 * @return Devuelve el id del elmento borrado.
	 */
	Integer delete(Integer id);

	/**
	 * Metetodo que comprueba si existe objeto adrress con el pais, provincia o estado y ciudad.
	 * @param address Se le pasa por argumento un objeto del tipo Address.
	 * @return Devuelve el objeto Address completo.
	 */
	Adress exists (Adress address);
}