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
@Table(name = "rating_estampa")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "RatingEstampa.findAll", query = "SELECT r FROM RatingEstampa r"),
  @NamedQuery(name = "RatingEstampa.findByIdRatingEstampa", query = "SELECT r FROM RatingEstampa r WHERE r.idRatingEstampa = :idRatingEstampa"),
  @NamedQuery(name = "RatingEstampa.findByNombre", query = "SELECT r FROM RatingEstampa r WHERE r.nombre = :nombre")})
public class RatingEstampa implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_rating_estampa")
  private Integer idRatingEstampa;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "nombre")
  private String nombre;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRating")
  private List<VotoEstampa> votoEstampaList;

  public RatingEstampa() {
  }

  public RatingEstampa(Integer idRatingEstampa) {
    this.idRatingEstampa = idRatingEstampa;
  }

  public RatingEstampa(Integer idRatingEstampa, String nombre) {
    this.idRatingEstampa = idRatingEstampa;
    this.nombre = nombre;
  }

  public Integer getIdRatingEstampa() {
    return idRatingEstampa;
  }

  public void setIdRatingEstampa(Integer idRatingEstampa) {
    this.idRatingEstampa = idRatingEstampa;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @XmlTransient
  public List<VotoEstampa> getVotoEstampaList() {
    return votoEstampaList;
  }

  public void setVotoEstampaList(List<VotoEstampa> votoEstampaList) {
    this.votoEstampaList = votoEstampaList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idRatingEstampa != null ? idRatingEstampa.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof RatingEstampa)) {
      return false;
    }
    RatingEstampa other = (RatingEstampa) object;
    if ((this.idRatingEstampa == null && other.idRatingEstampa != null) || (this.idRatingEstampa != null && !this.idRatingEstampa.equals(other.idRatingEstampa))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "co.estampas.entities.RatingEstampa[ idRatingEstampa=" + idRatingEstampa + " ]";
  }
  
}
