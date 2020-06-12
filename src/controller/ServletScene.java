package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entities.Scene;
import model.entities.ScenesMedia;
import model.services.LocationService;
import model.services.ProductionService;
import model.services.SceneService;

@WebServlet("/scene")
public class ServletScene extends HttpServlet{
	private static final long serialVersionUID = -6641315023837891091L;
	private static final String UPLOAD_DIRECTORY = "scenes";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SceneService ss = new SceneService();
		LocationService ls = new LocationService();
		ProductionService ps = new ProductionService();

		String page = (!req.getParameter("page").isEmpty())? req.getParameter("page") : "edit";

		if (req.getParameter("page").equals("view")) {
			req.setAttribute("isList", 1);
			req.setAttribute("withFancyBox", 1);
		} else {
			req.setAttribute("isForm", 1);
			req.setAttribute("withSelect2", 1);
		}


		int id = Integer.parseInt(req.getParameter("id"));

		Scene s = new Scene();
		s = ss.find(id);

		req.setAttribute("scene", s);

		// Se pasan los datos por parametros a los Selects
		req.setAttribute("locations", ls.listSelect2());
		req.setAttribute("productions", ps.listSelect2());

		for (ScenesMedia img : s.getScenesMedias()) {
			System.out.println(img.getFilename());
		}

		String path = getServletContext().getContextPath() + File.separator + "images" + File.separator + UPLOAD_DIRECTORY + File.separator;

		req.setAttribute("path", path);

		if (page.equals("view")) {
			req.getRequestDispatcher("scene-view.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("scene.jsp").forward(req, resp);
		}
	}
}