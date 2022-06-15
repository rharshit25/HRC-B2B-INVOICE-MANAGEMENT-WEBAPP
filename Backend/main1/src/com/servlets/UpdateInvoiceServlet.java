package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.InvoiceDAO;
import com.google.gson.Gson;

/**
 * Servlet implementation class UpdateInvoiceServlet
 */
@WebServlet("/UpdateInvoiceServlet")
public class UpdateInvoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		InvoiceDAO invoicedao = new InvoiceDAO();
		invoicedao.UpdateInvoice(Integer.parseInt(request.getParameter("sl_no")), request.getParameter("invoice_currency"), request.getParameter("cust_payment_terms"));
		
		PrintWriter out = response.getWriter();
		response.setHeader("Access-Control-Allow-Origin", "*");
		String json = new Gson().toJson(invoicedao);
		out.print(json);
		
	}

}