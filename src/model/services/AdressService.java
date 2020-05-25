package model.services;

import model.entities.Adress;
import model.persistent.daoImpl.AdressDaoImpl;

public class AdressService {
	AdressDaoImpl ad = new AdressDaoImpl();

	public Adress add (Adress a) {
		if (ad.exists(a) != null) {
			System.out.println(a);
			return a;
		} else {
			return ad.create(a);
		}
	}

	public boolean exists(Adress adress) {
		if(ad.exists(adress) != null) {
			return true;
		} else {
			return false;
		}
	}
}