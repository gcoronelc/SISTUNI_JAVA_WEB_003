package pe.egcc.app.service;

import java.util.List;
import java.util.Map;

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
  
  public Map<String,Object> conCuenta(String cuenta){
    return daoCuenta.conCuenta(cuenta);
  }
  
  public List<Map<String, ?>> conMovimientos(String cuenta) {
    return daoCuenta.conMovimientos(cuenta);
  }

}
