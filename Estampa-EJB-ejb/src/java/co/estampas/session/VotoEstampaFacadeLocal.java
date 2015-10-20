/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.estampas.session;

import co.estampas.entities.VotoEstampa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresV
 */
@Local
public interface VotoEstampaFacadeLocal {

  void create(VotoEstampa votoEstampa);

  void edit(VotoEstampa votoEstampa);

  void remove(VotoEstampa votoEstampa);

  VotoEstampa find(Object id);

  List<VotoEstampa> findAll();

  List<VotoEstampa> findRange(int[] range);

  int count();
  
}
