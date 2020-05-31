package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.services.ProductionService;
@WebServlet("/production-list")
public class ServletProductionList extends HttpServlet{
	private static final long serialVersionUID = -3269019503273347132L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("withMaps", 0);
		req.setAttribute("isList", 1);
		req.setAttribute("isForm", 0);
		req.setAttribute("withSelect2", 0);

		ProductionService ps = new ProductionService();
		req.setAttribute("productions", ps.list());
		req.getRequestDispatcher("production-list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductionService ps = new ProductionService();

		int id = Integer.parseInt(req.getParameter("id"));
		boolean active = Boolean.parseBoolean(req.getParameter("active"));

		 System.out.println("id: " + id);
		 System.out.println("active: " + active);

		String msg;
		switch (ps.toggleCheck(id, active)) {
			case "ER-TC01":
				msg = "ERROR: al cambiar el estado, vuelve a intentarlo";
				break;
			default:
				msg = "OK: Estado actualizado";
				break;
		}
		resp.setContentType("Text/plain");
		resp.getWriter().write(msg);
	}
}