/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.*;
import java.util.ArrayList;
import modelo.Usuario;

/**
 *
 * @author CesarTu
 */
public class Conectar {
    
    static String bd = "proyectodae";
    static String usuario = "root";
    static String password = "naruto99";
    static String url = "jdbc:mysql://localhost:3306/"+bd;
    Connection conexion = null;
    private String driver = "com.mysql.jdbc.Driver";
    
    public Connection getConnection() {
        try {
             Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {System.out.print("Error en Clase por nombre" + ex);}

        try {
            conexion = DriverManager.getConnection(url,usuario,password);
            if (conexion!=null){
                System.out.println("Conexión a base de datos "+bd+" OK");
            }
        }catch(Exception e){e.printStackTrace();}
        return conexion;

    }
public void abrir() throws ClassNotFoundException, SQLException{
        Class.forName(driver);
        conexion = DriverManager.getConnection(url, usuario, password);
    }
    
    public void cerrar() throws SQLException{
        conexion.close();
    }
    
    public ArrayList<Usuario> listar () throws SQLException{
        ArrayList <Usuario> listaUsuarios = new ArrayList<>();
        Usuario a = null;
        Statement smt;
        ResultSet rs;
        
        String query = "SELECT * FROM usuarios";
        smt = conexion.createStatement();
        rs = smt.executeQuery(query);
        
        while(rs.next()){
            a = new Usuario();
            a.setId_usuario(Integer.parseInt(rs.getString("id_usuario")));
            a.setNombre_usuario(rs.getString("nombre_usuario"));
            a.setTipo_usuario(rs.getString("tipo_usuario"));
            a.setPassword_usuario(rs.getString("password_usuario"));
            a.setCorreo_usuario(rs.getString("correo_usuario"));
            a.setTelefono_usuario(rs.getString("telefono_usuario"));
            
            listaUsuarios.add(a);
        }
        return listaUsuarios;
    }
    public int insertar (Usuario a) throws SQLException{
        int Id_usuario=a.getId_usuario();
        String nombre_usuario = a.getNombre_usuario();
        String tipo_usuario = a.getTipo_usuario();
        String password_usuario = a.getPassword_usuario();
        String correo_usuario = a.getCorreo_usuario();
        String telefono_usuario = a.getTelefono_usuario();
        
        String query = "INSERT INTO usuarios VALUES ("
                + Id_usuario+ ","
                +"'"+ nombre_usuario + "',"
                +"'"+ tipo_usuario + "',"+ "'" +password_usuario + "',"
                +"'"+ correo_usuario + "',"
                +"'"+ telefono_usuario +"'" + ")";
        System.out.println(query);
        
        Statement smt = conexion.createStatement();
        int i = smt.executeUpdate(query);
        return i;
    }
        public int modificar (Usuario a) throws SQLException{
        int Id_usuario = a.getId_usuario();
        String nombre_usuario = a.getNombre_usuario();
        String tipo_usuario = a.getTipo_usuario();
        String password_usuario = a.getPassword_usuario();
        String correo_usuario = a.getCorreo_usuario();
        String telefono_usuario = a.getTelefono_usuario();
        
        String query = "UPDATE usuarios SET id_usuario ="
                + Id_usuario + ","
                + "nombre_usuario = '" +nombre_usuario + "',"
                + "tipo_usuario = '" + tipo_usuario + "',"
                + "password_usuario = '" + password_usuario + "',"
                + "correo_usuario = '" + correo_usuario + "'," 
                + "telefono_usuario = '" + telefono_usuario + "'"
                + " WHERE id_usuario = "
                +Id_usuario;
        
        System.out.println(query);
        
        Statement smt = conexion.createStatement();
        int i = smt.executeUpdate(query);
        return i;
    }
        public int eliminar(int id_usuario) throws SQLException{
        Statement smt;
        String query = "DELETE FROM usuarios WHERE id_usuario =" + id_usuario;
        System.out.println(query);
        smt = conexion.createStatement();
        int i = smt.executeUpdate(query);
        return i;
    }
        
}

