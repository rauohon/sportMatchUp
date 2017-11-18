<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.naming.Context"%>
<%
	Connection connection = null;
	
	try{
		Context context = new InitialContext();
		DataSource datasource = 
				(DataSource)context.lookup("java:comp/env/mompommDB");
		connection = datasource.getConnection();
		out.println("DB Connect Successfull");
	}catch(Exception ex){
		out.println("DB Connect Failure");
		ex.printStackTrace();
	}
%>
