package pe.egcc.app.service;


import java.util.ArrayList;
import java.util.List;

import pe.egcc.app.bean.VentaBean;

public class CarritoService {

  private List<VentaBean> lista;

  public CarritoService() {
    lista = new ArrayList<>();
  }

  public void agregar(VentaBean bean) {
    bean.setImporte(bean.getPrecio() * bean.getCant());
    lista.add(bean);
  }
  
  public List<VentaBean> getLista() {
    return lista;
  }

}
