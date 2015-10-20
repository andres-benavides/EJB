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
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
  @NamedQuery(name = "Factura.findByIdFactura", query = "SELECT f FROM Factura f WHERE f.idFactura = :idFactura"),
  @NamedQuery(name = "Factura.findByFecha", query = "SELECT f FROM Factura f WHERE f.fecha = :fecha"),
  @NamedQuery(name = "Factura.findByPrecioTotal", query = "SELECT f FROM Factura f WHERE f.precioTotal = :precioTotal")})
public class Factura implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_factura")
  private Integer idFactura;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "fecha")
  private String fecha;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "precio_total")
  private String precioTotal;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFactura")
  private List<FacturaDetalle> facturaDetalleList;
  @JoinColumn(name = "id_forma_pago", referencedColumnName = "id_forma_pago")
  @ManyToOne(optional = false)
  private FormaPago idFormaPago;
  @JoinColumn(name = "id_factura_detalle", referencedColumnName = "id_factura_detalle")
  @ManyToOne(optional = false)
  private FacturaDetalle idFacturaDetalle;
  @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
  @ManyToOne(optional = false)
  private Comprador idCliente;

  public Factura() {
  }

  public Factura(Integer idFactura) {
    this.idFactura = idFactura;
  }

  public Factura(Integer idFactura, String fecha, String precioTotal) {
    this.idFactura = idFactura;
    this.fecha = fecha;
    this.precioTotal = precioTotal;
  }

  public Integer getIdFactura() {
    return idFactura;
  }

  public void setIdFactura(Integer idFactura) {
    this.idFactura = idFactura;
  }

  public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public String getPrecioTotal() {
    return precioTotal;
  }

  public void setPrecioTotal(String precioTotal) {
    this.precioTotal = precioTotal;
  }

  @XmlTransient
  public List<FacturaDetalle> getFacturaDetalleList() {
    return facturaDetalleList;
  }

  public void setFacturaDetalleList(List<FacturaDetalle> facturaDetalleList) {
    this.facturaDetalleList = facturaDetalleList;
  }

  public FormaPago getIdFormaPago() {
    return idFormaPago;
  }

  public void setIdFormaPago(FormaPago idFormaPago) {
    this.idFormaPago = idFormaPago;
  }

  public FacturaDetalle getIdFacturaDetalle() {
    return idFacturaDetalle;
  }

  public void setIdFacturaDetalle(FacturaDetalle idFacturaDetalle) {
    this.idFacturaDetalle = idFacturaDetalle;
  }

  public Comprador getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(Comprador idCliente) {
    this.idCliente = idCliente;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idFactura != null ? idFactura.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Factura)) {
      return false;
    }
    Factura other = (Factura) object;
    if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "co.estampas.entities.Factura[ idFactura=" + idFactura + " ]";
  }
  
}
