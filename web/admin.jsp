

<%@page import="modelo.Usuario"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="persistencia.Conectar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
        <%@include file="principal\componentes\head.html" %>
    </head>
    
    <body>
        <%@include file="principal\componentes\preloader.html" %>
         <%@include file="principal\componentes\navegacion_inicio.html" %>
         <br><br><br><br>
         <%
            ArrayList<Usuario> listaUsuario = null;
            Conectar obj = new Conectar();
            
            try{
                obj.abrir();
                listaUsuario = obj.listar();
                obj.cerrar();
            }catch(SQLException ex){
                ex.getMessage();
            }
            
            if(listaUsuario == null){

            }else{
            
        %>
         <div align="center"> <a class="button large" href="agregarUsuarios.jsp"> Agregar Usuarios</a> </div>
        <div class="card-body">
            <div class="table-responsive">
            <table id="datatable" class="table table-striped table-bordered p-0">
              <thead>
                  <tr>
                      <th>Id Usuario</th>
                      <th>Nombre de Usuario</th>
                      <th>Apellido de Usuario</th>
                      <th>Tipo de Usuario</th>
                      <th>Password</th>
                      <th>Correo</th>
                      <th>Telefono</th>
                      <%--  <th>Fecha creacion</th>
                      <th>Fecha modificacion</th>--%>
                      <th>Modificar</th>
                      <th>Eliminar</th>
                  </tr>
              </thead>
              <tbody>
                  <%
                    for(int i=0; i<listaUsuario.size();i++){
                  %>
                  <tr>
                      <td>
                          <%
                            out.print(listaUsuario.get(i).getId_usuario());
                          %>
                      </td>
                      <td>
                          <%
                            out.print(listaUsuario.get(i).getNombre_usuario());
                          %>
                      </td>
                      <td>
                          <%
                            out.print(listaUsuario.get(i).getApellido_usuario());
                          %>
                      </td>
                      <td>
                          <%
                            out.print(listaUsuario.get(i).getTipo_usuario());
                          %>
                      </td>
                      <td>
                          <%
                            out.print(listaUsuario.get(i).getPassword_usuario());
                          %>
                      </td>
                      <td>
                          <%
                            out.print(listaUsuario.get(i).getCorreo_usuario());
                          %>
                      </td>
                      <td>
                          <%
                            out.print(listaUsuario.get(i).getTelefono_usuario());
                          %>
                      </td>
                      
                     <%-- <td>
                          <%
                            out.print(listaUsuario.get(i).getFecha_creacion());
                          %>
                      </td>
                      <td>
                          <%
                            out.print(listaUsuario.get(i).getFecha_modificacion());
                          %>
                      </td> --%>
                      <td>
                          <button type="button" data-toggle="modal" data-target="#exampleModal" class=button large>Modificar</button>
                          <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                              <div class="modal-content">
                                <div class="modal-header">
                                  <div class="modal-title" id="exampleModalLabel">
                                     <div class="mb-30">
                                      <h6>ACTUALIZAR</h6>
                                      <h2>Actualizar Usuario</h2>
                                    </div>
                                  </div>
                                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                  </button>
                                </div>
                                <div class="modal-body">
                    
                                 <form name = "formulario_Producto" mathod = "post" enctype="multipart/form-data" action = "servletActualizaUsuario">
                                                    
                                     <table align = "center">
                     
                                         <tr>
                                        <td>Id del Usuario:</td><td><input type="text" name="txtId" value="<%
                                            out.print(listaUsuario.get(i).getId_usuario());%>" /></td>
                                        </tr>
                                        <tr>
                                        <td>Nombre del Usuario:</td><td><input type="text" name="txtNombre" value=""/></td>
                                        </tr>
                                        <tr>
                                        <td>Apellido del Usuario:</td><td><input type="text" name="txtApellido" value=""/></td>
                                        </tr>
                                        <tr>
                                            <td>Tipo de Usuario:</td><td><select id="txtTipoU" name="txtTipoUsuario" value="" /><option>Admin</option><option>Empleado</option><option>Cliente</option></select></td>
                                        </tr>
                                        <tr>
                                            <td>Password:</td><td><input type="text" name="txtPass" value="" /></td>
                                        </tr>
                                        <tr>
                                            <td>Correo:</td><td><input type="text" name="txtCorreo" value="" /></td>
                                        </tr>
                                        <tr>
                                            <td>Telefono:</td><td><input type="text" name="txtTel" value="" /></td>
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
                      <form action="servletEliminarUsuario">
                          
                          <td>
                              <input type="hidden" value="<%
                                  out.print(listaUsuario.get(i).getId_usuario());%>" name="txtId">
                              <input type="submit" class=button large value="Eliminar" />
                              
                          </td>
                      </form>
                  </tr>
                   <%
                }
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
