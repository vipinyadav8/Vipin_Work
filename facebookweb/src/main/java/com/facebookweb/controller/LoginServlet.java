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
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		facebookWebUser f = new facebookWebUser();
		f.setUserename(name);
		f.setPassword(password);
		
		facebookwebServiceInterface s = facebookwebService.createObject();
		boolean k = s.loginProfile(f);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
		if(k) {
			out.println("Welcome "+name);
			out.println("View a profile <a href=search.html>Click here</a>");
			out.println("Edit a profile <a href=edit.html>Click here</a>");
			out.println("Delete a profile <a href=delete.html>Click here</a>");
		}
		else {
			out.println("Invalid Id and password <a href=login.html>Try Again</a>");
		}
		out.println("</body></html>");
	}

}
