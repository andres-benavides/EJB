/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.estampas.session;

import co.estampas.entities.TamanoTexto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AndresV
 */
@Stateless
public class TamanoTextoFacade extends AbstractFacade<TamanoTexto> implements TamanoTextoFacadeLocal {
  @PersistenceContext(unitName = "Estampa-EJB-ejbPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public TamanoTextoFacade() {
    super(TamanoTexto.class);
  }
  
}
