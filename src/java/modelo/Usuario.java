/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author CesarTu
 */
public class Usuario {
    private int id_usuario;
    private String nombre_usuario;
    private String apellido_usuario;
    private String tipo_usuario;
    private String password_usuario;
    private String correo_usuario;
    private String telefono_usuario;
//    private String fecha_creacion;
//    private String fecha_modificacion;

    public Usuario() {
    }

    /**
     * @return the id_usuario
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * @return the nombre_usuario
     */
    public String getNombre_usuario() {
        return nombre_usuario;
    }

    /**
     * @param nombre_usuario the nombre_usuario to set
     */
    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellido_usuario() {
        return apellido_usuario;
    }

    public void setApellido_usuario(String apellido_usuario) {
        this.apellido_usuario = apellido_usuario;
    }

    /**
     * @return the tipo_usuario
     */
    public String getTipo_usuario() {
        return tipo_usuario;
    }

    /**
     * @param tipo_usuario the tipo_usuario to set
     */
    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    /**
     * @return the password_usaurio
     */
    public String getPassword_usuario() {
        return password_usuario;
    }

    /**
     * @param password_usaurio the password_usaurio to set
     */
    public void setPassword_usuario(String password_usaurio) {
        this.password_usuario = password_usaurio;
    }

    /**
     * @return the correo_usaurio
     */
    public String getCorreo_usuario() {
        return correo_usuario;
    }

    /**
     * @param correo_usaurio the correo_usaurio to set
     */
    public void setCorreo_usuario(String correo_usaurio) {
        this.correo_usuario = correo_usaurio;
    }

    /**
     * @return the telefono_usaurio
     */
    public String getTelefono_usuario() {
        return telefono_usuario;
    }

    /**
     * @param telefono_usaurio the telefono_usaurio to set
     */
    public void setTelefono_usuario(String telefono_usaurio) {
        this.telefono_usuario = telefono_usaurio;
    }

//    public String getFecha_creacion() {
//        return fecha_creacion;
//    }
//
//    public void setFecha_creacion(String fecha_creacion) {
//        this.fecha_creacion = fecha_creacion;
//    }
//
//    public String getFecha_modificacion() {
//        return fecha_modificacion;
//    }
//
//    public void setFecha_modificacion(String fecha_modificacion) {
//        this.fecha_modificacion = fecha_modificacion;
//    }
    
}
