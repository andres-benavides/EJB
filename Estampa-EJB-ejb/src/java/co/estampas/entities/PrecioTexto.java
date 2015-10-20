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
@Table(name = "precio_texto")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "PrecioTexto.findAll", query = "SELECT p FROM PrecioTexto p"),
  @NamedQuery(name = "PrecioTexto.findByIdPrecioTexto", query = "SELECT p FROM PrecioTexto p WHERE p.idPrecioTexto = :idPrecioTexto"),
  @NamedQuery(name = "PrecioTexto.findByPrecio", query = "SELECT p FROM PrecioTexto p WHERE p.precio = :precio")})
public class PrecioTexto implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_precio_texto")
  private Integer idPrecioTexto;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "precio")
  private String precio;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrecioTexto")
  private List<FacturaDetalle> facturaDetalleList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrecioTexto")
  private List<TamanoTexto> tamanoTextoList;

  public PrecioTexto() {
  }

  public PrecioTexto(Integer idPrecioTexto) {
    this.idPrecioTexto = idPrecioTexto;
  }

  public PrecioTexto(Integer idPrecioTexto, String precio) {
    this.idPrecioTexto = idPrecioTexto;
    this.precio = precio;
  }

  public Integer getIdPrecioTexto() {
    return idPrecioTexto;
  }

  public void setIdPrecioTexto(Integer idPrecioTexto) {
    this.idPrecioTexto = idPrecioTexto;
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
  public List<TamanoTexto> getTamanoTextoList() {
    return tamanoTextoList;
  }

  public void setTamanoTextoList(List<TamanoTexto> tamanoTextoList) {
    this.tamanoTextoList = tamanoTextoList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idPrecioTexto != null ? idPrecioTexto.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof PrecioTexto)) {
      return false;
    }
    PrecioTexto other = (PrecioTexto) object;
    if ((this.idPrecioTexto == null && other.idPrecioTexto != null) || (this.idPrecioTexto != null && !this.idPrecioTexto.equals(other.idPrecioTexto))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "co.estampas.entities.PrecioTexto[ idPrecioTexto=" + idPrecioTexto + " ]";
  }
  
}
