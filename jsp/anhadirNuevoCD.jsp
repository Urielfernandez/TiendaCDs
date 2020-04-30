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
          <form action="/administrador" method="POST">
            <input type="hidden" name="opcion" value="almacenarNuevoCD"/>
            <div class="form-group">
              <label for="nombre">Título:</label>
              <input type="text" class="form-control" name="titulo">
            </div>

            <div class="form-group">
              <label for="text">Artista:</label>
              <input type="text" class="form-control" name="artista">
            </div>

            <div class="form-group">
              <label for="text">País de Origen:</label>
              <input type="text" class="form-control" name="pais">
            </div>

            <div class="form-group">
              <label for="text">Año de publicación:</label>
              <input type="text" class="form-control" name="anho">
            </div>

            <div class="form-group">
              <label for="text">Cantidad en Stock:</label>
              <input type="number" class="form-control" name="cantidad">
            </div>

            <div class="form-group">
              <label for="text">Precio</label>
              <input type="number" class="form-control" name="precio">
            </div>

            <div class="form-group text-center">
              <button type="submit" class="boton px-5">Guardar nuevo CD</button>
            </div>
          </form>
        </div>
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