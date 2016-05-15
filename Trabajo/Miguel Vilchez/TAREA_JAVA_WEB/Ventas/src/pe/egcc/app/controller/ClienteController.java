package pe.egcc.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.egcc.app.service.ClienteService;

@WebServlet({"/AltaCliente","/BajaCliente"})
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClienteService clienteService;
	
	@Override
	public void init() throws ServletException {
		clienteService = new ClienteService();
	}
	
	@Override
	protected void service(HttpServletRequest request, 
	    HttpServletResponse response) 
	    throws ServletException, IOException {
	  
	  String path = request.getServletPath();
	  if(path.equals("/AltaCliente")){
		  AltaCliente(request,response);
	  }
	  
	  
	  
	}


  private void AltaCliente(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
    String salida;
    try {
      // Datos
      String idCliente = request.getParameter("idCliente");
      String Nombre = request.getParameter("Nombre");
      String Direccion = request.getParameter("Direccion");
      String RucDNI = request.getParameter("RucDNI");
      String Telefono = request.getParameter("Telefono");
       
      // Empleado 
      String codEmp = SessionUtil.getCodEmp(request);
      if(codEmp == null){
        throw new RuntimeException("Debes iniciar sesión.");
      }
      // Proceso
      clienteService.procAltaCliente(idCliente, Nombre, Direccion, RucDNI, Telefono);
      salida = "Registrado Correctamente";
    } catch (Exception e) {
      salida = "-1 " + e.getMessage();
    } 
    // Salida
    response.setContentType("text/plain");
    PrintWriter out = response.getWriter();
    out.println(salida);
    out.flush();
    out.close();
    
  }

}
