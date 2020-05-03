package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



import modelo.tienda.Pedido;
import modelo.tienda.Seleccion;
import modelo.vo.*;

public class DAOPedidos {

    public DAOPedidos() {
    }

    public boolean guardarPedido(Pedido pedido, Connection conexion) {
        String consultaStock = "SELECT * FROM inventario WHERE cd=? AND cantidad_stock >= ?";
        String actualizacionStock = "UPDATE inventario SET cantidad_stock=? WHERE cd=?";
        String insercionPedidos = "INSERT INTO pedidos (usuario, total_compra) VALUES (?,?)";
        String insercionItemsPedido = "INSERT INTO items_pedido VALUES (?, ?, ?, now())";

        int indice = -1;

        try {
            conexion.setAutoCommit(false);

            PreparedStatement preparedStatement = conexion.prepareStatement(insercionPedidos, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, pedido.getUsuario().getEmail());
            preparedStatement.setDouble(2, pedido.getTotalCompra());

            preparedStatement.executeUpdate();

            ResultSet clavesGeneradas = preparedStatement.getGeneratedKeys();
            if(clavesGeneradas.next()){
                indice = clavesGeneradas.getInt(1);
            }

            for(Seleccion seleccionActual : pedido.getProductos()){
                PreparedStatement preparedStatementStock = conexion.prepareStatement(consultaStock);

                preparedStatementStock.setString(1, seleccionActual.getCd().getTitulo());
                preparedStatementStock.setInt(2, seleccionActual.getCantidad());
    
                ResultSet hayStock = preparedStatementStock.executeQuery();

                if(hayStock.next()){
                    int stockActual = hayStock.getInt("cantidad_stock");
                    stockActual -= seleccionActual.getCantidad();

                    PreparedStatement preparedStatementActualizacion = conexion.prepareStatement(actualizacionStock);
                    preparedStatementActualizacion.setInt(1, stockActual);
                    preparedStatementActualizacion.setString(2, seleccionActual.getCd().getTitulo());

                    preparedStatementActualizacion.executeUpdate();
                    
                    PreparedStatement preparedStatementSeleccion = conexion.prepareStatement(insercionItemsPedido);

                    preparedStatementSeleccion.setInt(1, indice);
                    preparedStatementSeleccion.setString(2, seleccionActual.getCd().getTitulo());
                    preparedStatementSeleccion.setInt(3, seleccionActual.getCantidad());

                    preparedStatementSeleccion.executeUpdate();
                }
                else {
                    System.out.println("No hay stock suficiente del CD "+seleccionActual.getCd().getTitulo());
                    conexion.rollback();
                    return false;
                }
            }
            conexion.commit();

        } catch (SQLException e) {
            try {
                conexion.rollback();
            } catch (SQLException e1) {
                System.out.println(e1.getMessage());
            }
            System.out.println("DAOUsuarios: No se ha podido guardar el pedido del usuario: " + pedido.getUsuario().getEmail());
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

    public String updateMembresiaUsuario(UsuarioVO usuario, Connection conexion) {
        String membresia = null;
        double importeGastado = 0.0;

        String consulta = "SELECT * FROM pedidos WHERE usuario=?";
        String actualizacion = "UPDATE usuarios SET membresia=? WHERE usuario = ?";

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

        //Chequeamos el sumatorio
        if(importeGastado>100){
            membresia = "VIP";

            if(usuario instanceof UsuarioBasico){
                //El usuario ahora ha pasado a ser VIP, por lo que actualizamos su membresía
                try{
                    PreparedStatement preparedStatement = conexion.prepareStatement(actualizacion);

                    preparedStatement.setString(1, "VIP");
                    preparedStatement.setString(2, usuario.getEmail());

                    preparedStatement.executeUpdate();

                }catch(SQLException e) {
                    System.out.println(e.getMessage());
                }
            }

        }else{
            membresia = "Basico";
        }

        return membresia;
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