package pe.egcc.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pe.egcc.app.dao.espec.DaoCuentaEspec;
import pe.egcc.app.db.AccesoDB;

public class DaoCuentaImpl implements DaoCuentaEspec{

  @Override
  public void procDeposito(String cuenta, double importe, String codEmp) {
    Connection cn = null;
    try {
      // La conexi�n
      cn = AccesoDB.getConnection();
      // Inicio de Tx
      cn.setAutoCommit(false);
      // Obteneniendo datos de la cuenta
      String sql = "select dec_cuensaldo, int_cuencontmov "
          + "from cuenta "
          + "where chr_cuencodigo = ? "
          + "for update";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      ResultSet rs = pstm.executeQuery();
      if(!rs.next()){
        throw new RuntimeException("Cuenta no existe.");
      }
      double saldo = rs.getDouble("dec_cuensaldo");
      int cont = rs.getInt("int_cuencontmov");
      rs.close();
      pstm.close();
      // Retardo
      // Thread.currentThread().sleep(1000);
      // Actualizar cuenta
      saldo += importe;
      cont++;
      sql = "update cuenta "
          + "set dec_cuensaldo = ?, "
          + "int_cuencontmov = ? "
          + "where chr_cuencodigo = ? ";
      pstm = cn.prepareStatement(sql);      
      pstm.setDouble(1, saldo);
      pstm.setInt(2, cont);
      pstm.setString(3, cuenta);
      int n = pstm.executeUpdate();
      if(n == 0){
        throw new RuntimeException("Cuenta no existe.");
      }
      pstm.close();
      // Registrar movimiento
      sql = "insert into movimiento(chr_cuencodigo, "
          + "int_movinumero, dtt_movifecha, "
          + "chr_emplcodigo, chr_tipocodigo, "
          + "dec_moviimporte) values(?,?,SYSDATE,?,'003',?)";
      pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      pstm.setInt(2, cont);
      pstm.setString(3, codEmp);
      pstm.setDouble(4, importe);
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
      String msg  = "Error en el proceso registrar dep�sito.";
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
