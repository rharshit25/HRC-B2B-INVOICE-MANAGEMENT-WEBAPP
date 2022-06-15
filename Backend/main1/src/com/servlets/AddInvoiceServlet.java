package com.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.InvoiceDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pojo.InvoicePojo;
import static java.util.stream.Collectors.joining;


@WebServlet("/AddInvoiceServlet")
public class AddInvoiceServlet extends HttpServlet {

     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	 String json = "";
 		try
 		{
 			json = new BufferedReader(new InputStreamReader(request.getInputStream())).lines().collect(joining("\n"));
 		}
 		catch (Exception e)
 		{
 			response.setStatus(500);
 		}
 		
 		
 		System.out.println(json);
 		
 		Gson gsonbuilder = new GsonBuilder().create();
 		
 		InvoicePojo invoice = gsonbuilder.fromJson(json, InvoicePojo.class);
 		System.out.println(invoice.toString());
 		
 		InvoiceDAO InvoiceDAO = new InvoiceDAO();
 		
 		InvoiceDAO.AddInvoice(invoice);
 		
 		response.setStatus(200);
 
		
		
		
		


	}

}
