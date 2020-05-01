package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.tienda.Pedido;
import modelo.vo.*;

public class DAOPedidos {

    public DAOPedidos() {
    }

    public boolean guardarPedido(Pedido pedido, Connection conexion) {
        return false;
    }

    public boolean actualizaStock(Pedido pedido, Connection conexion) {
        return false;
    }

    public boolean insertaArticulos(Pedido pedido, Connection conexion) {
        return false;
    }

    public boolean insertaPedido(Pedido pedido, Connection conexion) {
        return false;
    }

    public ArrayList<String> getCDsPedidosUsuario(UsuarioVO usuario, Connection conexion){
        ArrayList<String> lista=new ArrayList<>();//lista de titulos de CDs que o usuario pediu
        ArrayList<Integer> listaItemsPedidos=getIdPedidosUsuario(usuario, conexion);
        String consulta = "SELECT * FROM pedidos WHERE usuario=?";

        try {
            for(int i=0;i<listaItemsPedidos.size();i++){
                PreparedStatement preparedStatement = conexion.prepareStatement(consulta);

                preparedStatement.setInt(1,listaItemsPedidos.get(i));

                ResultSet resultado = preparedStatement.executeQuery();

                while (resultado.next()) {
                    if(!lista.contains(resultado.getString("cd")))
                        lista.add(resultado.getString("cd"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public ArrayList<Integer> getIdPedidosUsuario(UsuarioVO usuario, Connection conexion){
        ArrayList<Integer> lista=new ArrayList<>();
        String consulta = "SELECT * FROM pedidos WHERE usuario=?";

        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);

            preparedStatement.setString(1, usuario.getEmail());

            ResultSet resultado = preparedStatement.executeQuery();

            while (resultado.next()) {
                lista.add(resultado.getInt("id"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public ArrayList<String> getCDsNoComentados(ArrayList<String> listaCDs,UsuarioVO usuario, Connection conexion){


        ArrayList<String> lista= (ArrayList<String>) listaCDs.clone();
        String consulta = "SELECT * FROM opiniones WHERE cd=? and usuario=?";

        try {
            for(int i=0;i<listaCDs.size();i++){
                PreparedStatement preparedStatement = conexion.prepareStatement(consulta);

                preparedStatement.setString(1,listaCDs.get(i));
                preparedStatement.setString(2,usuario.getEmail());

                ResultSet resultado = preparedStatement.executeQuery();

                while (resultado.next()) {
                    if(lista.contains(resultado.getString("cd")))
                        lista.remove(resultado.getString("cd"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public ArrayList<String> titulosNoComentados(UsuarioVO usuario, Connection conexion){
        ArrayList<String> lista= new ArrayList<>();
        //añado los titulos de los cds comprados a una lista(sin repetirlos)
        String consulta = "SELECT * FROM pedidos p JOIN items_pedido i"+
                        "ON p.id=i.pedido"+    
                        " WHERE p.usuario=?";

        try {
                PreparedStatement preparedStatement = conexion.prepareStatement(consulta);

                preparedStatement.setString(1,usuario.getEmail());

                ResultSet resultado = preparedStatement.executeQuery();

                while (resultado.next()) {
                    if(!lista.contains(resultado.getString("cd")))
                        lista.add(resultado.getString("cd"));
                }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //Quito cds ya comentados
        consulta = "SELECT * FROM opiniones "+
                        " WHERE email=?";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);

            preparedStatement.setString(1,usuario.getEmail());

            ResultSet resultado = preparedStatement.executeQuery();

            while (resultado.next()) {
                if(lista.contains(resultado.getString("cd")))
                    lista.remove(resultado.getString("cd"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return lista;
    }

    public ArrayList<String> obtenerComentariosTitulo(String tituloCD, Connection conexion){
        ArrayList<String> lista= new ArrayList<>();
        String consulta = "SELECT * FROM opiniones where cd=?";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);

            preparedStatement.setString(1,tituloCD);

            ResultSet resultado = preparedStatement.executeQuery();

            while (resultado.next()) {
                lista.add(resultado.getString("opinion"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return lista;
    }

    public boolean nuevaValoracion(Connection conexion,String cd, UsuarioVO usuario, float nota, String comentario){
        String consulta = "INSERT INTO opiniones VALUES(?,?,?,?)";

        try{
            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);

            preparedStatement.setFloat(1, nota);
            preparedStatement.setString(2, comentario);
            preparedStatement.setString(3, cd);
            preparedStatement.setString(4, usuario.getEmail());

            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            System.out.println("DAOCD: No se ha podido guardar la valoracion: "+nota+" : "+ comentario);
            System.out.println(e.getMessage());
        }

        return false;
    }

}