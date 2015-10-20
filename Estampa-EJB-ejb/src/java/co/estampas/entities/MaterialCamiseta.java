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
@Table(name = "material_camiseta")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "MaterialCamiseta.findAll", query = "SELECT m FROM MaterialCamiseta m"),
  @NamedQuery(name = "MaterialCamiseta.findByIdMaterial", query = "SELECT m FROM MaterialCamiseta m WHERE m.idMaterial = :idMaterial"),
  @NamedQuery(name = "MaterialCamiseta.findByMaterial", query = "SELECT m FROM MaterialCamiseta m WHERE m.material = :material")})
public class MaterialCamiseta implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_material")
  private Integer idMaterial;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "material")
  private String material;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMaterial")
  private List<FacturaDetalle> facturaDetalleList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMaterial")
  private List<Camiseta> camisetaList;

  public MaterialCamiseta() {
  }

  public MaterialCamiseta(Integer idMaterial) {
    this.idMaterial = idMaterial;
  }

  public MaterialCamiseta(Integer idMaterial, String material) {
    this.idMaterial = idMaterial;
    this.material = material;
  }

  public Integer getIdMaterial() {
    return idMaterial;
  }

  public void setIdMaterial(Integer idMaterial) {
    this.idMaterial = idMaterial;
  }

  public String getMaterial() {
    return material;
  }

  public void setMaterial(String material) {
    this.material = material;
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
    hash += (idMaterial != null ? idMaterial.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof MaterialCamiseta)) {
      return false;
    }
    MaterialCamiseta other = (MaterialCamiseta) object;
    if ((this.idMaterial == null && other.idMaterial != null) || (this.idMaterial != null && !this.idMaterial.equals(other.idMaterial))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "co.estampas.entities.MaterialCamiseta[ idMaterial=" + idMaterial + " ]";
  }
  
}
