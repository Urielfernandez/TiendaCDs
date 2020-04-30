<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<div class="col-lg-3 col-md-4 my-3 px-3">
  <div class="card h-100">
    <img class="card-img-top" src="imagenes/cd.png">

    <div class="card-body px-3 pt-1">
      <h5 class="card-title">${cd.titulo}</h5>
      <h6 class="card-subtitle mb-2 text-muted">${cd.artista}</h6>
      <h6><fmt:formatNumber value="${cd.precio}" type="number" minFractionDigits="2" maxFractionDigits="2"/> €</h6>
      <p class="card-text">Pais: ${cd.pais}, año: ${cd.anho}</p>

      <form action="tienda" method="post" class="form-inline">
        <input type="hidden" name="opcion" value="anhadirArticulo">
        <input type="hidden" name="nombre" value="${cd.titulo}">

        <div class="input-group mx-auto">
          <select class="form-control m-0 p-0" name="unidadesSeleccionadas">
            <option selected value="1">1</option>
            <c:forEach var="i" begin="2" end="10">
              <option value="${i}">${i}</option>
            </c:forEach>
          </select>

          <button type="submit" class="botonAnhadirCarrito px-3">
            <img src="imagenes/iconos/carro.svg" class="align-top" height="22" width="22">
            Añadir a la cesta
          </button>
        </div> 
      </form>
    </div>
  </div>
</div>