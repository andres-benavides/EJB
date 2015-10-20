/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.estampas.session;

import co.estampas.entities.MaterialCamiseta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AndresV
 */
@Stateless
public class MaterialCamisetaFacade extends AbstractFacade<MaterialCamiseta> implements MaterialCamisetaFacadeLocal {
  @PersistenceContext(unitName = "Estampa-EJB-ejbPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public MaterialCamisetaFacade() {
    super(MaterialCamiseta.class);
  }
  
}
