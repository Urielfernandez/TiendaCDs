<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
        <div class="col-6 mx-auto mt-3 p-0 cabeceroSeccion">
          <h1 class="m-1 text-center">Error</h1>
        </div>
      </div>
      <div class="row">
        <div class="col-6 mx-auto my-3">
          <div class="text-center">
            <img src="./imagenes/iconos/error.svg" class="mx-auto my-5" alt="Logo" height="90" width="90">
          </div>
          <p class="text-center">Ha habido un error</p>
          <p class="text-center">Por favor, inténtelo de nuevo más tarde.</p>
          <div class="text-center">
            <a href="./tienda"><button type="button" class="boton px-3">Volver a la tienda</button><a>
          </div>
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
	</body>

</html>