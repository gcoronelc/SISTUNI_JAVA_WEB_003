package pe.egcc.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pe.egcc.app.domain.Empleado;
import pe.egcc.app.service.LogonService;


@WebServlet({ "/LogonIngreso", "/LogonSalir" })
public class LogonController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		if(path.equals("/LogonIngreso")){
		  logonIngreso(request,response);
		}
	}

  private void logonIngreso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String destino;
    try {
      // Datos
      String usuario = request.getParameter("usuario");
      String clave = request.getParameter("clave");
      // Proceso
      LogonService service = new LogonService();
      Empleado bean = service.validar(usuario, clave);
      // Dato en sesion
      HttpSession session = request.getSession();
      session.setAttribute("usuario", bean);
      // Salida
      destino = "main.jsp";
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
      destino = "index.jsp";
    }
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher(destino);
    rd.forward(request, response);
  }

}
