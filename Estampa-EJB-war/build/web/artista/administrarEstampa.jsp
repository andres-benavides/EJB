
<%@page import="co.estampas.entities.EstampaCamiseta"%>
<%@page import="co.estampas.entities.LugarEstampaCamiseta"%>
<%@page import="co.estampas.entities.TamanoEstampa"%>
<%@page import="co.estampas.session.TemaEstampaFacade"%>
<%@page import="java.util.List"%>
<%@page import="co.estampas.entities.TemaEstampa"%>
<%@page import="java.util.ArrayList"%>
<%@page import="co.estampas.session.TemaEstampaFacadeLocal"%>
<%@page import="javax.ejb.EJB"%>
<%
  /**
   * CRELA UNA OBJETO DE TIPO SESSION
   */
  HttpSession objSesion = request.getSession(false);
  String usuario = (String) (objSesion.getAttribute("idUsuaio"));
  //TRAIGO LOS TEMAS DE LAS ESTAMPAS QUE ESTAN EN LA SESSION
  List<TemaEstampa> temas = (List<TemaEstampa>) (objSesion.getAttribute("temasEstampa"));
  //TRAIGO LOS TEMAS DE LAS ESTAMPAS QUE ESTAN EN LA SESSION
  List<TamanoEstampa> tamanoEstampa = (List<TamanoEstampa>) (objSesion.getAttribute("tamanosEstampa"));
  //TRAIGO LOS LUGARES DE LAS ESTAMPAS QUE ESTAN EN LA SESSION
  List<LugarEstampaCamiseta> lugarEstampa = (List<LugarEstampaCamiseta>) (objSesion.getAttribute("lugarEstampa"));
  //TRAIGO LAS ESTAMPAS DEL ARTISTA QUE ESTAN EN LA SESSION
  List<EstampaCamiseta> estampa = (List<EstampaCamiseta>) (objSesion.getAttribute("estampas"));
  
  String deServlet = (String) objSesion.getAttribute("servlet");
  boolean servlet;
  servlet = deServlet!=null;
  if(servlet){
    out.println("<script>alert('Estampa Guardada con exito');</script>");
    objSesion.setAttribute("servlet",null);
  }
%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!--LLAMO LOS SCRIPT DE JS QUE NECESITO EN ESTE CASO FUNCIONES Y LA LIBRERIA DE JQUERY-->

    <script type="text/javascript" src="../js/libs/jquery.js"></script>
    <script type="text/javascript" src="../js/funciones.js"></script>
    <script type="text/javascript" src="../js/jssor.slider-20.mini.js"></script>

    <link rel="stylesheet" href="../js/libs/bootstrap-3.3.5-dist/css/bootstrap.min.css" />

    <title>Estampate!!!!</title>
    <style type="text/css">
      li:hover{
        background:#81F7D8;
        border-left-style:  solid;
        border-right-style:  solid;
        border-left-width: 1px;
        border-right-width: 1px;
      }

      .contenedor{
        display: block;
        width: 181px;
        float: left;
      }


      /* jssor slider bullet navigator skin 01 css */
      /*
      .jssorb01 div           (normal)
      .jssorb01 div:hover     (normal mouseover)
      .jssorb01 .av           (active)
      .jssorb01 .av:hover     (active mouseover)
      .jssorb01 .dn           (mousedown)
      */
      .jssorb01 {
        position: absolute;
      }
      .jssorb01 div, .jssorb01 div:hover, .jssorb01 .av {
        position: absolute;
        /* size of bullet elment */
        width: 12px;
        height: 12px;
        filter: alpha(opacity=70);
        opacity: .7;
        overflow: hidden;
        cursor: pointer;
        border: #000 1px solid;
      }
      .jssorb01 div { background-color: gray; }
      .jssorb01 div:hover, .jssorb01 .av:hover { background-color: #d3d3d3; }
      .jssorb01 .av { background-color: #fff; }
      .jssorb01 .dn, .jssorb01 .dn:hover { background-color: #555555; }

      /* jssor slider arrow navigator skin 05 css */
      /*
      .jssora05l                  (normal)
      .jssora05r                  (normal)
      .jssora05l:hover            (normal mouseover)
      .jssora05r:hover            (normal mouseover)
      .jssora05l.jssora05ldn      (mousedown)
      .jssora05r.jssora05rdn      (mousedown)
      */
      .jssora05l, .jssora05r {
        display: block;
        position: absolute;
        /* size of arrow element */
        width: 40px;
        height: 40px;
        cursor: pointer;
        background: url('../imgx/a17.png') no-repeat;
        overflow: hidden;
      }
      .jssora05l { background-position: -10px -40px; }
      .jssora05r { background-position: -70px -40px; }
      .jssora05l:hover { background-position: -130px -40px; }
      .jssora05r:hover { background-position: -190px -40px; }
      .jssora05l.jssora05ldn { background-position: -250px -40px; }
      .jssora05r.jssora05rdn { background-position: -310px -40px; }

      /* jssor slider thumbnail navigator skin 09 css */

      .jssort09-600-45 .p {
        position: absolute;
        top: 0;
        left: 0;
        width: 600px;
        height: 45px;
      }

      .jssort09-600-45 .t {
        font-family: verdana;
        font-weight: normal;
        position: absolute;
        width: 100%;
        height: 100%;
        top: 0;
        left: 0;
        color:#fff;
        line-height: 45px;
        font-size: 20px;
        padding-left: 10px;
      }
    </style>
    <script type="text/javascript">
      $(document).ready(function () {
        $("#btnVerCat").click(function () {
          $("#adminDisenio").hide();
          $("#subirEstampa").hide();
          $("#verCatalogo").show();
        });
        $("#btnSubDis").click(function () {
          $("#adminDisenio").hide();
          $("#verCatalogo").hide();
          $("#subirEstampa").show();
        });
        $("#btnAdmiDis").click(function () {
          $("#adminDisenio").show();
          $("#verCatalogo").hide();
          $("#subirEstampa").hide();
        });
      });
    </script>
  </head>
  <body>
    <nav class="navbar navbar-default">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="#">Estampate</a>
        </div>
        <div class="collapse navbar-collapse" >
          <a href="index.jsp"><button type="button" class="btn btn-default navbar-btn" id="btnSession">Volver</button></a>
          <a href="../index.jsp"><button type="button" class="btn btn-default navbar-btn" id="btnSession">Cerrar Sesion</button></a>
        </div>
      </div>
    </nav>
    <!--FORMULARIO DE REGISTRO-->
    <div class="container-fluid" id="registro" >
      <div class="row">
        <div class="col-xs-4"></div>
        <div class="col-xs-4">
          <div class="row">
            <div class="col-xs-4"><button type="button" class="btn btn-default navbar-btn" id="btnVerCat">Ver Catalogo</button></div>
            <div class="col-xs-4"><button type="button" class="btn btn-default navbar-btn" id="btnSubDis">Subir nuevo diseño</button></div>
            <div class="col-xs-4"><button type="button" class="btn btn-default navbar-btn" id="btnAdmiDis">Administrar Diseños</button></div>
          </div>
        </div>
        <div class="col-xs-4"></div>
      </div>
      <div class="row">
        <div class="col xs 8" id="adminDisenio">

        </div>
        <div class="col xs 8" id="subirEstampa" style="display:none">
          <form class="form-horizontal" action="../guardarEstampa" method="post" role="form" enctype="multipart/form-data" >
            <div class="form-group">
              <label class="col-lg-2 control-label"  class="col-lg-2 control-label" for="nombre">Nombre:</label>
              <div class="col-lg-4">
                <input type="hidden" value="<%out.print(usuario);%>" name="idArtista" />
                <input type="text" name="nombre" id="nombre" class="form-control" required  />
              </div>
            </div>
            <div class="form-group">
              <label class="col-lg-2 control-label"  for="temaEstampa">Tema estampa :</label>
              <div class="col-lg-4">
                <select class="form-control" name="temaEstampa" required>
                  <%
                    for (TemaEstampa est : temas) {
                      out.println("<option value='" + est.getIdTemaEstampa() + "'>" + est.getTipoTema() + "</option>");
                    }
                  %>
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-lg-2 control-label"  for="precio">Precio</label>
              <div class="col-lg-4">
                <input type="number" name="precio" id="precio" required class="form-control" min="1" max="9999999999" />
              </div>
            </div>
            <div class="form-group">
              <label class="col-lg-2 control-label"  for="precio">Tamaño</label>
              <div class="col-lg-4">
                <select class="form-control" name="tamanoEstampa" required>
                  <%
                    for (TamanoEstampa tamp : tamanoEstampa) {
                      out.println("<option value='" + tamp.getIdTamanoEstampa() + "'>" + tamp.getEspecificacionTamano() + "</option>");
                    }
                  %>
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-lg-2 control-label"  for="ubicacion">Lugar de la estampa</label>
              <div class="col-lg-4">
                <select class="form-control" name="ubicacion" required>
                  <%
                    for (LugarEstampaCamiseta lug : lugarEstampa) {
                      out.println("<option value='" + lug.getIdLugarEstampaCamiseta() + "'>" + lug.getEspecificacionLugar() + "</option>");
                    }
                  %>
                </select>
              </div>
            </div>
            <div class="form-group">
              <label class="col-lg-2 control-label"  for="cedula">Imagen</label>
              <div class="col-lg-4">
                <input type="file" name="estampa" id="estampa" accept="image/png" class="form-control" />
              </div>
            </div>

            <div class="form-group">
              <div class="col-lg-7">
                <input type="submit" name="Guardar" id="guardar" class="btn btn-success" />
              </div>
            </div>
          </form>
        </div>
        <div class="col xs 8" id="verCatalogo" style="display:none">

          <div id="jssor_1" style="position: relative; margin: 0 auto; top: 0px; left: 0px; width: 600px; height: 300px; overflow: hidden; visibility: hidden;">
            <!-- Loading Screen -->
            <div data-u="loading" style="position: absolute; top: 0px; left: 0px;">
              <div style="filter: alpha(opacity=70); opacity: 0.7; position: absolute; display: block; top: 0px; left: 0px; width: 100%; height: 100%;"></div>
              <div style="position:absolute;display:block;background:url('img/loading.gif') no-repeat center center;top:0px;left:0px;width:100%;height:100%;"></div>
            </div>
            <div data-u="slides" style="cursor: default; position: relative; top: 0px; left: 0px; width: 600px; height: 300px; overflow: hidden;">
              <%
                for (EstampaCamiseta est : estampa) {
                  out.print("<div style='display: none;'>");
                  out.print("<img data-u='image' src='../" + est.getImagenes() + "'/>");
                  out.print("<div data-u='thumb'>");
                  out.print("<b>Nombre: " + est.getDescripcion() + "</b>");
                  out.print("<b>  Precio: $" + est.getPrecio() + "</b>");
                  out.print("</div>");
                  out.print("</div>");
                }
              %>
            </div>
            <!-- Thumbnail Navigator -->
            <div data-u="thumbnavigator" class="jssort09-600-45" style="position:absolute;bottom:0px;left:0px;width:600px;height:45px;">
              <div style="position: absolute; top: 0; left: 0; width: 100%; height:100%; background-color: #000; filter:alpha(opacity=40.0); opacity:0.4;"></div>
              <!-- Thumbnail Item Skin Begin -->
              <div data-u="slides" style="cursor: default;">
                <div data-u="prototype" class="p">
                  <div data-u="thumbnailtemplate" class="t"></div>
                </div>
              </div>
              <!-- Thumbnail Item Skin End -->
            </div>
            <!-- Bullet Navigator -->
            <div data-u="navigator" class="jssorb01" style="bottom:16px;right:10px;">
              <div data-u="prototype" style="width:12px;height:12px;"></div>
            </div>
            <!-- Arrow Navigator -->
            <span data-u="arrowleft" class="jssora05l" style="top:123px;left:8px;width:40px;height:40px;" data-autocenter="2"></span>
            <span data-u="arrowright" class="jssora05r" style="top:123px;right:8px;width:40px;height:40px;" data-autocenter="2"></span>
            <a href="http://www.jssor.com" style="display:none">Jssor Slider</a>
          </div>
        </div>
      </div>
    </div>
    <script>
      jQuery(document).ready(function ($) {

        var jssor_1_SlideshowTransitions = [
          {$Duration: 1200, x: -0.3, $During: {$Left: [0.3, 0.7]}, $Easing: {$Left: $Jease$.$InCubic, $Opacity: $Jease$.$Linear}, $Opacity: 2},
          {$Duration: 1200, x: 0.3, $SlideOut: true, $Easing: {$Left: $Jease$.$InCubic, $Opacity: $Jease$.$Linear}, $Opacity: 2}
        ];

        var jssor_1_options = {
          $AutoPlay: false,
          $SlideshowOptions: {
            $Class: $JssorSlideshowRunner$,
            $Transitions: jssor_1_SlideshowTransitions,
            $TransitionsOrder: 1
          },
          $ArrowNavigatorOptions: {
            $Class: $JssorArrowNavigator$
          },
          $BulletNavigatorOptions: {
            $Class: $JssorBulletNavigator$
          },
          $ThumbnailNavigatorOptions: {
            $Class: $JssorThumbnailNavigator$,
            $Cols: 1,
            $Align: 0
          }
        };

        var jssor_1_slider = new $JssorSlider$("jssor_1", jssor_1_options);

        //responsive code begin
        //you can remove responsive code if you don't want the slider scales while window resizes
        function ScaleSlider() {
          var refSize = jssor_1_slider.$Elmt.parentNode.clientWidth;
          if (refSize) {
            refSize = Math.min(refSize, 600);
            jssor_1_slider.$ScaleWidth(refSize);
          }
          else {
            window.setTimeout(ScaleSlider, 30);
          }
        }
        ScaleSlider();
        $(window).bind("load", ScaleSlider);
        $(window).bind("resize", ScaleSlider);
        $(window).bind("orientationchange", ScaleSlider);
        //responsive code end
      });
    </script>
  </body>
</html>
