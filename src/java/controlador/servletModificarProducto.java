/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Producto;
import persistencia.Conectar;

/**
 *
 * @author CesarTu
 */
@WebServlet(name = "servletModificarProducto", urlPatterns = {"/servletModificarProducto"})
public class servletModificarProducto extends HttpServlet {

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
        String paginaRespuesta;
        
        int id_producto;
        String nombre_libro = "";
        String descripcion_producto = "";
        String unidad_producto = "";
        int cantidad_producto;
        String ubicacion_almacen = "";
        

        Conectar obj = new Conectar();
        Producto a = new Producto();

        id_producto = Integer.parseInt(request.getParameter("txtIdPro"));
        nombre_libro = request.getParameter("txtNombre_libro");
        descripcion_producto = request.getParameter("txtDescripcion");
        unidad_producto = request.getParameter("txtUnidad");
        cantidad_producto = Integer.parseInt(request.getParameter("txtCantidad"));
        ubicacion_almacen = request.getParameter("txtUbicacion");

        a.setId_producto(id_producto);
        a.setNombre_libro(nombre_libro);
        a.setDescripcion_producto(descripcion_producto);
        a.setUnidad_producto(unidad_producto);
        a.setCantidad_producto(cantidad_producto);
        a.setUbicacion_almacen(ubicacion_almacen);


        try {
            obj.abrir();
            int i = obj.modificarProducto(a);
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
