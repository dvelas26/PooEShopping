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

@WebServlet("/modificar")
public class Modificar extends HttpServlet {
	
	  CategoriaDAO catDAO = new CategoriaDAO();
	  Categoria cat = new Categoria();
	  
	  public void doGet( HttpServletRequest request, HttpServletResponse response) 
	            throws IOException, ServletException {
		  
		    String n = request.getParameter("id");
			
			cat=catDAO.obtenerCategoriaPorId(Integer.parseInt(n));
			
			RequestDispatcher view = request.getRequestDispatcher("admincategorias/modificar.jsp");
			request.setAttribute("categoria",cat);
			view.forward(request, response); 
	  }

	  public void doPost( HttpServletRequest request, 
	                      HttpServletResponse response) 
	                      throws IOException, ServletException {
		  
		String id = request.getParameter("id");
	    String n = request.getParameter("nombre");
	    String d = request.getParameter("descripcion");
	    
	    cat.setId(Integer.parseInt(id));
	    cat.setNombre(n);
	    cat.setDescripcion(d);
	    catDAO.modificar(cat);

	    RequestDispatcher view = request.getRequestDispatcher("admincategorias/mensaje.jsp");
	    request.setAttribute("mensaje","Categoria modificada satisfactoriamente");
	    view.forward(request, response); 
	  }
}
