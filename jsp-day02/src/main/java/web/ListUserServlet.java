package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;

public class ListUserServlet extends HttpServlet{

	public ListUserServlet() {
		System.out.println("ListUserServlet的構造方法");
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ListUserServlet.service()");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		UserDAO dao = new UserDAO();
		try {
			List<User> users = dao.findAll();
			//1.先綁定到request對象
			request.setAttribute("users", users);
			//2.獲得轉發器
			RequestDispatcher rd = request.getRequestDispatcher("listUsers.jsp");
			//3.forward()
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			out.println("系統繁忙，稍候重試！");
		}
	}
	
}
