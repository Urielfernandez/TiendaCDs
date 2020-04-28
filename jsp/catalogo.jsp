<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Esta es una web con utilidades para músicos y gestión de una escuela de música">
    <meta name="keywords" content="partituras, metrónomo, grabadora, cursos, escuela, música, matrícula">
    <title>Escuela de música</title>
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/main.css">
  </head>

  <body>
    <%@ include file="navTienda.jsp" %>

    <section class="container-fluid">
      <div class="row">
        <nav class="col-lg-2 p-0 pt-3 menuLateral">
          <ul class="p-0 subcategorias">
            <a href="#"><li class="secionActual">Guitarras</li></a>
          </ul>
        </nav>

        <div class="col-lg-10">
          <div class="row">
            <div class="col mx-4 mt-2 p-0 cabeceroSeccion">
              <h1 class="m-0">Tienda</h1>
            </div>
          </div>

          <div class="row mt-3 mx-1">
            <c:forEach var="articulo" items="${listaArticulos}">
              <%@ include file="articulo.jsp" %>
            </c:forEach>
          </div>
        </div>
      </div>
    </section>

    <script src="./js/jquery-3.4.1.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/tienda/catalogo.js"></script>
  </body>
</html>