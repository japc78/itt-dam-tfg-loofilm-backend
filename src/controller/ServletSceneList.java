package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.services.SceneService;

@WebServlet("/scene-list")
public class ServletSceneList extends HttpServlet{
	private static final long serialVersionUID = -1966465052223218872L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("withMaps", 0);
		req.setAttribute("isList", 1);
		req.setAttribute("isForm", 0);
		req.setAttribute("withSelect2", 0);

		SceneService ss = new SceneService();
		req.setAttribute("scenes", ss.list());
		req.getRequestDispatcher("scene-list.jsp").forward(req, resp);
	}
}