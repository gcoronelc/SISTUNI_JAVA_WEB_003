package pe.egcc.app.domain;

public class Empleado {

  private String idEmpleado;
  private String Nombre;
  private String Apellidos;
  private String Email;
  private String Usuario;
  private String Clave;

  
  public Empleado() {
  }


public String getIdEmpleado() {
	return idEmpleado;
}


public void setIdEmpleado(String idEmpleado) {
	this.idEmpleado = idEmpleado;
}


public String getNombre() {
	return Nombre;
}


public void setNombre(String nombre) {
	Nombre = nombre;
}


public String getApellidos() {
	return Apellidos;
}


public void setApellidos(String apellidos) {
	Apellidos = apellidos;
}


public String getEmail() {
	return Email;
}


public void setEmail(String email) {
	Email = email;
}


public String getUsuario() {
	return Usuario;
}


public void setUsuario(String usuario) {
	Usuario = usuario;
}


public String getClave() {
	return Clave;
}


public void setClave(String clave) {
	Clave = clave;
}

  
  
}
