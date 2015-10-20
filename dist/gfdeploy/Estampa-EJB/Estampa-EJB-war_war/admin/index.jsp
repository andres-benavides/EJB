<%-- 
    Document   : index
    Created on : 27/08/2015, 11:10:50 PM
    Author     : AndresV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!--LLAMOloooo LOS SCRIPT DE JS QUE NECESITO EN ESTE CASO FUNCIONES Y LA LIBRERIA DE JQUERY-->
    <script type="text/javascript" src="../js/libs/jquery.js"></script>
    <script type="text/javascript" src="../js/funciones.js"></script>
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
    </style>
  </head>
  <body>
    <nav class="navbar navbar-default">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="#">Estampate</a>
        </div>
        <div class="collapse navbar-collapse" >
          <a href="../index.jsp"><button type="button" class="btn btn-default navbar-btn" id="btnSession">Cerrar Sesion</button></a>
          <ul class="nav navbar-nav">
            <li><a id="administrarTarifa">Administrar Tarifas</a></li>
            <li><a href="#">Generar Reportes</a></li>
            <li><a href="modificarPerfil.jsp">Modificar Perfil</a></li>
          </ul>
        </div>
      </div>
    </nav>
    <!--FORMULARIO DE REGISTRO-->
    <div class="container-fluid" id="administrarTarifa" >
      <div class="row">
        <div class="col-lg-6 col-ms-6 col-xs-6">
          <form class="form-horizontal" action="../administrador" method="post" role="form"  >
            <div class="form-group">
              <label class="col-lg-6 control-label"  for="precioCamisa">Precio estadar camisa:</label>
              <div class="col-lg-6">
                <input type="hidden" name="action" value="adminTarifa" />
                <input type="text" name="precioCamisa" id="precioCamisa" class="form-control" required />
              </div>
            </div>
            <div class="form-group">
              <label class="col-lg-6 control-label"  for="precioTexto">Precio estandar texto:</label>
              <div class="col-lg-6">
                <input type="text" name="precioTexto" id="precioTexto" class="form-control" required />
              </div>
            </div>
            <div class="form-group">
              <div class="col-lg-12">
                <input type="submit" name="registrar" id="registrar" class="btn btn-success" />
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
