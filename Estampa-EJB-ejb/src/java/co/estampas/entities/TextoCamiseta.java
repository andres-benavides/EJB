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
@Table(name = "texto_camiseta")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "TextoCamiseta.findAll", query = "SELECT t FROM TextoCamiseta t"),
  @NamedQuery(name = "TextoCamiseta.findByIdTextoCamiseta", query = "SELECT t FROM TextoCamiseta t WHERE t.idTextoCamiseta = :idTextoCamiseta"),
  @NamedQuery(name = "TextoCamiseta.findByDescripcionTexto", query = "SELECT t FROM TextoCamiseta t WHERE t.descripcionTexto = :descripcionTexto")})
public class TextoCamiseta implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_texto_camiseta")
  private Integer idTextoCamiseta;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "descripcion_texto")
  private String descripcionTexto;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTextoCamiseta")
  private List<FacturaDetalle> facturaDetalleList;
  @JoinColumn(name = "id_tamano_texto", referencedColumnName = "id_tamano_texto")
  @ManyToOne(optional = false)
  private TamanoTexto idTamanoTexto;
  @OneToMany(mappedBy = "idTextoCamiseta")
  private List<Camiseta> camisetaList;

  public TextoCamiseta() {
  }

  public TextoCamiseta(Integer idTextoCamiseta) {
    this.idTextoCamiseta = idTextoCamiseta;
  }

  public TextoCamiseta(Integer idTextoCamiseta, String descripcionTexto) {
    this.idTextoCamiseta = idTextoCamiseta;
    this.descripcionTexto = descripcionTexto;
  }

  public Integer getIdTextoCamiseta() {
    return idTextoCamiseta;
  }

  public void setIdTextoCamiseta(Integer idTextoCamiseta) {
    this.idTextoCamiseta = idTextoCamiseta;
  }

  public String getDescripcionTexto() {
    return descripcionTexto;
  }

  public void setDescripcionTexto(String descripcionTexto) {
    this.descripcionTexto = descripcionTexto;
  }

  @XmlTransient
  public List<FacturaDetalle> getFacturaDetalleList() {
    return facturaDetalleList;
  }

  public void setFacturaDetalleList(List<FacturaDetalle> facturaDetalleList) {
    this.facturaDetalleList = facturaDetalleList;
  }

  public TamanoTexto getIdTamanoTexto() {
    return idTamanoTexto;
  }

  public void setIdTamanoTexto(TamanoTexto idTamanoTexto) {
    this.idTamanoTexto = idTamanoTexto;
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
    hash += (idTextoCamiseta != null ? idTextoCamiseta.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof TextoCamiseta)) {
      return false;
    }
    TextoCamiseta other = (TextoCamiseta) object;
    if ((this.idTextoCamiseta == null && other.idTextoCamiseta != null) || (this.idTextoCamiseta != null && !this.idTextoCamiseta.equals(other.idTextoCamiseta))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "co.estampas.entities.TextoCamiseta[ idTextoCamiseta=" + idTextoCamiseta + " ]";
  }
  
}
