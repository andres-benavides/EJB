/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.estampas.session;

import co.estampas.entities.Artista;
import co.estampas.entities.EstampaCamiseta;
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
public class EstampaCamisetaFacade extends AbstractFacade<EstampaCamiseta> implements EstampaCamisetaFacadeLocal {
  @PersistenceContext(unitName = "Estampa-EJB-ejbPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public EstampaCamisetaFacade() {
    super(EstampaCamiseta.class);
  }

  @Override
  public List<EstampaCamiseta> estampaByArtista(Artista idArtista) {
    Query query = getEntityManager().createNamedQuery("EstampaCamiseta.findByArtista");
    query.setParameter("idArtista", idArtista);
    List estampaCamiseta = (List<EstampaCamiseta>) query.getResultList();
    return estampaCamiseta;
  }
  
}
