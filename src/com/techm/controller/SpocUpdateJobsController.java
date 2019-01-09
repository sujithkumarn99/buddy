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
 * Servlet implementation class EditJobController
 */
public class SpocUpdateJobsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpocUpdateJobsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int x=0;
		RequestDispatcher rd=null;
		PrintWriter out=response.getWriter();
		Job job= new Job();
		job.setJobcode(request.getParameter("jobCode"));
		job.setSkill(request.getParameter("skill"));
		job.setExp(request.getParameter("exp1")+"-"+request.getParameter("exp2")+"years");
		job.setLocation(request.getParameter("location"));
		SpocDAO dao= new SpocDAO();
		x=dao.updateJobDetails(job);
		if (x == 1) {
			rd=request.getRequestDispatcher("/SpocViewAndUpdateJobsController");
			rd.include(request, response);
				out.println("Job Updated Successfully");
		}else{
			rd=request.getRequestDispatcher("/SpocViewAndUpdateJobsController");
			rd.include(request, response);
			out.println("enter valid data");
		}

	}

}
