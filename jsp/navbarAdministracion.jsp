<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav id="barraNavegacion" class="navbar navbar-expand-md sticky-top py-1 navbar-dark bg-dark">
  <a class="navbar-brand" href="administrador">
    <img src="imagenes/cdLogo.jpg" alt="Inicio" height="40" width="45" title="Inicio">
  </a>

  <h3 id="tituloWeb" class="text-left my-auto text-white">Tienda de CDs</h3>

  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="linkBarraNavegacion" href="administrador">Menú de administración</a>
      </li>
      <li class="nav-item">
        <a class="linkBarraNavegacion" href="nuevoCD">Añadir nuevo CD</a>
      </li>
      <li class="nav-item">
        <a class="linkBarraNavegacion" href="administrador?vista=verCatalogo">Catálogo</a>
      </li>
    </ul>

    <ul class="navbar-nav">
      <li class="nav-item my-auto">
        <a class="usuario" href="#">
          ${email}
        </a>
      </li>
      <li class="nav-item">
        <a class="usuario" href="#">
          <img src="imagenes/iconos/usuario.svg" class="icono" height="32" width="32">
        </a>
      </li>
    </ul>
  </div>
</nav>