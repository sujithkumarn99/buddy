package com.techm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techm.dao.SpocDAO;
import com.techm.model.Job;

/**
 * Servlet implementation class SpocDeleteJobsController
 */
public class SpocDeleteJobsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpocDeleteJobsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int val = 0;
		SpocDAO dao= new SpocDAO();
		PrintWriter out=response.getWriter();
		RequestDispatcher rd=null;
		System.out.println(request.getParameter("selected"));
		String jobcode = request.getParameter("selected");
		
		val = dao.deleteJobs(jobcode);
		if (val == 1) {
			rd=request.getRequestDispatcher("/SpocViewAndDeleteJobsController");
			rd.include(request, response);
				out.println("Job Deleted Successfully");
		}else{
			rd=request.getRequestDispatcher("/SpocViewAndDeleteJobsController");
			rd.include(request, response);
			out.println("select job to delete");
		}

	}

}
