package pe.egcc.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pe.egcc.app.bean.VentaBean;
import pe.egcc.app.service.CarritoService;


@WebServlet({"/Agregar","/Listado","/Reset"})
public class CarritoController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest request, 
      HttpServletResponse response) 
          throws ServletException, IOException {
   
    String path = request.getServletPath();
    if(path.equals("/Agregar")){
      agregar(request,response);
    } else if(path.equals("/Listado")){
      listado(request,response);
    } else if(path.equals("/Reset")){
      reset(request,response);
    }
    
  }

  private void agregar(HttpServletRequest request, 
      HttpServletResponse response) 
          throws ServletException, IOException {
    String destino;
    VentaBean bean = new VentaBean();
    try {
      // Datos
      bean.setCliente(request.getParameter("cliente"));
      bean.setProducto(request.getParameter("producto"));
      bean.setPrecio(Double.parseDouble(request.getParameter("precio")));
      bean.setCant(Integer.parseInt(request.getParameter("cant")));
      // Objeto de Session
      CarritoService carrito = obtenerCarrito(request);
      carrito.agregar(bean);
      // Destino
      request.setAttribute("carrito", carrito);
      destino = "listado.jsp";
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
      request.setAttribute("bean", bean);
      destino = "agregar.jsp";
    }
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher(destino);
    rd.forward(request, response);
  }

  private CarritoService obtenerCarrito(HttpServletRequest request) {
    HttpSession session = request.getSession();
    if(session.getAttribute("carrito") == null){
      session.setAttribute("carrito", new CarritoService());
    }
    return (CarritoService) session.getAttribute("carrito");
  }

  private void listado(HttpServletRequest request, HttpServletResponse response) {
    // TODO Auto-generated method stub
    
  }

  private void reset(HttpServletRequest request, HttpServletResponse response) {
    // TODO Auto-generated method stub
    
  }
  
}
