package pe.egcc.app.dao.impl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog gcoronelc.blogspot.com
 */
public final class JdbcUtil {

  private JdbcUtil() {
  }

  public static List<Map<String, ?>> rsToList(ResultSet rs) throws SQLException {
    ResultSetMetaData md = rs.getMetaData();
    int columns = md.getColumnCount();
    List<Map<String, ?>> results = new ArrayList<Map<String, ?>>();
    while (rs.next()) {
      Map<String, Object> row = new HashMap<String, Object>();
      for (int i = 1; i <= columns; i++) {
        row.put(md.getColumnLabel(i).toUpperCase(), rs.getObject(i));
      }
      results.add(row);
    }
    return results;
  }

  /**
   * Pasa la fila actual del ResultSet a un Map.
   * 
   * @param rs El ResultSet.
   * @return Retorna un objeto Map.
   * @throws SQLException
   */
  public static Map<String, Object> rsToMap(ResultSet rs) throws SQLException {
    ResultSetMetaData md = rs.getMetaData();
    int columns = md.getColumnCount();
    Map<String, Object> rec;
    rec = new HashMap<String, Object>();
    for (int i = 1; i <= columns; i++) {
      rec.put(md.getColumnLabel(i).toUpperCase(), rs.getObject(i));
    }
    return rec;
  }

}