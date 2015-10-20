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
@Table(name = "estampa_camiseta")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "EstampaCamiseta.findAll", query = "SELECT e FROM EstampaCamiseta e"),
  @NamedQuery(name = "EstampaCamiseta.findByIdEstampaCamiseta", query = "SELECT e FROM EstampaCamiseta e WHERE e.idEstampaCamiseta = :idEstampaCamiseta"),
  @NamedQuery(name = "EstampaCamiseta.findByDescripcion", query = "SELECT e FROM EstampaCamiseta e WHERE e.descripcion = :descripcion"),
  @NamedQuery(name = "EstampaCamiseta.findByImagenes", query = "SELECT e FROM EstampaCamiseta e WHERE e.imagenes = :imagenes"),
  @NamedQuery(name = "EstampaCamiseta.findByUbicacion", query = "SELECT e FROM EstampaCamiseta e WHERE e.ubicacion = :ubicacion"),
  @NamedQuery(name = "EstampaCamiseta.findByPrecio", query = "SELECT e FROM EstampaCamiseta e WHERE e.precio = :precio"),
  @NamedQuery(name = "EstampaCamiseta.findByArtista", query = "SELECT e FROM EstampaCamiseta e WHERE e.idArtista = :idArtista"),
  @NamedQuery(name = "EstampaCamiseta.findByIdLugarEstampa", query = "SELECT e FROM EstampaCamiseta e WHERE e.idLugarEstampa = :idLugarEstampa")})
public class EstampaCamiseta implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_estampa_camiseta")
  private Integer idEstampaCamiseta;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "descripcion")
  private String descripcion;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "imagenes")
  private String imagenes;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "ubicacion")
  private String ubicacion;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "precio")
  private String precio;
  @Basic(optional = false)
  @NotNull
  @Column(name = "id_lugar_estampa")
  private int idLugarEstampa;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstampaCamiseta")
  private List<FacturaDetalle> facturaDetalleList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstampa")
  private List<VotoEstampa> votoEstampaList;
  @JoinColumn(name = "id_tema_estampa", referencedColumnName = "id_tema_estampa")
  @ManyToOne(optional = false)
  private TemaEstampa idTemaEstampa;
  @JoinColumn(name = "id_tamano_estampa", referencedColumnName = "id_tamano_estampa")
  @ManyToOne(optional = false)
  private TamanoEstampa idTamanoEstampa;
  @JoinColumn(name = "id_artista", referencedColumnName = "id_artista")
  @ManyToOne(optional = false)
  private Artista idArtista;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstampaCamiseta")
  private List<Camiseta> camisetaList;

  public EstampaCamiseta() {
  }

  public EstampaCamiseta(Integer idEstampaCamiseta) {
    this.idEstampaCamiseta = idEstampaCamiseta;
  }

  public EstampaCamiseta(Integer idEstampaCamiseta, String descripcion, String imagenes, String ubicacion, String precio, int idLugarEstampa) {
    this.idEstampaCamiseta = idEstampaCamiseta;
    this.descripcion = descripcion;
    this.imagenes = imagenes;
    this.ubicacion = ubicacion;
    this.precio = precio;
    this.idLugarEstampa = idLugarEstampa;
  }

  public Integer getIdEstampaCamiseta() {
    return idEstampaCamiseta;
  }

  public void setIdEstampaCamiseta(Integer idEstampaCamiseta) {
    this.idEstampaCamiseta = idEstampaCamiseta;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getImagenes() {
    return imagenes;
  }

  public void setImagenes(String imagenes) {
    this.imagenes = imagenes;
  }

  public String getUbicacion() {
    return ubicacion;
  }

  public void setUbicacion(String ubicacion) {
    this.ubicacion = ubicacion;
  }

  public String getPrecio() {
    return precio;
  }

  public void setPrecio(String precio) {
    this.precio = precio;
  }

  public int getIdLugarEstampa() {
    return idLugarEstampa;
  }

  public void setIdLugarEstampa(int idLugarEstampa) {
    this.idLugarEstampa = idLugarEstampa;
  }

  @XmlTransient
  public List<FacturaDetalle> getFacturaDetalleList() {
    return facturaDetalleList;
  }

  public void setFacturaDetalleList(List<FacturaDetalle> facturaDetalleList) {
    this.facturaDetalleList = facturaDetalleList;
  }

  @XmlTransient
  public List<VotoEstampa> getVotoEstampaList() {
    return votoEstampaList;
  }

  public void setVotoEstampaList(List<VotoEstampa> votoEstampaList) {
    this.votoEstampaList = votoEstampaList;
  }

  public TemaEstampa getIdTemaEstampa() {
    return idTemaEstampa;
  }

  public void setIdTemaEstampa(TemaEstampa idTemaEstampa) {
    this.idTemaEstampa = idTemaEstampa;
  }

  public TamanoEstampa getIdTamanoEstampa() {
    return idTamanoEstampa;
  }

  public void setIdTamanoEstampa(TamanoEstampa idTamanoEstampa) {
    this.idTamanoEstampa = idTamanoEstampa;
  }

  public Artista getIdArtista() {
    return idArtista;
  }

  public void setIdArtista(Artista idArtista) {
    this.idArtista = idArtista;
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
    hash += (idEstampaCamiseta != null ? idEstampaCamiseta.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof EstampaCamiseta)) {
      return false;
    }
    EstampaCamiseta other = (EstampaCamiseta) object;
    if ((this.idEstampaCamiseta == null && other.idEstampaCamiseta != null) || (this.idEstampaCamiseta != null && !this.idEstampaCamiseta.equals(other.idEstampaCamiseta))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "co.estampas.entities.EstampaCamiseta[ idEstampaCamiseta=" + idEstampaCamiseta + " ]";
  }
  
}
