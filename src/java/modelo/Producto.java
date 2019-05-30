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
public class Producto {
    private int id_producto;
    private String nombre_libro;
    private String descripcion_producto;
    private String unidad_producto;
    private int cantidad_producto;
    private String ubicacion_almacen;

    public Producto() {
    }

    /**
     * @return the id_producto
     */
    public int getId_producto() {
        return id_producto;
    }

    /**
     * @param id_producto the id_producto to set
     */
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_libro() {
        return nombre_libro;
    }

    public void setNombre_libro(String nombre_libro) {
        this.nombre_libro = nombre_libro;
    }

    /**
     * @return the descripcion_producto
     */
    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    /**
     * @param descripcion_producto the descripcion_producto to set
     */
    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    /**
     * @return the unidad_producto
     */
    public String getUnidad_producto() {
        return unidad_producto;
    }

    /**
     * @param unidad_producto the unidad_producto to set
     */
    public void setUnidad_producto(String unidad_producto) {
        this.unidad_producto = unidad_producto;
    }

    /**
     * @return the cantidad_producto
     */
    public int getCantidad_producto() {
        return cantidad_producto;
    }

    /**
     * @param cantidad_producto the cantidad_producto to set
     */
    public void setCantidad_producto(int cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }

    /**
     * @return the ubicacion_almacen
     */
    public String getUbicacion_almacen() {
        return ubicacion_almacen;
    }

    /**
     * @param ubicacion_almacen the ubicacion_almacen to set
     */
    public void setUbicacion_almacen(String ubicacion_almacen) {
        this.ubicacion_almacen = ubicacion_almacen;
    }
    
}
