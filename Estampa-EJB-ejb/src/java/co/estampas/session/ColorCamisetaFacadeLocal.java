/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.estampas.session;

import co.estampas.entities.ColorCamiseta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresV
 */
@Local
public interface ColorCamisetaFacadeLocal {

  void create(ColorCamiseta colorCamiseta);

  void edit(ColorCamiseta colorCamiseta);

  void remove(ColorCamiseta colorCamiseta);

  ColorCamiseta find(Object id);

  List<ColorCamiseta> findAll();

  List<ColorCamiseta> findRange(int[] range);

  int count();
  
}
