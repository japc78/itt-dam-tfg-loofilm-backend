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

@WebServlet("/update-status")
public class ServletUpdateStatus extends HttpServlet{
	private static final long serialVersionUID = 1199158874435164349L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String category = req.getParameter("category");
		int id = Integer.parseInt(req.getParameter("id"));
		boolean active = Boolean.parseBoolean(req.getParameter("active"));

		// System.out.println("id: " + id);
		// System.out.println("active: " + active);
		// System.out.println("category: " + category);

		String msg;
		switch (updateState(category, id, active)) {
			case "ER-L01":
			case "ER-P01":
			case "ER-S01":
				msg = "ERROR: al cambiar el estado, vuelve a intentarlo";
				break;
			case "ER-G00":
				msg = "ERROR: Error desconocido, pongase en contacto con soporte";
				break;
			default:
				msg = "OK: Estado actualizado";
				break;
		}
		resp.setContentType("Text/plain");
		resp.getWriter().write(msg);
	}

	private String updateState (String category, int id, boolean active) {
		switch (category) {
			case "location":
				LocationService ls = new LocationService();
				return ls.toggleCheck(id, active);
			case "production":
				ProductionService ps = new ProductionService();
				return ps.toggleCheck(id, active);
			case "scene":
				SceneService ss = new SceneService();
				return ss.toggleCheck(id, active);
			default:
				return "ER-G00";
		}
	}
}