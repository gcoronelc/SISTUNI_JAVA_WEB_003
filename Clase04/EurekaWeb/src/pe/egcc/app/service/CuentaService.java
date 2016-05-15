package pe.egcc.app.service;

import pe.egcc.app.dao.espec.DaoCuentaEspec;
import pe.egcc.app.dao.impl.DaoCuentaImpl;

public class CuentaService {

  private DaoCuentaEspec daoCuenta;
  
  public CuentaService() {
    daoCuenta = new DaoCuentaImpl();
  }
  
  public void procDeposito(String cuenta, 
      double importe, String codEmp) {
    daoCuenta.procDeposito(cuenta, importe, codEmp);    
  }

}
