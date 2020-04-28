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
    <link rel="stylesheet" href="./css/carrito.css">
  </head>

  <body>
    <%@ include file="navTienda.jsp" %>

    <section class="container">
      <div class="row">
        <div class="col-6 mx-auto mt-3 p-0 cabeceroSeccion">
          <h1 class="m-1 text-center">Carrito</h1>
        </div>
      </div>
      
      <div class="row">
        <div class="col-6 mx-auto my-3">
          <div class="text-center">
            <img src="./imagenes/iconos/carritoVacio.svg" class="mx-auto my-5" alt="Logo" height="90" width="90">
          </div>
          <h4 class="text-center">Tu carrito está vacio!</h4>
          <p class="text-center">Puedes añadir productos en la tienda.</p>
          <div class="text-center">
            <a href="tienda"><button type="button" class="btnInicio">Volver a la tienda</button><a>
          </div>
        </div>
      </div>
    </section>

    <script src="./js/jquery-3.4.1.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
  </body>
</html>