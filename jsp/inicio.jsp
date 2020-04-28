<%@ page contentType="text/html" pageEncoding="UTF-8" %>

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

		<%@ include file="navTienda.jsp" %>

    <section class="container-fluid">
      <div class="row">
        <nav class="col-lg-2 p-0 pt-3 menuLateral">
          <ul class="p-0 subcategorias">
            <a href="#"><li class="secionActual">Guitarras</li></a>
          </ul>
        </nav>

        <div class="col-lg-10">
          <div class="row">
            <div class="col mx-4 mt-2 p-0 cabeceroSeccion">
              <h1 class="m-0">Tienda</h1>
            </div>
          </div>

          <div class="row mt-3 mx-1">
            <c:forEach var="articulo" items="${listaArticulos}">
              <%@ include file="articulo.jsp" %>
            </c:forEach>
          </div>
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