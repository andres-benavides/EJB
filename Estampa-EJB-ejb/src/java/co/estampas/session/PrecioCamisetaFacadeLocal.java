/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.estampas.session;

import co.estampas.entities.PrecioCamiseta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresV
 */
@Local
public interface PrecioCamisetaFacadeLocal {

  void create(PrecioCamiseta precioCamiseta);

  void edit(PrecioCamiseta precioCamiseta);

  void remove(PrecioCamiseta precioCamiseta);

  PrecioCamiseta find(Object id);

  List<PrecioCamiseta> findAll();

  List<PrecioCamiseta> findRange(int[] range);

  int count();
  
}
