package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.User;

@WebServlet("/signup")
public class Signup extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	User user=new User();
	user.setEmail(req.getParameter("email"));
	user.setMobile(Long.parseLong(req.getParameter("phone")));
	user.setName(req.getParameter("name"));
	user.setPassword(req.getParameter("password"));
	
	UserDao dao=new UserDao();
	dao.signup(user);
	
	resp.setContentType("text/html");
	resp.getWriter().print("Account Created Successfully");
	
	req.getRequestDispatcher("Login.html").include(req, resp);
	
}
}
