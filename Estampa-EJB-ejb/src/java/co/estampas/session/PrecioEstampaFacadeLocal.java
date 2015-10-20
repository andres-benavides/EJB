/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.estampas.session;

import co.estampas.entities.PrecioEstampa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresV
 */
@Local
public interface PrecioEstampaFacadeLocal {

  void create(PrecioEstampa precioEstampa);

  void edit(PrecioEstampa precioEstampa);

  void remove(PrecioEstampa precioEstampa);

  PrecioEstampa find(Object id);

  List<PrecioEstampa> findAll();

  List<PrecioEstampa> findRange(int[] range);

  int count();
  
}
