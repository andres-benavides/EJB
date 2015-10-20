/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.estampas.servlets;

import co.estampas.entities.Artista;
import co.estampas.entities.EstampaCamiseta;
import co.estampas.entities.TamanoEstampa;
import co.estampas.entities.TemaEstampa;
import co.estampas.session.ArtistaFacadeLocal;
import co.estampas.session.EstampaCamisetaFacadeLocal;
import co.estampas.session.LugarEstampaCamisetaFacadeLocal;
import co.estampas.session.TamanoEstampaFacadeLocal;
import co.estampas.session.TemaEstampaFacadeLocal;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author AndresV
 */
public class guardarEstampa extends HttpServlet {

  @EJB
  private EstampaCamisetaFacadeLocal estampaCamisetaFacade;
  @EJB
  private ArtistaFacadeLocal artistaFacade;
  @EJB
  private LugarEstampaCamisetaFacadeLocal lugarEstampaCamisetaFacade;
  @EJB
  private TamanoEstampaFacadeLocal tamanoEstampaFacade;
  @EJB
  private TemaEstampaFacadeLocal temaEstampaFacade;

  private String dirUploadFiles;
  private boolean subioImagen;
  private int idArtistax;
  ArrayList<String> campos = new ArrayList();

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
    try{
    HttpSession objSesion = request.getSession(true);
    objSesion.setAttribute("estampas",null);
    /* TODO output your page here. You may use following sample code. */
    List<EstampaCamiseta> estampas = new ArrayList<>();
    estampas = estampaCamisetaFacade.estampaByArtista(artistaFacade.find(this.idArtistax));
    objSesion.setAttribute("estampas", estampas);

    //request.setAttribute("servlet", "ok");
    objSesion.setAttribute("servlet", "ok");
    //request.getRequestDispatcher("artista/administrarEstampa.jsp").forward(request, response);
    response.sendRedirect("artista/administrarEstampa.jsp");
//    out.print(subioImagen);
    }catch(Exception ex){
      
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
    String rutaImg = "NN";
    /*
     SUBIR LA IMAGEN AL SERVIDOR
     */
    dirUploadFiles = getServletContext().getRealPath(getServletContext().getInitParameter("dirUploadFiles"));
    if (ServletFileUpload.isMultipartContent(request)) {
      FileItemFactory factory = new DiskFileItemFactory();
      ServletFileUpload upload = new ServletFileUpload(factory);
      upload.setSizeMax(new Long(getServletContext().getInitParameter("maxFileSize")).longValue());
      List listUploadFiles = null;
      FileItem item = null;
      try {
        listUploadFiles = upload.parseRequest(request);
        Iterator it = listUploadFiles.iterator();
        while (it.hasNext()) {
          item = (FileItem) it.next();
          if (!item.isFormField()) {
            if (item.getSize() > 0) {
              String nombre = item.getName();
              String extension = nombre.substring(nombre.lastIndexOf("."));
              File archivo = new File(dirUploadFiles, nombre);
              item.write(archivo);
              if (archivo.exists()) {
                subioImagen = true;
                rutaImg = "estampas/" + nombre;
//                response.sendRedirect("uploadsave.jsp");
              } else {
                subioImagen = false;
              }
            }
          } else {
            campos.add(item.getString());
          }
        }
      } catch (FileUploadException e) {
        subioImagen = false;
      } catch (Exception e) {
        subioImagen = false;
      }
    }
    if (subioImagen) {
      String nombreImg = campos.get(1);
      processRequest(request, response);
      EstampaCamiseta estampa = new EstampaCamiseta();
      //BUSCO EL ARTISTA QUE VA A GUARDAR LA ESTAMPA
      this.idArtistax = Integer.parseInt(campos.get(0));
      Artista ar = artistaFacade.find(Integer.parseInt(campos.get(0)));
      estampa.setIdArtista(ar);
      //TRAIGO EL TAMAÑO QUE ELIGIERON DE LA ESTAMPA
      TamanoEstampa tamEstampa = tamanoEstampaFacade.find(Integer.parseInt(campos.get(4)));
      estampa.setIdTamanoEstampa(tamEstampa);
      //TRAIGO EL TEMA QUE ELIGIERON DE LA ESTAMPA
      TemaEstampa temaEstampa = temaEstampaFacade.find(Integer.parseInt(campos.get(2)));
      estampa.setIdTemaEstampa(temaEstampa);
      //ASIGNO EL NOMBRE DE LA ESTAMPA
      estampa.setDescripcion(nombreImg);
      //ASIGNO LA RUTA DE LA IMAGEN QUE CREO
      estampa.setImagenes(rutaImg);
      //ASIGNO LA UBICACION DE LA IMAGEN EN LA CAMISA
      estampa.setUbicacion(campos.get(5));
      //ASIGNO EL PRECIO DE LA IMAGEN QUE CREO
      estampa.setPrecio(campos.get(3));
      //ASIGNO EL ID DEL LUGAR 
      estampa.setIdLugarEstampa(Integer.parseInt(campos.get(5)));
      //GUARDAR LA ESTAMPA
      estampaCamisetaFacade.create(estampa);
    } else {
      System.out.println("Error al subir imagen");
    }
        campos = new ArrayList<>();

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
