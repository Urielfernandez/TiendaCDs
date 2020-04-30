package controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.http.*;

import modelo.tienda.Carrito;
import modelo.tienda.Seleccion;
import modelo.vo.CDVO;
import modelo.vo.UsuarioVO;

public class ControladorAdministrador extends HttpServlet {
    private HelperCD gestionCDS;
    private HelperUsuarios gestionUsuarios;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.gestionCDS = new HelperCD();
        this.gestionUsuarios = new HelperUsuarios();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opcion = request.getParameter("opcion");
        /////////////////////////////////
        UsuarioVO usuario;
        Connection conexion;
        Carrito carrito;

		HttpSession sesion = request.getSession();

        if (sesion.getAttribute("usuario") == null && sesion.getAttribute("conexion") == null) {
			// Creamos el usuario y el carrito para una sesion
			sesion.setAttribute("usuario", new UsuarioVO());
            Connection aux = crearConexionBBDD();

            // Comprobamos si se conecta, si no mostramos un error
            if (aux != null) {
                sesion.setAttribute("conexion", aux);
            }
            else {
                mostrarPagina("jsp/error.jsp", request, response);
            }
		}
        
        // Obtenemos el usuario y la sesion
        usuario = (UsuarioVO) sesion.getAttribute("usuario");
        conexion = (Connection) sesion.getAttribute("conexion");

        //COMPROBACIONES DE opcion
        request.setAttribute("listaUsuarios", this.gestionUsuarios.listarUsuarios(conexion));
        mostrarPagina("jsp/administracion.jsp", request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opcion = request.getParameter("opcion");
        /////////////////////////////////////
        UsuarioVO usuario;
        Connection conexion;
        
        
        /*
         * Cuando el usuario inicio se debería: Generar la sesion del usuario Generar
         * una conexion a la BD y almacenarla en dicha sesion
         */

        // Obtenemos la sesion y la creamos si no la hay
		HttpSession sesion = request.getSession();

        if (sesion.getAttribute("usuario") == null && sesion.getAttribute("conexion") == null) {
			// Creamos el usuario y el carrito para una sesion
			sesion.setAttribute("usuario", new UsuarioVO());
            
            Connection aux = crearConexionBBDD();

            // Comprobamos si se conecta, si no mostramos un error
            if (aux != null) {
                sesion.setAttribute("conexion", aux);
            }
            else {
                mostrarPagina("jsp/error.jsp", request, response);
            }
		}

		// Obtenemos el usuario y la sesion
        usuario = (UsuarioVO) sesion.getAttribute("usuario");
        conexion = (Connection) sesion.getAttribute("conexion");
        

        switch(opcion){
            case "almacenarNuevoCD":
                CDVO nuevoCD = this.gestionCDS.recogerCamposCD(request.getParameter("titulo"),
                                                                request.getParameter("artista"),
                                                                request.getParameter("pais"),
                                                                request.getParameter("precio"),
                                                                request.getParameter("anho"));
                int cantidadIntroducida = Integer.parseInt(request.getParameter("cantidad"));
                this.gestionCDS.anhadirNuevoCD(nuevoCD, cantidadIntroducida, conexion);
                mostrarPagina("index.html", request, response);
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