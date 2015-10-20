/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.estampas.session;

import co.estampas.entities.Artista;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresV
 */
@Local
public interface ArtistaFacadeLocal {

  void create(Artista artista);

  void edit(Artista artista);

  void remove(Artista artista);

  Artista find(Object id);

  List<Artista> findAll();

  List<Artista> findRange(int[] range);

  int count();
  public List<Artista> logIn(String user,String password);
}
