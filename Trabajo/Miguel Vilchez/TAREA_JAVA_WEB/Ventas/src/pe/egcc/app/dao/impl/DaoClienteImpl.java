package pe.egcc.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;

import pe.egcc.app.dao.espec.DaoClienteEspec;
import pe.egcc.app.db.AccesoDB;

public class DaoClienteImpl implements DaoClienteEspec{

  @Override
  public void procAltaCliente(String idCliente, String Nombre, String Direccion,String RucDNI,String Telefono) {
    Connection cn = null;
    try {
      // La conexión
      cn = AccesoDB.getConnection();
      // Inicio de Tx
      cn.setAutoCommit(false);

      // Registrar movimiento
      String sql = "insert into Clientes(idCliente,Nombre,Direccion,RucDNI,Telefono) " +
          "values(?,?,?,?,?)";
      
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, idCliente); 
      pstm.setString(2, Nombre);
      pstm.setString(3, Direccion);
      pstm.setString(4, RucDNI);
      pstm.setString(5, Telefono);
      pstm.executeUpdate();
      pstm.close();
      // Confirmar Tx
      cn.commit();
    } catch (Exception e) {
      e.printStackTrace();
      try {
        cn.rollback();
      } catch (Exception e2) {
      }
      String msg  = "Error en el proceso registrar cliente.";
      if( e != null && e.getMessage() != null){
        msg += "\n" + e.getMessage();
      }
      throw new RuntimeException(msg);
    } finally {
      try {
        cn.close();
      } catch (Exception e2) {
      }
    }
  }

}
