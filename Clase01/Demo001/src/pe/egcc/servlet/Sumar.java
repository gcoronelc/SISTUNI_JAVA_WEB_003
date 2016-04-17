package pe.egcc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Sumar")
public class Sumar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  // Datos
	  int num1 = Integer.parseInt(request.getParameter("n1"));
	  int num2 = Integer.parseInt(request.getParameter("n2"));
	  
	  // Proceso
	  int suma = num1 + num2;
	  
	  // Reporte
	  response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println("<head>");
    out.println("<title>SUMAR</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>SUMAR</h1>");;
    out.println("<p>Número 1: " + num1 + "</p>");;
    out.println("<p>Número 2: " + num2 + "</p>");;
    out.println("<p>Suma: " + suma + "</p>");;
    out.println("</body>");
    out.println("</html>");
	}

}
