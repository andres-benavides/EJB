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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AndresV
 */
@Entity
@Table(name = "administrador")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a"),
  @NamedQuery(name = "Administrador.findByIdAdmin", query = "SELECT a FROM Administrador a WHERE a.idAdmin = :idAdmin"),
  @NamedQuery(name = "Administrador.login", query = "SELECT a FROM Administrador a WHERE a.usuario = :usuario AND a.password = :password"),
  @NamedQuery(name = "Administrador.findByUsuario", query = "SELECT a FROM Administrador a WHERE a.usuario = :usuario"),
  @NamedQuery(name = "Administrador.findByPassword", query = "SELECT a FROM Administrador a WHERE a.password = :password")})
public class Administrador implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_admin")
  private Integer idAdmin;
  @Size(max = 30)
  @Column(name = "usuario")
  private String usuario;
  @Size(max = 40)
  @Column(name = "password")
  private String password;

  public Administrador() {
  }

  public Administrador(Integer idAdmin) {
    this.idAdmin = idAdmin;
  }

  public Integer getIdAdmin() {
    return idAdmin;
  }

  public void setIdAdmin(Integer idAdmin) {
    this.idAdmin = idAdmin;
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

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idAdmin != null ? idAdmin.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Administrador)) {
      return false;
    }
    Administrador other = (Administrador) object;
    if ((this.idAdmin == null && other.idAdmin != null) || (this.idAdmin != null && !this.idAdmin.equals(other.idAdmin))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "co.estampas.entities.Administrador[ idAdmin=" + idAdmin + " ]";
  }
  
}
