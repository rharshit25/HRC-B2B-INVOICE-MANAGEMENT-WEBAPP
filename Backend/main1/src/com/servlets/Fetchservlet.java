package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.InvoiceDAO;
import com.google.gson.Gson;
import com.pojo.InvoicePojo;


@WebServlet("/fetchservlet") 
public class Fetchservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InvoiceDAO fetchdata=new InvoiceDAO();
		 
		 ArrayList<InvoicePojo> data = fetchdata.getData();
		  //System.out.println(data);
		  	
		  	Gson gson = new Gson();
			String respData = gson.toJson(data);
			
			
			response.setHeader("Access-Control-Allow-Origin", "*");
			
			
			response.getWriter().print(respData);
	}


	

}