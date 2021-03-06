/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.estampas.session;

import co.estampas.entities.Stock;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AndresV
 */
@Local
public interface StockFacadeLocal {

  void create(Stock stock);

  void edit(Stock stock);

  void remove(Stock stock);

  Stock find(Object id);

  List<Stock> findAll();

  List<Stock> findRange(int[] range);

  int count();
  
}
