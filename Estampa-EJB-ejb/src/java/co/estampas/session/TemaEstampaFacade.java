/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.estampas.session;

import co.estampas.entities.Artista;
import co.estampas.entities.TemaEstampa;
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
public class TemaEstampaFacade extends AbstractFacade<TemaEstampa> implements TemaEstampaFacadeLocal {

  @PersistenceContext(unitName = "Estampa-EJB-ejbPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public TemaEstampaFacade() {
    super(TemaEstampa.class);
  }

  @Override
  public List<TemaEstampa> findAll() {
    Query query = getEntityManager().createNamedQuery("TemaEstampa.findAll");
    List temaEstampa = (List<TemaEstampa>) query.getResultList();
    return temaEstampa;
  }
}
