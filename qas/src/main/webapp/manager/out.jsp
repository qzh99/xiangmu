<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%  
session.removeAttribute("currentuser");  //清空Session变量  
response.sendRedirect("../login.html");  
%>  