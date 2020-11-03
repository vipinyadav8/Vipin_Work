package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebookweb.Service.facebookwebService;
import com.facebookweb.Service.facebookwebServiceInterface;
import com.facebookweb.entity.facebookWebUser;

/**
 * Servlet implementation class ViewServlet
 */
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		
		facebookWebUser f = new facebookWebUser();
		f.setEmail(email);
		
		facebookwebServiceInterface s = facebookwebService.createObject();
		facebookWebUser k = s.viewProfile(f);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
		if(k!=null) {
			out.println("Name: "+k.getUserename());
			out.println("Password: "+k.getPassword());
			out.println("Email: "+k.getEmail());
			out.println("Address: "+k.getAddress());
			out.println("</body></html>");
		}
		else {
			out.println("User not found");
		}
	}

}
