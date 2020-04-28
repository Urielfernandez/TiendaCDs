<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-md sticky-top py-1 barraNavegacion">
  <a class="navbar-brand" href="../index.html">
    <img src="../imagenes/iconos/logo.svg" class="logo" alt="Inicio" height="42" width="42" title="Inicio">
  </a>

  <h3 class="titulo text-left text-white my-auto">Escuela de música</h3>
  
  <div class="navbar-light bottonCollapse">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
  </div>

  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav mr-auto items">
      <li class="nav-item">
        <a class="nav-link text-nowrap" href="../html/utilidades/partituras.html">Utilidades</a>
      </li>
      <li class="nav-item">
        <a class="nav-link text-nowrap" href="../tienda">Tienda</a>
      </li>
      <li class="nav-item text-nowrap">
        <a class="nav-link" href="../html/cursos/guitarra.html">Cursos</a>
      </li>
      <li class="nav-item">
        <a class="nav-link text-nowrap" href="../html/informacion.html">Información y contacto</a>
      </li>   
    </ul>

    <div class="my-2 mx-lg-4 mx-md-2 barraBusqueda">
      <input type="text" placeholder="Buscar">
    </div>
    
    <ul class="navbar-nav items">
      <li class="nav-item mx-0">
        <a class="nav-link d-inline-block" href="../tienda?view=compras">
          ${email}
          <img src="../imagenes/iconos/usuario.svg" class="icono" height="32" width="32">
        </a>
      </li>
      <li class="nav-item m-0 ml-1">
        <a class="nav-link d-inline-block" href="../tienda?view=carrito">
          Carrito
          <img src="../imagenes/iconos/carro.svg" class="icono" height="32" width="32">
        </a>
      </li>
    </ul>
  </div>
</nav>