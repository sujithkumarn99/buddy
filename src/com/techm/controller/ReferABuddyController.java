package com.techm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techm.dao.EmpDAO;
import com.techm.model.Referral;

/**
 * Servlet implementation class ReferABuddyController
 */
public class ReferABuddyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReferABuddyController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd=null;
		PrintWriter out=response.getWriter();
		Referral ref= new Referral();
		System.out.println("controllerRID----------"+request.getParameter("referralid")+"--------------");
		ref.setReferralId(request.getParameter("referralid"));
		ref.setJobcode(request.getParameter("jobCode"));
		ref.setBuddyName(request.getParameter("buddyName"));
		ref.setBuddyMobNo(request.getParameter("buddyMobileNo"));
		ref.setSkill(request.getParameter("skill"));
		ref.setExperience(request.getParameter("exp1")+"-"+request.getParameter("exp2")+"years");
		ref.setUsername(request.getParameter("username"));
		HttpSession session = request.getSession();
		session.setAttribute("username", ((String) session.getAttribute("username")));
		System.out.println((String) session.getAttribute("username"));
		EmpDAO dao = new EmpDAO();
		
			int x = dao.referABuddy(ref);
		
		if (x == 1) {
			rd=request.getRequestDispatcher("/ViewAvailableJobsController");
			rd.include(request, response);
				out.println("Refered Successfully");
		}else{
			rd=request.getRequestDispatcher("/ViewAvailableJobsController");
			rd.include(request, response);
			out.println("enter valid data");
		}
	}

}
