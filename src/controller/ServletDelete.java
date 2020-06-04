package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entities.Location;
import model.entities.Production;
import model.entities.Scene;
import model.services.LocationService;
import model.services.ProductionService;
import model.services.SceneService;
@WebServlet("/delete")
public class ServletDelete extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String category = req.getParameter("category");
		int id = Integer.parseInt(req.getParameter("id"));

		// System.out.println("id: " + id);
		// System.out.println("category: " + category);

		String msg;
		switch (delete(category, id)) {
			case "ER-L02":
			case "ER-P02":
			case "ER-S02":
				msg = "ERROR: al eliminar el elemento vuelve a intentarlo";
				break;
			case "ER-G00":
				msg = "ERROR: Error desconocido, pongase en contacto con soporte";
				break;
			default:
				msg = "OK: Elemento borrado";
				break;
		}
		resp.setContentType("Text/plain");
		resp.getWriter().write(msg);
	}

	private String delete (String category, int id) {
		switch (category) {
			case "location":
				LocationService ls = new LocationService();
				return ls.remove(id);
			case "production":
				ProductionService ps = new ProductionService();
				Production p = ps.find(id);
				return ps.remove(p); 
			case "scene":
				SceneService ss = new SceneService();
				Scene s = ss.find(id);
				return ss.remove(s);
			default:
				return "ER-G00";
		}
	}
}