package com.techm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techm.dao.SpocDAO;
import com.techm.model.Job;

/**
 * Servlet implementation class ViewAndEditController
 */
public class SpocViewJobsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpocViewJobsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int val = 0;
		Job job=new Job();
		ArrayList<Job> al = new ArrayList<Job>();
		SpocDAO spdao = new SpocDAO();
		HttpSession session = request.getSession();
		session.setAttribute("username", ((String) session.getAttribute("username")));
		System.out.println((String) session.getAttribute("username"));
		String jobcode=request.getParameter("selected");
		try {
			al = spdao.viewJobDetails(jobcode);
		}

		catch (Exception e) {
		}
		
		Iterator<Job> it= al.iterator();
		while(it.hasNext()){
			job=it.next();
		}
		
		session.setAttribute("jobArrayList", al);
		session.setAttribute("session", "true");
		session.setAttribute("jobDetails", job);
		RequestDispatcher rd = request
				.getRequestDispatcher("/spocUpdateJobs.jsp");
		rd.forward(request, response);

}
}
