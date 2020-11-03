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
 * Servlet implementation class EditServlet
 */
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		
		facebookWebUser f = new facebookWebUser();
		f.setUserename(email);
		
		facebookwebServiceInterface s = facebookwebService.createObject();
		int k = s.editProfile(f);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
		if(k>0) {
			out.println("Profile edited successfully");
		}
		else {
			out.println("No Profile with such email <a href=login.html>Try Again</a>");
		}
		out.println("</body></html>");
	}

}
