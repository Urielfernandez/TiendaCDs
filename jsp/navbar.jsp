<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav id="barraNavegacion" class="navbar navbar-expand-md sticky-top py-1">
  <a class="navbar-brand" href="index.html">
    <img src="imagenes/cd.jpg" alt="Inicio" height="40" width="45" title="Inicio">
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
        <a class="nav-link text-nowrap" href="index.html">Catálogo de CDs</a>
      </li>
    </ul>

    <form class="form-inline mx-md-3 my-2">
      <a href="registro.html">
        <button type="button" class="px-2 botonBarraNavegacion">Registrarse</button>
      </a>
    </form>

    <form class="form-inline my-2">
      <a href="iniciarSesion.html">
        <button type="button" class="text-nowrap px-2 botonBarraNavegacion">Iniciar sesión</button>
      </a>
    </form>
  </div>
  
</nav>