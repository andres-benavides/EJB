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
@Table(name = "lugar_estampa_camiseta")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "LugarEstampaCamiseta.findAll", query = "SELECT l FROM LugarEstampaCamiseta l"),
  @NamedQuery(name = "LugarEstampaCamiseta.findByIdLugarEstampaCamiseta", query = "SELECT l FROM LugarEstampaCamiseta l WHERE l.idLugarEstampaCamiseta = :idLugarEstampaCamiseta"),
  @NamedQuery(name = "LugarEstampaCamiseta.findByEspecificacionLugar", query = "SELECT l FROM LugarEstampaCamiseta l WHERE l.especificacionLugar = :especificacionLugar")})
public class LugarEstampaCamiseta implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_lugar_estampa_camiseta")
  private Integer idLugarEstampaCamiseta;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "especificacion_lugar")
  private String especificacionLugar;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLugarEstampaCamiseta")
  private List<FacturaDetalle> facturaDetalleList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLugarEstampaCamiseta")
  private List<Camiseta> camisetaList;

  public LugarEstampaCamiseta() {
  }

  public LugarEstampaCamiseta(Integer idLugarEstampaCamiseta) {
    this.idLugarEstampaCamiseta = idLugarEstampaCamiseta;
  }

  public LugarEstampaCamiseta(Integer idLugarEstampaCamiseta, String especificacionLugar) {
    this.idLugarEstampaCamiseta = idLugarEstampaCamiseta;
    this.especificacionLugar = especificacionLugar;
  }

  public Integer getIdLugarEstampaCamiseta() {
    return idLugarEstampaCamiseta;
  }

  public void setIdLugarEstampaCamiseta(Integer idLugarEstampaCamiseta) {
    this.idLugarEstampaCamiseta = idLugarEstampaCamiseta;
  }

  public String getEspecificacionLugar() {
    return especificacionLugar;
  }

  public void setEspecificacionLugar(String especificacionLugar) {
    this.especificacionLugar = especificacionLugar;
  }

  @XmlTransient
  public List<FacturaDetalle> getFacturaDetalleList() {
    return facturaDetalleList;
  }

  public void setFacturaDetalleList(List<FacturaDetalle> facturaDetalleList) {
    this.facturaDetalleList = facturaDetalleList;
  }

  @XmlTransient
  public List<Camiseta> getCamisetaList() {
    return camisetaList;
  }

  public void setCamisetaList(List<Camiseta> camisetaList) {
    this.camisetaList = camisetaList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idLugarEstampaCamiseta != null ? idLugarEstampaCamiseta.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof LugarEstampaCamiseta)) {
      return false;
    }
    LugarEstampaCamiseta other = (LugarEstampaCamiseta) object;
    if ((this.idLugarEstampaCamiseta == null && other.idLugarEstampaCamiseta != null) || (this.idLugarEstampaCamiseta != null && !this.idLugarEstampaCamiseta.equals(other.idLugarEstampaCamiseta))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "co.estampas.entities.LugarEstampaCamiseta[ idLugarEstampaCamiseta=" + idLugarEstampaCamiseta + " ]";
  }
  
}
