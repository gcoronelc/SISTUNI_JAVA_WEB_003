package pe.egcc.app.service;

import pe.egcc.app.dao.espec.DaoClienteEspec;
import pe.egcc.app.dao.impl.DaoClienteImpl;

public class ClienteService {

  private DaoClienteEspec daoCliente;
  
  public ClienteService() {
	  daoCliente = new DaoClienteImpl();
  }
  
  public void procAltaCliente(String idCliente, String Nombre, String Direccion,String RucDNI,String Telefono) {
	  daoCliente.procAltaCliente( idCliente,  Nombre,  Direccion, RucDNI, Telefono);    
  }

}

