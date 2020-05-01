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
    <%@ include file="navbar.jsp" %>

    <section class="container">
      <div class="row">
        <div class="col">
          <h1 class="tituloPagina">Valoraciones de un CD: ${titulo} </h1>
        </div>
      </div>
      
      <div class="row">
        <ul class="col tabla">
              
          <c:forEach var="seleccion" items="${valoracioneCD}">
            <li class="items">
              <ul class="row p-0">
                <li class="col-5 my-auto">${seleccion}</li>
              </ul>
            </li>
          </c:forEach>
        </ul>
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
    <script src="js/comprobarLogin.js"></script>
  </body>
</html>