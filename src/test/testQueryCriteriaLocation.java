package test;

import model.entities.Location;
import model.services.LocationService;

public class testQueryCriteriaLocation {

	public static void main(String[] args) {
		LocationService ls = new LocationService();

		for (Object[] l : ls.list()) {
			System.out.println(l.toString());
		}
	}
}