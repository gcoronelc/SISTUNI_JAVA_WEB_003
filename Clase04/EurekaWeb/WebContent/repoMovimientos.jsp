<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <h1>REPORTE DE MOVIMIENTOS</h1>
  
  <form id="formCuenta">
    <label>Cuenta: </label>
    <input type="text" name="cuenta" />
    <input type="button" value="Consultar" id="btnConsultar" />
  </form>
  
  <div id="divResultado" style="height: ">
    
  </div>

  <script type="text/javascript">
  
  $("#btnConsultar").click(function(){
	  var data = $("#formCuenta").serialize();
	  var url = "RepoMovimientos?" + data;
	  alert(url);
	  var txtHTML = "<object data='" + url + 
	  "' style='width:100%;height:500px;' type='application/pdf'></object>";
	  $("#divResultado").html(txtHTML);
  });
  
  </script>
</body>
</html>