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
@Table(name = "factura_detalle")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "FacturaDetalle.findAll", query = "SELECT f FROM FacturaDetalle f"),
  @NamedQuery(name = "FacturaDetalle.findByIdFacturaDetalle", query = "SELECT f FROM FacturaDetalle f WHERE f.idFacturaDetalle = :idFacturaDetalle"),
  @NamedQuery(name = "FacturaDetalle.findByFecha", query = "SELECT f FROM FacturaDetalle f WHERE f.fecha = :fecha"),
  @NamedQuery(name = "FacturaDetalle.findByPrecioTotal", query = "SELECT f FROM FacturaDetalle f WHERE f.precioTotal = :precioTotal")})
public class FacturaDetalle implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_factura_detalle")
  private Integer idFacturaDetalle;
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
  @JoinColumn(name = "id_forma_pago", referencedColumnName = "id_forma_pago")
  @ManyToOne(optional = false)
  private FormaPago idFormaPago;
  @JoinColumn(name = "id_camiseta", referencedColumnName = "id_camiseta")
  @ManyToOne(optional = false)
  private Camiseta idCamiseta;
  @JoinColumn(name = "id_lugar_estampa_camiseta", referencedColumnName = "id_lugar_estampa_camiseta")
  @ManyToOne(optional = false)
  private LugarEstampaCamiseta idLugarEstampaCamiseta;
  @JoinColumn(name = "id_estampa_camiseta", referencedColumnName = "id_estampa_camiseta")
  @ManyToOne(optional = false)
  private EstampaCamiseta idEstampaCamiseta;
  @JoinColumn(name = "id_texto_camiseta", referencedColumnName = "id_texto_camiseta")
  @ManyToOne(optional = false)
  private TextoCamiseta idTextoCamiseta;
  @JoinColumn(name = "id_precio_texto", referencedColumnName = "id_precio_texto")
  @ManyToOne(optional = false)
  private PrecioTexto idPrecioTexto;
  @JoinColumn(name = "id_material", referencedColumnName = "id_material")
  @ManyToOne(optional = false)
  private MaterialCamiseta idMaterial;
  @JoinColumn(name = "id_tamano_texto", referencedColumnName = "id_tamano_texto")
  @ManyToOne(optional = false)
  private TamanoTexto idTamanoTexto;
  @JoinColumn(name = "id_factura", referencedColumnName = "id_factura")
  @ManyToOne(optional = false)
  private Factura idFactura;
  @JoinColumn(name = "id_stock", referencedColumnName = "id_stock")
  @ManyToOne(optional = false)
  private Stock idStock;
  @JoinColumn(name = "id_tema_estampa", referencedColumnName = "id_tema_estampa")
  @ManyToOne(optional = false)
  private TemaEstampa idTemaEstampa;
  @JoinColumn(name = "id_precio_estampa", referencedColumnName = "id_precio_estampa")
  @ManyToOne(optional = false)
  private PrecioEstampa idPrecioEstampa;
  @JoinColumn(name = "id_precio_camiseta", referencedColumnName = "id_precio_camiseta")
  @ManyToOne(optional = false)
  private PrecioCamiseta idPrecioCamiseta;
  @JoinColumn(name = "id_talla", referencedColumnName = "id_talla")
  @ManyToOne(optional = false)
  private TallaCamiseta idTalla;
  @JoinColumn(name = "id_color", referencedColumnName = "id_color")
  @ManyToOne(optional = false)
  private ColorCamiseta idColor;
  @JoinColumn(name = "id_tamano_estampa", referencedColumnName = "id_tamano_estampa")
  @ManyToOne(optional = false)
  private TamanoEstampa idTamanoEstampa;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFacturaDetalle")
  private List<Factura> facturaList;

  public FacturaDetalle() {
  }

  public FacturaDetalle(Integer idFacturaDetalle) {
    this.idFacturaDetalle = idFacturaDetalle;
  }

  public FacturaDetalle(Integer idFacturaDetalle, String fecha, String precioTotal) {
    this.idFacturaDetalle = idFacturaDetalle;
    this.fecha = fecha;
    this.precioTotal = precioTotal;
  }

  public Integer getIdFacturaDetalle() {
    return idFacturaDetalle;
  }

  public void setIdFacturaDetalle(Integer idFacturaDetalle) {
    this.idFacturaDetalle = idFacturaDetalle;
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

  public FormaPago getIdFormaPago() {
    return idFormaPago;
  }

  public void setIdFormaPago(FormaPago idFormaPago) {
    this.idFormaPago = idFormaPago;
  }

  public Camiseta getIdCamiseta() {
    return idCamiseta;
  }

  public void setIdCamiseta(Camiseta idCamiseta) {
    this.idCamiseta = idCamiseta;
  }

  public LugarEstampaCamiseta getIdLugarEstampaCamiseta() {
    return idLugarEstampaCamiseta;
  }

  public void setIdLugarEstampaCamiseta(LugarEstampaCamiseta idLugarEstampaCamiseta) {
    this.idLugarEstampaCamiseta = idLugarEstampaCamiseta;
  }

  public EstampaCamiseta getIdEstampaCamiseta() {
    return idEstampaCamiseta;
  }

  public void setIdEstampaCamiseta(EstampaCamiseta idEstampaCamiseta) {
    this.idEstampaCamiseta = idEstampaCamiseta;
  }

  public TextoCamiseta getIdTextoCamiseta() {
    return idTextoCamiseta;
  }

  public void setIdTextoCamiseta(TextoCamiseta idTextoCamiseta) {
    this.idTextoCamiseta = idTextoCamiseta;
  }

  public PrecioTexto getIdPrecioTexto() {
    return idPrecioTexto;
  }

  public void setIdPrecioTexto(PrecioTexto idPrecioTexto) {
    this.idPrecioTexto = idPrecioTexto;
  }

  public MaterialCamiseta getIdMaterial() {
    return idMaterial;
  }

  public void setIdMaterial(MaterialCamiseta idMaterial) {
    this.idMaterial = idMaterial;
  }

  public TamanoTexto getIdTamanoTexto() {
    return idTamanoTexto;
  }

  public void setIdTamanoTexto(TamanoTexto idTamanoTexto) {
    this.idTamanoTexto = idTamanoTexto;
  }

  public Factura getIdFactura() {
    return idFactura;
  }

  public void setIdFactura(Factura idFactura) {
    this.idFactura = idFactura;
  }

  public Stock getIdStock() {
    return idStock;
  }

  public void setIdStock(Stock idStock) {
    this.idStock = idStock;
  }

  public TemaEstampa getIdTemaEstampa() {
    return idTemaEstampa;
  }

  public void setIdTemaEstampa(TemaEstampa idTemaEstampa) {
    this.idTemaEstampa = idTemaEstampa;
  }

  public PrecioEstampa getIdPrecioEstampa() {
    return idPrecioEstampa;
  }

  public void setIdPrecioEstampa(PrecioEstampa idPrecioEstampa) {
    this.idPrecioEstampa = idPrecioEstampa;
  }

  public PrecioCamiseta getIdPrecioCamiseta() {
    return idPrecioCamiseta;
  }

  public void setIdPrecioCamiseta(PrecioCamiseta idPrecioCamiseta) {
    this.idPrecioCamiseta = idPrecioCamiseta;
  }

  public TallaCamiseta getIdTalla() {
    return idTalla;
  }

  public void setIdTalla(TallaCamiseta idTalla) {
    this.idTalla = idTalla;
  }

  public ColorCamiseta getIdColor() {
    return idColor;
  }

  public void setIdColor(ColorCamiseta idColor) {
    this.idColor = idColor;
  }

  public TamanoEstampa getIdTamanoEstampa() {
    return idTamanoEstampa;
  }

  public void setIdTamanoEstampa(TamanoEstampa idTamanoEstampa) {
    this.idTamanoEstampa = idTamanoEstampa;
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
    hash += (idFacturaDetalle != null ? idFacturaDetalle.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof FacturaDetalle)) {
      return false;
    }
    FacturaDetalle other = (FacturaDetalle) object;
    if ((this.idFacturaDetalle == null && other.idFacturaDetalle != null) || (this.idFacturaDetalle != null && !this.idFacturaDetalle.equals(other.idFacturaDetalle))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "co.estampas.entities.FacturaDetalle[ idFacturaDetalle=" + idFacturaDetalle + " ]";
  }
  
}
