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
  <h2>LISTADO DE VENTAS</h2>
  <table border="1">
  
    <tr>
      <th>CLIENTE</th>
      <th>PRODUCTO</th>
      <th>PRECIO</th>
      <th>CANTIDAD</th>
      <th>IMPORTE</th>
    </tr>
    
    <c:forEach items="${carrito.lista}" var="r">
	    <tr>
	      <td>${r.cliente}</td>
	      <td>${r.producto}</td>
	      <td>${r.precio}</td>
	      <td>${r.cant}</td>
	      <td>${r.importe}</td>
	    </tr>
    </c:forEach>
    
  </table>
</body>
</html>