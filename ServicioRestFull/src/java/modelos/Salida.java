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
@Table(name = "salida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salida.findAll", query = "SELECT s FROM Salida s")
    , @NamedQuery(name = "Salida.findByIdSalida", query = "SELECT s FROM Salida s WHERE s.idSalida = :idSalida")
    , @NamedQuery(name = "Salida.findByFecha", query = "SELECT s FROM Salida s WHERE s.fecha = :fecha")
    , @NamedQuery(name = "Salida.findByTipo", query = "SELECT s FROM Salida s WHERE s.tipo = :tipo")
    , @NamedQuery(name = "Salida.findByDestino", query = "SELECT s FROM Salida s WHERE s.destino = :destino")
    , @NamedQuery(name = "Salida.findByImporte", query = "SELECT s FROM Salida s WHERE s.importe = :importe")
    , @NamedQuery(name = "Salida.findByCreador", query = "SELECT s FROM Salida s WHERE s.creador = :creador")
    , @NamedQuery(name = "Salida.findByFechaCreacion", query = "SELECT s FROM Salida s WHERE s.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Salida.findByEliminado", query = "SELECT s FROM Salida s WHERE s.eliminado = :eliminado")})
public class Salida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_salida")
    private Integer idSalida;
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
    @Column(name = "destino")
    private String destino;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSalida")
    private Collection<DetalleSalida> detalleSalidaCollection;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne
    private Cliente idCliente;

    public Salida() {
    }

    public Salida(Integer idSalida) {
        this.idSalida = idSalida;
    }

    public Salida(Integer idSalida, Date fecha, String tipo, String destino, double importe, String creador, boolean eliminado) {
        this.idSalida = idSalida;
        this.fecha = fecha;
        this.tipo = tipo;
        this.destino = destino;
        this.importe = importe;
        this.creador = creador;
        this.eliminado = eliminado;
    }

    public Integer getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(Integer idSalida) {
        this.idSalida = idSalida;
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

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
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
    public Collection<DetalleSalida> getDetalleSalidaCollection() {
        return detalleSalidaCollection;
    }

    public void setDetalleSalidaCollection(Collection<DetalleSalida> detalleSalidaCollection) {
        this.detalleSalidaCollection = detalleSalidaCollection;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSalida != null ? idSalida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salida)) {
            return false;
        }
        Salida other = (Salida) object;
        if ((this.idSalida == null && other.idSalida != null) || (this.idSalida != null && !this.idSalida.equals(other.idSalida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "conexion.Salida[ idSalida=" + idSalida + " ]";
    }
    
}
