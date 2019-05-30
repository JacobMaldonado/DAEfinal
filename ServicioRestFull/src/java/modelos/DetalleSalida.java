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
@Table(name = "detalle_salida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleSalida.findAll", query = "SELECT d FROM DetalleSalida d")
    , @NamedQuery(name = "DetalleSalida.findByIdDetalleSalida", query = "SELECT d FROM DetalleSalida d WHERE d.idDetalleSalida = :idDetalleSalida")
    , @NamedQuery(name = "DetalleSalida.findByCantidad", query = "SELECT d FROM DetalleSalida d WHERE d.cantidad = :cantidad")})
public class DetalleSalida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_salida")
    private Integer idDetalleSalida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false)
    private Producto idProducto;
    @JoinColumn(name = "id_salida", referencedColumnName = "id_salida")
    @ManyToOne(optional = false)
    private Salida idSalida;

    public DetalleSalida() {
    }

    public DetalleSalida(Integer idDetalleSalida) {
        this.idDetalleSalida = idDetalleSalida;
    }

    public DetalleSalida(Integer idDetalleSalida, int cantidad) {
        this.idDetalleSalida = idDetalleSalida;
        this.cantidad = cantidad;
    }

    public Integer getIdDetalleSalida() {
        return idDetalleSalida;
    }

    public void setIdDetalleSalida(Integer idDetalleSalida) {
        this.idDetalleSalida = idDetalleSalida;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Salida getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(Salida idSalida) {
        this.idSalida = idSalida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleSalida != null ? idDetalleSalida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleSalida)) {
            return false;
        }
        DetalleSalida other = (DetalleSalida) object;
        if ((this.idDetalleSalida == null && other.idDetalleSalida != null) || (this.idDetalleSalida != null && !this.idDetalleSalida.equals(other.idDetalleSalida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "conexion.DetalleSalida[ idDetalleSalida=" + idDetalleSalida + " ]";
    }
    
}
