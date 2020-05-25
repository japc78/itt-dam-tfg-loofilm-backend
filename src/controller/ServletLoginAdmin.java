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
@WebServlet("/loginadmin")
public class ServletLoginAdmin extends HttpServlet {
	private static final long serialVersionUID = 313045378965602880L;

	/**
	 * Gestiona el Login de los administradores a la Backend de la App
	 *
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Se captura los datos del formulario.
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");

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
				request.setAttribute("msgType", "error");
				request.setAttribute("msg", "Error de la App");
				request.setAttribute("email", user);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				break;
			case "ER-U01":
				request.setAttribute("msgType", "error");
				request.setAttribute("msg", "El email no es correcto");
				request.setAttribute("email", user);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				break;
			case "ER-U02":
				request.setAttribute("msgType", "error");
				request.setAttribute("msg", "La contraseña no es correcta");
				request.setAttribute("email", user);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				break;
			default:
				request.getRequestDispatcher("dashboard.jsp").forward(request, response);
				break;
		}

	}
}
