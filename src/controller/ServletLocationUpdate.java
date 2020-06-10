package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.entities.City;
import model.entities.Country;
import model.entities.County;
import model.entities.Location;
import model.entities.LocationsMedia;
import model.services.LocationService;
import model.services.LocationsMediaService;
@WebServlet("/location-update")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)   // 50MB
public class ServletLocationUpdate extends HttpServlet {
	private static final long serialVersionUID = -1952783503110422356L;
	private static final String UPLOAD_DIRECTORY = "locations";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		// Se instancia las entidades y servicios necesarios.
		LocationService ls = new LocationService();
		LocationsMediaService lms = new LocationsMediaService();

		System.out.println("id " + req.getParameter("id"));

		int id 				= Integer.parseInt(req.getParameter("id"));
		boolean active 		= Boolean.parseBoolean(req.getParameter("active"));
		String name 		= req.getParameter("name");
		String description 	= req.getParameter("description");
		String street 		= req.getParameter("street");
		String web			= req.getParameter("web");
		String email		= req.getParameter("email");
		String phone		= req.getParameter("phone");
		String city			= req.getParameter("locality");
		String postal_code 	= req.getParameter("postal_code");
		String county 		= req.getParameter("administrative_area_level_2");
		String country 		= req.getParameter("country");
		String countryCode 	= req.getParameter("countryCode");
		String gps 			= req.getParameter("gps");

		List<LocationsMedia> images = new ArrayList<>();

		Country c = new Country(countryCode , country);
		County co = new County(county);
		City ci = new City(city);

		Location l = new Location(id, active, name, description, email, gps, phone, postal_code, street, web, ci);


		// Subida de ficheros
		String uploadPath = getServletContext().getRealPath("") + File.separator + "images" + File.separator + UPLOAD_DIRECTORY;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) uploadDir.mkdir();

		for (Part part : req.getParts()) {
			// Se optiene el nombre del fichero.
			String fileName = getFileName(part);

			if (!fileName.isEmpty()) {
				System.out.println("Filename: " + fileName);
				String img[] = fileName.split("\\.");
				for (String i : img) {
					System.out.println("img:" + i);
				}
				// Se comprueba que no haya un fichero con el mismo nombre, si existiera, se le cambia el nombre para guardarlo.
				fileName = lms.existsImage(fileName) ? img[0] + "-1." + img[1] : fileName;
				System.out.println("Filename: " + fileName);
				images.add(new LocationsMedia(fileName, l));
				part.write(uploadPath + File.separator + fileName);
			}
		}

		l.setLocationsMedias(images);

		String result = ls.update(l,ci,co,c);
		System.out.println(result);

		// Se procesa la respuesta.
		switch (result) {
			case "ER-L00":
				req.setAttribute("msgType", "error");
				req.setAttribute("msg", "Error: La localizacion ya se encuentra en la BD");
				req.getRequestDispatcher("location-create.jsp").forward(req, resp);
				break;
			default:
				req.setAttribute("msgType", "ok");
				req.setAttribute("msg", "Elemento añadido correctamente");

				req.setAttribute("withMaps", 0);
				req.setAttribute("isList", 1);
				req.setAttribute("isForm", 0);
				req.setAttribute("withSelect2", 0);

				req.setAttribute("locations", ls.list());
				req.getRequestDispatcher("location-list.jsp").forward(req, resp);
				break;
		}

		// Modo pruebas
		// request.getRequestDispatcher("location-create.jsp").forward(request, response);
	}

	/**
     * Metodo que extrae del HTTP header el nombre del fichero.
    */
	private String getFileName(Part part) {
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename"))
	            return content.substring(content.indexOf("=") + 2, content.length() - 1);
	        }
	    return "";
	}
}