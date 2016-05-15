package pe.egcc.app.service;

import pe.egcc.app.dao.espec.DaoRetiroEspec;
import pe.egcc.app.dao.impl.DaoRetiroImpl;

public class CuentaRetiro {

	private DaoRetiroEspec daoRetiro;
	
public CuentaRetiro(){
daoRetiro= new DaoRetiroImpl();	
}	
	
public void procRetiro(String cuenta, double importe, String clave,
		String codEmp){
	daoRetiro.procRetiro(cuenta, importe, clave, codEmp);
}


}
