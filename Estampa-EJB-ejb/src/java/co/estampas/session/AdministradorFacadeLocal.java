/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.estampas.session;

import co.estampas.entities.Administrador;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresV
 */
@Local
public interface AdministradorFacadeLocal {

  void create(Administrador administrador);

  void edit(Administrador administrador);

  void remove(Administrador administrador);

  Administrador find(Object id);

  List<Administrador> findAll();

  List<Administrador> findRange(int[] range);

  int count();
  
  public List<Administrador> login(String user,String password);
  
}
