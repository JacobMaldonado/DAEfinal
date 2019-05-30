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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente")
    , @NamedQuery(name = "Cliente.findByNombre", query = "SELECT c FROM Cliente c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Cliente.findByApellidoPa", query = "SELECT c FROM Cliente c WHERE c.apellidoPa = :apellidoPa")
    , @NamedQuery(name = "Cliente.findByApellidoMa", query = "SELECT c FROM Cliente c WHERE c.apellidoMa = :apellidoMa")
    , @NamedQuery(name = "Cliente.findByCalle", query = "SELECT c FROM Cliente c WHERE c.calle = :calle")
    , @NamedQuery(name = "Cliente.findByColonia", query = "SELECT c FROM Cliente c WHERE c.colonia = :colonia")
    , @NamedQuery(name = "Cliente.findByMunicipio", query = "SELECT c FROM Cliente c WHERE c.municipio = :municipio")
    , @NamedQuery(name = "Cliente.findByEstado", query = "SELECT c FROM Cliente c WHERE c.estado = :estado")
    , @NamedQuery(name = "Cliente.findByCp", query = "SELECT c FROM Cliente c WHERE c.cp = :cp")
    , @NamedQuery(name = "Cliente.findByCorreo", query = "SELECT c FROM Cliente c WHERE c.correo = :correo")
    , @NamedQuery(name = "Cliente.findByTelefono", query = "SELECT c FROM Cliente c WHERE c.telefono = :telefono")
    , @NamedQuery(name = "Cliente.findByRazonSoc", query = "SELECT c FROM Cliente c WHERE c.razonSoc = :razonSoc")
    , @NamedQuery(name = "Cliente.findByRfc", query = "SELECT c FROM Cliente c WHERE c.rfc = :rfc")
    , @NamedQuery(name = "Cliente.findByObservaciones", query = "SELECT c FROM Cliente c WHERE c.observaciones = :observaciones")
    , @NamedQuery(name = "Cliente.findByCreador", query = "SELECT c FROM Cliente c WHERE c.creador = :creador")
    , @NamedQuery(name = "Cliente.findByFechaCreacion", query = "SELECT c FROM Cliente c WHERE c.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Cliente.findByModificador", query = "SELECT c FROM Cliente c WHERE c.modificador = :modificador")
    , @NamedQuery(name = "Cliente.findByFechaModificacion", query = "SELECT c FROM Cliente c WHERE c.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "Cliente.findByEliminado", query = "SELECT c FROM Cliente c WHERE c.eliminado = :eliminado")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente")
    private Integer idCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "apellido_pa")
    private String apellidoPa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "apellido_ma")
    private String apellidoMa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "calle")
    private String calle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "colonia")
    private String colonia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "municipio")
    private String municipio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cp")
    private int cp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")
    private double telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "razon_soc")
    private String razonSoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "rfc")
    private String rfc;
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
    @OneToMany(mappedBy = "idCliente")
    private Collection<Salida> salidaCollection;

    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(Integer idCliente, String nombre, String apellidoPa, String apellidoMa, String calle, String colonia, String municipio, String estado, int cp, String correo, double telefono, String razonSoc, String rfc, String creador, boolean eliminado) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidoPa = apellidoPa;
        this.apellidoMa = apellidoMa;
        this.calle = calle;
        this.colonia = colonia;
        this.municipio = municipio;
        this.estado = estado;
        this.cp = cp;
        this.correo = correo;
        this.telefono = telefono;
        this.razonSoc = razonSoc;
        this.rfc = rfc;
        this.creador = creador;
        this.eliminado = eliminado;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPa() {
        return apellidoPa;
    }

    public void setApellidoPa(String apellidoPa) {
        this.apellidoPa = apellidoPa;
    }

    public String getApellidoMa() {
        return apellidoMa;
    }

    public void setApellidoMa(String apellidoMa) {
        this.apellidoMa = apellidoMa;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public double getTelefono() {
        return telefono;
    }

    public void setTelefono(double telefono) {
        this.telefono = telefono;
    }

    public String getRazonSoc() {
        return razonSoc;
    }

    public void setRazonSoc(String razonSoc) {
        this.razonSoc = razonSoc;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
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
    public Collection<Salida> getSalidaCollection() {
        return salidaCollection;
    }

    public void setSalidaCollection(Collection<Salida> salidaCollection) {
        this.salidaCollection = salidaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "conexion.Cliente[ idCliente=" + idCliente + " ]";
    }
    
}
