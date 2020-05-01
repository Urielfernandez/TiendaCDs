package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

import modelo.tienda.Carrito;
import modelo.tienda.MailSender;
import modelo.tienda.Seleccion;
import modelo.vo.InicioSesionVO;
import modelo.vo.Tipo;
import modelo.vo.UsuarioVO;

public class ControladorTienda extends HttpServlet {

    private HelperCD gestionCDS;
    private HelperUsuarios gestionUsuarios;

    // atributos necesarias para la realización de las distintas peticiones
    private Carrito carrito;
    private UsuarioVO usuario;
    private Connection conexion;
    private HttpSession sesion;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        gestionCDS = new HelperCD();
        gestionUsuarios = new HelperUsuarios();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vista = request.getParameter("vista");
        /*
         * Cuando el usuario inicio se debería: Generar la sesion del usuario Generar
         * una conexion a la BD y almacenarla en dicha sesion
         */

        actualizarDatosSesion(request, response);

        if (vista == null) {
            request.setAttribute("listaArticulos", gestionCDS.cargarCDs(conexion));
            mostrarPagina("jsp/catalogo.jsp", request, response);
        } else {
            switch (vista) {
                case "carrito":
                    request.setAttribute("contenidoCarrito", carrito.getProductos().values());

                    // Chequeamos la membresia
                    if (usuario.getNombre().isEmpty()) {
                        System.out.println("\n\n---EL USUARIO NO ESTA INTRODUCIDO, ES NULL");
                        request.setAttribute("importeTotal", String.format("%.2f", carrito.getImporteTotal()));
                        mostrarPagina("./jsp/carrito.jsp", request, response);
                    } else {
                        System.out.println("\n\n---EL USUARIO SI ESTA INTRODUCIDO, ES DISTINTO DE NULL. Nombre: "+usuario.getNombre()+", email: "+usuario.getEmail()+", tipo: "+usuario.getTipo());
                        String membresia = this.gestionUsuarios.getMembresia(usuario, conexion);
                        if (membresia.equals("VIP")) {
                            System.out.println("\n\n---EL USUARIO ES VIP");
                            request.setAttribute("importeTotal", 
                                    String.format("%.2f", carrito.getImporteTotal()) + " con 20% de descuento --> "
                                            + String.format("%.2f", carrito.getImporteTotal() * 0.8));
                        } else if (membresia.equals("Basico")) {
                            System.out.println("\n\n---EL USUARIO ES BASICO");
                            request.setAttribute("importeTotal", "Usuario básico--> "+String.format("%.2f", carrito.getImporteTotal()));
                        }
                        mostrarPagina("./jsp/carrito.jsp", request, response);
                    }
                    break;

                case "cargarCDsValorables":
                    request.setAttribute("cdsValorables", gestionCDS.obtenerCDsValorables(usuario, conexion));
                    mostrarPagina("jsp/addComment.jsp", request, response);
                    break;

                case "verValoracionesCD":
                    String titulo = request.getParameter("titulo");
                    request.setAttribute("valoracioneCD", gestionCDS.obtenerValoracionesCD(titulo, conexion));
                    request.setAttribute("titulo",titulo);
                    mostrarPagina("jsp/verValoracionesCD.jsp", request, response);
                    break;
            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opcion = request.getParameter("opcion");

        actualizarDatosSesion(request, response);

        if (opcion == null) {
            mostrarPagina("jsp/error.jsp", request, response);
        }

        else {
            switch (opcion) {
                case "anhadirCarrito":
                    request.setAttribute("listaArticulos", gestionCDS.cargarCDs(conexion));
                    mostrarPagina("jsp/catalogo.jsp", request, response);
                    break;
                case "verCarrito":
                    request.setAttribute("contenidoCarrito", carrito.getProductos().values());

                    // Chequeamos la membresia
                    String membresia = this.gestionUsuarios.getMembresia(usuario, conexion);
                    if (membresia.equals("VIP")) {
                        request.setAttribute("importeTotal", String.format("%.2f", carrito.getImporteTotal())
                                + " con 20% de descuento: " + String.format("%.2f", carrito.getImporteTotal() * 0.8));
                    } else if (membresia.equals("Basico")) {

                        request.setAttribute("importeTotal", String.format("%.2f", carrito.getImporteTotal()));
                    }
                    mostrarPagina("./jsp/carrito.jsp", request, response);
                    break;
                case "anhadirArticulo":
                    Seleccion nuevoItem = new Seleccion(
                            gestionCDS.recogerCamposCD(request.getParameter("titulo"), request.getParameter("artista"),
                                    request.getParameter("pais"), request.getParameter("precio"),
                                    request.getParameter("anho")),
                            Integer.parseInt((String) request.getParameter("unidadesSeleccionadas")));
                    carrito.anhadirAlCarrito(nuevoItem);
                    request.setAttribute("precioTotal", carrito.getImporteTotal());
                    request.setAttribute("listaArticulos", gestionCDS.cargarCDs(conexion));
                    mostrarPagina("./jsp/catalogo.jsp", request, response);
                    break;
                case "eliminarArticulo":
                    this.carrito.eliminarDelCarrito(request.getParameter("titulo"));
                    request.setAttribute("importeTotal", this.carrito.getImporteTotal());
                    request.setAttribute("contenidoCarrito", this.carrito.getProductos().values());
                    mostrarPagina("jsp/carrito.jsp", request, response);
                    break;
                case "comprar":
                     this.usuario.getEmail();
                    // Parte de envio del correo
                    MailSender mensajero = new MailSender();
                    mensajero.enviarConGMail(usuario.getEmail(), this.carrito.getProductos().values());
                    request.setAttribute("listaArticulos", gestionCDS.cargarCDs(conexion));
                    mostrarPagina("./jsp/catalogo.jsp", request, response);
                    break;
                case "iniciarSesion":
                    InicioSesionVO inicioSesion = new InicioSesionVO();
                    inicioSesion.setEmail(request.getParameter("email"));
                    inicioSesion.setContrasenha(request.getParameter("contrasenha"));

                    usuario = gestionUsuarios.inicioSesion(inicioSesion, conexion);

                    // DIRECTAMENTE QUITAMOS EL IF PORQUE SABEMOS QUE SIEMPRE SON CORRECTAS
                    // LAS CREDENCIALES
                    // El usuario ha introducido unas credeciales válidas y queda logueado

                    // Enviamos la cookie que indica que el usuario está logueado
                    Cookie cookie = new Cookie("email", usuario.getNombre());
                    cookie.setMaxAge(30 * 60);
                    response.addCookie(cookie);

                    sesion.setAttribute("email", usuario.getEmail());
                    sesion.setAttribute("usuario", usuario);

                    // Ahora chequeamos si es usuario o administrador para llevarlo a una de las
                    // páginas
                    if (usuario.getTipo().equals(Tipo.administrador)) {

                        request.setAttribute("listaUsuarios", this.gestionUsuarios.listarUsuarios(conexion));
                        mostrarPagina("jsp/administracion.jsp", request, response);

                    } else {
                        request.setAttribute("listaArticulos", gestionCDS.cargarCDs(conexion));
                        mostrarPagina("./jsp/catalogo.jsp", request, response);
                    }

                    break;

                case "chequearErroresCredenciales":

                    request.setCharacterEncoding("UTF-8");
                    response.setCharacterEncoding("UTF-8");

                    response.setContentType("text/plain");
                    PrintWriter out = response.getWriter();

                    inicioSesion = new InicioSesionVO();
                    inicioSesion.setEmail(request.getParameter("email"));
                    inicioSesion.setContrasenha(request.getParameter("contrasenha"));

                    UsuarioVO loginUsuario = gestionUsuarios.inicioSesion(inicioSesion, conexion);

                    if (loginUsuario != null) {
                        out.print("true");
                    } else {
                        out.print("false");
                    }
                    break;

                case "comentarCD":
                    String nota= request.getParameter("nota");
                    String comentario=request.getParameter("comentario");
                    if(!gestionCDS.introducirValoracion(conexion, request.getParameter("cdSeleccionado"), usuario, nota, comentario))
                        mostrarPagina("jsp/error.jsp", request, response);
                    //devolver vista de catalogo o seguir en añadir comentarios?
                    request.setAttribute("listaArticulos", gestionCDS.cargarCDs(conexion));
                    mostrarPagina("jsp/catalogo.jsp", request, response);
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
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tiendacds?serverTimezone=UTC", "dawa",
                    "Dawaproyecto1");
        } catch (SQLException e) {
            System.out.println("Controlador Tienda: no se ha podido generar una conexión para el usuario.");
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Controlador Tienda: no se ha podido cargar el driver.");
            System.out.println(e.getMessage());
        }

        return conexion;
    }

    private void actualizarDatosSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtenemos la sesion y la creamos si no la hay
        sesion = request.getSession();

        // Creamos el usuario, el carrito y la conexion para una sesion si no existen
        if (sesion.getAttribute("usuario") == null) {
            sesion.setAttribute("usuario", new UsuarioVO());
        } else {
            usuario = (UsuarioVO) sesion.getAttribute("usuario");
        }

        if (sesion.getAttribute("carrito") == null) {
            sesion.setAttribute("carrito", new Carrito());
        }

        if (sesion.getAttribute("conexion") == null) {
            Connection aux = crearConexionBBDD();

            // Comprobamos si se conecta, si no mostramos un error
            if (aux != null) {
                sesion.setAttribute("conexion", aux);
            } else {
                mostrarPagina("jsp/error.jsp", request, response);
            }
        }

        usuario = (UsuarioVO) sesion.getAttribute("usuario");
        carrito = (Carrito) sesion.getAttribute("carrito");
        conexion = (Connection) sesion.getAttribute("conexion");
    }

}