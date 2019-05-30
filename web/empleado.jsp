

<%@page import="java.sql.SQLException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Producto"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="persistencia.Conectar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empleado</title>
        <%@include file="principal\componentes\head.html" %>
    </head>
    
    <body>
        <%@include file="principal\componentes\preloader.html" %>
         <%@include file="principal\componentes\navegacion_inicio.html" %>
         <br><br><br><br>
         <%
            ArrayList<Producto> mostrarProductos = null;
            Conectar obj = new Conectar();
            
            try{
                obj.abrir();
                mostrarProductos = obj.listarProductos();
                obj.cerrar();
            }catch(SQLException ex){
                ex.getMessage();
            }
            
            if(mostrarProductos == null){

            }else{
            
        %>
         <div align="center"> <a class="button large" href="agregarProducto.jsp"> Agregar productos</a> </div>
        <div class="card-body">
            <div class="table-responsive">
            <table id="datatable" class="table table-striped table-bordered p-0">
              <thead>
                  <tr>
                      <th>Id Producto</th>
                      <th>Nombre Producto</th>
                      <th>Descripcion Producto</th>
                      <th>Unidad Producto</th>
                      <th>Cantidad</th>
                      <th>Ubicacion en Almacen</th>
                      <th>Modificar</th>
                      <th>Eliminar</th>
                      <th>SALIDA</th>
                      <th>ENTRADA</th>
                  </tr>
              </thead>
              <tbody>
                  <%
                    for(int i=0; i<mostrarProductos.size();i++){
                  %>
                  <tr>
                      <td>
                          <%
                            out.print(mostrarProductos.get(i).getId_producto());
                          %>
                      </td>
                      <td>
                          <%
                            out.print(mostrarProductos.get(i).getNombre_libro());
                          %>
                      </td>
                      <td>
                          <%
                            out.print(mostrarProductos.get(i).getDescripcion_producto());
                          %>
                      </td>
                      <td>
                          <%
                            out.print(mostrarProductos.get(i).getUnidad_producto());
                          %>
                      </td>
                      <td>
                          <%
                            out.print(mostrarProductos.get(i).getCantidad_producto());
                          %>
                      </td>
                      <td>
                          <%
                            out.print(mostrarProductos.get(i).getUbicacion_almacen());
                          %>
                      </td>
                      
                      <td>
                          <button type="button" data-toggle="modal" data-target="#exampleModal" class=button large>Modificar</button>
                          <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                              <div class="modal-content">
                                <div class="modal-header">
                                  <div class="modal-title" id="exampleModalLabel">
                                     <div class="mb-30">
                                      <h6>ACTUALIZAR</h6>
                                      <h2>Actualizar Libro</h2>
                                    </div>
                                  </div>
                                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                  </button>
                                </div>
                                <div class="modal-body">
                    
                                    <form name = "formulario_Producto_mod" mathod = "post"  action = "servletModificarProducto">
                                        <table align = "center">
                                            <tr>
                                            <td>Id del producto:</td><td><input type="text" name="txtIdPro" value="<%
                                                out.print(mostrarProductos.get(i).getId_producto());
                                              %>" /></td>
                                            </tr>
                                            <tr>
                                            <td>Nombre de producto:</td><td><input type="text" name="txtNombre_libro" /></td>
                                            </tr>
                                            <tr>
                                            <td>Descripcion de producto:</td><td><input type="text" name="txtDescripcion" /></td>
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
                                            <td><input type="submit" value="Modificar" class="button large" /></td>
                                            </tr>
                                        </table>
                                    </form>
                                 
                                </div>
                                        
                                <div class="modal-footer">
                                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                </div>
                              </div>
                            </div>
                          </div>
                      </td>
                      <td>
                          <form action="servletEliminarProducto">
                              <input type="hidden" value="<%
                                                out.print(mostrarProductos.get(i).getId_producto());
                                              %>" name="txtId">
                              <input type="submit"  class=button large value="Eliminar" />
                          </form>
                          </td>
                      <td>
                          <form action="servletSalida">
                              <input type="text" name="txtSalida" placeholder="cantidad de salida"/>
                              <input type="hidden" name="txtCantidadAc" value="<%
                            out.print(mostrarProductos.get(i).getCantidad_producto());
                          %>">
                              <input type="hidden" name="txtIdP" value="<%
                            out.print(mostrarProductos  .get(i).getId_producto());
                          %>">
                              <input type="hidden" name="usuario" value="<%=session.getAttribute("usuario")%>">
                              <div align="center"><br><input type="submit" value="enviar" class=button large /></div>
                              <br>
                          </form>
                      </td>
                      <td>
                          <form action="servletEntrada">
                              <input type="text" name="txtEntrada" placeholder="cantidad de Entrada"/>
                              <input type="hidden" name="txtCantidadAc" value="<%=mostrarProductos.get(i).getCantidad_producto()%>">
                              <input type="hidden" name="txtIdP" value="<%=
                            mostrarProductos.get(i).getId_producto()
                          %>">
                              <input type="hidden" name="usuario" value="<%=session.getAttribute("usuario")%>">
                              <div align="center"><br><input type="submit" value="enviar" class=button large /></div>
                              <br>
                          </form>
                      </td>
                  </tr>
                  <%}
                }
                  %>
                  </tbody>
              
            
           </table>
          </div>
          </div>
        <%@include file="principal\componentes\footer.html" %>
        <%@include file="principal\componentes\mis_scripts.html" %>
    </body>
</html>
