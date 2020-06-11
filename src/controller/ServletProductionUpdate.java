package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.entities.Production;
import model.services.ProductionService;

@WebServlet("/production-update")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)   // 50MB
public class ServletProductionUpdate extends HttpServlet{
	private static final long serialVersionUID = 772441833086993599L;
	private static final String UPLOAD_DIRECTORY = "productions";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		// Instancia del servicio y la entidad necesaria
		ProductionService ps = new ProductionService();
		Production p;

		// Se regocen los valores de los campos recibidos.
		int id 				= Integer.parseInt(req.getParameter("id"));
		boolean active 		= Boolean.parseBoolean(req.getParameter("active"));
		String name 		= req.getParameter("name");
		String description 	= req.getParameter("description");
		String cast 		= req.getParameter("cast");
		int type 			= Integer.parseInt(req.getParameter("type"));
		int year 			= Integer.parseInt(req.getParameter("year"));
		String web			= req.getParameter("web");
		String fileName		= "";

		// Se optiene el nombre de la imagen actual
		p = ps.find(id);
		String oldPoster = p.getFilename();

		// Subida de imagenes
		// Ruta de la ubicacioon de los ficheros
		String uploadPath = getServletContext().getRealPath("") + File.separator + "images" + File.separator + UPLOAD_DIRECTORY;
		File uploadDir = new File(uploadPath);

		// Sino existe la carpeta se crea
		if (!uploadDir.exists()) uploadDir.mkdir();

		for (Part part : req.getParts()) {
			// Se optiene el nombre del fichero.
			fileName = getFileName(part);
			System.out.println("FileName Part: " + fileName);

			if (!fileName.isEmpty()) {
				System.out.println("Filename: " + fileName);
				String img[] = fileName.split("\\.");
				for (String i : img) {
					System.out.println("img:" + i);
				}

				// Se crea un tipo de dato file para comprobar si el fichero existe antes de subirlo.
				File fileNew = new File(uploadPath + File.separator + fileName);

				// Se comprueba que no haya un fichero con el mismo nombre, si existiera, se le cambia el nombre para guardarlo.
				fileName = fileNew.exists() ? img[0] + "-1." + img[1] : fileName;
				System.out.println("Filename: " + fileName);
				part.write(uploadPath + File.separator + fileName);
			}
		}

		// Se comprueba si la imagen ha sido modificada.
		fileName = (fileName != "") ? fileName : oldPoster;
		System.out.println("Production id antes: " + id );

		System.out.println("Old image: " + oldPoster);

		p = new Production(id, active, name, year, type, description, cast, web, fileName);
		System.out.println("Production id: " + p.getId());

		String result = ps.update(p);
		// System.out.println(result);
		// Se procesa la respuesta.
		switch (result) {
			case "ER-PU1":
				System.out.println(result);
				req.setAttribute("isForm", 1);
				req.setAttribute("production", p);
				req.setAttribute("msgType", "error");
				req.setAttribute("msg", "Error: La produccion ya se encuentra en la BD");
				req.getRequestDispatcher("production.jsp").forward(req, resp);
				break;
			default:
				if (fileName != "") {
					File file = new File(uploadPath + File.separator + oldPoster);
					if (file.exists()) {
						file.delete();
					}
				}
				req.setAttribute("msgType", "ok");
				req.setAttribute("msg", "Elemento actualizado correctamente");

				req.setAttribute("withMaps", 0);
				req.setAttribute("isList", 1);
				req.setAttribute("isForm", 0);
				req.setAttribute("withSelect2", 0);

				req.setAttribute("productions", ps.list());
				req.getRequestDispatcher("production-list.jsp").forward(req, resp);
				break;
		}
	}

	private String getFileName(Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename"))
				return content.substring(content.indexOf("=") + 2, content.length() - 1);
			}
		return "";
	}
}