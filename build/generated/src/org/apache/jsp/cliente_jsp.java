package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Statement;
import controlador.Conectar;
import java.sql.Connection;

public final class cliente_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(5);
    _jspx_dependants.add("/principal/componentes/head.html");
    _jspx_dependants.add("/principal/componentes/preloader.html");
    _jspx_dependants.add("/principal/componentes/navegacion_inicio.html");
    _jspx_dependants.add("/principal/componentes/footer.html");
    _jspx_dependants.add("/principal/componentes/mis_scripts.html");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Cliente</title>\n");
      out.write("         ");
      out.write("<link rel=\"shortcut icon\" href=\"principal/images/favicon.ico\" />\n");
      out.write("\n");
      out.write("<!-- Font -->\n");
      out.write("<link  rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Poppins:200,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900\">\n");
      out.write("\n");
      out.write("<!-- css -->\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"principal/css/style.css\" />");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("<div id=\"pre-loader\">\n");
      out.write("    <img src=\"principal/images/pre-loader/loader-01.svg\" alt=\"\">\n");
      out.write("</div>");
      out.write("\n");
      out.write("         ");
      out.write("<nav class=\"admin-header navbar navbar-default col-lg-12 col-12 p-0 fixed-top d-flex flex-row\">\n");
      out.write("  <!-- logo -->\n");
      out.write("  <div class=\"text-left navbar-brand-wrapper\">\n");
      out.write("    <a class=\"navbar-brand brand-logo\" href=\"catalago.jsp\">Almacen de libros<img src=\"\" alt=\"\" ></a>\n");
      out.write("    \n");
      out.write("  </div>\n");
      out.write("  <ul class=\"nav navbar-nav ml-auto\">\n");
      out.write("    <li class=\"nav-item fullscreen\">\n");
      out.write("      \n");
      out.write("    </li>\n");
      out.write("    <li class=\"nav-item dropdown mr-30\">\n");
      out.write("      \n");
      out.write("    \n");
      out.write("      <div class=\"dropdown-menu dropdown-menu-right\">\n");
      out.write("        <div class=\"dropdown-header\">\n");
      out.write("          <div class=\"media\">\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </li>\n");
      out.write("  </ul>\n");
      out.write("</nav>");
      out.write("\n");
      out.write("         <br>\n");
      out.write("         <br>\n");
      out.write("         <br>\n");
      out.write("         <br>\n");
      out.write("        <div class=\"card-body\">\n");
      out.write("            <div class=\"table-responsive\">\n");
      out.write("            <table id=\"datatable\" class=\"table table-striped table-bordered p-0\">\n");
      out.write("              <thead>\n");
      out.write("                  <tr>\n");
      out.write("                      <th>Id Producto</th>\n");
      out.write("                      <th>Titulo del libro</th>\n");
      out.write("                      <th>Descripcion Producto</th>\n");
      out.write("                      <th>Unidad Producto</th>\n");
      out.write("                      <th>Cantidad</th>\n");
      out.write("                      <th>Ubicacion en Almacen</th>\n");
      out.write("                  </tr>\n");
      out.write("              </thead>\n");
      out.write("              <tbody>\n");
      out.write("                   ");
  
                        Connection conectame;

                        Conectar objCon = new Conectar();
                        conectame = objCon.getConnection();
                        Statement st = conectame.createStatement();
                        ResultSet rs = st.executeQuery("select * from productos");
                        while(rs.next()){
                    
      out.write("\n");
      out.write("                  <tr>\n");
      out.write("                      <td>");
      out.print(rs.getObject("id_producto"));
      out.write("</td>\n");
      out.write("                      <td>");
      out.print(rs.getObject("nombre_libro"));
      out.write("</td>\n");
      out.write("                      <td>");
      out.print(rs.getObject("descripcion_producto"));
      out.write("</td>\n");
      out.write("                      <td>");
      out.print(rs.getObject("unidad_producto"));
      out.write("</td>\n");
      out.write("                      <td>");
      out.print(rs.getObject("cantidad_producto"));
      out.write("</td>\n");
      out.write("                      <td>");
      out.print(rs.getObject("ubicacion_almacen"));
      out.write("</td>\n");
      out.write("                  </tr>\n");
      out.write("                  ");
}
      out.write("\n");
      out.write("              </tfoot>\n");
      out.write("              \n");
      out.write("           </table>\n");
      out.write("          </div>\n");
      out.write("          </div>\n");
      out.write("\n");
      out.write("         ");
      out.write("<footer class=\"p-4\">\n");
      out.write("      <div class=\"row\">\n");
      out.write("        <div class=\"col-md-6\">\n");
      out.write("          <div class=\"text-center text-md-left\">\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-md-6\">\n");
      out.write("          <ul class=\"text-center text-md-right\">\n");
      out.write("         \n");
      out.write("          </ul>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </footer>");
      out.write("\n");
      out.write("        ");
      out.write("<!--=================================\n");
      out.write(" jquery -->\n");
      out.write("\n");
      out.write("<!-- jquery -->\n");
      out.write("<script src=\"principal/js/jquery-3.3.1.min.js\"></script>\n");
      out.write("\n");
      out.write("<!-- plugins-jquery -->\n");
      out.write("<script src=\"principal/js/plugins-jquery.js\"></script>\n");
      out.write("\n");
      out.write("<!-- plugin_path -->\n");
      out.write("<script>var plugin_path = 'principal/js/';</script>\n");
      out.write("\n");
      out.write("<!-- chart -->\n");
      out.write("<script src=\"principal/js/chart-init.js\"></script>\n");
      out.write("\n");
      out.write("<!-- calendar -->\n");
      out.write("<script src=\"principal/js/calendar.init.js\"></script>\n");
      out.write("\n");
      out.write("<!-- charts sparkline -->\n");
      out.write("<script src=\"principal/js/sparkline.init.js\"></script>\n");
      out.write("\n");
      out.write("<!-- charts morris -->\n");
      out.write("<script src=\"principal/js/morris.init.js\"></script>\n");
      out.write("\n");
      out.write("<!-- datepicker -->\n");
      out.write("<script src=\"principal/js/datepicker.js\"></script>\n");
      out.write("\n");
      out.write("<!-- sweetalert2 -->\n");
      out.write("<script src=\"principal/js/sweetalert2.js\"></script>\n");
      out.write("\n");
      out.write("<!-- toastr -->\n");
      out.write("<script src=\"principal/js/toastr.js\"></script>\n");
      out.write("\n");
      out.write("<!-- validation -->\n");
      out.write("<script src=\"principal/js/validation.js\"></script>\n");
      out.write("\n");
      out.write("<!-- lobilist -->\n");
      out.write("<script src=\"principal/js/lobilist.js\"></script>\n");
      out.write(" \n");
      out.write("<!-- custom -->\n");
      out.write("<script src=\"principal/js/custom.js\"></script>");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
