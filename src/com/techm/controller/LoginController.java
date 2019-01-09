package com.techm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techm.dao.LoginDAO;
import com.techm.model.Login;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

    Login login = new Login();
	LoginDAO dao= new LoginDAO();
	RequestDispatcher rd= null;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		try{
			
			login.setUsername(request.getParameter("username"));
			login.setPassword(request.getParameter("password"));
			
			String role = dao.loginValidation(login);
			if(role.equals("employee")){
				HttpSession sess = request.getSession();
				sess.setAttribute("username", login.getUsername());
				sess.setAttribute("fname",login.getFirstName());
				sess.setAttribute("lname",login.getLastName());
				sess.setAttribute("session", "true");
				rd=request.getRequestDispatcher("employeeHomePage.jsp");
				rd.forward(request, response);
			}else if(role.equals("spoc")){
				HttpSession sess = request.getSession();
				sess.setAttribute("username", login.getUsername());
				sess.setAttribute("fname",login.getFirstName());
				sess.setAttribute("lname",login.getLastName());
				sess.setAttribute("session", "true");
				rd=request.getRequestDispatcher("spocHomePage.jsp");
				rd.forward(request, response);
			}else{
				HttpSession sess = request.getSession();
				sess.setAttribute("loginmsg", null);
				sess.setAttribute("session", "false");
				rd=request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
				out.println("Invalid username or password");
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	}
