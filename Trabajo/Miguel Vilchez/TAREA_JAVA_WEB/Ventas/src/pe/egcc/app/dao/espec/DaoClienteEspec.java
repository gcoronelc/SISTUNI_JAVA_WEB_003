package pe.egcc.app.dao.espec;

public interface DaoClienteEspec {

  /**
   * Registra el depósito en la base de datos.
   * 
   * @param cuenta
   * @param importe
   * @param codEmp
   */
  void procAltaCliente(String idCliente, String Nombre, String Direccion,String RucDNI,String Telefono);
  
  
}

