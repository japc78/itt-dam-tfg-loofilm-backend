package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entities.Production;
import model.services.ProductionService;


@WebServlet("/production")
public class ServletProduction extends HttpServlet {
	private static final long serialVersionUID = 3486969229857625093L;
	private static final String UPLOAD_DIRECTORY = "productions";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductionService ps = new ProductionService();

		String page = (!req.getParameter("page").isEmpty())? req.getParameter("page") : "edit";

		if (req.getParameter("page").equals("view")) {
			req.setAttribute("isList", 1);
			req.setAttribute("withFancyBox", 1);
		}
		req.setAttribute("isForm", 1);

		int id = Integer.parseInt(req.getParameter("id"));

		Production p = new Production();

		p = ps.find(id);
		req.setAttribute("production", p);

		String path = getServletContext().getContextPath() + File.separator + "images" + File.separator + UPLOAD_DIRECTORY + File.separator;
		req.setAttribute("path", path);

		if (page.equals("view")) {
			req.getRequestDispatcher("production-view.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("production.jsp").forward(req, resp);
		}
	}
}