/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jacob
 */
@Entity
@Table(name = "detalle_entrada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleEntrada.findAll", query = "SELECT d FROM DetalleEntrada d")
    , @NamedQuery(name = "DetalleEntrada.findByIdDetalleEntrada", query = "SELECT d FROM DetalleEntrada d WHERE d.idDetalleEntrada = :idDetalleEntrada")
    , @NamedQuery(name = "DetalleEntrada.findByCantidad", query = "SELECT d FROM DetalleEntrada d WHERE d.cantidad = :cantidad")})
public class DetalleEntrada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_entrada")
    private Integer idDetalleEntrada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "id_entrada", referencedColumnName = "id_entrada")
    @ManyToOne(optional = false)
    private Entrada idEntrada;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false)
    private Producto idProducto;

    public DetalleEntrada() {
    }

    public DetalleEntrada(Integer idDetalleEntrada) {
        this.idDetalleEntrada = idDetalleEntrada;
    }

    public DetalleEntrada(Integer idDetalleEntrada, int cantidad) {
        this.idDetalleEntrada = idDetalleEntrada;
        this.cantidad = cantidad;
    }

    public Integer getIdDetalleEntrada() {
        return idDetalleEntrada;
    }

    public void setIdDetalleEntrada(Integer idDetalleEntrada) {
        this.idDetalleEntrada = idDetalleEntrada;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Entrada getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(Entrada idEntrada) {
        this.idEntrada = idEntrada;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleEntrada != null ? idDetalleEntrada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleEntrada)) {
            return false;
        }
        DetalleEntrada other = (DetalleEntrada) object;
        if ((this.idDetalleEntrada == null && other.idDetalleEntrada != null) || (this.idDetalleEntrada != null && !this.idDetalleEntrada.equals(other.idDetalleEntrada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "conexion.DetalleEntrada[ idDetalleEntrada=" + idDetalleEntrada + " ]";
    }
    
}
