package controlador;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.usuario1;

/**
 *
 * @author ANGEL
 */
public class consultasUsuario extends Conexion {

    public Object[] fila = new Object[12];
    
    public boolean autenticacion(String usuario, String contraseña) {
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String consulta = "SELECT * FROM usuario WHERE (username = ? AND password = SHA(?)) and eliminado=0";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, usuario);
            pst.setString(2, contraseña);
            System.out.println("pst: " + pst.toString());
            rs = pst.executeQuery();

            if (rs.absolute(1)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (getConexion() != null) {
                    getConexion().close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public boolean registrar(String nombre, String apellido, String username, String correo, String contraseña,
            int tipo, String creador) {
        PreparedStatement pst = null;

        try {
            String consulta = "INSERT INTO usuario(nombre,apellido,username,email,password,id_rol,creador) VALUES(?,?,?,?,SHA(?),?,?)";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, nombre);
            pst.setString(2, apellido);
            pst.setString(3, username);
            pst.setString(4, correo);
            pst.setString(5, contraseña);
            pst.setInt(6, tipo);
            pst.setString(7, creador);

            if (pst.executeUpdate() == 1) {
                return true;
            }
        } catch (Exception e) {
            return false;
        } finally {
            try {
                if (getConexion() != null) {
                    getConexion().close();
                }
                if (pst != null) {
                    pst.close();
                }

            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public boolean borrar(int id) {
        PreparedStatement pst = null;

        try {
            String consulta = "UPDATE usuario set eliminado = ? WHERE id_usuario = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setBoolean(1, true);
            pst.setInt(2, id);

            if (pst.executeUpdate() == 1) {
                return true;
            }
        } catch (Exception e) {
            return false;
        } finally {
            try {
                if (getConexion() != null) {
                    getConexion().close();
                }
                if (pst != null) {
                    pst.close();
                }

            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public boolean actualizar(String nombre, String apellido, String username, String correo, String contraseña,
            int tipo, String modificador, int id) {
        PreparedStatement pst = null;

        try {
            String consulta = "UPDATE usuario SET nombre = ?,apellido = ?,username = ?,email = ?,"
                    + "password = SHA(?),id_rol = ?,modificador = ?,fecha_modificacion=NOW() WHERE id_usuario = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, nombre);
            pst.setString(2, apellido);
            pst.setString(3, username);
            pst.setString(4, correo);
            pst.setString(5, contraseña);
            pst.setInt(6, tipo);
            pst.setString(7, modificador);
            pst.setInt(8, id);

            if (pst.executeUpdate() == 1) {
                return true;
            }
        } catch (Exception e) {
            return false;
        } finally {
            try {
                if (getConexion() != null) {
                    getConexion().close();
                }
                if (pst != null) {
                    pst.close();
                }

            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public List<usuario1> buscar(String cadena) {
        Statement pst = null;
        ResultSet rs = null;
        List lista = new ArrayList<>();
        if (cadena.matches("^[A-Za-z0-9]+$")
                || cadena.matches("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$")) {
            try {

                String consulta = "SELECT * FROM usuario WHERE concat(id_usuario,nombre,apellido,"
                        + "username,email,id_rol,creador) LIKE '%" + cadena + "%' and eliminado=0";
                pst = getConexion().createStatement();
                rs = pst.executeQuery(consulta);

                while (rs.next()) {
                    usuario1 u = new usuario1();
                    u.setId(rs.getInt(1));
                    u.setNombre(rs.getString(2));
                    u.setApellido(rs.getString(3));
                    u.setUsername(rs.getString(4));
                    u.setCorreo(rs.getString(5));
                    u.setContraseña(rs.getString(6));
                    u.setTipo(rs.getInt(7));
                    u.setCreador(rs.getString(8));
                    u.setFecha_creacion(rs.getString(9));
                    u.setModificador(rs.getString(10));
                    u.setFecha_modificacion(rs.getString(11));
                    u.setEliminado(rs.getBoolean(12));

                    lista.add(u);
                }

            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "Error " + e);
            } finally {
                try {
                    if (getConexion() != null) {
                        getConexion().close();
                    }
                    if (pst != null) {
                        pst.close();
                    }
                    if (rs != null) {
                        rs.close();
                    }
                } catch (Exception e) {
//                    JOptionPane.showMessageDialog(null, "Error " + e);
                }
            }
        }
        return lista;
    }

    public List<usuario1> usuarios() {
        Statement pst = null;
        ResultSet rs = null;
        List lista = new ArrayList<>();
        try {

            String consulta = "SELECT * FROM usuario WHERE eliminado=0";
            pst = getConexion().createStatement();
            rs = pst.executeQuery(consulta);

            while (rs.next()) {
                usuario1 u = new usuario1();
                u.setId(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setApellido(rs.getString(3));
                u.setUsername(rs.getString(4));
                u.setCorreo(rs.getString(5));
                u.setContraseña(rs.getString(6));
                u.setTipo(rs.getInt(7));
                u.setCreador(rs.getString(8));
                u.setFecha_creacion(rs.getString(9));
                u.setModificador(rs.getString(10));
                u.setFecha_modificacion(rs.getString(11));
                u.setEliminado(rs.getBoolean(12));

                lista.add(u);
            }

        } catch (Exception e) {

        } finally {
            try {
                if (getConexion() != null) {
                    getConexion().close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {

            }
        }

        return lista;
    }

    public usuario1 usuario(int id) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        usuario1 u = new usuario1();
        try {

            String consulta = "SELECT * FROM usuario WHERE id_usuario = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, id);
            rs = pst.executeQuery();

            if (rs.next()) {
                u.setId(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setApellido(rs.getString(3));
                u.setUsername(rs.getString(4));
                u.setCorreo(rs.getString(5));
                u.setContraseña(rs.getString(6));
                u.setTipo(rs.getInt(7));
                u.setCreador(rs.getString(8));
                u.setFecha_creacion(rs.getString(9));
                u.setModificador(rs.getString(10));
                u.setFecha_modificacion(rs.getString(11));
                u.setEliminado(rs.getBoolean(12));

            }

        } catch (Exception e) {

        } finally {
            try {
                if (getConexion() != null) {
                    getConexion().close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {

            }
        }

        return u;
    }

    public boolean isEmailRegistered(String correo) throws SQLException {
        PreparedStatement pst = null;
        ResultSet rs = null;

        String consulta = "SELECT * FROM usuario WHERE email = ? and eliminado=0";
        pst = getConexion().prepareStatement(consulta);
        pst.setString(1, correo);
        rs = pst.executeQuery();

        return rs.next();
    }
    
    public boolean isUsernameRegistered(String username) throws SQLException {
        PreparedStatement pst = null;
        ResultSet rs = null;

        String consulta = "SELECT * FROM usuario WHERE username = ? and eliminado=0";
        pst = getConexion().prepareStatement(consulta);
        pst.setString(1, username);
        rs = pst.executeQuery();

        return rs.next();
    }

    public String obtenerId(String correo) {
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String consulta = "SELECT id_usuario FROM usuario WHERE email = ? and eliminado=0";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, correo);
            rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
            return "";
        } finally {
            try {
                if (getConexion() != null) {
                    getConexion().close();
                }
                if (pst != null) {
                    pst.close();
                }

                if (rs != null) {
                    rs.close();
                }

            } catch (Exception e) {
                return "";
            }
        }
        return "";
    }

    public static void main(String[] args) throws SQLException {
        consultasUsuario c = new consultasUsuario();
////        usuario u=new usuario();
//         System.out.println(c.autenticacion("angel123","123"));
        System.out.println(c.registrar("angel", "hernandez", "wwd", "wwd@hotmail.com", "wwd", 1, "angel"));
//      System.out.println(c.actualizar("Angel", "Hernandez", "angel123", "angel@hotmail.com","123", 2,"angel2",5));
//        System.out.println(c.buscar("angel123").get(0).getTipo());
////        System.out.println(u.getApellido());
//        System.out.println(c.isEmailRegistered("angel@hotmail.com"));
//            System.out.println(c.borrar(5));
//System.out.println(c.obtenerId("ww@hotmail.com"));
//System.out.println(c.usuario(12).getCorreo());
//System.out.println(c.usuarios().get(0).getCorreo());
    }
}
