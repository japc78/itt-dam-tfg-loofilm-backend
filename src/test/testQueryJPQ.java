package test;

import model.entities.Location;
import model.entities.LocationsMedia;
import model.services.LocationService;


public class testQueryJPQ {

	public static void main(String[] args) {
		LocationService ls = new LocationService();
		// ProductionService ps = new ProductionService();
		// SceneService ss = new SceneService();

		Location l = new Location();


		// Localizaciones
			// for (Object[] l : ls.list()) {
			// 	for (int i = 0; i < l.length; i++) {
			// 		System.out.print("- " + l[i]);
			// 	}
			// 	System.out.print("\n");
			// }

			l = ls.find(52);

			for (LocationsMedia img : l.getLocationsMedias()) {
				System.out.println(img.getFilename());
			}


			//System.out.println(ls.remove(8));
			// System.out.println(ps.remove(20));
			//System.out.println(ls.remove(8));

			// for (Object[] l : ls.listSelect2()) {
			// 	for (int i = 0; i < l.length; i++) {
			// 		System.out.print("- " + l[i]);
			// 	}
			// 	System.out.print("\n");
			// }

		// Producciones
			// for (Object[] p : ps.list()) {
			// 	for (int i = 0; i < p.length; i++) {
			// 		System.out.print("- " + p[i]);
			// 	}
			// 	System.out.print("\n");
			// }


		// Escenas
			// for (Object[] s : ss.list()) {
			// 	for (int i = 0; i < s.length; i++) {
			// 		System.out.print("- " + s[i]);
			// 	}
			// 	System.out.print("\n");
			// }
	}
}