package pe.egcc.app.prueba;

import java.util.List;
import java.util.Map;

import pe.egcc.app.dao.espec.DaoCuentaEspec;
import pe.egcc.app.dao.impl.DaoCuentaImpl;

public class Prueba003 {
  
  public static void main(String[] args) {
    DaoCuentaEspec dao = new DaoCuentaImpl();
    List<Map<String, ?>> lista = dao.conMovimientos("00200002");
    for(Map<String,?> rec: lista){
      System.out.println(rec.get("CUENSALDO") + 
          " | " + rec.get("MOVIFECHA").toString() + 
          " | " + rec.get("TIPONOMBRE") + 
          " | " + rec.get("MOVIIMPORTE"));
    }
  }

}
