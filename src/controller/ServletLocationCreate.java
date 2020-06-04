package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
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
import model.services.LocationService;

/**
 * Servlet implementation class ServletLocationCreate
 */

@WebServlet("/location-create")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)   // 50MB
public class ServletLocationCreate extends HttpServlet {
	private static final long serialVersionUID = 4089613927822307019L;
	private static final String SAVE_DIR = "location";
	private static final String DEFAULT_FILENAME = "loofilm_location";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("withMaps", 1);
		req.setAttribute("isForm", 1);
		req.setAttribute("isList", 0);
		req.setAttribute("withSelect2", 0);

		req.getRequestDispatcher("location-create.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		// Se instancia las entidades y servicios necesarios.
		LocationService ls = new LocationService();

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

		// Subida de ficheros
        // Se optiene la ruta absoluta de la aplicacion
        String appPath = req.getServletContext().getRealPath("");

		// Se crea el path donde se ubicaran los fichros
        String savePath = appPath + File.separator + "images" + File.separator + SAVE_DIR;
		System.out.println("Ruta " + savePath);

        // Se crea el direcctorio sino existe
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        // Sube los ficheros
        for (Part part : req.getParts()) {
			String fileName = extractFileName(part);
			System.out.println("File " + fileName);
            // refines the fileName in case it is an absolute path
            fileName = new File(fileName).getName();
            part.write(fileName);
        }

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
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return DEFAULT_FILENAME;
    }
}
