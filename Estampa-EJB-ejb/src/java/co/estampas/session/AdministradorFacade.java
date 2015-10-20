/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.estampas.session;

import co.estampas.entities.Administrador;
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
public class AdministradorFacade extends AbstractFacade<Administrador> implements AdministradorFacadeLocal {
  @PersistenceContext(unitName = "Estampa-EJB-ejbPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public AdministradorFacade() {
    super(Administrador.class);
  }

  @Override
  public List<Administrador> login(String user,String password) {
    Query query = getEntityManager().createNamedQuery("Administrador.login");
    query.setParameter("usuario", user);
    query.setParameter("password", password);
    List admin = (List<Administrador>) query.getResultList();
    return admin;
  }
  
}
