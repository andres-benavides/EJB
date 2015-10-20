/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.estampas.session;

import co.estampas.entities.Artista;
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
public class ArtistaFacade extends AbstractFacade<Artista> implements ArtistaFacadeLocal {
  @PersistenceContext(unitName = "Estampa-EJB-ejbPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public ArtistaFacade() {
    super(Artista.class);
  }

  @Override
  public List<Artista> logIn(String user, String password) {
    Query query = getEntityManager().createNamedQuery("Artista.validarLogin");
    query.setParameter("usuario", user);
    query.setParameter("password", password);
    List artista = (List<Artista>) query.getResultList();
    return artista;
  }
  
}
