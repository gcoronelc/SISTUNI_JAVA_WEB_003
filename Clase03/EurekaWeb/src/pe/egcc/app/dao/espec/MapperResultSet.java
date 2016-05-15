package pe.egcc.app.dao.espec;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Gustavo Coronel
 *
 * @param <T> Retorna un objeto de Tipo T con los datos de la fila actual del rs.
 */
public interface MapperResultSet<T> {

  T mapper(ResultSet rs) throws SQLException;
  
}
