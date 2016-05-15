<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/estilos.css" />
<style type="text/css">
  #LOGON{
    width: 350px;
    margin: 10px auto;
    border: 2px #0080FF solid;
    padding: 5px;
  }
</style>
<title>Insert title here</title>
</head>
<body>

  <div id="LOGON">
    <h1>INGRESO AL SISTEMA</h1>
    
    <c:if test="${error != null}">
      <p class="egcc_error">${error}</p>
    </c:if>
    
    <form method="post" action="LogonIngreso">
      <fieldset style="padding: 5px;">
        <legend>Datos de Logueo</legend>
        <label>Usuario:</label>
        <input type="text" name="usuario" /><br/>
        <label>Clave:</label>
        <input type="password" name="clave" /><br/>
        <input type="submit" value="Ingresar" />
      </fieldset>
    </form>
  </div>
 
</body>
</html>