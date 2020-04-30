package controlador;

import java.io.Console;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sound.sampled.SourceDataLine;

import modelo.tienda.Carrito;
import modelo.tienda.Seleccion;
import modelo.vo.InicioSesionVO;
import modelo.vo.UsuarioVO;

public class ControladorTienda extends HttpServlet {

    HelperCD gestionCDS;
    HelperUsuarios gestionUsuarios;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        gestionCDS = new HelperCD();
        gestionUsuarios = new HelperUsuarios();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vista = request.getParameter("vista");
        //atributos necesarias para la realización de las distintas peticiones
        Carrito carrito;
        UsuarioVO usuario;
        Connection conexion = null;
        /*
         * Cuando el usuario inicio se debería: Generar la sesion del usuario Generar
         * una conexion a la BD y almacenarla en dicha sesion
         */

        // Obtenemos la sesion y la creamos si no la hay
		HttpSession sesion = request.getSession();

        // Creamos el usuario, el carrito y la conexion para una sesion si no existen
        if(sesion.getAttribute("usuario") == null) {
            sesion.setAttribute("usuario", new UsuarioVO());
        }

        if(sesion.getAttribute("carrito") == null) {
            sesion.setAttribute("carrito", new Carrito());
        }

        if(sesion.getAttribute("conexion") == null) {
            Connection aux = crearConexionBBDD();

            // Comprobamos si se conecta, si no mostramos un error
            if (aux != null) {
                sesion.setAttribute("conexion", aux);
            }
            else {
                mostrarPagina("jsp/error.jsp", request, response);
            }
        }

        usuario = (UsuarioVO) sesion.getAttribute("usuario");
        carrito = (Carrito) sesion.getAttribute("carrito");
        conexion = (Connection) sesion.getAttribute("conexion");

        if(vista == null){
            request.setAttribute("listaArticulos", gestionCDS.cargarCDs(conexion));
            mostrarPagina("jsp/catalogo.jsp", request, response);
        }
        else {
            switch(vista){
                case "carrito":
                    request.setAttribute("contenidoCarrito", carrito.getProductos().values());
                    mostrarPagina("jsp/carrito.jsp", request, response);
                    break;
            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opcion = request.getParameter("opcion");
        //atributos necesarias para la realización de las distintas peticiones
        Carrito carrito = null;
        UsuarioVO usuario = null;
        Connection conexion = null;

		HttpSession sesion = request.getSession();

        if (sesion.getAttribute("usuario") == null && sesion.getAttribute("carrito") == null
                && sesion.getAttribute("conexion") == null) {
			// Creamos el usuario y el carrito para una sesion
			sesion.setAttribute("usuario", new UsuarioVO());
            sesion.setAttribute("carrito", new Carrito());
            
            Connection aux = crearConexionBBDD();

            // Comprobamos si se conecta, si no mostramos un error
            if (aux != null) {
                sesion.setAttribute("conexion", aux);
            }
            else {
                mostrarPagina("jsp/error.jsp", request, response);
            }
        }
        else{
            // Obtenemos el usuario y el carrito de la sesion
            carrito = (Carrito) sesion.getAttribute("carrito");
            usuario = (UsuarioVO) sesion.getAttribute("usuario");
            conexion = (Connection) sesion.getAttribute("conexion");
        }

        if (opcion == null){
            mostrarPagina("jsp/error.jsp", request, response);
        }

        else {
            switch(opcion){
                case  "anhadirCarrito":
                    request.setAttribute("listaArticulos", gestionCDS.cargarCDs(conexion));
                    mostrarPagina("jsp/catalogo.jsp", request, response);  
                    break;
                case "verCarrito":
                    request.setAttribute("contenidoCarrito", carrito.getProductos().values());
                    mostrarPagina("./jsp/carrito.jsp", request, response);
                    break;
                case "anhadirArticulo":
                    Seleccion nuevoItem = new Seleccion( gestionCDS.recogerCamposCD(request.getParameter("titulo"), request.getParameter("artista"), request.getParameter("pais"), request.getParameter("precio"), request.getParameter("anho")), 
                                                            Integer.parseInt((String) request.getParameter("unidadesSeleccionadas")));
                    carrito.anhadirAlCarrito(nuevoItem);
                    request.setAttribute("precioTotal", carrito.getImporteTotal());
                    request.setAttribute("listaArticulos", gestionCDS.cargarCDs(conexion));
                    mostrarPagina("./jsp/catalogo.jsp", request, response);
                    break;

                case "iniciarSesion":
                    InicioSesionVO inicioSesion = new InicioSesionVO();
                    inicioSesion.setEmail((String) request.getParameter("email"));
                    inicioSesion.setContrasenha((String) request.getParameter("contrasenha"));

                    UsuarioVO loginUsuario = gestionUsuarios.inicioSesion(inicioSesion, conexion);

                    if (loginUsuario != null){
                        //El usuario ha introducido unas credeciales válidas y queda logueado
                        usuario=loginUsuario;
                        //Enviamos la cookie que indica que el usuario está logueado
                        Cookie cookie = new Cookie("nombre", usuario.getNombre());
                        cookie.setMaxAge(30*60);
                        response.addCookie(cookie);

                        request.setAttribute("NombreUsuario", usuario.getNombre());
                        request.setAttribute("listaArticulos", gestionCDS.cargarCDs(conexion));
                        mostrarPagina("./jsp/catalogo.jsp", request, response);
                    }else{
                        //El usuario no ha introducido unas credenciales válidas
                        mostrarPagina("index.html", request, response);
                    }

                    break;
            }
        }
    }

    private void mostrarPagina(String pagina, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(pagina).forward(request, response);
    }

    private Connection crearConexionBBDD() {
        Connection conexion = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tiendacds?serverTimezone=UTC", "dawa", "Dawaproyecto1");
        } 
        catch (SQLException e) {
            System.out.println("Controlador Tienda: no se ha podido generar una conexión para el usuario.");
            System.out.println(e.getMessage());
        }
        catch (ClassNotFoundException e) {
            System.out.println("Controlador Tienda: no se ha podido cargar el driver.");
            System.out.println(e.getMessage());
        }

        return conexion;
    }

}