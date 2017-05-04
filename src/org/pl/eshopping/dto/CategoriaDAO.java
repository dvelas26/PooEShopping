package org.pl.eshopping.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.pl.eshopping.bd.Conexion;

public class CategoriaDAO {
	
	Statement st = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection conn = null;
	Conexion conexion = null;
	
	public void agregar(Categoria c){  
		
		try { conn = Conexion.getConexion();
			String query = "INSERT INTO categoria (nombre, descripcion) values (?, ?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, c.getNombre()); ps.setString(2, c.getDescripcion());
			ps.executeUpdate();
		}
		catch(Exception e){	e.printStackTrace();}
		finally{
			try { rs.close(); } catch (Exception e) { /* ignored */ }
		}
	}
	
	public void modificar(Categoria c){  
		try {
			conn = Conexion.getConexion();			
			String query = "UPDATE categoria set nombre=?,  descripcion=? WHERE id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, c.getNombre());	ps.setString(2, c.getDescripcion());
			ps.setString(3, c.getId().toString());
			ps.executeUpdate();			
		}
		catch(Exception e){	e.printStackTrace(); }
		finally{
			try { rs.close(); } catch (Exception e) { /* ignored */ }
		}
	}
	
	public void eliminar(Categoria c){  
		
		try {
			conn = Conexion.getConexion();
			String query = "DELETE FROM categoria WHERE id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, c.getId().toString());
			ps.executeUpdate();
		}
		catch(Exception e){ e.printStackTrace(); }
		finally{
			try { rs.close(); } catch (Exception e) { /* ignored */ }
		}
	}
	
	public ArrayList<Categoria> obtenerCategorias() 
	{
	    ArrayList<Categoria> categorias = new ArrayList<Categoria>();
	    try {
	    	conn = Conexion.getConexion();
	    	st = conn.createStatement();
	        String s = "SELECT * FROM categoria";
	        rs = st.executeQuery(s);

	        while (rs.next()) {
	        	
	        	Categoria categoria = new Categoria();
	        	categoria.setId(rs.getInt("id"));
	        	categoria.setNombre(rs.getString("nombre"));
	        	categoria.setDescripcion(rs.getString("descripcion"));
	        	categorias.add(categoria);
	        }

	        rs.close();
	    } catch (Exception e) {
	        System.out.println(e);
	    }

	    return categorias;
	}
	
	public Categoria obtenerCategoriaPorId(Integer id) 
	{
		Categoria categoria = new Categoria();
	    try {
	    	conn = Conexion.getConexion();
	    	st = conn.createStatement();
	        String s = "SELECT * FROM categoria WHERE id='"+id+"'";
	        rs = st.executeQuery(s);

	        while (rs.next()) {
	        	categoria.setId(rs.getInt("id"));
	        	categoria.setNombre(rs.getString("nombre"));
	        	categoria.setDescripcion(rs.getString("descripcion"));
	        }

	        rs.close();
	    } catch (Exception e) {
	        System.out.println(e);
	    }

	    return categoria;
	}
}
