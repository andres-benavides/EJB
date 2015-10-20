/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.estampas.session;

import co.estampas.entities.Comprador;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author AndresV
 */
@Stateless
public class CompradorFacade extends AbstractFacade<Comprador> implements CompradorFacadeLocal {
  @PersistenceContext(unitName = "Estampa-EJB-ejbPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public CompradorFacade() {
    super(Comprador.class);
  }

  @Override
  public List<Comprador> logIn(String user,String password) {
    Query query = getEntityManager().createNamedQuery("Comprador.validarLogin");
    query.setParameter("usuario", user);
    query.setParameter("password", password);
    List comprador = (List<Comprador>) query.getResultList();
    return comprador;
    //usuario = (Usuarios) query.getSingleResult();
  }
  
}
