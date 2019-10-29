package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Candy;
import com.revature.services.CandyService;

public class CandyServlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	CandyService candyService = new CandyService();
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws 
			IOException, ServletException {
		ObjectMapper om = new ObjectMapper();
		
		Candy candy = om.readValue(request.getReader(), Candy.class);
		
		candy = candyService.save(candy);
		response.setStatus(201);
		om.writeValue(response.getWriter(), candy);
		
	}
}
