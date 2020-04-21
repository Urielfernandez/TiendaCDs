package modelo.dao;

import java.sql.Connection;
import java.util.ArrayList;
import modelo.vo.InicioSesionVO;
import modelo.vo.UsuarioVO;

public class DAOUsuarios {

    public DAOUsuarios() {
    }

    public boolean guardarUsuario(UsuarioVO usuario, Connection conexion) {
        return false;
    }

    public boolean iniciarSesion(InicioSesionVO credenciales, Connection conexion) {
        return false;
    }

    public UsuarioVO obtenerUsuario(UsuarioVO usuario, Connection conexion) {
        return null;
    }

    public ArrayList<UsuarioVO> obtenerUsuarios(UsuarioVO usuario, Connection conexion) {
        return null;
    }

    public boolean modificarUsuario(UsuarioVO usuario, Connection conexion) {
        return false;
    }

    public boolean borrarUsuario(UsuarioVO usuario, Connection conexion) {
        return false;
    }
    
}