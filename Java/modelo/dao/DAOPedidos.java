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
        String insercionPedidos = "INSERT INTO pedidos ('usuario', 'total_compra') VALUES (?,?)";

        try {
            conexion.setAutoCommit(false);

            PreparedStatement preparedStatement = conexion.prepareStatement(insercionPedidos, PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, pedido.getUsuario().getEmail());
            preparedStatement.setDouble(2, pedido.getTotalCompra());

            int indice = preparedStatement.executeUpdate();





        } catch (SQLException e) {
            try {
                conexion.rollback();
            } catch (SQLException e1) {
                System.out.println(e1.getMessage());
            }
            System.out.println("DAOUsuarios: No se ha podido guardar el pedido del usuario:" + pedido.getUsuario().getEmail());
            System.out.println(e.getMessage());

            return false;
        }

        return true;
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

    public String getMembresiaUsuario(UsuarioVO usuario, Connection conexion) {
        String membresia = null;
        double importeGastado = 0.0;
        String consulta = "SELECT * FROM pedidos WHERE usuario=?";

        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);

            preparedStatement.setString(1, usuario.getEmail());

            ResultSet resultado = preparedStatement.executeQuery();

            while (resultado.next()) {
                
                importeGastado+= resultado.getDouble("total_compra");

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        if(importeGastado>100){
            membresia = "VIP";
        }else{
            membresia = "Basico";
        }

        return membresia;
    }

    public ArrayList<String> getCDsPedidosUsuario(UsuarioVO usuario, Connection conexion) {
        ArrayList<String> lista = new ArrayList<>();// lista de titulos de CDs que o usuario pediu
        ArrayList<Integer> listaItemsPedidos = getIdPedidosUsuario(usuario, conexion);
        String consulta = "SELECT * FROM pedidos WHERE usuario=?";

        try {
            for (int i = 0; i < listaItemsPedidos.size(); i++) {
                PreparedStatement preparedStatement = conexion.prepareStatement(consulta);

                preparedStatement.setInt(1, listaItemsPedidos.get(i));

                ResultSet resultado = preparedStatement.executeQuery();

                while (resultado.next()) {
                    if (!lista.contains(resultado.getString("cd")))
                        lista.add(resultado.getString("cd"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public ArrayList<Integer> getIdPedidosUsuario(UsuarioVO usuario, Connection conexion) {
        ArrayList<Integer> lista = new ArrayList<>();
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

    public ArrayList<String> getCDsNoComentados(ArrayList<String> listaCDs, UsuarioVO usuario, Connection conexion) {

        ArrayList<String> lista = (ArrayList<String>) listaCDs.clone();
        String consulta = "SELECT * FROM opiniones WHERE cd=? and usuario=?";

        try {
            for (int i = 0; i < listaCDs.size(); i++) {
                PreparedStatement preparedStatement = conexion.prepareStatement(consulta);

                preparedStatement.setString(1, listaCDs.get(i));
                preparedStatement.setString(2, usuario.getEmail());

                ResultSet resultado = preparedStatement.executeQuery();

                while (resultado.next()) {
                    if (lista.contains(resultado.getString("cd")))
                        lista.remove(resultado.getString("cd"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public ArrayList<String> titulosNoComentados(UsuarioVO usuario, Connection conexion) {
        ArrayList<String> lista = new ArrayList<>();
        // añado los titulos de los cds comprados a una lista(sin repetirlos)
        String consulta = "SELECT cd FROM pedidos p JOIN items_pedido i " +
                                     "ON p.id=i.pedido " +
                                     " WHERE p.usuario=?";

        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);

            preparedStatement.setString(1, usuario.getEmail());

            ResultSet resultado = preparedStatement.executeQuery();

            while (resultado.next()) {
                if (!lista.contains(resultado.getString("cd")))
                    lista.add(resultado.getString("cd"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        // Quito cds ya comentados
        consulta = "SELECT cd FROM opiniones WHERE email=?";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);

            preparedStatement.setString(1, usuario.getEmail());

            ResultSet resultado = preparedStatement.executeQuery();

            while (resultado.next()) {
                if (lista.contains(resultado.getString("cd")))
                    lista.remove(resultado.getString("cd"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return lista;
    }

    public ArrayList<ValoracionVO> obtenerValoracionesTitulo(String tituloCD, Connection conexion) {
        ArrayList<ValoracionVO> lista = new ArrayList<>();
        String consulta = "SELECT * FROM opiniones where cd=?";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);

            preparedStatement.setString(1, tituloCD);

            ResultSet resultado = preparedStatement.executeQuery();

            while (resultado.next()) {
                ValoracionVO v=new ValoracionVO(resultado.getFloat("nota"),
                                                resultado.getString("opinion"),
                                                resultado.getString("cd"),
                                                resultado.getString("email"));

                lista.add(v);
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