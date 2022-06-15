package com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.InvoiceDAO;
import com.google.gson.Gson;
import com.pojo.InvoicePojo;

/**
 * Servlet implementation class SearchInvoiceServlet
 */
@WebServlet("/SearchInvoiceServlet")
public class SearchInvoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InvoiceDAO invoicedao = new InvoiceDAO();
		ArrayList<InvoicePojo> data = invoicedao.SearchInvoice(Long.parseLong(request.getParameter("cust_number")));
		  //System.out.println(data);
		  	
		  	Gson gson = new Gson();
			String respData = gson.toJson(data);
			
			response.getWriter().print(respData);
	}

	

}
