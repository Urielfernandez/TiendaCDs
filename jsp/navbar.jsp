<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav id="barraNavegacion" class="navbar navbar-expand-md sticky-top py-1">
  <a class="navbar-brand" href="index.html">
    <img src="imagenes/cdLogo.jpg" alt="Inicio" height="40" width="45" title="Inicio">
  </a>

  <h3 id="tituloWeb" class="text-left my-auto text-white">Tienda de CDs</h3>
  
  <div id="botonCollapse" class="navbar-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
  </div>

  <div id="navbarNav" class="collapse navbar-collapse">
    <ul class="navbar-nav mr-auto itemsBarraNavegacion">
      <li class="nav-item">
        <a class="nav-link px-3" href="index.html">Catálogo</a>
      </li>
      <li class="nav-item">
        <a class="nav-link px-3" href="tienda?vista=carrito">Carrito</a>
      </li>
    </ul>

    <form class="form-inline mx-md-3 my-2">
      <a href="registrar">
        <button type="button" class="boton">Registrarse</button>
      </a>
    </form>

    <form class="form-inline my-2">
      <a href="html/iniciarSesion.html">
        <button type="button" class="text-nowrap boton">Iniciar sesión</button>
      </a>
    </form>
  </div>

  
</nav>