<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav id="barraNavegacion" class="navbar navbar-expand-md sticky-top py-1 navbar-dark bg-dark">
  <a class="navbar-brand" href="index.html">
    <img src="imagenes/cdLogo.jpg" alt="Inicio" height="40" width="45" title="Inicio">
  </a>

  <h3 id="tituloWeb" class="text-left my-auto text-white">Tienda de CDs</h3>

  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="linkBarraNavegacion" href="tienda">Catálogo</a>
      </li>
      <li class="itemBarraNavegacion">
        <a class="linkBarraNavegacion activo" href="tienda?vista=carrito">Carrito</a>
      </li>
    </ul>

    <c:choose>
      <c:when test="${nombreUsuario == null}">
        <form class="form-inline mx-md-3 my-2">
          <a href="registrar">
            <button type="button" class="btn btn-outline-light">Registrarse</button>
          </a>
        </form>

        <form class="form-inline my-2">
          <a href="html/iniciarSesion.html">
            <button type="button" class="btn btn-outline-light">Iniciar sesión</button>
          </a>
        </form>
      </c:when>

      <c:otherwise>
        <ul class="navbar-nav">
          <li class="nav-item my-auto">
            <a class="usuario" href="#">
              ${nombreUsuario}
            </a>
          </li>
          <li class="nav-item">
            <a class="usuario" href="#">
              <img src="imagenes/iconos/usuario.svg" class="icono" height="32" width="32">
            </a>
          </li>
        </ul>
      </c:otherwise>
    </c:choose>
  </div>
  
</nav>