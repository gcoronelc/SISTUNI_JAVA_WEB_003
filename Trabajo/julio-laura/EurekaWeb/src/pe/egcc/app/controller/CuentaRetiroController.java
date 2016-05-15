package pe.egcc.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.egcc.app.service.CuentaRetiro;


/**
 * Servlet implementation class CuentaRetiroController
 */
@WebServlet("/CuentaRetiroController")
public class CuentaRetiroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CuentaRetiro cuentaretiro;
	
	@Override
	public void init() throws ServletException {
	 cuentaretiro = new CuentaRetiro();
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		  String path = request.getServletPath();
		  if(path.equals("/CuentaRetiroController")){
			  cuentaRetiroController(request,response);
	}

}

	private void cuentaRetiroController(HttpServletRequest request, HttpServletResponse response) 
			throws IOException 
			 {
	    String salida;
	    try {
	      // Datos
	      String cuenta = request.getParameter("cuenta");
	      double importe = Double.parseDouble(request.getParameter("importe"));
	      String clave = request.getParameter("clave");
	      // Empleado
	      String codEmp = SessionUtil.getCodEmp(request);
	      if(codEmp == null){
	        throw new RuntimeException("Debes iniciar sesión.");
	      }
	      // Proceso
	      cuentaretiro.procRetiro(cuenta, importe, clave, codEmp);
	      salida = "PERDISTE DINERO";
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
