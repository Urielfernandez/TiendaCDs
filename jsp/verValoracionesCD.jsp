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
          <h1 class="tituloPagina">Valoraciones</h1>
        </div>
      </div>

      <div class="row my-2">
        <div class="col-4">
          <img class="img-fluid" src="imagenes/cd.png">
        </div>
        <div class="col-8 my-auto">
          <p class="my-1" style="font-size: 18px;">Título: ${cd.titulo}</p>
          <p class="my-1" style="font-size: 18px;">Artista: ${cd.artista}</p>
          <p class="my-1" style="font-size: 18px;">País: ${cd.pais}</p>
          <p class="my-1" style="font-size: 18px;">Año: ${cd.anho}</p>
          <p class="my-1" style="font-size: 18px;">Precio: <fmt:formatNumber value="${cd.precio}" type="number" minFractionDigits="2" maxFractionDigits="2"/> €</p>
          <p class="my-1" style="font-size: 18px;">Nota media: ${notaMedia}</p>
        </div>
      </div>

      <div class="row">
        <ul class="col tabla">
          <li class="items mt-2">
            <ul class="row p-0">
              <li class="col-3"><b>Usuario</b></li>
              <li class="col-1"><b>Nota</b></li>
              <li class="col-8"><b>Opinion</b></li>
            </ul>
          </li> 
              
          <c:forEach var="seleccion" items="${valoracionesCD}">
            <li class="items">
              <ul class="row p-0">
                <li class="col-3 my-auto">${seleccion.emailUsuarioEmisor}</li>
                <li class="col-1 my-auto">${seleccion.nota}</li>
                <li class="col-8 my-auto">${seleccion.opinion}</li>
              </ul>
            </li>
          </c:forEach>
        </ul>
      </div>
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