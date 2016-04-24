<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<<c:set var="nombre" value="Gustavo Coronel" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <h1>JSTL - IF</h1>

  <c:if test="${nombre == null}">
    <p>No existe nombre</p>
  </c:if>
  
  <c:if test="${nombre != null}">
    <p>Mi nombre es: ${nombre}</p>
  </c:if>
  
</body>
</html>