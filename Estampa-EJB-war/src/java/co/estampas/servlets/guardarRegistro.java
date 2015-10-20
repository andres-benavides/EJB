/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.estampas.servlets;

import co.estampas.entities.Artista;
import co.estampas.entities.Comprador;
import co.estampas.session.ArtistaFacadeLocal;
import co.estampas.session.CompradorFacadeLocal;
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
public class guardarRegistro extends HttpServlet {
  @EJB
  private CompradorFacadeLocal compradorFacade;
  @EJB
  private ArtistaFacadeLocal artistaFacade;
  

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
      out.println("<title>Servlet guardarRegistro</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet guardarRegistro at " + request.getContextPath() + "</h1>");
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
    //RESIBO EL TIPO PARA SABER SI ES REGISTRO DE ARTISTA "A" O DE COMPRADOR "C"
    String tipo = request.getParameter("tipo");
    //HAGO EL REQUEST DE LOS CAMPOS DEL FORMULARIO
    String nombre = request.getParameter("nombre");
    String apellido = request.getParameter("apellido");
    String direccion = request.getParameter("direccion");
    String cedula = (request.getParameter("cedula"));
    String celular = (request.getParameter("celular"));
    String usuario = request.getParameter("usuario");
    String password = request.getParameter("password");

    //CREO EL DAO QUE ME VALIDA SI EL USUARIO YA ESTA REGISTRADO
    if (request.getParameter("modifica") == null) {
      //validarLoginDAO validaUser = new validarLoginDAO();
      if (tipo.equals("C")) {
        Comprador comprador = new Comprador(0,nombre, apellido, direccion, cedula, celular, usuario, password);
        compradorFacade.find(comprador);
       
        //SI EL USUARIO NO ESTA REGISTRADO GUARDO EL REGISTRO
                  compradorFacade.create(comprador);

//        if (compradorFacade.find(comprador)==null) {
//        }
      } else if (tipo.equals("A")) {
        Artista artista = new Artista(0,nombre, apellido, direccion, cedula, celular, usuario, password);
       
        //SI EL USUARIO NO ESTA REGISTRADO GUARDO EL REGISTRO
                 artistaFacade.create(artista);

//        if (artistaFacade.find(artista)==null) {
//        }
      }

    } /*else if (request.getParameter("modifica").equals("S")) {
      this.tipo = tipo;
      guardarRegistroDAO registro = new guardarRegistroDAO();
      if (tipo.equals("A")) {
        //Artista artista = new Artista();
        datosGeneralesDAO infoUser = new datosGeneralesDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        Artista artista = infoUser.getArtista(id);
        artista.setNombre(nombre);
        artista.setApellido(apellido);
        artista.setDireccion(direccion);
        artista.setCedula(cedula);
        artista.setCelular(celular);
        artista.setUsuario(usuario);
        artista.setPassword(password);
        registro.actualizaArtista(artista);
      } else if (tipo.equals("C")) {
        datosGeneralesDAO infoUser = new datosGeneralesDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        Comprador comprador = infoUser.getComprador(id);
        comprador.setNombre(nombre);
        comprador.setApellido(apellido);
        comprador.setDireccion(direccion);
        comprador.setCedula(cedula);
        comprador.setCelular(celular);
        comprador.setUsuario(usuario);
        comprador.setPassword(password);
        registro.actualizaComprador(comprador);
      }
    }*/
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
