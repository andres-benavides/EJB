/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.estampas.session;

import co.estampas.entities.TemaEstampa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresV
 */
@Local
public interface TemaEstampaFacadeLocal {

  void create(TemaEstampa temaEstampa);

  void edit(TemaEstampa temaEstampa);

  void remove(TemaEstampa temaEstampa);

  TemaEstampa find(Object id);

 public List<TemaEstampa> findAll();

  List<TemaEstampa> findRange(int[] range);

  int count();
  
}
