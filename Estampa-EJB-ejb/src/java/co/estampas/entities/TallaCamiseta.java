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
@Table(name = "talla_camiseta")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "TallaCamiseta.findAll", query = "SELECT t FROM TallaCamiseta t"),
  @NamedQuery(name = "TallaCamiseta.findByIdTalla", query = "SELECT t FROM TallaCamiseta t WHERE t.idTalla = :idTalla"),
  @NamedQuery(name = "TallaCamiseta.findByTalla", query = "SELECT t FROM TallaCamiseta t WHERE t.talla = :talla")})
public class TallaCamiseta implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_talla")
  private Integer idTalla;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 10)
  @Column(name = "talla")
  private String talla;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTalla")
  private List<FacturaDetalle> facturaDetalleList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTalla")
  private List<Camiseta> camisetaList;

  public TallaCamiseta() {
  }

  public TallaCamiseta(Integer idTalla) {
    this.idTalla = idTalla;
  }

  public TallaCamiseta(Integer idTalla, String talla) {
    this.idTalla = idTalla;
    this.talla = talla;
  }

  public Integer getIdTalla() {
    return idTalla;
  }

  public void setIdTalla(Integer idTalla) {
    this.idTalla = idTalla;
  }

  public String getTalla() {
    return talla;
  }

  public void setTalla(String talla) {
    this.talla = talla;
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
    hash += (idTalla != null ? idTalla.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof TallaCamiseta)) {
      return false;
    }
    TallaCamiseta other = (TallaCamiseta) object;
    if ((this.idTalla == null && other.idTalla != null) || (this.idTalla != null && !this.idTalla.equals(other.idTalla))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "co.estampas.entities.TallaCamiseta[ idTalla=" + idTalla + " ]";
  }
  
}
