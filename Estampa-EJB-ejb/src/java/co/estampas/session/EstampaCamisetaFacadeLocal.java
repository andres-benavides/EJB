/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.estampas.session;

import co.estampas.entities.Artista;
import co.estampas.entities.EstampaCamiseta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresV
 */
@Local
public interface EstampaCamisetaFacadeLocal {

  void create(EstampaCamiseta estampaCamiseta);

  void edit(EstampaCamiseta estampaCamiseta);

  void remove(EstampaCamiseta estampaCamiseta);

  EstampaCamiseta find(Object id);

  List<EstampaCamiseta> findAll();

  List<EstampaCamiseta> findRange(int[] range);

  int count();
  
  List<EstampaCamiseta> estampaByArtista(Artista idArtista);
  
}
