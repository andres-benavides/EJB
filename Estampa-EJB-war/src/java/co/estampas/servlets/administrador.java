/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.estampas.servlets;

import co.estampas.entities.PrecioCamiseta;
import co.estampas.entities.PrecioTexto;
import co.estampas.session.PrecioCamisetaFacadeLocal;
import co.estampas.session.PrecioTextoFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AndresV
 */
public class administrador extends HttpServlet {
  @EJB
  private PrecioTextoFacadeLocal precioTextoFacade;
  @EJB
  private PrecioCamisetaFacadeLocal precioCamisetaFacade;
  
  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
      /* TODO output your page here. You may use following sample code. */
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet administrador</title>");      
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet administrador at " + request.getContextPath() + "</h1>");
      out.println("</body>");
      out.println("</html>");
    }
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String action = request.getParameter("action");
    switch(action){
      case "adminTarifa":
        String precionCamisa = request.getParameter("precioCamisa");
        String preciontexto = request.getParameter("precioTexto");
        if(precionCamisa!=null){
          PrecioCamiseta cami = new PrecioCamiseta();
          cami.setPrecio(precionCamisa);
          precioCamisetaFacade.create(cami);
        }
        if(preciontexto!=null){
          PrecioTexto txt = new PrecioTexto();
          txt.setPrecio(preciontexto);
          precioTextoFacade.create(txt);
        }
        break;
    }
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
