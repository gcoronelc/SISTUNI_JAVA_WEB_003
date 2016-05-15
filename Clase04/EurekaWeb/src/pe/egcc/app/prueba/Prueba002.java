package pe.egcc.app.prueba;

import java.util.Map;

import pe.egcc.app.dao.espec.DaoCuentaEspec;
import pe.egcc.app.dao.impl.DaoCuentaImpl;

public class Prueba002 {
  
  public static void main(String[] args) {
    DaoCuentaEspec dao = new DaoCuentaImpl();
    Map<String, Object> rec = dao.conCuenta("00200002");
    for(String key: rec.keySet()){
      System.out.println(key + " | " + rec.get(key));
    }
  }

}
