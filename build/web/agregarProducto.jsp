
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar</title>
         <%@include file="principal\componentes\head.html" %>
    </head>
    <body>
        <%@include file="principal\componentes\preloader.html" %>
         <%@include file="principal\componentes\navegacion_inicio.html" %>
         <br>
         <br>
         <br>
         <br>
         <form name = "formulario_Producto" mathod = "post" enctype="multipart/form-data" action = "servletAgregarProducto">
        <table align = "center">
            <tr>
            <td>Titulo:</td><td><input type="text" name="txtNombre_libro" /></td>
            </tr>
            <tr>
            <td>Descripcion:</td><td><input type="text" name="txtDescripcion" /></td>
            </tr>
            <tr>
            <td>Unidad de Producto:</td><td><input type="text" name="txtUnidad" /></td>
            </tr>
            <tr>
            <td>Cantidad de Producto:</td><td><input type="text" name="txtCantidad" /></td>
            </tr>
            <tr>
            <td>Ubicacion en Almacen:</td><td><input type="text" name="txtUbicacion" /></td>
            </tr>
            <tr>
            <td><input type="submit" value="Agregar" class="button large" /></td>
            <td><div align="center"> <a class="button large" href="empleado.jsp">Consultar</a> </div></td>
            </tr>
            </table>
        </form>
        <br><br><br>
         <%@include file="principal\componentes\footer.html" %>
        <%@include file="principal\componentes\mis_scripts.html" %>
    </body>
</html>
