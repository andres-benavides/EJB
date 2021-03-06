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
@Table(name = "comprador")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Comprador.findAll", query = "SELECT c FROM Comprador c"),
  @NamedQuery(name = "Comprador.findByIdCliente", query = "SELECT c FROM Comprador c WHERE c.idCliente = :idCliente"),
  @NamedQuery(name = "Comprador.findByNombre", query = "SELECT c FROM Comprador c WHERE c.nombre = :nombre"),
  @NamedQuery(name = "Comprador.findByApellido", query = "SELECT c FROM Comprador c WHERE c.apellido = :apellido"),
  @NamedQuery(name = "Comprador.findByDireccion", query = "SELECT c FROM Comprador c WHERE c.direccion = :direccion"),
  @NamedQuery(name = "Comprador.findByCedula", query = "SELECT c FROM Comprador c WHERE c.cedula = :cedula"),
  @NamedQuery(name = "Comprador.findByCelular", query = "SELECT c FROM Comprador c WHERE c.celular = :celular"),
  @NamedQuery(name = "Comprador.findByUsuario", query = "SELECT c FROM Comprador c WHERE c.usuario = :usuario"),
  @NamedQuery(name = "Comprador.findByPassword", query = "SELECT c FROM Comprador c WHERE c.password = :password"),
  @NamedQuery(name = "Comprador.validarLogin", query = "SELECT c FROM Comprador c WHERE c.password = :password AND c.usuario = :usuario")})

public class Comprador implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id_cliente")
  private Integer idCliente;
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
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
  private List<Factura> facturaList;

  public Comprador() {
  }

  public Comprador(int id,String nombre, String apellido, String direccion, String cedula, String celular, String usuario, String password) {
     this.idCliente = id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.direccion = direccion;
    this.cedula = cedula;
    this.celular = celular;
    this.usuario = usuario;
    this.password = password;
  }

  public Comprador(Integer idCliente) {
    this.idCliente = idCliente;
  }

  public Integer getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(Integer idCliente) {
    this.idCliente = idCliente;
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
  public List<Factura> getFacturaList() {
    return facturaList;
  }

  public void setFacturaList(List<Factura> facturaList) {
    this.facturaList = facturaList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idCliente != null ? idCliente.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Comprador)) {
      return false;
    }
    Comprador other = (Comprador) object;
    if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "co.estampas.entities.Comprador[ idCliente=" + idCliente + " ]";
  }
  
}
