<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="es">

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Tienda de CDs</title>
		
    <link rel="stylesheet" href="css/main.css">

    <!-- Bootstrap -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
			crossorigin="anonymous">
	</head>

  <body>
    <%@ include file="navbarCarrito.jsp" %>

    <section class="container">
      <div class="row">
        <div class="col">
          <h1 class="tituloPagina">Carrito</h1>
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
                    <input type="hidden" name="nombre" value="${articulo.cd.titulo}">
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
              <li class="col-3"><h4><fmt:formatNumber value="${precioTotal}" type="number" minFractionDigits="2" maxFractionDigits="2"/> €</h4></li>
            </ul>
          </li> 
        </ul>
      </div>      
    </section>

		<!-- JQuery -->
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" 
      integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" 
      crossorigin="anonymous">
    </script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" 
      integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
			crossorigin="anonymous">
    </script>
    <!-- Bootstrap -->
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" 
      integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
			crossorigin="anonymous">
    </script>
  </body>
</html>