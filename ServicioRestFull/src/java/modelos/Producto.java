/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jacob
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto")
    , @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Producto.findByProveedor", query = "SELECT p FROM Producto p WHERE p.proveedor = :proveedor")
    , @NamedQuery(name = "Producto.findByUbicacionAlmacen", query = "SELECT p FROM Producto p WHERE p.ubicacionAlmacen = :ubicacionAlmacen")
    , @NamedQuery(name = "Producto.findByCosto", query = "SELECT p FROM Producto p WHERE p.costo = :costo")
    , @NamedQuery(name = "Producto.findByPrecio", query = "SELECT p FROM Producto p WHERE p.precio = :precio")
    , @NamedQuery(name = "Producto.findByStock", query = "SELECT p FROM Producto p WHERE p.stock = :stock")
    , @NamedQuery(name = "Producto.findByStockMinimo", query = "SELECT p FROM Producto p WHERE p.stockMinimo = :stockMinimo")
    , @NamedQuery(name = "Producto.findByAvisoStockMinimo", query = "SELECT p FROM Producto p WHERE p.avisoStockMinimo = :avisoStockMinimo")
    , @NamedQuery(name = "Producto.findByObservaciones", query = "SELECT p FROM Producto p WHERE p.observaciones = :observaciones")
    , @NamedQuery(name = "Producto.findByCreador", query = "SELECT p FROM Producto p WHERE p.creador = :creador")
    , @NamedQuery(name = "Producto.findByFechaCreacion", query = "SELECT p FROM Producto p WHERE p.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Producto.findByModificador", query = "SELECT p FROM Producto p WHERE p.modificador = :modificador")
    , @NamedQuery(name = "Producto.findByFechaModificacion", query = "SELECT p FROM Producto p WHERE p.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "Producto.findByEliminado", query = "SELECT p FROM Producto p WHERE p.eliminado = :eliminado")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_producto")
    private Integer idProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "proveedor")
    private String proveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ubicacion_almacen")
    private String ubicacionAlmacen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo")
    private double costo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock")
    private int stock;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock_minimo")
    private int stockMinimo;
    @Column(name = "aviso_stock_minimo")
    private Boolean avisoStockMinimo;
    @Size(max = 50)
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "creador")
    private String creador;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Size(max = 40)
    @Column(name = "modificador")
    private String modificador;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eliminado")
    private boolean eliminado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private Collection<DetalleEntrada> detalleEntradaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private Collection<DetalleSalida> detalleSalidaCollection;
    @JoinColumn(name = "id_unidad", referencedColumnName = "id_unidad")
    @ManyToOne(optional = false)
    private Unidad idUnidad;

    public Producto() {
    }

    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(Integer idProducto, String nombre, String descripcion, String proveedor, String ubicacionAlmacen, double costo, double precio, int stock, int stockMinimo, String creador, boolean eliminado) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
        this.ubicacionAlmacen = ubicacionAlmacen;
        this.costo = costo;
        this.precio = precio;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
        this.creador = creador;
        this.eliminado = eliminado;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getUbicacionAlmacen() {
        return ubicacionAlmacen;
    }

    public void setUbicacionAlmacen(String ubicacionAlmacen) {
        this.ubicacionAlmacen = ubicacionAlmacen;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public Boolean getAvisoStockMinimo() {
        return avisoStockMinimo;
    }

    public void setAvisoStockMinimo(Boolean avisoStockMinimo) {
        this.avisoStockMinimo = avisoStockMinimo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getModificador() {
        return modificador;
    }

    public void setModificador(String modificador) {
        this.modificador = modificador;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    @XmlTransient
    public Collection<DetalleEntrada> getDetalleEntradaCollection() {
        return detalleEntradaCollection;
    }

    public void setDetalleEntradaCollection(Collection<DetalleEntrada> detalleEntradaCollection) {
        this.detalleEntradaCollection = detalleEntradaCollection;
    }

    @XmlTransient
    public Collection<DetalleSalida> getDetalleSalidaCollection() {
        return detalleSalidaCollection;
    }

    public void setDetalleSalidaCollection(Collection<DetalleSalida> detalleSalidaCollection) {
        this.detalleSalidaCollection = detalleSalidaCollection;
    }

    public Unidad getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Unidad idUnidad) {
        this.idUnidad = idUnidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "conexion.Producto[ idProducto=" + idProducto + " ]";
    }
    
}
