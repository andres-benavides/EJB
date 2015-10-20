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
@Table(name = "color_camiseta")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "ColorCamiseta.findAll", query = "SELECT c FROM ColorCamiseta c"),
  @NamedQuery(name = "ColorCamiseta.findByIdColor", query = "SELECT c FROM ColorCamiseta c WHERE c.idColor = :idColor"),
  @NamedQuery(name = "ColorCamiseta.findByColor", query = "SELECT c FROM ColorCamiseta c WHERE c.color = :color")})
public class ColorCamiseta implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_color")
  private Integer idColor;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "color")
  private String color;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idColor")
  private List<FacturaDetalle> facturaDetalleList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idColor")
  private List<Camiseta> camisetaList;

  public ColorCamiseta() {
  }

  public ColorCamiseta(Integer idColor) {
    this.idColor = idColor;
  }

  public ColorCamiseta(Integer idColor, String color) {
    this.idColor = idColor;
    this.color = color;
  }

  public Integer getIdColor() {
    return idColor;
  }

  public void setIdColor(Integer idColor) {
    this.idColor = idColor;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
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
    hash += (idColor != null ? idColor.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ColorCamiseta)) {
      return false;
    }
    ColorCamiseta other = (ColorCamiseta) object;
    if ((this.idColor == null && other.idColor != null) || (this.idColor != null && !this.idColor.equals(other.idColor))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "co.estampas.entities.ColorCamiseta[ idColor=" + idColor + " ]";
  }
  
}
