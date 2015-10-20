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
@Table(name = "precio_estampa")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "PrecioEstampa.findAll", query = "SELECT p FROM PrecioEstampa p"),
  @NamedQuery(name = "PrecioEstampa.findByIdPrecioEstampa", query = "SELECT p FROM PrecioEstampa p WHERE p.idPrecioEstampa = :idPrecioEstampa"),
  @NamedQuery(name = "PrecioEstampa.findByPrecio", query = "SELECT p FROM PrecioEstampa p WHERE p.precio = :precio")})
public class PrecioEstampa implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_precio_estampa")
  private Integer idPrecioEstampa;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "precio")
  private String precio;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrecioEstampa")
  private List<FacturaDetalle> facturaDetalleList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrecioEstampa")
  private List<TamanoEstampa> tamanoEstampaList;

  public PrecioEstampa() {
  }

  public PrecioEstampa(Integer idPrecioEstampa) {
    this.idPrecioEstampa = idPrecioEstampa;
  }

  public PrecioEstampa(Integer idPrecioEstampa, String precio) {
    this.idPrecioEstampa = idPrecioEstampa;
    this.precio = precio;
  }

  public Integer getIdPrecioEstampa() {
    return idPrecioEstampa;
  }

  public void setIdPrecioEstampa(Integer idPrecioEstampa) {
    this.idPrecioEstampa = idPrecioEstampa;
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
  public List<TamanoEstampa> getTamanoEstampaList() {
    return tamanoEstampaList;
  }

  public void setTamanoEstampaList(List<TamanoEstampa> tamanoEstampaList) {
    this.tamanoEstampaList = tamanoEstampaList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idPrecioEstampa != null ? idPrecioEstampa.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof PrecioEstampa)) {
      return false;
    }
    PrecioEstampa other = (PrecioEstampa) object;
    if ((this.idPrecioEstampa == null && other.idPrecioEstampa != null) || (this.idPrecioEstampa != null && !this.idPrecioEstampa.equals(other.idPrecioEstampa))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "co.estampas.entities.PrecioEstampa[ idPrecioEstampa=" + idPrecioEstampa + " ]";
  }
  
}
