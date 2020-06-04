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

@WebServlet("/scene-create")
public class ServletSceneCreate extends HttpServlet {
	private static final long serialVersionUID = 4000751667389489942L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("withMaps", 0);
		req.setAttribute("isList", 0);
		req.setAttribute("isForm", 1);
		req.setAttribute("withSelect2", 1);

		LocationService ls = new LocationService();
		ProductionService ps = new ProductionService();

		// Se pasan los datos por parametros a los Selects
		req.setAttribute("locations", ls.listSelect2());
		req.setAttribute("productions", ps.listSelect2());

		req.getRequestDispatcher("scene-create.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		// Servicios necesarios
		SceneService ss = new SceneService();
		LocationService ls = new LocationService();
		ProductionService ps = new ProductionService();

		// Objetos necesarios
		Location location = new Location();
		Production production = new Production();
		Scene s;

		// Se regocen los valores de los campos recibidos.
		int idLocation 		= Integer.parseInt(req.getParameter("location"));
		int idProduction 		= Integer.parseInt(req.getParameter("production"));
		String name 		= req.getParameter("name");
		String description 	= req.getParameter("description");

		// System.out.println("Localizacion Id: " +  idLocation);
		// System.out.println("Produccion Id: " +  idProduction);

		location = ls.find(idLocation);
		production = ps.find(idProduction);

		s = new Scene(location, production, name, description);

		// Se añade y se procesa la respuesta.
		switch (ss.add(s)) {
			case "ER-S00":
				req.setAttribute("msgType", "error");
				req.setAttribute("msg", "Error: Ha habido un problema con la aplicación, vuelve a intentarlo");
				req.getRequestDispatcher("scene-create.jsp").forward(req, resp);
				break;
			case "ER-S01":
				req.setAttribute("msgType", "error");
				req.setAttribute("msg", "Error: La escena ya se encuentra en la BD");
				req.getRequestDispatcher("scene-create.jsp").forward(req, resp);
				break;
			default:
				req.getRequestDispatcher("scene-list").forward(req, resp);
				break;
		}
	}
}