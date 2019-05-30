/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Movimiento;
import modelo.Producto;
import persistencia.Conectar;

/**
 *
 * @author CesarTu
 */
@WebServlet(name = "servletSalida", urlPatterns = {"/servletSalida"})
public class servletSalida extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String paginaRespuesta;
        
        int id_producto;
        int cantidad_producto;
        int cantidad_salida;
        int id_usuario;

        Conectar obj = new Conectar();
        Producto a = new Producto();
        Movimiento m = new Movimiento();
        
        id_producto = Integer.parseInt(request.getParameter("txtIdP"));
        cantidad_producto = Integer.parseInt(request.getParameter("txtCantidadAc"));
        cantidad_salida = Integer.parseInt(request.getParameter("txtSalida"));
        String usuario = (String) request.getParameter("usuario");
        
        m.setId_producto(id_producto);
        m.setNombre_usuario(usuario);
        m.setCantidad(cantidad_salida);
        m.setTipo("salida");
         
        
        cantidad_producto=cantidad_producto-cantidad_salida;
        
        a.setId_producto(id_producto);
        a.setCantidad_producto(cantidad_producto);

        try {
            
            obj.abrir();
            obj.modificarS(a);
            int i = obj.insertarMovimiento(m);
            obj.cerrar();

            if (i == 0) {
                paginaRespuesta = "empleado.jsp";
                request.setAttribute("mensaje", "alert('Error en la inserccion!')");
            } else {
                paginaRespuesta = "empleado.jsp";
                request.setAttribute("mensaje", "alert('inserccion correcta!')");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            paginaRespuesta = "empleado.jsp";
            request.setAttribute("mensaje", "alert('error en la inserccion')");
        }

        RequestDispatcher dispatcher
                = request.getRequestDispatcher(paginaRespuesta);
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
