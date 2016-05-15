<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="seguridad.jsp"/>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/estilos.css" />
<link rel="stylesheet" type="text/css" href="menu/menu.css" />
<script type="text/javascript" src="jquery/jquery.js"></script>
<script type="text/javascript" src="js/utilitario.js"></script>
<title>EUREKA APP</title>
</head>
<body>
  <div id="EGCC_PAGE">
  
    <div id="EGCC_HEAD">
    <table style="width: 100%;">
      <tr>
        <td><img alt="" src="img/logo.gif"> </td>
        <td><img alt="" src="img/eureka.jpg"> </td>
        <td>
        Usuario: ${sessionScope.usuario.usuario}<br>
        <a href="LogonSalir">Salir del Sistema</a>
        </td>
      </tr>
    </table>
    </div>

    <div id="EGCC_MENU">
    <jsp:include page="./menu/menu.jsp"/>
    </div>

    <div id="EGCC_WORK">
    <img alt="" width="600px" src="img/bank.jpg"/>
    </div>
        
  </div>
</body>
</html>