package org.pl.eshopping.controllers.admincategorias;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pl.eshopping.dto.Categoria;
import org.pl.eshopping.dto.CategoriaDAO;

@WebServlet("/agregar")
public class Agregar extends HttpServlet {
	
	  CategoriaDAO catDAO = new CategoriaDAO();
	  Categoria cat = new Categoria();

	  public void doPost( HttpServletRequest request, 
	                      HttpServletResponse response) 
	                      throws IOException, ServletException {

	    String n = request.getParameter("nombre");
	    String d = request.getParameter("descripcion");
	    
	    cat.setNombre(n);
	    cat.setDescripcion(d);
	    catDAO.agregar(cat);

	    RequestDispatcher view = request.getRequestDispatcher("admincategorias/mensaje.jsp");
	    request.setAttribute("mensaje","Categoria agregada satisfactoriamente");
	    view.forward(request, response); 
	  }
}
