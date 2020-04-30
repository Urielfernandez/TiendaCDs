<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Tienda de CDs</title>
		<!--Link para el uso de Bootstrap-->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
			crossorigin="anonymous">
		<link rel="stylesheet" href="./css/main.css">
	</head>

	<body>


	<%@ include file="navbar.jsp" %>

	
	<p>CHEQUEOS PREVIOS:
		${VARIABLE_ESTADO}
	</p>

    <section class="container">
      <div class="row">
        <div class="col my-3 p-0 pb-1 tituloPagina">
          <h1 class="m-0">Catálogo de CDs</h1>
        </div>
      </div>
      <div class="row">


      <div class="row">
        <c:forEach var="cd" items="${listaArticulos}">
          <%@ include file="cd.jsp" %>
        </c:forEach>
      </div>
	  <div class="row">
	  	<form method="GET" action="tienda">
			<input type="hidden" name="opcion" value="verCarrito">
			<button type="submit" class="btn btn-primary btn-lg btn-block">Ver el contenido del Carrito</button>
		</form>
	  </div>
    </div>


    </section>

		<!--Links para el uso de JQuery-->
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
			crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
			crossorigin="anonymous"></script>
	</body>

</html>