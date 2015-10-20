/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.estampas.session;

import co.estampas.entities.Comprador;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresV
 */
@Local
public interface CompradorFacadeLocal {

  void create(Comprador comprador);

  void edit(Comprador comprador);

  void remove(Comprador comprador);

  Comprador find(Object id);

  List<Comprador> findAll();

  List<Comprador> findRange(int[] range);

  int count();
  public List<Comprador> logIn(String user,String password);
  
}
