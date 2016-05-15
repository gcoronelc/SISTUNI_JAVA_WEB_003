package guest;

import javax.persistence.*;
import javax.servlet.*;
import javax.servlet.annotation.WebListener;

@WebListener
public class GuestListener implements ServletContextListener {
	private static EntityManagerFactory emf;
	// Prepare the EntityManagerFactory & Enhance:
	// public void contextInitialized(ServletContextEvent e) {
	//
	// EntityManagerFactory emf =
	// Persistence.createEntityManagerFactory("Guestbook");
	// e.getServletContext().setAttribute("emf", emf);
	// }

	@Override
	public void contextDestroyed(ServletContextEvent e) {
		emf.close();
	}

	@Override
	public void contextInitialized(ServletContextEvent e) {
		emf = Persistence.createEntityManagerFactory("Guestbook");
		e.getServletContext().setAttribute("emf", emf);
	}

	public static EntityManager CrearEntityManager() {
		if (emf == null) {
			throw new IllegalStateException("No sea bobito falta el contexto...");
		}
		return emf.createEntityManager();
	}

}