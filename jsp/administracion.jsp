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
		<%@ include file="navbarAdministracion.jsp" %>

    <section class="container">
      <div class="row">
        <div class="col">
          <h1 class="tituloPagina">Usuarios</h1>
        </div>
      </div>

      <div class="row">
        <ul class="col tabla">
          <li class="items mt-2">
            <ul class="row p-0">
              <li class="col-4"><b>Correo electrónico</b></li>
              <li class="col-2"><b>Contraseña</b></li>
            </ul>
          </li> 
              
          <c:forEach var="usuario" items="${listaUsuarios}">
            <li class="items">
              <ul class="row p-0">
                <li class="col-4 my-auto">${usuario.email}</li>
                <li class="col-2 my-auto">${usuario.contrasenha}</li>
                <li class="col-1 my-auto">
                  <form action="" method="POST" class="text-center">
                    <input type="hidden" name="usuarioEliminar" value="${usuario.email}">
                    <input type="hidden" name="opcion" value="">
                    <input type="submit" class="boton px-1" value="Eliminar">
                  </form>
                </li>
                <li class="col-5 my-auto">
                  <form action="" method="POST" class="text-center">
                    <input type="hidden" name="usuarioModificar" value="${usuario.email}">
                    <input type="hidden" name="opcion" value="">
                    <input type="submit" class="boton px-1" value="Modificar contraseña">
                    <input type="text" class="" placeholder="Nueva contraseña">
                  </form>
                </li>
              </ul>
            </li>
          </c:forEach>
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