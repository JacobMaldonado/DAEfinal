package Conexion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion1 {

    private Connection conexion = null;

    public Conexion1() {
        try {
            File archivo = new File("C:\\Program Files\\BD\\configDAE.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String driver, server, usuario, contraseña;
            driver = br.readLine();
            server = br.readLine();
            usuario = br.readLine();
            contraseña = br.readLine();
            Class.forName(driver);
            conexion = DriverManager.getConnection(server, usuario, contraseña);
        } catch (SQLException e) {
            System.out.println("Error al establecer conexión: " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar driver: " + e);
        } catch (IOException e) {
            String mensaje = "No se pudo tener acceso al archivo de configuración\n"
                                + " de conexión a la base de datos\n"
                                + "Ocurrio un error " + e.getMessage();
            JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public Connection getConexion(){
        return conexion;
    }

}

