package pe.egcc.app.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import pe.egcc.app.service.CuentaService;

@WebServlet({ "/CuentaDeposito", "/CuentaRetiro", 
  "/CuentaTransferencia", "/CuentaConsulta", 
  "/CuentaMovimientos","/RepoMovimientos" })
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
    } else if (path.equals("/CuentaMovimientos")) {
      cuentaMovimientos(request, response);
    } else if (path.equals("/RepoMovimientos")) {
      repoMovimientos(request, response);
    }

  }

  private void repoMovimientos(HttpServletRequest request, HttpServletResponse response) {
    try {
      // Dato
      String cuenta = request.getParameter("cuenta");
      // Datos
      List<Map<String, ?>> lista = cuentaService.conMovimientos(cuenta);
      System.out.println("EGCC Filas: " + lista.size());
      JRMapCollectionDataSource data = new JRMapCollectionDataSource(lista);
      // Cargar el logo
      String fileLogo = "/pe/egcc/app/img/logo.gif";
      InputStream isLogo = Class.class.getResourceAsStream(fileLogo);
      Map<String, Object> pars = new HashMap<>();
      pars.put("LOGO", fileLogo);
      // Creando el archivo PDF
      String fileRepo = "/pe/egcc/app/reportes/repoMovimientos.jasper";
      InputStream isRepo = getClass().getResourceAsStream(fileRepo);
      if(isRepo == null){
        System.out.println("EGCC Reporte nulo.");
      }
      byte[] bytes = JasperRunManager.runReportToPdf(isRepo, pars, data);
      // Enviar reporte
      response.setContentType("Application/pdf");
      response.setContentLength(bytes.length);
      ServletOutputStream out = response.getOutputStream();
      out.write(bytes, 0, bytes.length);
      out.flush();
      out.close();
    } catch (Exception e) {
      e.printStackTrace();
      
    }
  }

  private void cuentaMovimientos(HttpServletRequest request, HttpServletResponse response) throws IOException {
    List<Map<String, ?>> lista = null;
    String error = null;
    try {
      // Datos
      String cuenta = request.getParameter("cuenta");
      // Proceso
      lista = cuentaService.conMovimientos(cuenta);
      if (lista.isEmpty()) {
        throw new Exception("Cuenta no existe.");
      }
      error = null;
    } catch (Exception e) {
      lista = null;
      error = e.getMessage();
      if(error == null || error.isEmpty()){
        error = "No se puede acceder a la base de datos.";
      }
    }
    // Preparando la salida o reporte
    Map<String, Object> repo = new HashMap<>();
    if(lista != null){
      repo.put("code", 1);
      repo.put("lista", lista);
    } else {
      repo.put("code", -1);
      repo.put("error", error);
    }
    // Creando la cadena JSON
    Gson gson = new Gson();
    String textoJson = gson.toJson(repo);
    // Enviando la salida o reporte
    //response.setContentType("text/plain");
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    PrintWriter out = response.getWriter();
    out.print(textoJson);
    out.flush();
  }

  
  private void cuentaConsulta(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      // Datos
      String cuenta = request.getParameter("cuenta");
      // Proceso
      Map<String, Object> rec;
      rec = cuentaService.conCuenta(cuenta);
      if (rec == null) {
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
