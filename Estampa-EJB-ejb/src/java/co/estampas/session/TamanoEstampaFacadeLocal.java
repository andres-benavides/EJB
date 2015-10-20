/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.estampas.session;

import co.estampas.entities.TamanoEstampa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresV
 */
@Local
public interface TamanoEstampaFacadeLocal {

  void create(TamanoEstampa tamanoEstampa);

  void edit(TamanoEstampa tamanoEstampa);

  void remove(TamanoEstampa tamanoEstampa);

  TamanoEstampa find(Object id);

  public List<TamanoEstampa> findAll();

  List<TamanoEstampa> findRange(int[] range);

  int count();
  
}
