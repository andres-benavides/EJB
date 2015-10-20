/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.estampas.session;

import co.estampas.entities.Camiseta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresV
 */
@Local
public interface CamisetaFacadeLocal {

  void create(Camiseta camiseta);

  void edit(Camiseta camiseta);

  void remove(Camiseta camiseta);

  Camiseta find(Object id);

  List<Camiseta> findAll();

  List<Camiseta> findRange(int[] range);

  int count();
  
}
