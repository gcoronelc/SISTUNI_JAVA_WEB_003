<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RESULTADO</title>
</head>
<body>

  <h1><%= request.getAttribute("opera") %></h1>

  <p>Número 1: <%= request.getAttribute("num1") %></p>
  <p>Número 2: <%= request.getAttribute("num2") %></p>
  <p>Resultado: <%= request.getAttribute("rpta") %></p>

</body>
</html>