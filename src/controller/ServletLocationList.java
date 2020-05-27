package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.services.LocationService;

@WebServlet("/location-list")
public class ServletLocationList extends HttpServlet{
	private static final long serialVersionUID = -3293187870097919848L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LocationService ls = new LocationService();
		req.setAttribute(getServletName(), ls.list());
		req.getRequestDispatcher("location-list.jsp").forward(req, resp);
		super.doPost(req, resp);
	}
}