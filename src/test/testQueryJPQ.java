package test;

import model.entities.Location;
import model.services.LocationService;
import model.services.ProductionService;
import model.services.SceneService;

public class testQueryJPQ {

	public static void main(String[] args) {
		LocationService ls = new LocationService();
		ProductionService ps = new ProductionService();
		SceneService ss = new SceneService();


		// Localizaciones
			// for (Object[] l : ls.list()) {
			// 	for (int i = 0; i < l.length; i++) {
			// 		System.out.print("- " + l[i]);
			// 	}
			// 	System.out.print("\n");
			// }
		
			
			//System.out.println(ls.remove(8));
			System.out.println(ps.remove(20));
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
			for (Object[] s : ss.list()) {
				for (int i = 0; i < s.length; i++) {
					System.out.print("- " + s[i]);
				}
				System.out.print("\n");
			}
	}
}