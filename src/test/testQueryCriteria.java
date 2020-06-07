package test;

import model.services.LocationServiceCriteria;

public class testQueryCriteria {

	public static void main(String[] args) {
		LocationServiceCriteria ls = new LocationServiceCriteria();

		for (Object[] l : ls.list()) {
			System.out.println(l.toString());
		}
	}
}