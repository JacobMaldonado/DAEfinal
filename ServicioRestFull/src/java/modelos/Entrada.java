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
@Table(name = "entrada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entrada.findAll", query = "SELECT e FROM Entrada e")
    , @NamedQuery(name = "Entrada.findByIdEntrada", query = "SELECT e FROM Entrada e WHERE e.idEntrada = :idEntrada")
    , @NamedQuery(name = "Entrada.findByProveedor", query = "SELECT e FROM Entrada e WHERE e.proveedor = :proveedor")
    , @NamedQuery(name = "Entrada.findByFecha", query = "SELECT e FROM Entrada e WHERE e.fecha = :fecha")
    , @NamedQuery(name = "Entrada.findByTipo", query = "SELECT e FROM Entrada e WHERE e.tipo = :tipo")
    , @NamedQuery(name = "Entrada.findByOrigen", query = "SELECT e FROM Entrada e WHERE e.origen = :origen")
    , @NamedQuery(name = "Entrada.findByImporte", query = "SELECT e FROM Entrada e WHERE e.importe = :importe")
    , @NamedQuery(name = "Entrada.findByCreador", query = "SELECT e FROM Entrada e WHERE e.creador = :creador")
    , @NamedQuery(name = "Entrada.findByFechaCreacion", query = "SELECT e FROM Entrada e WHERE e.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Entrada.findByEliminado", query = "SELECT e FROM Entrada e WHERE e.eliminado = :eliminado")})
public class Entrada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_entrada")
    private Integer idEntrada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "proveedor")
    private String proveedor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "origen")
    private String origen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe")
    private double importe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "creador")
    private String creador;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "eliminado")
    private boolean eliminado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEntrada")
    private Collection<DetalleEntrada> detalleEntradaCollection;

    public Entrada() {
    }

    public Entrada(Integer idEntrada) {
        this.idEntrada = idEntrada;
    }

    public Entrada(Integer idEntrada, String proveedor, Date fecha, String tipo, String origen, double importe, String creador, boolean eliminado) {
        this.idEntrada = idEntrada;
        this.proveedor = proveedor;
        this.fecha = fecha;
        this.tipo = tipo;
        this.origen = origen;
        this.importe = importe;
        this.creador = creador;
        this.eliminado = eliminado;
    }

    public Integer getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(Integer idEntrada) {
        this.idEntrada = idEntrada;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntrada != null ? idEntrada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrada)) {
            return false;
        }
        Entrada other = (Entrada) object;
        if ((this.idEntrada == null && other.idEntrada != null) || (this.idEntrada != null && !this.idEntrada.equals(other.idEntrada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "conexion.Entrada[ idEntrada=" + idEntrada + " ]";
    }
    
}
