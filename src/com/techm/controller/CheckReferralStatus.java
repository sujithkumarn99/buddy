package com.techm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techm.dao.EmpDAO;
import com.techm.model.Referral;

/**
 * Servlet implementation class CheckReferralStatus
 */
public class CheckReferralStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckReferralStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int val = 0;
		ArrayList<Referral> al = new ArrayList<Referral>();
		EmpDAO dao = new EmpDAO();
		HttpSession session = request.getSession();
		String username=(String) session.getAttribute("username");
		session.setAttribute("username",
				((String) session.getAttribute("username")));
		System.out.println((String) session.getAttribute("username"));
		try {
			al = dao.checkReferralStatus(username);
		}

		catch (Exception e) {
		}

		session.setAttribute("listOfBuddy", al);
		session.setAttribute("session", "true");
		RequestDispatcher rd = request
				.getRequestDispatcher("/checkReferralStatus.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
