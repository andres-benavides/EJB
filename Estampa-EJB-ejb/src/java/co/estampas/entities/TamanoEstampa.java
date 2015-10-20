/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.estampas.entities;

import java.io.Serializable;
import java.util.List;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AndresV
 */
@Entity
@Table(name = "tamano_estampa")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "TamanoEstampa.findAll", query = "SELECT t FROM TamanoEstampa t"),
  @NamedQuery(name = "TamanoEstampa.findByIdTamanoEstampa", query = "SELECT t FROM TamanoEstampa t WHERE t.idTamanoEstampa = :idTamanoEstampa"),
  @NamedQuery(name = "TamanoEstampa.findByEspecificacionTamano", query = "SELECT t FROM TamanoEstampa t WHERE t.especificacionTamano = :especificacionTamano")})
public class TamanoEstampa implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_tamano_estampa")
  private Integer idTamanoEstampa;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "especificacion_tamano")
  private String especificacionTamano;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTamanoEstampa")
  private List<FacturaDetalle> facturaDetalleList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTamanoEstampa")
  private List<EstampaCamiseta> estampaCamisetaList;
  @JoinColumn(name = "id_precio_estampa", referencedColumnName = "id_precio_estampa")
  @ManyToOne(optional = false)
  private PrecioEstampa idPrecioEstampa;

  public TamanoEstampa() {
  }

  public TamanoEstampa(Integer idTamanoEstampa) {
    this.idTamanoEstampa = idTamanoEstampa;
  }

  public TamanoEstampa(Integer idTamanoEstampa, String especificacionTamano) {
    this.idTamanoEstampa = idTamanoEstampa;
    this.especificacionTamano = especificacionTamano;
  }

  public Integer getIdTamanoEstampa() {
    return idTamanoEstampa;
  }

  public void setIdTamanoEstampa(Integer idTamanoEstampa) {
    this.idTamanoEstampa = idTamanoEstampa;
  }

  public String getEspecificacionTamano() {
    return especificacionTamano;
  }

  public void setEspecificacionTamano(String especificacionTamano) {
    this.especificacionTamano = especificacionTamano;
  }

  @XmlTransient
  public List<FacturaDetalle> getFacturaDetalleList() {
    return facturaDetalleList;
  }

  public void setFacturaDetalleList(List<FacturaDetalle> facturaDetalleList) {
    this.facturaDetalleList = facturaDetalleList;
  }

  @XmlTransient
  public List<EstampaCamiseta> getEstampaCamisetaList() {
    return estampaCamisetaList;
  }

  public void setEstampaCamisetaList(List<EstampaCamiseta> estampaCamisetaList) {
    this.estampaCamisetaList = estampaCamisetaList;
  }

  public PrecioEstampa getIdPrecioEstampa() {
    return idPrecioEstampa;
  }

  public void setIdPrecioEstampa(PrecioEstampa idPrecioEstampa) {
    this.idPrecioEstampa = idPrecioEstampa;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idTamanoEstampa != null ? idTamanoEstampa.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof TamanoEstampa)) {
      return false;
    }
    TamanoEstampa other = (TamanoEstampa) object;
    if ((this.idTamanoEstampa == null && other.idTamanoEstampa != null) || (this.idTamanoEstampa != null && !this.idTamanoEstampa.equals(other.idTamanoEstampa))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "co.estampas.entities.TamanoEstampa[ idTamanoEstampa=" + idTamanoEstampa + " ]";
  }
  
}
