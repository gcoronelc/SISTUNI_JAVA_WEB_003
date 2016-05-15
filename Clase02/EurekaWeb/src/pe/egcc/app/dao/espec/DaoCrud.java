package pe.egcc.app.dao.espec;

import java.util.List;

/**
 * 
 * @author Gustavo Coronel
 *
 * @param <T> T representa cualquier clase del dominio.
 */
public interface DaoCrud<T> {
  
  void insertar(T bean);
  
  void actualizar(T bean);
  
  void eliminar(String codigo);
  
  T obtener(String codigo);
  
  /**
   * 
   * @return Retorna una lista
   */
  List<T> obtener();
  
  /**
   * 
   * @param bean
   * @return Retorna una lista
   */
  List<T> obtener(T bean);
  

}
