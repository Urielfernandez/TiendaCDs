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
    <%@ include file="navTienda.jsp" %>

    <section class="container">
      <div class="row">
        <div class="col mt-2 p-0 cabeceroSeccion">
          <h1 class="m-1 text-center">Resumen de compra</h1>
        </div>
      </div>
    </section>
    
    <section class="container mt-3" style="background-color: #f4f4f4;">
      <div class="row">
        <div class="col-12">
          <h3 class="mt-2 text-center">Factura simplificada</h3>
          <p class="m-0">Tienda de música S.A.</p>
          <p class="m-0">Santiago de Compostela</p>
          <p class="m-0">Teléfono: ${telefonoTienda}</p>
          <p class="m-0">Correo electrónico: ${emailTienda}</p>
        </div>
      </div>
      
      <div class="row mt-3 mx-1">
        <ul class="col-12 p-0 resumen">
          <li class="producto p-0 py-1">
            <ul class="row p-0">
              <li class="col-4 offset-2">Producto</li>
              <li class="col-2">Cantidad</li>
              <li class="col-2">Precio unidad</li>
              <li class="col-2">Importe</li>
            </ul>
          </li> 
              
          <c:forEach var="articulo" items="${compras}">
            <li class="producto p-0 py-1">
              <ul class="row p-0">
                <li class="col-2"><img src="./imagenes/productos/${articulo.imagen}" class="img-fluid" width="175" height="100"></li>
                <li class="col-4 my-auto">${articulo.nombre}</li>
                <li class="col-2 my-auto">${articulo.unidadesSeleccionadas}</li>
                <li class="col-2 my-auto"><fmt:formatNumber value="${articulo.precio}" type="number" minFractionDigits="2" maxFractionDigits="2"/> €</li>
                <li class="col-2 my-auto">
                  <fmt:formatNumber value="${articulo.precio * articulo.unidadesSeleccionadas}" type="number" minFractionDigits="2" maxFractionDigits="2"/> €
                </li>
              </ul>
            </li> 
          </c:forEach>
        </ul>

        <ul class="col-12 m-0 mt-1 p-0 total">
          <li class="p-0">
            <ul class="row p-0">
              <li class="col-2 offset-8"><h6>Base imponible:</h6></li>
              <li class="col-2">
                <h6>
                  <fmt:formatNumber value="${total * (1.0/(1.0 + 0.21))}" type="number" minFractionDigits="2" maxFractionDigits="2"/> €
                </h6>
              </li>
            </ul>
          </li> 
        </ul>

        <ul class="col-12 m-0 p-0 total">
          <li class="p-0">
            <ul class="row p-0">
              <li class="col-2 offset-8"><h6>IVA (21%):</h6></li>
              <li class="col-2">
                <h6>
                  <fmt:formatNumber value="${(total * (1.0/(1 + 0.21))) * 0.21}" type="number" minFractionDigits="2" maxFractionDigits="2"/> €
                </h6>
              </li>
            </ul>
          </li> 
        </ul>

        <ul class="col-12 mt-2 p-0 total">
          <li class="p-0">
            <ul class="row p-0">
              <li class="col-2 offset-8"><h4>Total:</h4></li>
              <li class="col-2"><h4><fmt:formatNumber value="${total}" type="number" minFractionDigits="2" maxFractionDigits="2"/> €</h4></li>
            </ul>
          </li> 
        </ul>
      </div>
    </section>

    <section class="container">
      <div class="row mt-3">
        <div class="col mx-auto">
          <form action="tienda" method="post" class="text-center">
            <input type="hidden" name="opcion" value="finalizar">
            <button type="submit" class="btnInicio px-md-3 px-lg-5">Finalizar</button>
          </form>
        </div>
      </div>
    </section>

    <script src="./js/jquery-3.4.1.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
  </body>
</html>