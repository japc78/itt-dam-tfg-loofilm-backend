package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entities.Production;
import model.services.ProductionService;

@WebServlet("/production-create")
@MultipartConfig
public class ServletProductionCreate extends HttpServlet{
	private static final long serialVersionUID = -6147400358347687716L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("withMaps", 0);
		req.setAttribute("isList", 0);
		req.setAttribute("isForm", 1); 
		req.setAttribute("withSelect2", 0); 

		req.getRequestDispatcher("production-create.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		// Instancia del servicio y la entidad necesaria
		ProductionService ps = new ProductionService();
		Production p;

		// Se regocen los valores de los campos recibidos.
		String name 		= req.getParameter("name");
		int year 			= Integer.parseInt(req.getParameter("year"));
		int type 			= Integer.parseInt(req.getParameter("type"));
		String description 	= req.getParameter("description");
		String cast 		= req.getParameter("cast");
		String web			= req.getParameter("web");

		p = new Production(name, year, type, description, cast, web);
		String result = ps.add(p);
		System.out.println(result);
		// Se procesa la respuesta.
		switch (result) {
			case "ER-P00":
				req.setAttribute("msgType", "error");
				req.setAttribute("msg", "Error: La produccion ya se encuentra en la BD");
				req.getRequestDispatcher("location-create.jsp").forward(req, resp);
				break;
			default:
				req.getRequestDispatcher("production-list.jsp").forward(req, resp);
				break;
		}
	}
}