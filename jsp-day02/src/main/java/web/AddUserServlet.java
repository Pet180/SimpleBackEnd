package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;

public class AddUserServlet extends HttpServlet{

	public AddUserServlet() {
		System.out.println("AddUserServlet的構造方法");
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddUserServlet.service()");
		//處理表單中文參數
		request.setCharacterEncoding("utf-8");
		//輸出中文
		response.setContentType("text/html;charset=utf-8");
		
		//取得用戶信息
		String username = request.getParameter("username");
//		System.out.println(username);
		String pwd = request.getParameter("pwd");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		
		//將用戶信息插入到數據庫
		try {
			UserDAO dao = new UserDAO();
			User user = new User();
			user.setUname(username);
			user.setPwd(pwd);
			user.setPhone(telephone);
			user.setEmail(email);
			dao.save(user);
			//response.getWriter().println("添加成功");
			//添加重定向到用戶列表
			response.sendRedirect("list");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("系統繁忙，稍候重試!");
		}
		
		
	}
	
}
