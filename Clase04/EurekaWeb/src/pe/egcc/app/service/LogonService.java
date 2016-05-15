package pe.egcc.app.service;

import pe.egcc.app.dao.espec.DaoCrudEmpleado;
import pe.egcc.app.dao.impl.DaoEmpleado;
import pe.egcc.app.domain.Empleado;

public class LogonService {
  
  public Empleado validar(String usuario, String clave){
    Empleado bean;
    if( !esCorrecto(usuario) || !esCorrecto(clave)){
      throw new RuntimeException("Datos son incorrectos.");
    }
    DaoCrudEmpleado daoEmpleado;
    daoEmpleado = new DaoEmpleado();
    bean = daoEmpleado.validar(usuario, clave);
    if(bean == null){
      throw new RuntimeException("Datos son incorrectos.");
    }
    return bean;
  }

  private boolean esCorrecto(String valor) {
    boolean rpta = false;
    if( valor != null && !valor.isEmpty()){
      rpta = true;
    }
    return rpta;
  }

}
