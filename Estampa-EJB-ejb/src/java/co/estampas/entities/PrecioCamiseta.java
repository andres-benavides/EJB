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
@Table(name = "precio_camiseta")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "PrecioCamiseta.findAll", query = "SELECT p FROM PrecioCamiseta p"),
  @NamedQuery(name = "PrecioCamiseta.findByIdPrecioCamiseta", query = "SELECT p FROM PrecioCamiseta p WHERE p.idPrecioCamiseta = :idPrecioCamiseta"),
  @NamedQuery(name = "PrecioCamiseta.findByPrecio", query = "SELECT p FROM PrecioCamiseta p WHERE p.precio = :precio")})
public class PrecioCamiseta implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_precio_camiseta")
  private Integer idPrecioCamiseta;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "precio")
  private String precio;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrecioCamiseta")
  private List<FacturaDetalle> facturaDetalleList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrecioCamiseta")
  private List<Camiseta> camisetaList;

  public PrecioCamiseta() {
  }

  public PrecioCamiseta(Integer idPrecioCamiseta) {
    this.idPrecioCamiseta = idPrecioCamiseta;
  }

  public PrecioCamiseta(Integer idPrecioCamiseta, String precio) {
    this.idPrecioCamiseta = idPrecioCamiseta;
    this.precio = precio;
  }

  public Integer getIdPrecioCamiseta() {
    return idPrecioCamiseta;
  }

  public void setIdPrecioCamiseta(Integer idPrecioCamiseta) {
    this.idPrecioCamiseta = idPrecioCamiseta;
  }

  public String getPrecio() {
    return precio;
  }

  public void setPrecio(String precio) {
    this.precio = precio;
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
    hash += (idPrecioCamiseta != null ? idPrecioCamiseta.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof PrecioCamiseta)) {
      return false;
    }
    PrecioCamiseta other = (PrecioCamiseta) object;
    if ((this.idPrecioCamiseta == null && other.idPrecioCamiseta != null) || (this.idPrecioCamiseta != null && !this.idPrecioCamiseta.equals(other.idPrecioCamiseta))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "co.estampas.entities.PrecioCamiseta[ idPrecioCamiseta=" + idPrecioCamiseta + " ]";
  }
  
}
