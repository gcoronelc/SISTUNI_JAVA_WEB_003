<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <h1>CONSULTAR MOVIMIENTOS</h1>
  
  <form id="formCuenta">
    <label>Cuenta: </label>
    <input type="text" name="cuenta" />
    <input type="button" value="Consultar" id="btnConsultar" />
  </form>
  
  <div id="divResultado">
    
  </div>

  <script type="text/javascript">
  
  $("#btnConsultar").click(function(){
	  var data = $("#formCuenta").serialize();
	  $.post("CuentaMovimientos",data,function(objJson){
		  if( objJson.code == -1){
			  $("#divResultado").html("<p class='egcc_error'>" + objJson.error + "</p>");
			  return;
		  }
		  var htmlTabla = "<table border='1' id='tabla'></table>";
		  $("#divResultado").html(htmlTabla);
		  $("#tabla").append("<tr><th>FECHA</th><th>TIPO</th><th>IMPORTE</th></tr>");
		  // Agregar movimientos
		  $.each(objJson.lista, function(i, item) {             
			  var trHTML = "<tr><td>" + item.MOVIFECHA +
			   "</td><td>" + item.TIPONOMBRE + 
			   "</td><td>" + item.MOVIIMPORTE + "</td></tr>";
			   $("#tabla").append(trHTML);
		  });
	  });
  });
  
  </script>
</body>
</html>