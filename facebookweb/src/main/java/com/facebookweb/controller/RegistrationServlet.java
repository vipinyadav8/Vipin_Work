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


public class RegistrationServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		
		facebookWebUser u =new facebookWebUser();
		u.setUserename(name);
		u.setPassword(password);
		u.setEmail(email);
		u.setAddress(address);;
		
		facebookwebServiceInterface s = facebookwebService.createObject();
		int k = s.createProfile(u);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
		if(k>0) {
			out.println("Profile created successfully <a href=login.html>Login here</a>");
		}
		out.println("</body></html>");
	}

}
