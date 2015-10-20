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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AndresV
 */
@Entity
@Table(name = "stock")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s"),
  @NamedQuery(name = "Stock.findByIdStock", query = "SELECT s FROM Stock s WHERE s.idStock = :idStock"),
  @NamedQuery(name = "Stock.findByCantidad", query = "SELECT s FROM Stock s WHERE s.cantidad = :cantidad")})
public class Stock implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_stock")
  private Integer idStock;
  @Basic(optional = false)
  @NotNull
  @Column(name = "cantidad")
  private int cantidad;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStock")
  private List<FacturaDetalle> facturaDetalleList;

  public Stock() {
  }

  public Stock(Integer idStock) {
    this.idStock = idStock;
  }

  public Stock(Integer idStock, int cantidad) {
    this.idStock = idStock;
    this.cantidad = cantidad;
  }

  public Integer getIdStock() {
    return idStock;
  }

  public void setIdStock(Integer idStock) {
    this.idStock = idStock;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  @XmlTransient
  public List<FacturaDetalle> getFacturaDetalleList() {
    return facturaDetalleList;
  }

  public void setFacturaDetalleList(List<FacturaDetalle> facturaDetalleList) {
    this.facturaDetalleList = facturaDetalleList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idStock != null ? idStock.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Stock)) {
      return false;
    }
    Stock other = (Stock) object;
    if ((this.idStock == null && other.idStock != null) || (this.idStock != null && !this.idStock.equals(other.idStock))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "co.estampas.entities.Stock[ idStock=" + idStock + " ]";
  }
  
}
