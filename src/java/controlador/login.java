
package controlador;

import Clientews.UsuarioWS;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author ANGEL
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

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

        String usuario = request.getParameter("usuario");
        String password = request.getParameter("pass");

        UsuarioWS usuarioConsulta = new UsuarioWS();
        HttpSession sesion = request.getSession(true);
        if (usuario.isEmpty() || password.isEmpty()) {
            sesion.setAttribute("error", "Llene por favor todos los campos");
            response.sendRedirect("formularioLogin.jsp");
        } else {
            //System.out.println("aut: " + new Consultas().autenticacion(usuario, password));
            if (usuarioConsulta.verificarUsuario(Boolean.class, usuario, password)) {
                int tipo = Integer.parseInt(usuarioConsulta.parseXML(usuarioConsulta.buscarUsuario(String.class, usuario))
                        .getElementsByTagName("idRol").item(0)
                        .getChildNodes().item(1).getTextContent());
                sesion = request.getSession(true);
                sesion.setAttribute("usuario", usuario);
                sesion.setAttribute("tipo", tipo);
                if(tipo==1 || tipo==2 || tipo==3){
                response.sendRedirect("catalago.jsp");
                }
                sesion.removeAttribute("error");
            } else {
                sesion.setAttribute("error", "Usuario o contraseña incorrectos");
                response.sendRedirect("formularioLogin.jsp");
            }
        }

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
