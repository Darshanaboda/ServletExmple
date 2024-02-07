package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.servlet.emp;
import com.servlet.emp;

/**
 * Servlet implementation class viewservlet
 */
public class viewservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewservlet() {
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
       // out.println("<a href='index.html'>Add New Emp</a>");  
        //out.println("<h1>Employees List</h1>");  
          
      
        
		List<emp> student = empdao.view();
		System.out.println(student);
		for(emp sb : student) {
			
			out.print("<html><body>");
			
			out.print("<table style='border: 1px solid black;padding:10px'>");
			// out.print("<tr><th>Id</th><th>Name<th>Edit</th><th>Delete</th></tr>");  
			//out.print("<tr><th>id</th><th>name</th><th>Delete</th></tr>");
				out.print("<tr><th> Id</th><th> Name</th>"+ "<tr><td>"+sb.getId()+"</td><td>"+sb.getName()+"</td><a href='/CRUDEx/delete?id="+sb.getId()+"'>delete</a><br> <a href='/CRUDEx/editservlet?id="+sb.getId()+"'>edit</a></td></tr>");
				out.print("</table>");                                                                                                 
				out.print("</body></html>");
			


		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
