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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AndresV
 */
@Entity
@Table(name = "artista")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Artista.findAll", query = "SELECT a FROM Artista a"),
  @NamedQuery(name = "Artista.findByIdArtista", query = "SELECT a FROM Artista a WHERE a.idArtista = :idArtista"),
  @NamedQuery(name = "Artista.findByNombre", query = "SELECT a FROM Artista a WHERE a.nombre = :nombre"),
  @NamedQuery(name = "Artista.findByApellido", query = "SELECT a FROM Artista a WHERE a.apellido = :apellido"),
  @NamedQuery(name = "Artista.findByDireccion", query = "SELECT a FROM Artista a WHERE a.direccion = :direccion"),
  @NamedQuery(name = "Artista.findByCedula", query = "SELECT a FROM Artista a WHERE a.cedula = :cedula"),
  @NamedQuery(name = "Artista.findByCelular", query = "SELECT a FROM Artista a WHERE a.celular = :celular"),
  @NamedQuery(name = "Artista.findByUsuario", query = "SELECT a FROM Artista a WHERE a.usuario = :usuario"),
  @NamedQuery(name = "Artista.findByPassword", query = "SELECT a FROM Artista a WHERE a.password = :password"),
  @NamedQuery(name = "Artista.validarLogin", query = "SELECT a FROM Artista a WHERE a.password = :password AND a.usuario = :usuario")})
public class Artista implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_artista")
  private Integer idArtista;
  @Size(max = 30)
  @Column(name = "nombre")
  private String nombre;
  @Size(max = 30)
  @Column(name = "apellido")
  private String apellido;
  @Size(max = 30)
  @Column(name = "direccion")
  private String direccion;
  @Size(max = 10)
  @Column(name = "cedula")
  private String cedula;
  @Size(max = 15)
  @Column(name = "celular")
  private String celular;
  @Size(max = 30)
  @Column(name = "usuario")
  private String usuario;
  @Size(max = 30)
  @Column(name = "password")
  private String password;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArtista")
  private List<EstampaCamiseta> estampaCamisetaList;

  public Artista() {
  }

  public Artista(int id,String nombre, String apellido, String direccion, String cedula, String celular, String usuario, String password) {
    this.idArtista = id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.direccion = direccion;
    this.cedula = cedula;
    this.celular = celular;
    this.usuario = usuario;
    this.password = password;
  }

  public Artista(Integer idArtista) {
    this.idArtista = idArtista;
  }

  public Integer getIdArtista() {
    return idArtista;
  }

  public void setIdArtista(Integer idArtista) {
    this.idArtista = idArtista;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getCedula() {
    return cedula;
  }

  public void setCedula(String cedula) {
    this.cedula = cedula;
  }

  public String getCelular() {
    return celular;
  }

  public void setCelular(String celular) {
    this.celular = celular;
  }

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @XmlTransient
  public List<EstampaCamiseta> getEstampaCamisetaList() {
    return estampaCamisetaList;
  }

  public void setEstampaCamisetaList(List<EstampaCamiseta> estampaCamisetaList) {
    this.estampaCamisetaList = estampaCamisetaList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idArtista != null ? idArtista.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Artista)) {
      return false;
    }
    Artista other = (Artista) object;
    if ((this.idArtista == null && other.idArtista != null) || (this.idArtista != null && !this.idArtista.equals(other.idArtista))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "co.estampas.entities.Artista[ idArtista=" + idArtista + " ]";
  }
  
}
