package pe.egcc.app.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent event)  { 
      List<String> ciudades = new ArrayList<>();
      ciudades.add("Chiclayo");
      ciudades.add("Arequipa");
      ciudades.add("Trujillo");
      ciudades.add("Piura");
      ciudades.add("Huancayo");
      ciudades.add("Cuzco");
      ciudades.add("Iquitos");
      ciudades.add("Chachapoyas");
      event.getSession().setAttribute("datos", ciudades);
    }


    public void sessionDestroyed(HttpSessionEvent event)  { 
    }
	
}
