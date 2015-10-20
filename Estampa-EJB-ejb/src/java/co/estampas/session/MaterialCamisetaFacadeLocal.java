/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.estampas.session;

import co.estampas.entities.MaterialCamiseta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresV
 */
@Local
public interface MaterialCamisetaFacadeLocal {

  void create(MaterialCamiseta materialCamiseta);

  void edit(MaterialCamiseta materialCamiseta);

  void remove(MaterialCamiseta materialCamiseta);

  MaterialCamiseta find(Object id);

  List<MaterialCamiseta> findAll();

  List<MaterialCamiseta> findRange(int[] range);

  int count();
  
}
