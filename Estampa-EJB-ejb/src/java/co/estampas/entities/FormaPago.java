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
@Table(name = "forma_pago")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "FormaPago.findAll", query = "SELECT f FROM FormaPago f"),
  @NamedQuery(name = "FormaPago.findByIdFormaPago", query = "SELECT f FROM FormaPago f WHERE f.idFormaPago = :idFormaPago"),
  @NamedQuery(name = "FormaPago.findByDescripcionFormaPago", query = "SELECT f FROM FormaPago f WHERE f.descripcionFormaPago = :descripcionFormaPago")})
public class FormaPago implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_forma_pago")
  private Integer idFormaPago;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "descripcion_forma_pago")
  private String descripcionFormaPago;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFormaPago")
  private List<FacturaDetalle> facturaDetalleList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFormaPago")
  private List<Factura> facturaList;

  public FormaPago() {
  }

  public FormaPago(Integer idFormaPago) {
    this.idFormaPago = idFormaPago;
  }

  public FormaPago(Integer idFormaPago, String descripcionFormaPago) {
    this.idFormaPago = idFormaPago;
    this.descripcionFormaPago = descripcionFormaPago;
  }

  public Integer getIdFormaPago() {
    return idFormaPago;
  }

  public void setIdFormaPago(Integer idFormaPago) {
    this.idFormaPago = idFormaPago;
  }

  public String getDescripcionFormaPago() {
    return descripcionFormaPago;
  }

  public void setDescripcionFormaPago(String descripcionFormaPago) {
    this.descripcionFormaPago = descripcionFormaPago;
  }

  @XmlTransient
  public List<FacturaDetalle> getFacturaDetalleList() {
    return facturaDetalleList;
  }

  public void setFacturaDetalleList(List<FacturaDetalle> facturaDetalleList) {
    this.facturaDetalleList = facturaDetalleList;
  }

  @XmlTransient
  public List<Factura> getFacturaList() {
    return facturaList;
  }

  public void setFacturaList(List<Factura> facturaList) {
    this.facturaList = facturaList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idFormaPago != null ? idFormaPago.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof FormaPago)) {
      return false;
    }
    FormaPago other = (FormaPago) object;
    if ((this.idFormaPago == null && other.idFormaPago != null) || (this.idFormaPago != null && !this.idFormaPago.equals(other.idFormaPago))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "co.estampas.entities.FormaPago[ idFormaPago=" + idFormaPago + " ]";
  }
  
}
