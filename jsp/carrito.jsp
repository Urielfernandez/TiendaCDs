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
    <link rel="stylesheet" href="./css/resumen.css">
  </head>

  <body>
    <%@ include file="/jsp/navTienda.jsp" %>

    <section class="container">
      <div class="row">
        <div class="col mt-2 p-0 cabeceroSeccion">
          <h1 class="m-1">Carrito</h1>
        </div>
      </div>
      
      <div class="row">
        <ul class="col-12 p-0 resumen">
          <li class="producto p-0 py-1 mt-3">
            <ul class="row p-0">
              <li class="col-3 offset-2">Producto</li>
              <li class="col-2">Precio unidad</li>
              <li class="col-2">Cantidad</li>
              <li class="col-2">Importe</li>
            </ul>
          </li> 
              
          <c:forEach var="articulo" items="${contenidoCarrito}">
            <li class="producto p-0 py-1">
              <ul class="row p-0">
                <li class="col-2 p-0"><img src="./imagenes/cd.png" class="img-fluid" width="175" height="100"></li>
                <li class="col-3 my-auto">${articulo.cd.titulo}</li>
                <li class="col-2 my-auto"><fmt:formatNumber value="${articulo.cd.precio}" type="number" minFractionDigits="2" maxFractionDigits="2"/> €</li>
                <li class="col-2 my-auto">${articulo.cantidad}</li>
                <li class="col-2 my-auto"><fmt:formatNumber value="${articulo.cd.precio * articulo.cantidad}" type="number" minFractionDigits="2" maxFractionDigits="2"/>€</li>
                <li class="col-1 my-auto">
                  <form action="./tienda" method="post" class="text-center">
                    <input type="hidden" name="opcion" value="removeFromCarrito">
                    <input type="hidden" name="nombre" value="${articulo.nombre}">
                    <button type="submit" class="btnInicio">
                      <img src="./imagenes/iconos/papelera.svg" height="24" width="24">
                    </button>
                  </form>
                </li>
              </ul>
            </li>
          </c:forEach>
        </ul>

        <ul class="col-12 p-0 total">
          <li class="p-0 py-1">
            <ul class="row p-0">
              <li class="col-2 offset-5">
                <form action="./tienda" method="post" class="text-center">
                  <input type="hidden" name="opcion" value="comprar">
                  <button type="submit" class="btnInicio px-md-3 px-lg-5">Pagar</button>
                </form>
              </li>
              <li class="col-2 text-right"><h4>Total:</h4></li>
              <li class="col-3"><h4><fmt:formatNumber value="${carrito.total}" type="number" minFractionDigits="2" maxFractionDigits="2"/> €</h4></li>
            </ul>
          </li> 
        </ul>
      </div>      
    </section>

    <script src="./js/jquery-3.4.1.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
  </body>
</html>