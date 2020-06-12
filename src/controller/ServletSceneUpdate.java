package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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

@WebServlet("/scene-update")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)
public class ServletSceneUpdate extends HttpServlet {
	private static final long serialVersionUID = 2964130612854455678L;
	private static final String UPLOAD_DIRECTORY = "scenes";

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
		Scene sUpdate = new Scene();

		// Se regocen los valores de los campos recibidos.
		int id 				= Integer.parseInt(req.getParameter("id"));
		boolean active 		= Boolean.parseBoolean(req.getParameter("active"));
		int idLocation 				= Integer.parseInt(req.getParameter("location"));
		int idProduction 			= Integer.parseInt(req.getParameter("production"));
		String name 				= req.getParameter("name");
		String description 			= req.getParameter("description");
		String video				= req.getParameter("video");
		List<String> oldImg  = (req.getParameterValues("oldimg[]") != null) ? new ArrayList<>(Arrays.asList(req.getParameterValues("oldimg[]"))) : null;

		// Se crea una lista para las imagenes y otra paras las que se van a borrar del servidor.
		List<ScenesMedia> images 	= new ArrayList<>();
		List<ScenesMedia> delImages = new ArrayList<>();

		location = ls.find(idLocation);
		production = ps.find(idProduction);

		sUpdate = new Scene(id, active, location, production, name, description, video);

		s = ss.find(id);

		// Se añaden las imágenes ya exsitentes.
		if (oldImg != null) {
			for (ScenesMedia img : s.getScenesMedias()) {
				// Se add a la lista si se encuentra en los datos recibidos.
				if (oldImg.contains(String.valueOf(img.getId()))) {
					images.add(img);
				} else {
					delImages.add(img);
				}
			}
		}

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

		sUpdate.setScenesMedias(images);

		// Se añade y se procesa la respuesta.
		switch (ss.update(sUpdate)) {
			case "ER-SU1":
				req.setAttribute("withMaps", 1);
				req.setAttribute("isForm", 1);
				req.setAttribute("withSelect2", 1);

				req.setAttribute("locations", sUpdate);

				req.setAttribute("msgType", "error");
				req.setAttribute("msg", "Error: Ha habido un problema con la aplicación, vuelve a intentarlo");
				req.getRequestDispatcher("location.jsp").forward(req, resp);
				break;
			default:
				for (ScenesMedia img : delImages) {
					File file = new File(uploadPath + File.separator + img.getFilename());
					if (file.exists()) {
						file.delete();
					}
				}

				req.setAttribute("msgType", "ok");
				req.setAttribute("msg", "Elemento añadido correctamente");
				req.setAttribute("isList", 1);
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