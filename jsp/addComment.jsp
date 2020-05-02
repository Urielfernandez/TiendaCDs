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
          <h1 class="tituloPagina">Añadir comentarios</h1>
        </div>
      </div>

      <div class="row">
        <ul class="col tabla">
          <li class="items mt-2">
            <ul class="row p-0">
              <li class="col my-auto"><b>CDs sin valorar:</b></li>
            </ul>
          </li>     
          <c:forEach var="seleccion" items="${cdsValorables}">
            <li class="items">
              <ul class="row p-0">
                <li class="col my-auto">Título: ${seleccion.titulo}</li>
              </ul>
              <ul class="row p-0">
                <li class="col my-auto">Artista: ${seleccion.artista}</li>
              </ul>
              <ul class="row p-0">
                <li class="col my-auto">Precio: <fmt:formatNumber value="${seleccion.precio}" type="number" minFractionDigits="2" maxFractionDigits="2"/> €</li>
              </ul>

              <form action="tienda" method="POST" class="row p-0 my-2">
                <input type="hidden" name="opcion" value="comentarCD">
                <input type="hidden" name="cdSeleccionado" value="${seleccion.titulo}">

                <li class="col-2 my-auto">
                  <input type="text" class="form-control" name="nota" placeholder="Nota">
                </li>
                <li class="col-8 my-auto">
                  <input type="text" class="form-control" name="comentario" placeholder="Tu comentario">
                </li>
                <li class="col-2 my-auto">
                  <button type="submit" class="btn btn-primary">Comentar</button>
                </li>
              </form>
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