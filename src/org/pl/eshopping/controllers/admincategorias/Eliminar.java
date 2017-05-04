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

@WebServlet("/eliminar")
public class Eliminar extends HttpServlet {
	
	  CategoriaDAO catDAO = new CategoriaDAO();
	  Categoria cat = new Categoria();

	  public void doGet( HttpServletRequest request, 
	                      HttpServletResponse response) 
	                      throws IOException, ServletException {

	    String id = request.getParameter("id");
	    cat.setId(Integer.parseInt(id));
	    catDAO.eliminar(cat);

	    RequestDispatcher view = request.getRequestDispatcher("admincategorias/mensaje.jsp");
	    request.setAttribute("mensaje","Categoria eliminada satisfactoriamente");
	    view.forward(request, response); 
	  }
}

