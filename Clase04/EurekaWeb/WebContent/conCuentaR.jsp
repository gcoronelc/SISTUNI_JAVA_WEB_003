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
  <h1>RESULTADO</h1>
  
  <c:if test="${error != null}">
    <p class="egcc_error">${error}</p>
  </c:if>
  
  <c:if test="${rec != null}">
	  <table>
	    <tr>
	      <td>Cuenta:</td>
	      <td>${rec.CUENTA}</td>
	    </tr>
	    <tr>
	      <td>Sucursal:</td>
	      <td>${rec.SUCURSAL}</td>
	    </tr>
	    <tr>
	      <td>Cliente:</td>
	      <td>${rec.CLIENTE}</td>
	    </tr>
	    <tr>
	      <td>Moneda:</td>
	      <td>${rec.MONEDA}</td>
	    </tr>
	    <tr>
	      <td>Saldo:</td>
	      <td>${rec.SALDO}</td>
	    </tr>
	    <tr>
	      <td>Creada el:</td>
	      <td>${rec.FECHA}</td>
	    </tr>
	    <tr>
	      <td>Estado:</td>
	      <td>${rec.ESTADO}</td>
	    </tr>
	    <tr>
	      <td>Movimientos:</td>
	      <td>${rec.MOVS}</td>
	    </tr>  
	  </table>
  </c:if>

</body>
</html>