<%@ page contentType="text/html" pageEncoding="UTF-8" %>

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
		<script src="https://code.jquery.com/jquery-3.5.0.min.js"
			integrity="sha256-xNzN2a4ltkB44Mc/Jz3pT4iU1cmeR0FkXs4pru/JxaQ="
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