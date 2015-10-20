/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.estampas.session;

import co.estampas.entities.PrecioTexto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresV
 */
@Local
public interface PrecioTextoFacadeLocal {

  void create(PrecioTexto precioTexto);

  void edit(PrecioTexto precioTexto);

  void remove(PrecioTexto precioTexto);

  PrecioTexto find(Object id);

  List<PrecioTexto> findAll();

  List<PrecioTexto> findRange(int[] range);

  int count();
  
}
