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

    <div class="container-fluid my-2 mx-lg-3 mx-md-2 px-0 barraBusqueda">
      <input type="text" placeholder="Buscar">
    </div>

    <form class="form-inline mx-md-1 mx-lg-2 my-2">
      <a href="../html/registro.html"><button type="button" class="px-2 btnBarra">Registrarse</button></a>
    </form>

    <form class="form-inline ml-md-1 ml-lg-2 my-2">
      <a href="../html/iniciarSesion.html"><button type="button" class="text-nowrap px-2 btnBarra">Iniciar sesión</button></a>
    </form>
  </div>
</nav>