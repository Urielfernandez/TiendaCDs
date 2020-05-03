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
          <h1 class="tituloPagina">Catálogo de CDs</h1>
        </div>
      </div>

      <div class="row">
        <div class="col">
          <p class="mt-2" style="font-size: 18px">Filtros:</p>
          <form action="tienda" method="GET" class="mb-3">
            <input type="hidden" name="vista" value="filtrar">
            <div class="form-row">
              <div class="col">
                <input type="text" class="form-control" name="precio" placeholder="Precio máximo">
              </div>
              <div class="col">
                <input type="text" class="form-control" name="titulo" placeholder="Título">
              </div>
              <div class="col">
                <input type="text" class="form-control" name="artista" placeholder="Artista">
              </div>
              <div class="col">
                <input type="text" class="form-control" name="anho" placeholder="Año">
              </div>
              <div class="col">
                <input type="text" class="form-control" name="pais" placeholder="País">
              </div>
            </div>
            <div class="form-row">
              <div class="col mt-3 text-center">
                <button type="submit" class="btn btn-primary px-5">Filtrar</button>
              </div>
            </div>
          </form>
          <h1 class="tituloPagina"></h1>
        </div>
      </div>

      <div class="row">
        <c:forEach var="cd" items="${listaArticulos}">
          <%@ include file="cd.jsp" %>
        </c:forEach>
      </div>
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
    <script src="js/filtro.js"></script>

	</body>

</html>