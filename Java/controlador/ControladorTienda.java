package controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.http.*;

import controlador.HelperCD;
import modelo.tienda.Carrito;
import modelo.vo.UsuarioVO;

public class ControladorTienda extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HelperCD gestionCDS;
        /*
         * Cuando el usuario inicio se debería: Generar la sesion del usuario Generar
         * una conexion a la BD y almacenarla en dicha sesion
         */

        // Obtenemos la sesion y la creamos si no la hay
		HttpSession sesion = request.getSession();

        if (sesion.getAttribute("usuario") == null && sesion.getAttribute("carrito") == null
                && sesion.getAttribute("conexion") == null) {
			// Creamos el usuario y el carrito para una sesion
			sesion.setAttribute("usuario", new UsuarioVO());
            sesion.setAttribute("carrito", new Carrito());
            sesion.setAttribute("sesion", crearConexionBBDD());
		}

		// Obtenemos el usuario y el carrito de la sesion
		Carrito carrito = (Carrito) sesion.getAttribute("carrito");
        UsuarioVO usuario = (UsuarioVO) sesion.getAttribute("usuario");
        Connection conexion = (Connection) sesion.getAttribute("conexion");

        gestionCDS = new HelperCD();  

        request.setAttribute("listaArticulos", gestionCDS.cargarCDs(conexion));
        
        mostrarPagina("jsp/catalogo.jsp", request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        mostrarPagina("index.html", request, response);
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