/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.estampas.session;

import co.estampas.entities.TextoCamiseta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresV
 */
@Local
public interface TextoCamisetaFacadeLocal {

  void create(TextoCamiseta textoCamiseta);

  void edit(TextoCamiseta textoCamiseta);

  void remove(TextoCamiseta textoCamiseta);

  TextoCamiseta find(Object id);

  List<TextoCamiseta> findAll();

  List<TextoCamiseta> findRange(int[] range);

  int count();
  
}
