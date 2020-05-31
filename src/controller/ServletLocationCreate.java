package controller;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.eclipse.persistence.jpa.jpql.parser.AdditionExpression;
import org.omg.CORBA.portable.InputStream;

import model.entities.City;
import model.entities.Country;
import model.entities.County;
import model.entities.Location;
import model.services.LocationService;

/**
 * Servlet implementation class ServletLocationCreate
 */

@WebServlet("/location-create")
@MultipartConfig
public class ServletLocationCreate extends HttpServlet {
	private static final long serialVersionUID = 4089613927822307019L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("withMaps", 1);
		req.setAttribute("isForm", 1);
		req.setAttribute("isList", 0);
		req.setAttribute("withSelect2", 0);

		req.getRequestDispatcher("location-create.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		// Se instancia las entidades y servicios necesarios.
		LocationService ls = new LocationService();

		// TODO Subida de ficheros. Solo uno.
		// Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
		// String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
		// InputStream fileContent = (InputStream) filePart.getInputStream();

		String name 		= req.getParameter("name");
		String description 	= req.getParameter("description");
		String street 		= req.getParameter("street");
		String web			= req.getParameter("web");
		String email		= req.getParameter("email");
		String phone		= req.getParameter("phone");

		String city = req.getParameter("locality");
		String postal_code = req.getParameter("postal_code");
		String county = req.getParameter("administrative_area_level_2");
		String country = req.getParameter("country");
		String countryCode = req.getParameter("countryCode");
		String gps = ls.gpsFormat(req.getParameter("gps"));


		// TODO Subida de ficheros. Multiple.
		// Retrieves <input type="file" name="file" multiple="true">
		// List<Part> fileParts = request.getParts().stream().filter(part -> "file".equals(part.getName()) && part.getSize() > 0).collect(Collectors.toList());

		// for (Part filePart : fileParts) {
		// 	// MSIE fix.
		// 	String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

		// 	InputStream fileContent = (InputStream) filePart.getInputStream();
		// 	// ... (do your job here)
		// }

		Country c = new Country(countryCode , country);
		County co = new County(county);
		City ci = new City(city);

		Location l = new Location();

		l.setName(name);
		l.setDescription(description);
		l.setStreet(street);
		l.setPostalcode(postal_code);
		l.setWeb(web);
		l.setEmail(email);
		l.setPhone(phone);
		l.setGps(gps);

		// System.out.println(l.toString());
		// System.out.println(c.toString());
		// System.out.println(co.toString());
		// System.out.println(ci.toString());

		// c = countryService.add(c);
		// System.out.println("ServletLocation - Pais: " + c.getCountryCode() + " - " + c.getCountry());
		// co = countyService.add(co, c);
		// System.out.println("ServletLocation - Provincia: " + co.toString());
		// System.out.println(co.getId());
		// ci = cityService.add(ci, co);
		// System.out.println(ci.getCity());

		String result = ls.add(l,ci,co,c);
		System.out.println(result);

		// Se procesa la respuesta.
		switch (result) {
			case "ER-L00":
				req.setAttribute("msgType", "error");
				req.setAttribute("msg", "Error: La localizacion ya se encuentra en la BD");
				req.getRequestDispatcher("location-create.jsp").forward(req, resp);
				break;
			default:
				req.getRequestDispatcher("location-list.jsp").forward(req, resp);
				break;
		}

		// Modo pruebas
		// request.getRequestDispatcher("location-create.jsp").forward(request, response);
	}
}
