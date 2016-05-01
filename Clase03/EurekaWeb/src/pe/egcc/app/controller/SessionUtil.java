package pe.egcc.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import pe.egcc.app.domain.Empleado;

public final class SessionUtil {

  private SessionUtil() {
  }

  public static String getCodEmp(HttpServletRequest request){
    String codEmp = null;
    HttpSession session = request.getSession();
    if( session.getAttribute("usuario") != null){ 
      Empleado bean;
      bean = (Empleado) session.getAttribute("usuario");
      codEmp = bean.getCodigo();
    }
    return codEmp;
  }
  
  
}
