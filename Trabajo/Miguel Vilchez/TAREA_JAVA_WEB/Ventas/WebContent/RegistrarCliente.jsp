<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1>PROCESO CLIENTE</h1>
  <form id="formClient">
    <table> 
      <tr>
        <td>Idcliente:</td>
        <td><input type="text" name="idCliente" /></td>
      </tr>
      <tr>
        <td>Nombre</td>
        <td><input type="text" name="Nombre" /></td>
      </tr>
      <tr>
        <td>Direccion</td>
        <td><input type="text" name="Direccion" /></td>
      </tr>
      <tr>
        <td>RucDNI</td>
        <td><input type="text" name="RucDNI" /></td>
      </tr>
      <tr>
        <td>Telefono</td>
        <td><input type="text" name="Telefono" /></td>
      </tr>
    </table>
    <input type="button" id="btnProcesar" value="Procesar" />
  </form>
  <script type="text/javascript">
  
    $("#btnProcesar").click(function(){
    	var data = $("#formClient").serialize();
    	$.post("AltaCliente", data,function(texto){
    		alert(texto);
    	});
    });
  
  </script>
</body>
</html>