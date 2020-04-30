package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.vo.CDVO;
import modelo.vo.ValoracionVO;

public class DAOCDs {

    public DAOCDs() {
    }

    public boolean guardarCD(CDVO cd, Connection conexion) {
        String consulta = "INSERT INTO cds VALUES(?,?,?,?,?)";

        try{
            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);

            preparedStatement.setString(1, cd.getTitulo());
            preparedStatement.setString(2, cd.getArtista());
            preparedStatement.setString(3, cd.getPais());
            preparedStatement.setString(4, Double.toString(cd.getPrecio()));
            preparedStatement.setString(5, Integer.toString(cd.getAnho()));

            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            System.out.println("DAOCD: No se ha podido guardar el cd:" + cd.getTitulo());
            System.out.println(e.getMessage());
        }

        return false;
    }

    public void insertarStockCD(String titulo, int cantidad, Connection conexion){
        String consulta = "INSERT INTO inventario VALUES(?,?)";

        try{
            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);

            preparedStatement.setString(1, titulo);
            preparedStatement.setInt(2, cantidad);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("DAOCD: No se ha podido guardar el cd:" + titulo);
            System.out.println(e.getMessage());
        }
    }

    public CDVO obtenerCD(CDVO cd, Connection conexion) {
        CDVO cdCargado = null;
        String consulta = "SELECT * FROM cds WHERE titulo=?";

        try{
            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);

            preparedStatement.setString(1, cd.getTitulo());

            ResultSet resultado = preparedStatement.executeQuery();

            if(resultado.next()){
                cdCargado = new CDVO(resultado.getString("titulo"), resultado.getString("artista"), resultado.getString("pais"), Double.valueOf(resultado.getString("precio")), Integer.parseInt(resultado.getString("anho")), this.cargarValoracionesDeUnCD(resultado.getString("titulo"), conexion));
            }

            return cdCargado;
        } catch (SQLException e) {
            System.out.println("DAOCD: No se ha podido cargar el cd:" + cd.getTitulo());
            System.out.println(e.getMessage());
        }

        return null;
    }
    public CDVO obtenerCD(String cd, Connection conexion) {
        CDVO cdCargado = null;
        String consulta = "SELECT * FROM cds WHERE titulo=?";

        try{
            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);

            preparedStatement.setString(1, cd);

            ResultSet resultado = preparedStatement.executeQuery();

            if(resultado.next()){
                cdCargado = new CDVO(resultado.getString("titulo"), resultado.getString("artista"), resultado.getString("pais"), Double.valueOf(resultado.getString("precio")), Integer.parseInt(resultado.getString("anho")), this.cargarValoracionesDeUnCD(resultado.getString("titulo"), conexion));
            }

            return cdCargado;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
    public ArrayList<CDVO> obtenerCatalogo(Connection conexion) {
        ArrayList<CDVO> catalogo = new ArrayList<>();
        String consulta = "SELECT * FROM cds;";

        try{
            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);

            ResultSet resultado = preparedStatement.executeQuery();

            while(resultado.next()){
                CDVO nuevoCD = new CDVO(resultado.getString("titulo"),
                                            resultado.getString("artista"),
                                            resultado.getString("pais"),
                                            resultado.getDouble("precio"),
                                            resultado.getInt("anho"),
                                            this.cargarValoracionesDeUnCD(resultado.getString("titulo"),
                                            conexion));
                catalogo.add(nuevoCD);
            }

            return catalogo;
        }
        catch (SQLException e) {
            System.out.println("DAOCD: No se ha podido cargar el catálogo.");
            System.out.println(e.getMessage());
        }

        return null;
    }

    public boolean modificarCD(CDVO cd, Connection conexion) {
        String consulta = "UPDATE cds SET artista=?, pais=?, precio=?, anho=? WHERE titulo=?";

        try{
            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);

            preparedStatement.setString(1, cd.getArtista());
            preparedStatement.setString(2, cd.getPais());
            preparedStatement.setString(3, Double.toString(cd.getPrecio()));
            preparedStatement.setString(4, Integer.toString(cd.getAnho()));
            preparedStatement.setString(5, cd.getTitulo());

            preparedStatement.executeUpdate();

            return true;
        }
        catch (SQLException e) {
            System.out.println("DAOCD: No se ha podido actualizar el cd: "+ cd.getTitulo());
            System.out.println(e.getMessage());
        }

        return false;
    }

    public ArrayList<ValoracionVO> cargarValoracionesDeUnCD(String cd, Connection conexion){
        ArrayList<ValoracionVO> valoraciones = new ArrayList<>();
        String consulta = "SELECT * FROM opiniones WHERE cd = ?;";

        try{
            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);

            preparedStatement.setString(1, cd);

            ResultSet resultado = preparedStatement.executeQuery();

            while(resultado.next()){
                ValoracionVO valoracion = new ValoracionVO(resultado.getFloat("nota"), 
                                                                resultado.getString("opinion"), 
                                                                resultado.getString("cd"), 
                                                                resultado.getString("email"));
                valoraciones.add(valoracion);
            }

            return valoraciones;
        }
        catch (SQLException e) {
            System.out.println("DAOCD: No se han podido cargar las valoraciones del cd:" + cd);
            System.out.println(e.getMessage());
        }

        return null;
    }

}