/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.estampas.session;

import co.estampas.entities.TallaCamiseta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresV
 */
@Local
public interface TallaCamisetaFacadeLocal {

  void create(TallaCamiseta tallaCamiseta);

  void edit(TallaCamiseta tallaCamiseta);

  void remove(TallaCamiseta tallaCamiseta);

  TallaCamiseta find(Object id);

  List<TallaCamiseta> findAll();

  List<TallaCamiseta> findRange(int[] range);

  int count();
  
}
