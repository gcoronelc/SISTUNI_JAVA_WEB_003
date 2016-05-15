package pe.egcc.app.dao.espec;

import pe.egcc.app.domain.Empleado;

public interface DaoCrudEmpleado extends DaoCrud<Empleado> {

  Empleado validar(String usuario, String clave);
  
}
