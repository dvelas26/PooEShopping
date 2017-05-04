package org.pl.eshopping.controllers.admincategorias;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pl.eshopping.dto.Categoria;
import org.pl.eshopping.dto.CategoriaDAO;

@WebServlet("/index")
public class Index extends HttpServlet{

	CategoriaDAO catDAO = new CategoriaDAO();
	ArrayList<Categoria> categorias;
	
	public void init() throws ServletException  { }

	public void doGet( HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException {
		
		categorias=catDAO.obtenerCategorias();
		
		RequestDispatcher view = request.getRequestDispatcher("admincategorias/index.jsp");
		request.setAttribute("categorias",categorias);
		view.forward(request, response); 
	}

}
