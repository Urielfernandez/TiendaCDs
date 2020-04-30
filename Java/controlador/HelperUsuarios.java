package controlador;

import java.sql.Connection;

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
}