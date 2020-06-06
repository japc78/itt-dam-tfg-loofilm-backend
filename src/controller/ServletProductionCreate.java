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
import model.services.LocationService;
import model.services.ProductionService;

@WebServlet("/production-create")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
maxFileSize = 1024 * 1024 * 5,
maxRequestSize = 1024 * 1024 * 5 * 5)   // 50MB
public class ServletProductionCreate extends HttpServlet{
	private static final long serialVersionUID = -6147400358347687716L;
	private static final String UPLOAD_DIRECTORY = "productions";
	private static final String DEFAULT_FILENAME = "loofilm";


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("withMaps", 0);
		req.setAttribute("isList", 0);
		req.setAttribute("isForm", 1);
		req.setAttribute("withSelect2", 0);

		req.getRequestDispatcher("production-create.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		// Instancia del servicio y la entidad necesaria
		ProductionService ps = new ProductionService();
		Production p;

		// Se regocen los valores de los campos recibidos.
		String name 		= req.getParameter("name");
		int year 			= Integer.parseInt(req.getParameter("year"));
		int type 			= Integer.parseInt(req.getParameter("type"));
		String description 	= req.getParameter("description");
		String cast 		= req.getParameter("cast");
		String web			= req.getParameter("web");

		// Subida de ficheros
		String uploadPath = getServletContext().getRealPath("") + File.separator + "images" + File.separator + UPLOAD_DIRECTORY;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) uploadDir.mkdir();

		for (Part part : req.getParts()) {
			String fileName = getFileName(part);
			System.out.println("filename: " + fileName);
			part.write(uploadPath + File.separator + fileName);
		}

		p = new Production(name, year, type, description, cast, web);
		String result = ps.add(p);
		System.out.println(result);
		// Se procesa la respuesta.
		switch (result) {
			case "ER-P01":
				req.setAttribute("msgType", "error");
				req.setAttribute("msg", "Error: La produccion ya se encuentra en la BD");
				req.getRequestDispatcher("production-create.jsp").forward(req, resp);
				break;
			default:
				req.setAttribute("msgType", "ok");
				req.setAttribute("msg", "Elemento añadido correctamente");

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
	    return DEFAULT_FILENAME;
	}
}