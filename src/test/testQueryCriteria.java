package test;

import javax.persistence.Tuple;

import model.services.LocationServiceCriteria;

public class testQueryCriteria {

	public static void main(String[] args) {
		LocationServiceCriteria ls = new LocationServiceCriteria();

		for (Tuple l : ls.list()) {
			System.out.println("Info: " + l.get(0) + " - " + l.get(1) + " - " + l.get(2) + " - " +  l.get(3) + " - " + l.get(4));
		}
	}
}