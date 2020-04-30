package controlador;

import java.sql.Connection;
import java.util.ArrayList;

import modelo.dao.DAOUsuarios;
import modelo.vo.InicioSesionVO;
import modelo.vo.UsuarioVO;

public class HelperUsuarios {

    DAOUsuarios dao;

    public HelperUsuarios(){
        dao = new DAOUsuarios();
    }


    public UsuarioVO inicioSesion(InicioSesionVO inicioSesion, Connection conexion){
        
        if (dao.iniciarSesion(inicioSesion, conexion)){
            //Existe el usuario, lo buscamos y devolvemos

            UsuarioVO usuarioBusqueda = new UsuarioVO();
            usuarioBusqueda.setEmail(inicioSesion.getEmail());
            return  dao.obtenerUsuarioPorEmail(usuarioBusqueda, conexion);
        }

        return null;
        
    }

    public ArrayList<InicioSesionVO> listarUsuarios (Connection conexion) {
        return this.dao.obtenerUsuarios(conexion);
    }

    public boolean eliminarUsuario(UsuarioVO usuario, Connection conexion) {
        return this.dao.borrarUsuario(usuario, conexion);
    }
}