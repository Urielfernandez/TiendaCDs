package controlador;

import java.sql.Connection;

import modelo.dao.DAOUsuarios;
import modelo.vo.InicioSesionVO;
import modelo.vo.UsuarioVO;

public class HelperControlUsuario {

    DAOUsuarios dao;

    public HelperControlUsuario(){
        dao = new DAOUsuarios();
    }

    public boolean notificarEmailCliente(){
        return false;
    }

    public boolean registrarCliente(UsuarioVO usuario,InicioSesionVO credenciales, Connection conexion){
        return dao.guardarUsuario(usuario, credenciales, conexion);
    }
}