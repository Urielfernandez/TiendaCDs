package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.vo.InicioSesionVO;
import modelo.vo.UsuarioVO;

public class DAOUsuarios {

    public DAOUsuarios() {
    }

    public boolean guardarUsuario(UsuarioVO usuario, InicioSesionVO credenciales, Connection conexion) {
        String consulta = "INSERT INTO usuarios VALUES(?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);

            preparedStatement.setString(1, usuario.getEmail());
            preparedStatement.setString(2, usuario.getNombre());
            preparedStatement.setString(3, credenciales.getContrasenha());
            preparedStatement.setString(4, "usuario");
            preparedStatement.setString(5, "Basico");

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("DAOUsuarios: No se ha podido guardar el usuario:" + usuario.getEmail());
            System.out.println(e.getMessage());

            return false;
        }

        return true;

    }

    public boolean iniciarSesion(InicioSesionVO credenciales, Connection conexion) {
        String consulta = "SELECT * FROM usuarios WHERE email=? and contrasenha=?";

        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);

            preparedStatement.setString(1, credenciales.getEmail());
            preparedStatement.setString(2, credenciales.getContrasenha());

            ResultSet resultado = preparedStatement.executeQuery();

            if (resultado.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("DAOUsuarios: No se ha podido iniciar sesión con el usuario:" + credenciales.getEmail());
            System.out.println(e.getMessage());
        }

        return false;
    }

    public UsuarioVO obtenerUsuarioPorEmail(UsuarioVO usuario, Connection conexion) {
        String consulta = "SELECT * FROM usuarios WHERE email=?";

        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);

            preparedStatement.setString(1, usuario.getEmail());

            ResultSet resultado = preparedStatement.executeQuery();

            if (resultado.next()) {
                UsuarioVO usuarioAux = new UsuarioVO(resultado.getString("nombre"), resultado.getString("email"));
                return usuarioAux;
            }
        } catch (SQLException e) {
            System.out.println("DAOUsuarios: No se ha podido obtener el usuario:" + usuario.getEmail());
            System.out.println(e.getMessage());
        }
        return null;
    }

    // Para ver usuarios desde el menu de administracion, se almacenan en
    // InicioSesionVO para tener tanto e-mail como contrasenha
    public ArrayList<InicioSesionVO> obtenerUsuarios(Connection conexion) {
        String consulta = "SELECT * FROM usuarios";
        ArrayList<InicioSesionVO> listadoDeUsuarios = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);

            ResultSet resultado = preparedStatement.executeQuery();

            while (resultado.next()) {
                InicioSesionVO datosUsuario = new InicioSesionVO(resultado.getString("email"),
                        resultado.getString("contrasenha"));
                listadoDeUsuarios.add(datosUsuario);
            }
            return listadoDeUsuarios;
        } catch (SQLException e) {
            System.out.println("DAOUsuarios: No se han podido obtener los usuarios.");
            System.out.println(e.getMessage());
        }

        return null;
    }

    public boolean modificarUsuario(InicioSesionVO datosUsuario, Connection conexion) {
        String consulta = "UPDATE usuarios SET contrasenha=? WHERE email=?";

        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);

            preparedStatement.setString(1, datosUsuario.getContrasenha());
            preparedStatement.setString(2, datosUsuario.getEmail());

            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            System.out.println("DAOUsuarios: No se ha podido modificar la contraseña del usuario con email: "
                    + datosUsuario.getEmail());
            System.out.println(e.getMessage());
        }

        return false;
    }

    public boolean borrarUsuario(UsuarioVO usuario, Connection conexion) {
        String consulta = "DELETE FROM usuarios WHERE email=?";

        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);

            preparedStatement.setString(1, usuario.getEmail());

            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            System.out.println("DAOUsuarios: No se ha podido eliminar al usuario: " + usuario.getEmail());
            System.out.println(e.getMessage());
        }

        return false;
    }

}