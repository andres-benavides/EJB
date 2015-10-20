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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AndresV
 */
@Entity
@Table(name = "camiseta")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Camiseta.findAll", query = "SELECT c FROM Camiseta c"),
  @NamedQuery(name = "Camiseta.findByIdCamiseta", query = "SELECT c FROM Camiseta c WHERE c.idCamiseta = :idCamiseta"),
  @NamedQuery(name = "Camiseta.findByCantidad", query = "SELECT c FROM Camiseta c WHERE c.cantidad = :cantidad")})
public class Camiseta implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_camiseta")
  private Integer idCamiseta;
  @Basic(optional = false)
  @NotNull
  @Column(name = "cantidad")
  private int cantidad;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCamiseta")
  private List<FacturaDetalle> facturaDetalleList;
  @JoinColumn(name = "id_estampa_camiseta", referencedColumnName = "id_estampa_camiseta")
  @ManyToOne(optional = false)
  private EstampaCamiseta idEstampaCamiseta;
  @JoinColumn(name = "id_precio_camiseta", referencedColumnName = "id_precio_camiseta")
  @ManyToOne(optional = false)
  private PrecioCamiseta idPrecioCamiseta;
  @JoinColumn(name = "id_talla", referencedColumnName = "id_talla")
  @ManyToOne(optional = false)
  private TallaCamiseta idTalla;
  @JoinColumn(name = "id_color", referencedColumnName = "id_color")
  @ManyToOne(optional = false)
  private ColorCamiseta idColor;
  @JoinColumn(name = "id_material", referencedColumnName = "id_material")
  @ManyToOne(optional = false)
  private MaterialCamiseta idMaterial;
  @JoinColumn(name = "id_lugar_estampa_camiseta", referencedColumnName = "id_lugar_estampa_camiseta")
  @ManyToOne(optional = false)
  private LugarEstampaCamiseta idLugarEstampaCamiseta;
  @JoinColumn(name = "id_texto_camiseta", referencedColumnName = "id_texto_camiseta")
  @ManyToOne
  private TextoCamiseta idTextoCamiseta;

  public Camiseta() {
  }

  public Camiseta(Integer idCamiseta) {
    this.idCamiseta = idCamiseta;
  }

  public Camiseta(Integer idCamiseta, int cantidad) {
    this.idCamiseta = idCamiseta;
    this.cantidad = cantidad;
  }

  public Integer getIdCamiseta() {
    return idCamiseta;
  }

  public void setIdCamiseta(Integer idCamiseta) {
    this.idCamiseta = idCamiseta;
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

  public EstampaCamiseta getIdEstampaCamiseta() {
    return idEstampaCamiseta;
  }

  public void setIdEstampaCamiseta(EstampaCamiseta idEstampaCamiseta) {
    this.idEstampaCamiseta = idEstampaCamiseta;
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

  public MaterialCamiseta getIdMaterial() {
    return idMaterial;
  }

  public void setIdMaterial(MaterialCamiseta idMaterial) {
    this.idMaterial = idMaterial;
  }

  public LugarEstampaCamiseta getIdLugarEstampaCamiseta() {
    return idLugarEstampaCamiseta;
  }

  public void setIdLugarEstampaCamiseta(LugarEstampaCamiseta idLugarEstampaCamiseta) {
    this.idLugarEstampaCamiseta = idLugarEstampaCamiseta;
  }

  public TextoCamiseta getIdTextoCamiseta() {
    return idTextoCamiseta;
  }

  public void setIdTextoCamiseta(TextoCamiseta idTextoCamiseta) {
    this.idTextoCamiseta = idTextoCamiseta;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idCamiseta != null ? idCamiseta.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Camiseta)) {
      return false;
    }
    Camiseta other = (Camiseta) object;
    if ((this.idCamiseta == null && other.idCamiseta != null) || (this.idCamiseta != null && !this.idCamiseta.equals(other.idCamiseta))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "co.estampas.entities.Camiseta[ idCamiseta=" + idCamiseta + " ]";
  }
  
}
