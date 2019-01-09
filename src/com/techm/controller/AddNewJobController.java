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
 * Servlet implementation class AddNewJobController
 */
public class AddNewJobController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddNewJobController() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Job job = new Job();
		PrintWriter out=response.getWriter();
		RequestDispatcher rd=null;
		System.out.println(request.getParameter("jobCode"));
		job.setJobcode(request.getParameter("jobCode"));
		job.setSkill(request.getParameter("skill"));
		job.setExp(request.getParameter("exp1") + "-" + request.getParameter("exp2") + "years");
		job.setLocation(request.getParameter("location"));
		System.out.println(request.getParameter("spocName"));
		job.setSpocName(request.getParameter("spocName"));
		job.setMailId(request.getParameter("spocEmail"));

		SpocDAO spdao = new SpocDAO();
		int x = spdao.addNewJob(job);
		if (x == 1) {
			rd=request.getRequestDispatcher("/addNewJob.jsp");
			rd.include(request, response);
				out.println("Job Added Successfully");
		}else{
			rd=request.getRequestDispatcher("/addNewJob.jsp");
			rd.include(request, response);
			out.println("enter valid data");
		}

	}

}
