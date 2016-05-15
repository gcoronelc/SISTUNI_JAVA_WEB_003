package pe.egcc.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.egcc.app.service.CuentaService;

@WebServlet({ "/CuentaDeposito", "/CuentaRetiro", 
  "/CuentaTransferencia", "/CuentaConsulta" })
public class CuentaController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  private CuentaService cuentaService;

  @Override
  public void init() throws ServletException {
    cuentaService = new CuentaService();
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String path = request.getServletPath();
    if (path.equals("/CuentaDeposito")) {
      cuentaDeposito(request, response);
    } else if (path.equals("/CuentaConsulta")) {
      cuentaConsulta(request, response);
    }

  }

  private void cuentaConsulta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      // Datos
      String cuenta = request.getParameter("cuenta");
      // Proceso
      Map<String, Object> rec;
      rec = cuentaService.conCuenta(cuenta);
      if(rec == null){
        throw new Exception("Cuenta no existe.");
      }
      request.setAttribute("rec", rec);
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("conCuentaR.jsp");
    rd.forward(request, response);
  }

  private void cuentaDeposito(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String salida;
    try {
      // Datos
      String cuenta = request.getParameter("cuenta");
      double importe = Double.parseDouble(request.getParameter("importe"));
      // Empleado
      String codEmp = SessionUtil.getCodEmp(request);
      if (codEmp == null) {
        throw new RuntimeException("Debes iniciar sesión.");
      }
      // Proceso
      cuentaService.procDeposito(cuenta, importe, codEmp);
      salida = "1";
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
