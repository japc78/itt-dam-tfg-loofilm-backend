package test;

import model.services.LocationService;
import model.services.ProductionService;

public class testQueryJPQLocation {

	public static void main(String[] args) {
		LocationService ls = new LocationService();
		for (Object[] l : ls.list()) {
			for (int i = 0; i < l.length; i++) {
				System.out.print("- " + l[i]);
			}
			System.out.print("\n");
		}

		ProductionService ps = new ProductionService();
		for (Object[] p : ps.list()) {
			for (int i = 0; i < p.length; i++) {
				System.out.print("- " + p[i]);
			}
			System.out.print("\n");
		}
	}
}