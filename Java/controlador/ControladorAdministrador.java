package controlador;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class ControladorAdministrador extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        mostrarPagina("index.html", request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        mostrarPagina("index.html", request, response);
    }

    private void mostrarPagina(String pagina, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(pagina).forward(request, response);
    }

}