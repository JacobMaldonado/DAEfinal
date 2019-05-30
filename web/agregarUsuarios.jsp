

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
         <form name = "formulario_Producto" mathod = "post" enctype="multipart/form-data" action = "servletInsertarUsuario">
        <table align = "center">
            <tr>
            <td>Nombre del Usuario:</td><td><input type="text" name="txtNombre" /></td>
            </tr>
            <tr>
            <td>Apellido del Usuario:</td><td><input type="text" name="txtApellido" /></td>
            </tr>
            <tr>
                <td>Tipo de Usuario:</td><td><select id="txtTipoU" name="txtTipoUsuario" /><option>Admin</option><option>Empleado</option><option>Cliente</option></select></td>
            </tr>
            <tr>
                <td>Password:</td><td><input type="text" name="txtPass" /></td>
            </tr>
            <tr>
                <td>Correo:</td><td><input type="text" name="txtCorreo" /></td>
            </tr>
            <tr>
                <td>Telefono:</td><td><input type="text" name="txtTel" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Agregar" class="button large" /></td>
                <td><div align="center"> <a class="button large" href="admin.jsp">Consultar</a> </div></td>
            </tr>
            </table>
        </form>
        <br><br><br>
         <%@include file="principal\componentes\footer.html" %>
        <%@include file="principal\componentes\mis_scripts.html" %>
    </body>
</html>

