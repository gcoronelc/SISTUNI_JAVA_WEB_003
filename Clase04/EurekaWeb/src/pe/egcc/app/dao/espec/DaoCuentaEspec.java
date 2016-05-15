package pe.egcc.app.dao.espec;

import java.util.Map;

public interface DaoCuentaEspec {

  /**
   * Registra el depósito en la base de datos.
   * 
   * @param cuenta
   * @param importe
   * @param codEmp
   */
  void procDeposito(String cuenta, double importe, String codEmp);
  
  Map<String,Object> conCuenta(String cuenta);
  
  
  
  
}
