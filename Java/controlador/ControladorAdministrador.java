package controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.http.*;

import modelo.tienda.Carrito;
import modelo.tienda.TiendaException;
import modelo.vo.CDVO;
import modelo.vo.InicioSesionVO;
import modelo.vo.Tipo;
import modelo.vo.UsuarioBasico;
import modelo.vo.UsuarioVO;

public class ControladorAdministrador extends HttpServlet {
    private HelperCD gestionCDS;
    private HelperUsuarios gestionUsuarios;
    private HelperControlUsuario controlUsuarios;

    // atributos necesarias para la realización de las distintas peticiones
    // private UsuarioVO usuario;
    private Connection conexion;
    private HttpSession sesion;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.gestionCDS = new HelperCD();
        this.gestionUsuarios = new HelperUsuarios();
        controlUsuarios = new HelperControlUsuario();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // String vista = request.getParameter("vista");

        actualizarDatosSesion(request, response);

        request.setAttribute("listaUsuarios", this.gestionUsuarios.listarUsuarios(conexion));
        mostrarPagina("jsp/administracion.jsp", request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opcion = request.getParameter("opcion");

        actualizarDatosSesion(request, response);

        switch (opcion) {
            case "almacenarNuevoCD":
                CDVO nuevoCD = this.gestionCDS.recogerCamposCD(request.getParameter("titulo"),
                        request.getParameter("artista"), request.getParameter("pais"), request.getParameter("precio"),
                        request.getParameter("anho"));
                int cantidadIntroducida = Integer.parseInt(request.getParameter("cantidad"));
                try {
                    this.gestionCDS.anhadirNuevoCD(nuevoCD, cantidadIntroducida, conexion);
                    mostrarPagina("jsp/anhadirNuevoCD.jsp", request, response);
                } catch (TiendaException e) {
                    request.setAttribute("mensajeError", e.getMessage());
                    mostrarPagina("jsp/error.jsp", request, response);
                }
                
                break;

            case "eliminarUsuario":
                String usuarioEliminar = request.getParameter("usuarioEliminar");
                UsuarioVO usuario = new UsuarioVO("", usuarioEliminar, Tipo.usuario);
                if (this.gestionUsuarios.eliminarUsuario(usuario, this.conexion)) {
                    request.setAttribute("listaUsuarios", this.gestionUsuarios.listarUsuarios(conexion));
                    mostrarPagina("jsp/administracion.jsp", request, response);
                } else {
                    mostrarPagina("jsp/error.jsp", request, response);
                }
                break;

            case "modificarContrasenha":
                String usuarioModificar = request.getParameter("usuarioModificar");
                String nuevaContrasenha = request.getParameter("nuevaContrasenha");
                InicioSesionVO datosUsuario = new InicioSesionVO(usuarioModificar, nuevaContrasenha);

                if (this.gestionUsuarios.modificarContrasenha(datosUsuario, this.conexion)) {
                    request.setAttribute("listaUsuarios", this.gestionUsuarios.listarUsuarios(conexion));
                    mostrarPagina("jsp/administracion.jsp", request, response);
                } else {
                    mostrarPagina("jsp/error.jsp", request, response);
                }
                break;

            case "registrar":
                //Lo registramos como básico
                String nombre = request.getParameter("nombre");
                String email = request.getParameter("email");
                String password = request.getParameter("contrasenha");

                UsuarioBasico registroUser = new UsuarioBasico(nombre, email);
                InicioSesionVO inicioSesion = new InicioSesionVO(email, password);
                if (controlUsuarios.registrarCliente(registroUser, inicioSesion, this.conexion)){
                    request.setAttribute("listaArticulos", gestionCDS.cargarCDs(conexion));
                    mostrarPagina("./jsp/catalogo.jsp", request, response);
                }else{
                    mostrarPagina("jsp/error.jsp", request, response);
                }
                break;
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

        //usuario = (UsuarioVO) sesion.getAttribute("usuario");
        conexion = (Connection) sesion.getAttribute("conexion");
    }

}