

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="controlador.Conectar"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cliente</title>
         <%@include file="principal\componentes\head.html" %>
    </head>
    <body>
        <%@include file="principal\componentes\preloader.html" %>
         <%@include file="principal\componentes\navegacion_inicio.html" %>
         <br>
         <br>
         <br>
         <br>
        <div class="card-body">
            <div class="table-responsive">
            <table id="datatable" class="table table-striped table-bordered p-0">
              <thead>
                  <tr>
                      <th>Id Producto</th>
                      <th>Titulo del libro</th>
                      <th>Descripcion Producto</th>
                      <th>Unidad Producto</th>
                      <th>Cantidad</th>
                      <th>Ubicacion en Almacen</th>
                      <th>Cantidad</th>
                      <th>Tipo</th>
                  </tr>
              </thead>
              <tbody>
                   <%  
                        Connection conectame;

                        Conectar objCon = new Conectar();
                        conectame = objCon.getConnection();
                        Statement st = conectame.createStatement();
                        ResultSet rs = st.executeQuery("select * from movimientos "
                                                        + "inner join productos on movimientos.id_producto=productos.id_producto");
                        while(rs.next()){
                    %>
                  <tr>
                      <td><%=rs.getObject("id_producto")%></td>
                      <td><%=rs.getObject("nombre_libro")%></td>
                      <td><%=rs.getObject("descripcion_producto")%></td>
                      <td><%=rs.getObject("unidad_producto")%></td>
                      <td><%=rs.getObject("cantidad_producto")%></td>
                      <td><%=rs.getObject("ubicacion_almacen")%></td>
                      <td><%=rs.getObject("cantidad")%></td>
                      <td><%=rs.getObject("tipo_movimiento")%></td>
                  </tr>
                  <%}%>
              </tfoot>
              
           </table>
          </div>
          </div>

         <%@include file="principal\componentes\footer.html" %>
        <%@include file="principal\componentes\mis_scripts.html" %>
    </body>
</html>
