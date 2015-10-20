/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.estampas.servlets;

import co.estampas.entities.Administrador;
import co.estampas.entities.Artista;
import co.estampas.entities.Comprador;
import co.estampas.entities.EstampaCamiseta;
import co.estampas.entities.LugarEstampaCamiseta;
import co.estampas.entities.TamanoEstampa;
import co.estampas.entities.TemaEstampa;
import co.estampas.session.AdministradorFacadeLocal;
import co.estampas.session.ArtistaFacadeLocal;
import co.estampas.session.CompradorFacadeLocal;
import co.estampas.session.EstampaCamisetaFacadeLocal;
import co.estampas.session.LugarEstampaCamisetaFacadeLocal;
import co.estampas.session.TamanoEstampaFacadeLocal;
import co.estampas.session.TemaEstampaFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AndresV
 */
public class login extends HttpServlet {
  @EJB
  private AdministradorFacadeLocal administradorFacade;
  @EJB
  private EstampaCamisetaFacadeLocal estampaCamisetaFacade;
  @EJB
  private LugarEstampaCamisetaFacadeLocal lugarEstampaCamisetaFacade;
  @EJB
  private TamanoEstampaFacadeLocal tamanoEstampaFacade;
  @EJB
  private TemaEstampaFacadeLocal temaEstampaFacade;
  @EJB
  private ArtistaFacadeLocal artistaFacade;
  @EJB
  private CompradorFacadeLocal compradorFacade;
  
  List<Artista> artista = new ArrayList();
  List<Comprador> comprador = new ArrayList();
  List<Administrador> admin = new ArrayList();
  private boolean ingresoArtista = false;
  private boolean ingresoComprad = false;
  private boolean ingresoAdmin = false;

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
      HttpSession objSesion = request.getSession(true); 
      /* TODO output your page here. You may use following sample code. */
      if (ingresoArtista) {
        if (artista.size() > 0) {
          for (Artista ar : artista) {
            int idUser = ar.getIdArtista(); //aqui tu identificador de usuario
            String idString = Integer.toString(idUser);
            //ENVIO POR SESSION LA LISTA DE TEMAS DE LAS ESTAMPAS
            List<TemaEstampa> temas = new ArrayList();
            temas = temaEstampaFacade.findAll();
            objSesion.setAttribute("temasEstampa", temas );
            //ENVIO POR SESSION LA LSITA DE TAMAÑOS
            List<TamanoEstampa> tamanos = new ArrayList();
            tamanos = tamanoEstampaFacade.findAll();
            objSesion.setAttribute("tamanosEstampa", tamanos );
            //ENVIO POR SESSION LA LSITA DE LUGARES
            List<LugarEstampaCamiseta> lugar = new ArrayList();
            lugar = lugarEstampaCamisetaFacade.findAll();
            objSesion.setAttribute("lugarEstampa", lugar );
            //CREO LA SESION CON EL ID DEL USUARIO
            objSesion.setAttribute("idUsuaio", idString );
            //ENVIO LAS ESTAMPAS QUE TIENE EL ARTISTA
            int idArtista = Integer.parseInt(idString);
            List<EstampaCamiseta> estampas = new ArrayList<>();
            estampas=estampaCamisetaFacade.estampaByArtista(artistaFacade.find(idArtista));
            objSesion.setAttribute("estampas", estampas );
            ingresoArtista = false;
            response.sendRedirect("artista/index.jsp");
          }
        } else {
          out.println("<h1>Usuario no registrado</h1>");
        }
      } else if (ingresoComprad) {
        if (comprador.size() > 0) {
          for (Comprador co : comprador) {
             int idUser = co.getIdCliente(); //aqui tu identificador de usuario
             String idString = Integer.toString(idUser);
            objSesion.setAttribute("idUsuaio", idString );
            ingresoComprad = false;
            response.sendRedirect("comprador/index.jsp");
          }
        } else {
          out.println("<h1>Usuario no registrado</h1>");
        }
      }else if(ingresoAdmin){
        if (admin.size() > 0) {
          for (Administrador ad : admin) {
             int idAdmin = ad.getIdAdmin(); //aqui tu identificador de usuario
             //String idString = Integer.toString(idAdmin);
            objSesion.setAttribute("idadmin", idAdmin );
            ingresoComprad = false;
            response.sendRedirect("admin/index.jsp");
          }
        } else {
          out.println("<h1>Usuario no registrado</h1>");
        }
      }
        
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
    String tipo = request.getParameter("tipo");
    String user = request.getParameter("user");
    String pasword = request.getParameter("passwrd");
    switch (tipo) {
      case "C":
         ingresoComprad = true;
        comprador = compradorFacade.logIn(user, pasword);
        break;
      case "A":
        ingresoArtista = true;
        artista = artistaFacade.logIn(user, pasword);
        break;
      case "AD":
        ingresoAdmin = true;
        admin = administradorFacade.login(user, pasword);
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
