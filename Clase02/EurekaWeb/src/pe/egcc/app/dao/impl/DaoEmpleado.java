package pe.egcc.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import pe.egcc.app.dao.espec.DaoCrudEmpleado;
import pe.egcc.app.dao.espec.MapperResultSet;
import pe.egcc.app.db.AccesoDB;
import pe.egcc.app.domain.Empleado;

public class DaoEmpleado implements DaoCrudEmpleado, MapperResultSet<Empleado> {

  @Override
  public void insertar(Empleado bean) {
    // TODO Auto-generated method stub

  }

  @Override
  public void actualizar(Empleado bean) {
    // TODO Auto-generated method stub

  }

  @Override
  public void eliminar(String codigo) {
    // TODO Auto-generated method stub

  }

  @Override
  public Empleado obtener(String codigo) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Empleado> obtener() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Empleado> obtener(Empleado bean) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Empleado validar(String usuario, String clave) {
    Empleado bean = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select chr_emplcodigo, vch_emplpaterno,"
          + "vch_emplmaterno, vch_emplnombre, vch_emplciudad, "
          + "vch_empldireccion, vch_emplusuario "
          + "from empleado "
          + "where vch_emplusuario = ? "
          + "and vch_emplclave = ? ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, usuario);
      pstm.setString(2, clave);
      ResultSet rs = pstm.executeQuery();
      if(rs.next()){
        bean = mapper(rs);
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
    return bean;
  }

  @Override
  public Empleado mapper(ResultSet rs) throws SQLException{
    Empleado bean = new Empleado();
    bean.setCodigo(rs.getString("chr_emplcodigo"));
    bean.setPaterno(rs.getString("vch_emplpaterno"));
    bean.setMaterno(rs.getString("vch_emplmaterno"));
    bean.setNombre(rs.getString("vch_emplnombre"));
    bean.setCiudad(rs.getString("vch_emplciudad"));
    bean.setDireccion(rs.getString("vch_empldireccion"));
    bean.setUsuario(rs.getString("vch_emplusuario"));
    return bean;
  }
   
}
