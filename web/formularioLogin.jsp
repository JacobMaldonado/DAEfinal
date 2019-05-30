<%-- 
    Document   : formularioLogin
    Created on : 22-may-2019, 19:13:23
    Author     : Angel Hernandez
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${sessionScope['usuario']!=null}">
    <c:if test="${sessionScope['tipo']==1}">
        <% response.sendRedirect("catalago.jsp");%>
    </c:if>
    <c:if test="${sessionScope['tipo']==2}">
        <% response.sendRedirect("catalago.jsp");%>
    </c:if>
    <c:if test="${sessionScope['tipo']==3}">
        <% response.sendRedirect("catalago.jsp");%>
    </c:if>
</c:if>
<!DOCTYPE html>
<html lang="en" dir="rtl">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="keywords" content="HTML5 Template" />
        <meta name="description" content="Webmin - Bootstrap 4 & Angular 5 Admin Dashboard Template" />
        <meta name="author" content="potenzaglobalsolutions.com" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
        <title>LOGIN</title>

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
             preloader -->

            <div id="pre-loader">
                <img src="images/pre-loader/loader-01.svg" alt="">
            </div>

            <!--=================================
             preloader -->

            <!--=================================
            login-->

            <section class="height-100vh d-flex align-items-center page-section-ptb login" style="background-image: url(images/fondoLibreria2.jpg);" >
                <div class="container">
                    <div class="row justify-content-center no-gutters vertical-align">
                        <div class="col-lg-4 col-md-6 login-fancy-bg bg" style="background-image: url(images/fondoLibreria3.jpg);">
                            <div class="login-fancy">
                                <h2 class="text-white mb-20">Inicia sesión</h2>
                                <p class="mb-20 text-white">Para ver el contenido</p>
                                <ul class="list-unstyled  pos-bot pb-30">

                                </ul>
                            </div> 
                        </div>
                        <div class="col-lg-4 col-md-6 bg-dark">
                            <form action="/almacenLibro/login" method="post" id="forminicio">
                                <div class="login-fancy pb-40 clearfix">
                                    <h3 class="mb-30">Login</h3>
                                    <p style="color: #ff0000">${sessionScope['error']}</p>
                                    <div class="section-field mb-20">
                                        <label class="mb-10" for="name">Usuario </label>
                                        <input id="txtUsuario" class="web form-control" type="text" placeholder="usuario" name="usuario">                                        
                                    </div>
                                    <div class="section-field mb-20">
                                        <label class="mb-10" for="Password">Contraseña </label>
                                        <input id="txtPassword" class="Password form-control" type="password" placeholder="contraseña" name="pass">
                                    </div>
                                    <input type="submit" class="button" value="Iniciar sesión" id="btnIniciar"/>                   
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </section>

            <!--=================================
             login-->

        </div>



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