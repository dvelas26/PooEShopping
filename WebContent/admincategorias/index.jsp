<%@ include file="../general/header.jsp" %>

<h3>Agregar Categorías</h3>

<form method="POST" action="./agregar">
    Nombre: <input type="text" name="nombre" /><br>
     Descripción: <input type="text" name="descripcion" />
    <br><br><input type="Submit" value="Registrar">
   </form>   
   
<br /><hr />

<h3>Lista de Categorias</h3>
<c:if test="${!empty categorias}">
    <table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Nombre</th>
        <th width="120">Descripcion</th>
        <th width="120">Editar</th>
        <th width="120">Borrar</th>
    </tr>
    <c:forEach items="${categorias}" var="cat">
        <tr>
            <td>${cat.getId()}</td>
            <td>${cat.getNombre()}</td>
            <td>${cat.getDescripcion()}</td>
            <td><a href="./modificar?id=${cat.getId()}">Editar</a></td>
            <td><a href="./eliminar?id=${cat.getId()}">Borrar</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>

<%@ include file="../general/footer.jsp" %>
