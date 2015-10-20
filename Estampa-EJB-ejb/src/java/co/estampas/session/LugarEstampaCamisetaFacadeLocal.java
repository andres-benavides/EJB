/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.estampas.session;

import co.estampas.entities.LugarEstampaCamiseta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresV
 */
@Local
public interface LugarEstampaCamisetaFacadeLocal {

  void create(LugarEstampaCamiseta lugarEstampaCamiseta);

  void edit(LugarEstampaCamiseta lugarEstampaCamiseta);

  void remove(LugarEstampaCamiseta lugarEstampaCamiseta);

  LugarEstampaCamiseta find(Object id);

  List<LugarEstampaCamiseta> findAll();

  List<LugarEstampaCamiseta> findRange(int[] range);

  int count();
  
}
