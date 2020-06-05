package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		System.out.println("id: " + id);
		System.out.println("category: " + category);

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

				req.setAttribute("withMaps", 0);
				req.setAttribute("isList", 1);
				req.setAttribute("isForm", 0);
				req.setAttribute("withSelect2", 0);

				if (category.equals("location")) {
					LocationService s = new LocationService();
					req.setAttribute("locations", s.list());
					req.setAttribute("msg", msg);
					req.getRequestDispatcher("location-list.jsp").forward(req, resp);

				} else if (category.equals("production")) {
					ProductionService s = new ProductionService();
					req.setAttribute("productions", s.list());
					req.setAttribute("msg", msg);
					req.getRequestDispatcher("production-list.jsp").forward(req, resp);

				} else {
					SceneService s = new SceneService();
					req.setAttribute("scenes", s.list());
					req.setAttribute("msg", msg);
					req.getRequestDispatcher("scene-list.jsp").forward(req, resp);
				}
				break;
		}
	}

	private String delete (String category, int id) {
		switch (category) {
			case "location":
				LocationService ls = new LocationService();
				return ls.remove(id);
			case "production":
				ProductionService ps = new ProductionService();
				return ps.remove(id);
			case "scene":
				SceneService ss = new SceneService();
				return ss.remove(id);
			default:
				return "ER-G00";
		}
	}
}