package pe.egcc.app.dao.espec;

public interface DaoCuentaEspec {

  /**
   * Registra el depósito en la base de datos.
   * 
   * @param cuenta
   * @param importe
   * @param codEmp
   */
  void procDeposito(String cuenta, double importe, String codEmp);
  
  
}
