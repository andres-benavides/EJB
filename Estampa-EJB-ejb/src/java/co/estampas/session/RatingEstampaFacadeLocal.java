/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.estampas.session;

import co.estampas.entities.RatingEstampa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresV
 */
@Local
public interface RatingEstampaFacadeLocal {

  void create(RatingEstampa ratingEstampa);

  void edit(RatingEstampa ratingEstampa);

  void remove(RatingEstampa ratingEstampa);

  RatingEstampa find(Object id);

  List<RatingEstampa> findAll();

  List<RatingEstampa> findRange(int[] range);

  int count();
  
}
