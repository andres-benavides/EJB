/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.estampas.session;

import co.estampas.entities.TamanoTexto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresV
 */
@Local
public interface TamanoTextoFacadeLocal {

  void create(TamanoTexto tamanoTexto);

  void edit(TamanoTexto tamanoTexto);

  void remove(TamanoTexto tamanoTexto);

  TamanoTexto find(Object id);

  List<TamanoTexto> findAll();

  List<TamanoTexto> findRange(int[] range);

  int count();
  
}
