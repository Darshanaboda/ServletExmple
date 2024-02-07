package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.servlet.emp;

/**
 * Servlet implementation class saveservlet
 */
public class saveservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		  PrintWriter out=response.getWriter();
		  

			String i = request.getParameter("id");
			int id = Integer.parseInt(i);
		    String name=request.getParameter("name");
		   
		    emp sb = new emp(id,name);
			
			sb.setId(id);
			sb.setName(name);
			 int status=empdao.save(sb); 
		        if (status>0)
		        {
		        	System.out.print("<p> Record Succesfully save </p>");
		        	request.getRequestDispatcher("index.html").include(request, response);
		        }
		        else
		        {
		        	System.out.println("Soory! unable to save youre records");
		        }
		        response.sendRedirect ("viewservlet");
		      //  out.print("<a href=\"viewservlet\">view employees</a>");
		        out.close();
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
