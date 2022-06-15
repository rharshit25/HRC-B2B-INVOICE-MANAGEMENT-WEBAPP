package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.InvoiceDAO;

/**
 * Servlet implementation class DeleteInvoiceServlet
 */
@WebServlet("/DeleteInvoiceServlet")
public class DeleteInvoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InvoiceDAO invoicedao = new InvoiceDAO();
		invoicedao.DeleteInvoice(Integer.parseInt(request.getParameter("sl_no")));
	}

}