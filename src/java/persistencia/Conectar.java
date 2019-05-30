/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.*;
import java.util.ArrayList;
import modelo.Movimiento;
import modelo.Producto;
import modelo.Usuario;

/**
 *
 * @author CesarTu
 */
public class Conectar {

    static String bd = "proyectodae";
    static String usuario = "root";
    static String password = "naruto99";
    static String url = "jdbc:mysql://localhost:3306/" + bd;
    Connection conexion = null;
    private String driver = "com.mysql.jdbc.Driver";

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.print("Error en Clase por nombre" + ex);
        }

        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            if (conexion != null) {
                System.out.println("Conexión a base de datos " + bd + " OK");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conexion;

    }

    public void abrir() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        conexion = DriverManager.getConnection(url, usuario, password);
    }

    public void cerrar() throws SQLException {
        conexion.close();
    }

    public ArrayList<Usuario> listar() throws SQLException {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        Usuario a = null;
        Statement smt;
        ResultSet rs;

        String query = "SELECT * FROM usuarios";
        smt = conexion.createStatement();
        rs = smt.executeQuery(query);

        while (rs.next()) {
            a = new Usuario();
            a.setId_usuario(Integer.parseInt(rs.getString("id_usuario")));
            a.setNombre_usuario(rs.getString("nombre_usuario"));
            a.setApellido_usuario(rs.getString("apellido_usuario"));
            a.setTipo_usuario(rs.getString("tipo_usuario"));
            a.setPassword_usuario(rs.getString("password_usuario"));
            a.setCorreo_usuario(rs.getString("correo_usuario"));
            a.setTelefono_usuario(rs.getString("telefono_usuario"));

            listaUsuarios.add(a);
        }
        return listaUsuarios;
    }

    public ArrayList<Producto> listarProductos() throws SQLException {
        ArrayList<Producto> mostrarProductos = new ArrayList<>();
        Producto a = null;
        Statement smt;
        ResultSet rs;

        String query = "SELECT * FROM productos";
        smt = conexion.createStatement();
        rs = smt.executeQuery(query);

        while (rs.next()) {
            a = new Producto();
            a.setId_producto(Integer.parseInt(rs.getString("id_producto")));
            a.setNombre_libro(rs.getString("nombre_libro"));
            a.setDescripcion_producto(rs.getString("descripcion_producto"));
            a.setUnidad_producto(rs.getString("unidad_producto"));
            a.setCantidad_producto(Integer.parseInt(rs.getString("cantidad_producto")));
            a.setUbicacion_almacen(rs.getString("ubicacion_almacen"));

            mostrarProductos.add(a);
        }
        return mostrarProductos;
    }

    public int insertar(Usuario a) throws SQLException {
        int Id_usuario = a.getId_usuario();
        String nombre_usuario = a.getNombre_usuario();
        String apellido_usuario = a.getApellido_usuario();
        String tipo_usuario = a.getTipo_usuario();
        String password_usuario = a.getPassword_usuario();
        String correo_usuario = a.getCorreo_usuario();
        String telefono_usuario = a.getTelefono_usuario();
//        String fecha_creacion = a.getFecha_creacion();

        String query = "INSERT INTO usuarios VALUES ("
                + Id_usuario + ","
                + "'" + nombre_usuario + "',"+ "'" + apellido_usuario + "',"
                + "'" + tipo_usuario + "'," + "'" + password_usuario + "',"
                + "'" + correo_usuario + "',"
                + "'" + telefono_usuario + "'"+ ")";
//                + "'" + fecha_creacion + "'"
        System.out.println(query);

        Statement smt = conexion.createStatement();
        int i = smt.executeUpdate(query);
        return i;
    }

    public int insertarProducto(Producto a) throws SQLException {
        int Id_producto = a.getId_producto();
        String nombre_libro = a.getNombre_libro();
        String descripcion_producto = a.getDescripcion_producto();
        String unidad_producto = a.getUnidad_producto();
        int cantidad_producto = a.getCantidad_producto();
        String ubicacion_almacen = a.getUbicacion_almacen();

        String query = "INSERT INTO productos VALUES ("
                + Id_producto + ","
                + "'" + nombre_libro + "',"
                + "'" + descripcion_producto + "',"
                + "'" + unidad_producto + "'," + "" + cantidad_producto + ","
                + "'" + ubicacion_almacen + "'" + ")";
        System.out.println(query);

        Statement smt = conexion.createStatement();
        int i = smt.executeUpdate(query);
        return i;
    }
    
    public int insertarMovimiento(Movimiento m) throws SQLException{
        String query = "INSERT INTO movimientos VALUES ("
                + m.getId_movimiento() + ","
                +  m.getId_producto() + ","
                + "'" + m.getNombre_usuario() + "',"
                + "" + m.getCantidad()  + ","
                + "'" + m.getTipo()+ "'" + ")";
        System.out.println(query);
        
        Statement smt = conexion.createStatement();
        int i = smt.executeUpdate(query);
        return i;
    }

    public int modificar(Usuario a) throws SQLException {
        int Id_usuario = a.getId_usuario();
        String nombre_usuario = a.getNombre_usuario();
        String apellido_usuario = a.getApellido_usuario();
        String tipo_usuario = a.getTipo_usuario();
        String password_usuario = a.getPassword_usuario();
        String correo_usuario = a.getCorreo_usuario();
        String telefono_usuario = a.getTelefono_usuario();
//        String fecha_creacion = a.getFecha_creacion();

        String query = "UPDATE usuarios SET id_usuario ="
                + Id_usuario + ","
                + "nombre_usuario = '" + nombre_usuario + "',"
                + "apellido_usuario = '" + apellido_usuario + "',"
                + "tipo_usuario = '" + tipo_usuario + "',"
                + "password_usuario = '" + password_usuario + "',"
                + "correo_usuario = '" + correo_usuario + "',"
                + "telefono_usuario = '" + telefono_usuario + "'"
//                + "fecha_creacion = '" + fecha_creacion + "'"
                + " WHERE id_usuario = "
                + Id_usuario;

        System.out.println(query);

        Statement smt = conexion.createStatement();
        int i = smt.executeUpdate(query);
        return i;
    }

    public int modificarProducto(Producto a) throws SQLException {
        int Id_producto = a.getId_producto();
        String nombre_libro = a.getNombre_libro();
        String descripcion_producto = a.getDescripcion_producto();
        String unidad_producto = a.getUnidad_producto();
        int cantidad_producto = a.getCantidad_producto();
        String ubicacion_almacen = a.getUbicacion_almacen();

        String query = "UPDATE productos SET id_producto ="
                + Id_producto + ","
                + "nombre_libro = '" + nombre_libro + "',"
                + "descripcion_producto = '" + descripcion_producto + "',"
                + "unidad_producto = '" + unidad_producto + "',"
                + "cantidad_producto = " + cantidad_producto + ","
                + "ubicacion_almacen = '" + ubicacion_almacen + "'"
                + " WHERE id_producto = "
                + Id_producto;

        System.out.println(query);

        Statement smt = conexion.createStatement();
        int i = smt.executeUpdate(query);
        return i;
    }

    public int eliminar(int id_usuario) throws SQLException {
        Statement smt;
        String query = "DELETE FROM usuarios WHERE id_usuario =" + id_usuario;
        System.out.println(query);
        smt = conexion.createStatement();
        int i = smt.executeUpdate(query);
        return i;
    }

    public int eliminarProducto(int id_producto) throws SQLException {
        Statement smt;
        String query = "DELETE FROM productos WHERE id_producto =" + id_producto;
        System.out.println(query);
        smt = conexion.createStatement();
        int i = smt.executeUpdate(query);
        return i;
    }

    public int modificarS(Producto a) throws SQLException {
        int Id_producto = a.getId_producto();
        int cantidad_producto = a.getCantidad_producto();

        String query = "UPDATE productos SET id_producto ="
                + Id_producto + ","
                + "cantidad_producto = " + cantidad_producto + ""
                + " WHERE id_producto = "
                + Id_producto;

        System.out.println(query);

        Statement smt = conexion.createStatement();
        int i = smt.executeUpdate(query);
        return i;
    }
    public static void main(String[] args) {
        Conectar obj= new Conectar();
        obj.getConnection();
    }
}
