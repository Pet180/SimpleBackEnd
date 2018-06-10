package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
    	System.out.println("LoginServlet的構造器");
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("LoginServlet.service()");
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=UTF-8");
    	String uname = request.getParameter("uname");
    	String pwd = request.getParameter("pwd");
    	UserDAO dao = new UserDAO();
    	User user = dao.find(uname);
    	if (uname!=null && user.getPwd().equals(pwd)) {
    		//轉發到ListUserServlet
			request.getRequestDispatcher("list").forward(request, response);
		}else {
			//登錄錯誤，Redirect到login.jsp頁面。
			response.sendRedirect("login.jsp");
		}
    	
	}

}
