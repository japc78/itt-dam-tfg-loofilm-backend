package test;

import model.services.LocationService;

public class testQueryCriteria {

	public static void main(String[] args) {
		LocationService ls = new LocationService();

		for (Object[] l : ls.list()) {
			System.out.println(l.toString());
		}
	}
}