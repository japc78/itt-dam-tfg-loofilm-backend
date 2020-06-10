package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class ServletHome extends HttpServlet{
	private static final long serialVersionUID = -1696553553951560130L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("withMaps", 0);
		req.setAttribute("isForm", 0);
		req.setAttribute("isList", 0);
		req.setAttribute("withSelect2", 0);

		req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
	}
}