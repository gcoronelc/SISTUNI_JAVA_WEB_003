package pe.egcc.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import pe.egcc.app.dao.espec.DaoCuentaEspec;
import pe.egcc.app.db.AccesoDB;

public class DaoCuentaImpl implements DaoCuentaEspec{

  @Override
  public void procDeposito(String cuenta, double importe, String codEmp) {
    Connection cn = null;
    try {
      // La conexión
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
      String msg  = "Error en el proceso registrar depósito.";
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

  @Override
  public Map<String, Object> conCuenta(String cuenta) {
    Map<String, Object> rec = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "SELECT "
          + "  CU.CHR_CUENCODIGO CUENTA, "
          + "  CU.CHR_SUCUCODIGO SUCURSAL, "
          + "  CL.VCH_CLIEPATERNO || ' ' || "
          + "  CL.VCH_CLIEMATERNO || ', ' || "
          + "  CL.VCH_CLIENOMBRE CLIENTE, "
          + "  M.VCH_MONEDESCRIPCION MONEDA, "
          + "  CU.DEC_CUENSALDO SALDO, "
          + "  CU.DTT_CUENFECHACREACION FECHA, "
          + "  CU.VCH_CUENESTADO ESTADO, "
          + "  CU.INT_CUENCONTMOV MOVS "
          + "FROM MONEDA M "
          + "JOIN CUENTA CU ON M.CHR_MONECODIGO = CU.CHR_MONECODIGO "
          + "JOIN CLIENTE CL ON CU.CHR_CLIECODIGO = CL.CHR_CLIECODIGO "
          + "WHERE CU.CHR_CUENCODIGO = ? ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      ResultSet rs = pstm.executeQuery();
      if(rs.next()){
        rec = JdbcUtil.rsToMap(rs);
      }
      rs.close();
      pstm.close();
    } catch (Exception e) {
      String msg = "Error en el acceso a la BD.";
      if(e.getMessage() != null && !e.getMessage().isEmpty()){
        msg += " " + e.getMessage();
      }
      throw new RuntimeException(msg);
    } finally {
      try {
        cn.close();
      } catch (Exception e2) {
      }
    }
    return rec;
  }

  
  @Override
  public List<Map<String, ?>> conMovimientos(String cuenta) {
    List<Map<String, ?>> lista = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "SELECT SUCUCODIGO, SUCUNOMBRE, "
          + "CLIECODIGO, CLIENOMBRE, CUENCODIGO, "
          + "CUENSALDO, CUENESTADO, MOVINUMERO, "
          + "MOVIFECHA, MOVIIMPORTE, CUENREFERENCIA, "
          + "TIPOCODIGO, TIPONOMBRE, TIPOACCION, "
          + "MONECODIGO, MONENOMBRE "
          + "FROM V_MOVIMIENTO "
          + "WHERE CUENCODIGO = = ? ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, cuenta);
      ResultSet rs = pstm.executeQuery();
      lista = JdbcUtil.rsToList(rs);
      rs.close();
      pstm.close();
    } catch (Exception e) {
      String msg = "Error en el acceso a la BD.";
      if(e.getMessage() != null && !e.getMessage().isEmpty()){
        msg += " " + e.getMessage();
      }
      throw new RuntimeException(msg);
    } finally {
      try {
        cn.close();
      } catch (Exception e2) {
      }
    }
    return lista;
  }

}
