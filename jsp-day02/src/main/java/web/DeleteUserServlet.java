package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

public class DeleteUserServlet extends HttpServlet{

	public DeleteUserServlet() {
		System.out.println("DeleteUserServlet的構造器");
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DeleteUserServlet.service()");
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		UserDAO dao = new UserDAO();
		try {
			dao.delete(Integer.parseInt(id));
			//Redirection
			response.sendRedirect("list");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("系統繁忙，稍候重試");
		}
		
	}
	
}
