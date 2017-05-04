<%@ include file="../general/header.jsp" %>
<%@ page import="java.util.*" %>

<form method="POST" action="./modificar">
   <input type="hidden" name="id" value="${categoria.getId()}" />
    Nombre: <input type="text" name="nombre" value="${categoria.getNombre()}" /><br>
     Descripción: <input type="text" name="descripcion" value="${categoria.getDescripcion()}"  />
    <br><br>
      <input type="Submit" value="Modificar">
   </form>

<%@ include file="../general/footer.jsp" %>
