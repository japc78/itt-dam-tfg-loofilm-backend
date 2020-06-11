package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entities.Location;
import model.entities.LocationsMedia;
import model.services.LocationService;

/**
 * ServletLocation
 */
@WebServlet("/location")
public class ServletLocation extends HttpServlet{
	private static final long serialVersionUID = -3602943763187489779L;
	private static final String UPLOAD_DIRECTORY = "locations";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LocationService ls = new LocationService();

		String page = req.getParameter("page");

		req.setAttribute("withMaps", 1);
		req.setAttribute("isList", 0);
		req.setAttribute("isForm", 1);
		req.setAttribute("withSelect2", 0);


		int id = Integer.parseInt(req.getParameter("id"));

		Location l = new Location();
		l = ls.find(id);

		req.setAttribute("location", l);

		for (LocationsMedia img : l.getLocationsMedias()) {
			System.out.println(img.getFilename());
		}

		String path = getServletContext().getContextPath() + File.separator + "images" + File.separator + UPLOAD_DIRECTORY + File.separator;

		req.setAttribute("path", path);

		if (page.equals(page)) {
			req.getRequestDispatcher("location-view.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("location.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}