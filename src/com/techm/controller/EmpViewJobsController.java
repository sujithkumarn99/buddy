package com.techm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techm.dao.SpocDAO;
import com.techm.model.Job;

/**
 * Servlet implementation class EmpViewJobsController
 */
public class EmpViewJobsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpViewJobsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int val = 0;
		ArrayList<Job> al = new ArrayList<Job>();
		SpocDAO spdao = new SpocDAO();
		HttpSession session = request.getSession();
		session.setAttribute("username", ((String) session.getAttribute("username")));
		System.out.println((String) session.getAttribute("username"));
		try {
			al = spdao.viewExistingJobs();
		}

		catch (Exception e) {
		}

		session.setAttribute("listOfJobs", al);
		session.setAttribute("session", "true");
		RequestDispatcher rd = request
				.getRequestDispatcher("/empViewJobs.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
