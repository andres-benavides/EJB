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
@Table(name = "tema_estampa")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "TemaEstampa.findAll", query = "SELECT t FROM TemaEstampa t"),
  @NamedQuery(name = "TemaEstampa.findByIdTemaEstampa", query = "SELECT t FROM TemaEstampa t WHERE t.idTemaEstampa = :idTemaEstampa"),
  @NamedQuery(name = "TemaEstampa.findByTipoTema", query = "SELECT t FROM TemaEstampa t WHERE t.tipoTema = :tipoTema")})
public class TemaEstampa implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_tema_estampa")
  private Integer idTemaEstampa;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "tipo_tema")
  private String tipoTema;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTemaEstampa")
  private List<FacturaDetalle> facturaDetalleList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTemaEstampa")
  private List<EstampaCamiseta> estampaCamisetaList;

  public TemaEstampa() {
  }

  public TemaEstampa(Integer idTemaEstampa) {
    this.idTemaEstampa = idTemaEstampa;
  }

  public TemaEstampa(Integer idTemaEstampa, String tipoTema) {
    this.idTemaEstampa = idTemaEstampa;
    this.tipoTema = tipoTema;
  }

  public Integer getIdTemaEstampa() {
    return idTemaEstampa;
  }

  public void setIdTemaEstampa(Integer idTemaEstampa) {
    this.idTemaEstampa = idTemaEstampa;
  }

  public String getTipoTema() {
    return tipoTema;
  }

  public void setTipoTema(String tipoTema) {
    this.tipoTema = tipoTema;
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

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idTemaEstampa != null ? idTemaEstampa.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof TemaEstampa)) {
      return false;
    }
    TemaEstampa other = (TemaEstampa) object;
    if ((this.idTemaEstampa == null && other.idTemaEstampa != null) || (this.idTemaEstampa != null && !this.idTemaEstampa.equals(other.idTemaEstampa))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "co.estampas.entities.TemaEstampa[ idTemaEstampa=" + idTemaEstampa + " ]";
  }
  
}
