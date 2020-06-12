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

import model.entities.Location;
import model.entities.Production;
import model.entities.Scene;
import model.entities.ScenesMedia;
import model.services.LocationService;
import model.services.ProductionService;
import model.services.SceneService;
import model.services.ScenesMediaService;

@WebServlet("/scene-create")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)
public class ServletSceneCreate extends HttpServlet {
	private static final long serialVersionUID = 4000751667389489942L;
	private static final String UPLOAD_DIRECTORY = "scenes";

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
		ScenesMediaService sms = new ScenesMediaService();
		LocationService ls = new LocationService();
		ProductionService ps = new ProductionService();

		// Objetos necesarios
		Location location = new Location();
		Production production = new Production();
		Scene s;

		// Se regocen los valores de los campos recibidos.
		int idLocation 				= Integer.parseInt(req.getParameter("location"));
		int idProduction 			= Integer.parseInt(req.getParameter("production"));
		String name 				= req.getParameter("name");
		String description 			= req.getParameter("description");
		String video				= req.getParameter("video");
		List<ScenesMedia> images 	= new ArrayList<>();

		// System.out.println("Localizacion Id: " +  idLocation);
		// System.out.println("Produccion Id: " +  idProduction);

		location = ls.find(idLocation);
		production = ps.find(idProduction);

		s = new Scene(location, production, name, description, video);

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
				fileName = sms.existsImage(fileName) ? img[0] + "-1." + img[1] : fileName;
				System.out.println("Filename: " + fileName);
				images.add(new ScenesMedia(fileName, s));
				part.write(uploadPath + File.separator + fileName);
			}
		}

		s.setScenesMedias(images);

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
				req.setAttribute("msgType", "ok");
				req.setAttribute("msg", "Elemento añadido correctamente");

				req.setAttribute("withMaps", 0);
				req.setAttribute("isList", 1);
				req.setAttribute("isForm", 0);
				req.setAttribute("withSelect2", 0);

				req.setAttribute("scenes", ss.list());
				req.getRequestDispatcher("scene-list.jsp").forward(req, resp);
				break;
		}
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