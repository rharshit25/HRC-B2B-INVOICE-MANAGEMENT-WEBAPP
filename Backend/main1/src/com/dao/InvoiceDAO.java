package com.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pojo.InvoicePojo;



public class InvoiceDAO {
	
	final private String AddSQL="INSERT INTO winter_internship(business_code, cust_number, clear_date, buisness_year,"
			+ "doc_id,posting_date,document_create_date,due_in_date,invoice_currency,document_type,posting_id,total_open_amount,"
			+ "baseline_create_date,cust_payment_terms,invoice_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
	
	final private String Sql_updatequery= "update winter_internship SET invoice_currency=?, cust_payment_terms=? where sl_no =?";
	
	final private String Sql_deletequery = "delete from winter_internship where sl_no=?";
	
	final private String Sql_searchquery = "select * from winter_internship where cust_number=?";
	
	final private String Sql_advancesearchquery = "select * from winter_internship where doc_id=? and cust_number=? and invoice_id=? and buisness_year=?";

	
	public Connection getConnection()
	{
		 Connection conn =null;
		 String url ="jdbc:mysql://localhost:3306/grey_goose";
		 String user = "root";
		 String pass ="stavros@25";
			
			
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn =DriverManager.getConnection(url,user,pass);
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				return conn;

		}
	
	public ArrayList<InvoicePojo> getData()
	{
		ArrayList<InvoicePojo> ALLInvoice =new ArrayList<InvoicePojo>();
	
		try {
		 Connection conn = getConnection();
		 String sql_query="SELECT * from winter_internship LIMIT 200 OFFSET 0" ;
		 PreparedStatement pst = conn.prepareStatement(sql_query);
		 //System.out.println(pst);
		 
		 ResultSet rs = pst.executeQuery();
		
		 while(rs.next())
		 {
			 InvoicePojo s = new InvoicePojo();
			 	
				
				
				
				s.setSl_no(rs.getInt("sl_no"));
				s.setBusiness_code(rs.getString("business_code"));
				s.setCust_number(rs.getLong("cust_number"));
				s.setClear_date(rs.getString("clear_date"));
				s.setBuisness_year(rs.getInt("buisness_year"));
				s.setDoc_id(rs.getLong("doc_id"));
				s.setPosting_date(rs.getString("posting_date"));
				s.setDocument_create_date(rs.getString("document_create_date"));
				s.setDue_in_date(rs.getString("due_in_date"));
				s.setInvoice_currency(rs.getString("invoice_currency"));
				s.setDocument_type(rs.getString("document_type"));
				s.setPosting_id(rs.getInt("posting_id"));
				s.setTotal_open_amount(rs.getFloat("total_open_amount"));
				s.setBaseline_create_date(rs.getString("baseline_create_date"));
				s.setCust_payment_terms(rs.getString("cust_payment_terms"));
				s.setInvoice_id(rs.getLong("invoice_id"));
				
				
				ALLInvoice.add(s);
				
				
				
		 }
		 
		
		 
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception occur");
		}
		
		return ALLInvoice;
		
	
	}
	
	public void AddInvoice (InvoicePojo Invoice ) {
		try {
			 Connection conn = getConnection();
			
			 PreparedStatement pst = conn.prepareStatement(AddSQL);
			 pst.setString(1,Invoice.getBusiness_code());
			 pst.setLong(2,Invoice.getCust_number());
			 pst.setDate(3, Date.valueOf(Invoice.getClear_date()));
			 pst.setInt(4,Invoice.getBuisness_year());
			 pst.setLong(5,Invoice.getDoc_id());
			 pst.setDate(6, Date.valueOf(Invoice.getPosting_date()));
			 pst.setDate(7, Date.valueOf(Invoice.getDocument_create_date()));
			 pst.setDate(8, Date.valueOf(Invoice.getDue_in_date()));
			 pst.setString(9,Invoice.getInvoice_currency());
			 pst.setString(10,Invoice.getDocument_type());
			 pst.setInt(11,Invoice.getPosting_id());
			 pst.setFloat(12,Invoice.getTotal_open_amount());
			 pst.setDate(13, Date.valueOf(Invoice.getBaseline_create_date()));
			 pst.setString(14,Invoice.getCust_payment_terms());
			 pst.setLong(15,Invoice.getInvoice_id());
			 
			 System.out.println(pst.toString());
			 
			 pst.executeUpdate();
			 
			}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception occur");
		}
	}
	
	
	
	public void UpdateInvoice (int Sl_no, String Invoice_currency, String Cust_payment_terms) {
		try {
			 Connection conn = getConnection();
			 
			 PreparedStatement pst = conn.prepareStatement(Sql_updatequery);
			 pst.setString(1,Invoice_currency);
			 pst.setString(2,Cust_payment_terms);
			 pst.setInt(3,Sl_no);
			 pst.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception occur");
		}
	}
	
	public void DeleteInvoice (int Sl_no) {
		try {
			 Connection conn = getConnection();
			 
			 PreparedStatement pst = conn.prepareStatement(Sql_deletequery);
			 
			 pst.setInt(1,Sl_no);
			 pst.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception occur");
		}
		
	}
	
	public ArrayList<InvoicePojo> 	SearchInvoice(long cust_number)
	{
		ArrayList<InvoicePojo> ALLInvoice =new ArrayList<InvoicePojo>();
	
		try {
		 Connection conn = getConnection();
		 
		 PreparedStatement pst = conn.prepareStatement(Sql_searchquery);
		 //System.out.println(pst);
		 pst.setLong(1,cust_number);
		 System.out.println(pst.toString());
		 ResultSet rs = pst.executeQuery();
		
		 while(rs.next())
		 {
			 InvoicePojo s = new InvoicePojo();
			 	
				
				
				
				s.setSl_no(rs.getInt("sl_no"));
				s.setBusiness_code(rs.getString("business_code"));
				s.setCust_number(rs.getLong("cust_number"));
				s.setClear_date(rs.getString("clear_date"));
				s.setBuisness_year(rs.getInt("buisness_year"));
				s.setDoc_id(rs.getLong("doc_id"));
				s.setPosting_date(rs.getString("posting_date"));
				s.setDocument_create_date(rs.getString("document_create_date"));
				s.setDue_in_date(rs.getString("due_in_date"));
				s.setInvoice_currency(rs.getString("invoice_currency"));
				s.setDocument_type(rs.getString("document_type"));
				s.setPosting_id(rs.getInt("posting_id"));
				s.setTotal_open_amount(rs.getFloat("total_open_amount"));
				s.setBaseline_create_date(rs.getString("baseline_create_date"));
				s.setCust_payment_terms(rs.getString("cust_payment_terms"));
				s.setInvoice_id(rs.getLong("invoice_id"));
				
				
				ALLInvoice.add(s);
				
				
		 }
		 
		
		 
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception occur");
		}
		
		return ALLInvoice;
		
	
	}
	
	public ArrayList<InvoicePojo> 	AdvanceSearchInvoice(long doc_id, long cust_number, long invoice_id, int buisness_year)
	{
		ArrayList<InvoicePojo> ALLInvoice =new ArrayList<InvoicePojo>();
	
		try {
		 Connection conn = getConnection();
		 
		 PreparedStatement pst = conn.prepareStatement(Sql_advancesearchquery);
		 //System.out.println(pst);
		 pst.setLong(1,doc_id);
		 pst.setLong(2,cust_number);
		 pst.setLong(3,invoice_id);
		 pst.setInt(4,buisness_year);
		 System.out.println(pst.toString());
		 ResultSet rs = pst.executeQuery();
		
		 while(rs.next())
		 {
			 InvoicePojo s = new InvoicePojo();
			 	
				
				
				
				s.setSl_no(rs.getInt("sl_no"));
				s.setBusiness_code(rs.getString("business_code"));
				s.setCust_number(rs.getLong("cust_number"));
				s.setClear_date(rs.getString("clear_date"));
				s.setBuisness_year(rs.getInt("buisness_year"));
				s.setDoc_id(rs.getLong("doc_id"));
				s.setPosting_date(rs.getString("posting_date"));
				s.setDocument_create_date(rs.getString("document_create_date"));
				s.setDue_in_date(rs.getString("due_in_date"));
				s.setInvoice_currency(rs.getString("invoice_currency"));
				s.setDocument_type(rs.getString("document_type"));
				s.setPosting_id(rs.getInt("posting_id"));
				s.setTotal_open_amount(rs.getFloat("total_open_amount"));
				s.setBaseline_create_date(rs.getString("baseline_create_date"));
				s.setCust_payment_terms(rs.getString("cust_payment_terms"));
				s.setInvoice_id(rs.getLong("invoice_id"));
				
				
				ALLInvoice.add(s);
				
				
		 }
		 
		
		 
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception occur");
		}
		
		return ALLInvoice;
		
	
	}
}
