<%-- 
    Document   : cerrarSesion
    Created on : 29-may-2019, 15:48:58
    Author     : ANGEL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cerrar Sesión</title>
    </head>
    <body>
        <%
            session = request.getSession();
            if (session != null) {
                session.removeAttribute("usuario");
                session.removeAttribute("tipo");
                session.invalidate();
                response.sendRedirect("formularioLogin.jsp");
            }

        %>
    </body>
</html>
