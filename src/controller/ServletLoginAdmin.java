package controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entities.User;
import model.services.LoginUser;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class ServletLoginAdmin extends HttpServlet {
	private static final long serialVersionUID = 313045378965602880L;

	/**
	 * Gestiona el Login de los administradores a la Backend de la App
	 *
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		// Se captura los datos del formulario.
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");

		// Se crea una instancia de Usuario y paso el Email
		User user = new User();
		user.setEmail(email);

		// System.out.println("Srvl email: " + user.getEmail());
		// System.out.println("Srvl pass: " + pass);

		// Se instancia el gestor de Login
		LoginUser lu = new LoginUser();

		// Se recoge la respusesta
		String result;
		try {
			result = lu.loginAdmin(user, pass);
		} catch (NoSuchAlgorithmException e) {
			result = "ER-U00";
			e.printStackTrace();
		}

		System.out.println("Srvl result: " + result);

		// Gestiono la respuesta.
		switch (result) {
			case "ER-U00":
				req.setAttribute("msgType", "error");
				req.setAttribute("msg", "Error de la App");
				req.setAttribute("email", user);
				req.getRequestDispatcher("index.jsp").forward(req, resp);
				break;
			case "ER-U01":
				req.setAttribute("msgType", "error");
				req.setAttribute("msg", "El email no es correcto");
				req.setAttribute("email", user);
				req.getRequestDispatcher("index.jsp").forward(req, resp);
				break;
			case "ER-U02":
				req.setAttribute("msgType", "error");
				req.setAttribute("msg", "La contraseña no es correcta");
				req.setAttribute("email", user);
				req.getRequestDispatcher("index.jsp").forward(req, resp);
				break;
			default:
				String url = req.getRequestURL().toString();				
				req.setAttribute("url", url);
				req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
				break;
		}
	}
}
