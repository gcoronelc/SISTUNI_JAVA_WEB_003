<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h2>AGREGAR VENTA</h2>
  <p style="color:red;">${error}</p>
  <form method="post" action="Agregar">
    <fieldset style="width: 400px">
      <p>Cliente: <input type="text" name="cliente" value="${bean.cliente}"/></p>
      <p>Producto: <input type="text" name="producto" value="${bean.producto}"/></p>
      <p>Precio: <input type="text" name="precio" value="${bean.precio}"/></p>
      <p>Cantidad: <input type="text" name="cant" value="${bean.cant}"/></p>
      <p><input type="submit" value="Procesar"/></p>
    </fieldset>
  </form>
</body>
</html>