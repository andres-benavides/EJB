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
@Table(name = "tamano_texto")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "TamanoTexto.findAll", query = "SELECT t FROM TamanoTexto t"),
  @NamedQuery(name = "TamanoTexto.findByIdTamanoTexto", query = "SELECT t FROM TamanoTexto t WHERE t.idTamanoTexto = :idTamanoTexto"),
  @NamedQuery(name = "TamanoTexto.findByEspecificacionTamano", query = "SELECT t FROM TamanoTexto t WHERE t.especificacionTamano = :especificacionTamano")})
public class TamanoTexto implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_tamano_texto")
  private Integer idTamanoTexto;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "especificacion_tamano")
  private String especificacionTamano;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTamanoTexto")
  private List<FacturaDetalle> facturaDetalleList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTamanoTexto")
  private List<TextoCamiseta> textoCamisetaList;
  @JoinColumn(name = "id_precio_texto", referencedColumnName = "id_precio_texto")
  @ManyToOne(optional = false)
  private PrecioTexto idPrecioTexto;

  public TamanoTexto() {
  }

  public TamanoTexto(Integer idTamanoTexto) {
    this.idTamanoTexto = idTamanoTexto;
  }

  public TamanoTexto(Integer idTamanoTexto, String especificacionTamano) {
    this.idTamanoTexto = idTamanoTexto;
    this.especificacionTamano = especificacionTamano;
  }

  public Integer getIdTamanoTexto() {
    return idTamanoTexto;
  }

  public void setIdTamanoTexto(Integer idTamanoTexto) {
    this.idTamanoTexto = idTamanoTexto;
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
  public List<TextoCamiseta> getTextoCamisetaList() {
    return textoCamisetaList;
  }

  public void setTextoCamisetaList(List<TextoCamiseta> textoCamisetaList) {
    this.textoCamisetaList = textoCamisetaList;
  }

  public PrecioTexto getIdPrecioTexto() {
    return idPrecioTexto;
  }

  public void setIdPrecioTexto(PrecioTexto idPrecioTexto) {
    this.idPrecioTexto = idPrecioTexto;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idTamanoTexto != null ? idTamanoTexto.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof TamanoTexto)) {
      return false;
    }
    TamanoTexto other = (TamanoTexto) object;
    if ((this.idTamanoTexto == null && other.idTamanoTexto != null) || (this.idTamanoTexto != null && !this.idTamanoTexto.equals(other.idTamanoTexto))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "co.estampas.entities.TamanoTexto[ idTamanoTexto=" + idTamanoTexto + " ]";
  }
  
}
