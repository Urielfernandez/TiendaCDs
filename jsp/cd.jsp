<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<div class="col-lg-4 col-md-6 mb-4">
  <div class="card h-100">
    <a href="#"><img class="card-img-top" src="imagenes/cd.jpg"></a>
    
    <div class="card-body px-3 pb-3 pt-1">
      <h4 class="card-title">
        <a href="#">${cd.nombre}</a>
      </h4>
      <h5><fmt:formatNumber value="${cd.precio}" type="number" minFractionDigits="2" maxFractionDigits="2"/> €</h5>
      <p class="card-text">${cd.descripcion}</p>
      <p class="card-text">Unidades disponibles: ${cd.unidadesDisponibles}</p>

      <form action="tienda" method="post" class="form-inline">
        <input type="hidden" name="opcion" value="addToCarrito">
        <input type="hidden" name="nombre" value="${cd.nombre}">
        <input type="hidden" name="imagen" value="${cd.imagen}">
        <input type="hidden" name="precio" value="${cd.precio}">
        <input type="hidden" name="unidadesDisponibles" value="${cd.unidadesDisponibles}" class="unidadesDisponibles">

        <div class="input-group mx-auto">
          <select class="form-control cantidad" name="unidadesSeleccionadas">
            <option selected value="1">1</option>
            <c:if test="${cd.unidadesDisponibles >= 2}">
              <c:forEach var="i" begin="2" end="${cd.unidadesDisponibles}">
                <option value="${i}">${i}</option>
              </c:forEach>
            </c:if>
          </select>

          <button type="submit" class="text-nowrap px-3 btnCarrito">
            <img src="imagenes/iconos/carro.svg" class="align-top mr-2" height="24" width="24">
            Añadir a la cesta
          </button>
        </div> 
      </form>
    </div>
  </div>
</div>