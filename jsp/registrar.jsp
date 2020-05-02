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

	<body class="fondoPagina">
    <%@ include file="navbar.jsp" %>

    <section class="container">
      <div class="row">
        <div class="col-md-6 offset-md-3">
          <h1 class="tituloPagina">Registrarse</h1>
        </div>
      </div>

      <div class="row mt-2">
        <div class="col-md-6 offset-md-3">
          <form action="administrador" method="POST">
            <div class="form-group">
              <label for="nombre">Nombre</label>
              <input type="text" class="form-control" name="nombre">
            </div>

            <div class="form-group">
              <label for="email">Correo electrónico</label>
              <input type="email" class="form-control" name="email">
            </div>

            <div class="form-group">
              <label for="email">Contraseña</label>
              <input type="password" class="form-control" name="contrasenha">
            </div>

            <div class="form-group text-center">
              <input type="hidden" name="opcion" value="registrar">
              <button type="submit" class="btn btn-primary px-5">Registrarse</button>
            </div>
          </form>
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
