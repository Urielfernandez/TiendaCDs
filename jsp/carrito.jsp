<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="es">

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Tienda de CDs</title>
		
    <!-- Bootstrap css -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" 
      crossorigin="anonymous">
    <link rel="stylesheet" href="css/main.css">
	</head>

  <body>
    <%@ include file="navbar.jsp" %>

    <section class="container">
      <div class="row">
        <div class="col">
          <h1 class="tituloPagina">Carrito</h1>
        </div>
      </div>
      
      <div class="row">
        <ul class="col tabla">
          <li class="items mt-2">
            <ul class="row p-0">
              <li class="col-5"><b>Producto</b></li>
              <li class="col-2"><b>Precio unidad</b></li>
              <li class="col-2"><b>Cantidad</b></li>
              <li class="col-2"><b>Importe</b></li>
            </ul>
          </li> 
              
          <c:forEach var="seleccion" items="${contenidoCarrito}">
            <li class="items">
              <ul class="row p-0">
                <li class="col-5 my-auto">${seleccion.cd.titulo}</li>
                <li class="col-2 my-auto"><fmt:formatNumber value="${seleccion.cd.precio}" type="number" minFractionDigits="2" maxFractionDigits="2"/> €</li>
                <li class="col-2 my-auto">${seleccion.cantidad}</li>
                <li class="col-2 my-auto"><fmt:formatNumber value="${seleccion.cd.precio * seleccion.cantidad}" type="number" minFractionDigits="2" maxFractionDigits="2"/>€</li>
                <li class="col-1 my-auto">
                  <form action="tienda" method="post" class="text-center">
                    <input type="hidden" name="opcion" value="eliminarArticulo">
                    <input type="hidden" name="titulo" value="${seleccion.cd.titulo}">
                    <button type="submit" class="btn btn-light">
                      <img src="imagenes/iconos/papelera.svg" height="24" width="24">
                    </button>
                  </form>
                </li>
              </ul>
            </li>
          </c:forEach>
        </ul>
      </div>

      <c:choose>
        <c:when test="${mensajeDescuento != null && importeDescontado != null}">
          <div class="row">
            <ul class="col total">
              <li>
                <ul class="row p-0">
                  <li class="col-3 offset-9 my-auto">
                    <h5><fmt:formatNumber value="${importeTotal}" type="number" minFractionDigits="2" maxFractionDigits="2"/> €</h5>
                  </li>
                </ul>
              </li> 
            </ul>
          </div>

          <div class="row">
            <ul class="col total">
              <li>
                <ul class="row p-0">
                  <li class="col-3 offset-9 my-auto">
                    <h5>${mensajeDescuento}</h5>
                  </li>
                </ul>
              </li> 
            </ul>
          </div>

          <div class="row">
            <ul class="col total">
              <li>
                <ul class="row p-0">
                  <li class="col-2 offset-7 text-right my-auto"><h5>Total:</h5></li>
                  <li class="col-3 my-auto">
                    <h5><fmt:formatNumber value="${importeDescontado}" type="number" minFractionDigits="2" maxFractionDigits="2"/> €</h5>
                  </li>
                </ul>
              </li> 
            </ul>
          </div>
        </c:when>

        <c:otherwise>
          <div class="row">
            <ul class="col total">
              <li>
                <ul class="row p-0">
                  <li class="col-2 offset-7 text-right my-auto"><h5>Total:</h5></li>
                  <li class="col-3 my-auto">
                    <h5><fmt:formatNumber value="${importeTotal}" type="number" minFractionDigits="2" maxFractionDigits="2"/> €</h5>
                  </li>
                </ul>
              </li> 
            </ul>
          </div>
        </c:otherwise>
      </c:choose>
      
      <form action="tienda" method="POST" id="formulario" class="text-center">
        <input type="hidden" name="opcion" value="comprar">
        <button type="submit" class="btn btn-primary px-5">Pagar</button>
      </form>
    </section>

		<!-- JQuery -->
    <script
      src="https://code.jquery.com/jquery-3.4.1.min.js"
      integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
      crossorigin="anonymous">
    </script>
    <!-- Popper -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
      integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
      crossorigin="anonymous">
    </script>
    <!-- Bootstrap js -->
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" 
      integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
			crossorigin="anonymous">
    </script>
  </body>
  
</html>