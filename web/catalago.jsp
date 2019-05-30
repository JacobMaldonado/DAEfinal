<%-- 
    Document   : catalago
    Created on : 25-may-2019, 19:13:23
    Author     : Angel Hernandez
--%>

<%@page import="java.sql.Driver"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="Conexion.Conexion"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession(false);
    if(sesion.getAttribute("usuario") == null){

        response.sendRedirect("formularioLogin.jsp");
    }
    
    
%>
<!DOCTYPE html>
<html lang="en" dir="rtl">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="keywords" content="HTML5 Template" />
        <meta name="description" content="Webmin - Bootstrap 4 & Angular 5 Admin Dashboard Template" />
        <meta name="author" content="potenzaglobalsolutions.com" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
        <title>Home</title>

        <!-- Favicon -->
        <link rel="shortcut icon" href="images/favicon.ico" />

        <!-- Font -->
        <link  rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:200,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900">

        <!-- css -->
        <link rel="stylesheet" type="text/css" href="css/style.css" />

    </head>

    <body>

        <div class="wrapper">

            <!--=================================
            
            
            <!--=================================
             header start-->

          

            <nav class="admin-header navbar navbar-default col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
                <!-- logo -->
                <div class="text-left navbar-brand-wrapper">
                    <a class="navbar-brand brand-logo" href="catalago.jsp"><img src="images/logo-white.png" alt="" ></a>
                    <a class="navbar-brand brand-logo-mini" href="catalago.jsp"><img src="images/logo-icon-light.png" alt=""></a>
                </div>
                <!-- Top bar left -->
                <ul class="nav navbar-nav mr-auto">
                    <li class="nav-item">
                        <a id="button-toggle" class="button-toggle-nav inline-block ml-20 pull-left" href="javascript:void(0);"><i class="zmdi zmdi-menu ti-align-right"></i></a>
                    </li>
                    <li class="nav-item">
                        <div class="search">
                            <a class="search-btn not_click" href="javascript:void(0);"></a>
                            <div class="search-box not-click">
                                <input type="text" class="not-click form-control" placeholder="Search" value="" name="search">
                                <button class="search-button" type="submit"> <i class="fa fa-search not-click"></i></button>
                            </div>
                        </div>
                    </li>
                </ul>
                <!-- top bar right -->
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item fullscreen">
                        <a id="btnFullscreen" href="#" class="nav-link" ><i class="ti-fullscreen"></i></a>
                    </li>


                    <!--circulo -->
                    <li class="nav-item dropdown mr-30">
                        <a class="nav-link nav-pill user-avatar" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                            <img src="images/logo.png" alt="avatar">
                        </a>
                        <div class="dropdown-menu dropdown-menu-right">
                            <div class="dropdown-header">
                                <div class="media">
                                    <div class="media-body">
                                        <h4 class="mt-0 mb-0"><% 
                                            
                                            int tipo = (Integer)session.getAttribute("tipo");
                                            String usuario =(String) session.getAttribute("usuario");
                                            out.println(usuario);
                                        %>
                                        </h4>
                                    </div>
                                </div>
                            </div>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="cerrarSesion.jsp"><i class="text-success ti-user"></i>Cerrar sesion</a>
                            <div class="dropdown-divider"></div> 
                          </div>
                    </li>
                </ul>
            </nav>

            <!--=================================
             header End-->

            <!--=================================
             Main content -->

            <div class="container-fluid">
                <div class="row">
                    <!-- Left Sidebar -->
                    <div class="side-menu-fixed">
                        <div class="scrollbar side-menu-bg">
                            <ul class="nav navbar-nav side-menu" id="sidebarnav">


                                <!-- menu item table -->
                                <li>
                                    <a href="javascript:void(0);" data-toggle="collapse" data-target="#table">
                                        <div class="pull-left"><i class="ti-layout-tab-window"></i><span class="right-nav-text">data table</span></div>
                                        <div class="pull-right"><i class="ti-plus"></i></div><div class="clearfix"></div>
                                    </a>
                                    <ul id="table" class="collapse" data-parent="#sidebarnav">
                                        <li> <a href="data-html-table.html">Data html table</a> </li>
                                        <li> <a href="data-local.html">Data Local</a> </li>
                                        <li> <a href="data-table.html">Data table</a> </li>
                                    </ul>
                                </li>
                                <!-- menu item Custom pages-->





                            </ul>
                        </div> 
                    </div> 
                    <!-- Left Sidebar End-->

                    <!--=================================
                     Main content -->

                    
                    
                    <!--=================================
                   wrapper -->

                    <div class="content-wrapper">
                       
                        <footer class="p-4">
                            <div class="row">
                                <div class="col-md-6">

                                </div>
                                <div class="col-md-6">
                                    <ul class="text-center text-md-right">
                                        <li class="list-inline-item"><h3><a href="#">Bienvenido al sistema de contabilidad</a></h3></li>

                                    </ul>
                                </div>
                            </div>
                        </footer>
                       
                        <div class="page-title">
                            
                        </div>
                        <!-- main body --> 
                        
                        <div class="row">   
                            <% if(tipo == 1 ){%>
                            <div class="col-xl-4 mb-30">
                                <div class="card card-statistics h-100">
                                    <div class="card-body text-center">
                                        <div class="mb-10 mt-30">
                                            <h5 class="mt-20"><a href="admin.jsp">Agregar cliente</a></h5>
                                            <!-- action group -->
                                            <div class="divider"></div>
                                            <br>
                                            
                                            <p><a href="admin.jsp" class="btn btn-outline-success btn-sm">Ver lista de <br> clientes</a></p>
                                        </div> 
                                        <div class="divider"></div>
                                        <div class="row">                                            
                                            <div class="col-12 col-sm-4 mt-15">                                                

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <% } %>
                            <% if(tipo == 1){%>
                            <div class="col-xl-4 mb-30">
                                <div class="card card-statistics h-100">
                                    <div class="card-body text-center">
                                        <div class="mb-10 mt-30">
                                            <h5 class="mt-20"><a href="agregarUsuarios.jsp">Agregar usuario</a></h5>
                                            <!-- action group -->
                                            <div class="divider"></div>
                                            <br>
                                            
                                            <p><a href="agregarUsuarios.jsp" class="btn btn-outline-success btn-sm">Ver lista de <br> usuarios</a></p>
                                        </div> 
                                        <div class="divider"></div>
                                        <div class="row">                                            
                                            <div class="col-12 col-sm-4 mt-15">                                                

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <% } %>
                            <% if(tipo == 1 || tipo == 2){%>
                            <div class="col-xl-4 mb-30">
                                <div class="card card-statistics h-100">
                                    <div class="card-body text-center">
                                        <div class="mb-10 mt-30">
                                            <h5 class="mt-20"><a href="empleado.jsp">Agregar producto</a></h5>
                                            <!-- action group -->
                                            <div class="divider"></div>
                                            <br>
                                            
                                            <p><a href="empleado.jsp" class="btn btn-outline-success btn-sm"> productos</a></p>
                                        </div> 
                                        <div class="divider"></div>
                                        <div class="row">                                            
                                            <div class="col-12 col-sm-4 mt-15">                                                

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <% } %>
                            <% if(tipo == 3){%>
                            <div class="col-xl-4 mb-30">
                                <div class="card card-statistics h-100">
                                    <div class="card-body text-center">
                                        <div class="mb-10 mt-30">
                                            <h5 class="mt-20"><a href="cliente.jsp">Ver Productos</a></h5>
                                            <!-- action group -->
                                            <div class="divider"></div>
                                            <br>
                                            
                                            <p><a href="cliente.jsp" class="btn btn-outline-success btn-sm">Productos</a></p>
                                        </div> 
                                        <div class="divider"></div>
                                        <div class="row">                                            
                                            <div class="col-12 col-sm-4 mt-15">                                                

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <% } %>
                        </div> 
                        
                        
                        
                        <!--=================================
                        wrapper -->

                        <!--=================================
                         footer -->
                        
                        <footer class="p-4">
                            <p style="color: #ff0000">${sessionScope['error']}</p>
                            <div class="row">
                                <div class="col-md-6">

                                </div>
                                <div class="col-md-6">
                                    <ul class="text-center text-md-right">
                                        <li class="list-inline-item"><a href="#"></a> </li>

                                    </ul>
                                </div>
                            </div>
                        </footer>
                    </div> 
                </div>
            </div>
        </div>

        <!--=================================
         footer -->



        <!--=================================
         jquery -->

        <!-- jquery -->
        <script src="js/jquery-3.3.1.min.js"></script>

        <!-- plugins-jquery -->
        <script src="js/plugins-jquery.js"></script>

        <!-- plugin_path -->
        <script>var plugin_path = 'js/';</script>

        <!-- chart -->
        <script src="js/chart-init.js"></script>

        <!-- calendar -->
        <script src="js/calendar.init.js"></script>

        <!-- charts sparkline -->
        <script src="js/sparkline.init.js"></script>

        <!-- charts morris -->
        <script src="js/morris.init.js"></script>

        <!-- datepicker -->
        <script src="js/datepicker.js"></script>

        <!-- sweetalert2 -->
        <script src="js/sweetalert2.js"></script>

        <!-- toastr -->
        <script src="js/toastr.js"></script>

        <!-- validation -->
        <script src="js/validation.js"></script>

        <!-- lobilist -->
        <script src="js/lobilist.js"></script>

        <!-- custom -->
        <script src="js/custom.js"></script>

    </body>
</html> 