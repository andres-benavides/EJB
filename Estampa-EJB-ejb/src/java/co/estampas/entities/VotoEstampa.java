/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.estampas.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AndresV
 */
@Entity
@Table(name = "voto_estampa")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "VotoEstampa.findAll", query = "SELECT v FROM VotoEstampa v"),
  @NamedQuery(name = "VotoEstampa.findById", query = "SELECT v FROM VotoEstampa v WHERE v.id = :id")})
public class VotoEstampa implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @JoinColumn(name = "id_rating", referencedColumnName = "id_rating_estampa")
  @ManyToOne(optional = false)
  private RatingEstampa idRating;
  @JoinColumn(name = "id_estampa", referencedColumnName = "id_estampa_camiseta")
  @ManyToOne(optional = false)
  private EstampaCamiseta idEstampa;

  public VotoEstampa() {
  }

  public VotoEstampa(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public RatingEstampa getIdRating() {
    return idRating;
  }

  public void setIdRating(RatingEstampa idRating) {
    this.idRating = idRating;
  }

  public EstampaCamiseta getIdEstampa() {
    return idEstampa;
  }

  public void setIdEstampa(EstampaCamiseta idEstampa) {
    this.idEstampa = idEstampa;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof VotoEstampa)) {
      return false;
    }
    VotoEstampa other = (VotoEstampa) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "co.estampas.entities.VotoEstampa[ id=" + id + " ]";
  }
  
}
