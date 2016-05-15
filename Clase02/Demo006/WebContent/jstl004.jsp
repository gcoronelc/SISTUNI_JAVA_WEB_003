<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1>FOR EACH</h1>
  <c:set var="n1" value="20"/>
  <c:set var="n2" value="30"/>
  <c:set var="suma" value="${n1 + n2}"/>
  
  <p>Número 1: ${n1}</p>
  <p>Número 2: ${n2}</p>
  <p>Suma: ${suma}</p>
  
</body>
</html>

