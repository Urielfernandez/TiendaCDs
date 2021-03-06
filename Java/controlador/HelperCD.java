package controlador;

import java.sql.Connection;
import java.util.ArrayList;
import modelo.dao.DAOCDs;
import modelo.dao.DAOPedidos;
import modelo.tienda.TiendaException;
import modelo.vo.CDVO;
import modelo.vo.UsuarioVO;
import modelo.vo.ValoracionVO;

public class HelperCD {

    private DAOCDs conexionBDCDs;
    private DAOPedidos conexionBDpedidos;

    public HelperCD() {
        this.conexionBDCDs = new DAOCDs();
        this.conexionBDpedidos = new DAOPedidos();
    }

    public boolean introducirValoracion(Connection con, String cd, UsuarioVO usuario, String notaString, String comentario) {
        Float nota = Float.parseFloat(notaString);
        return conexionBDpedidos.nuevaValoracion(con, cd, usuario, nota, comentario);
    }

    public ArrayList<ValoracionVO> obtenerValoraciones(CDVO cd, Connection con) {
        // conectar con tabla opiniones
        ArrayList<ValoracionVO> listaValoraciones;
        listaValoraciones = conexionBDCDs.cargarValoracionesDeUnCD(cd.getTitulo(), con);
        return listaValoraciones;
    }

    public ArrayList<CDVO> obtenerCDsValorables(UsuarioVO usuario, Connection con) {
        ArrayList<CDVO> listaCDs = new ArrayList<>();
        // comprobar cuales de estos titulos ya se han valorado
        ArrayList<String> titulosNoComentados = conexionBDpedidos.titulosNoComentados(usuario, con);
        for (int i = 0; i < titulosNoComentados.size(); i++) {
            listaCDs.add(conexionBDCDs.obtenerCD(titulosNoComentados.get(i), con));
        }
        return listaCDs;
    }

    public ArrayList<ValoracionVO> obtenerValoracionesCD(String titulo, Connection con) {
        ArrayList<ValoracionVO> lista = conexionBDpedidos.obtenerValoracionesTitulo(titulo, con);
        return lista;
    }

    public CDVO recogerCamposCD(String titulo, String artista, String pais, String precioString, String anhoString) {
        Double precio = Double.parseDouble(precioString);
        Integer anho = Integer.parseInt(anhoString);

        CDVO cd = new CDVO(titulo, artista, pais, precio, anho);
        return cd;
    }

    public void anhadirNuevoCD(CDVO cd, int cantidad, Connection con) throws TiendaException {
        if (cd != null) {
            this.conexionBDCDs.guardarCD(cd, con);
            this.conexionBDCDs.insertarStockCD(cd.getTitulo(), cantidad, con);
        }
    }

    public ArrayList<CDVO> cargarCDs(Connection conexion) {
        return this.conexionBDCDs.obtenerCatalogo(conexion);
    }

    public CDVO obtenerCD(String titulo, Connection conexion) {
        return conexionBDCDs.obtenerCD(titulo, conexion);
    }

    public double obtenerNotaMedia(String titulo, Connection conexion) {
        ArrayList<ValoracionVO> valoraciones = conexionBDCDs.cargarValoracionesDeUnCD(titulo, conexion);
        double media = 0.0;

        for (ValoracionVO valoracion : valoraciones) {
            media += valoracion.getNota();
        }

        media /= valoraciones.size();

        return media;
    }

    public ArrayList<CDVO> filtrar(ArrayList<CDVO> listado, CDVO parametros, String precio, String anho){
        ArrayList<CDVO> catalogoFiltrado = new ArrayList<>();

        if(!parametros.getTitulo().isEmpty()){
            for(CDVO aux: listado){
                if(!aux.getTitulo().equals(parametros.getTitulo())){
                    catalogoFiltrado.add(aux);
                }
            }
        }

        if(!parametros.getArtista().isEmpty()){
            for(CDVO aux: listado){
                if(!aux.getArtista().equals(parametros.getArtista())){
                    if(!catalogoFiltrado.contains(aux)){
                        catalogoFiltrado.add(aux);
                    }
                }
            }
        }

        if(!parametros.getPais().isEmpty()){
            for(CDVO aux: listado){
                if(!aux.getPais().equals(parametros.getPais())){
                    if(!catalogoFiltrado.contains(aux)){
                        catalogoFiltrado.add(aux);
                    }
                }
            }
        }

        if(!precio.isEmpty()){
            float precioMax = Float.parseFloat(precio);
            for(CDVO aux: listado){
                if(aux.getPrecio() > precioMax){
                    if(!catalogoFiltrado.contains(aux)){
                        catalogoFiltrado.add(aux);
                    }
                }
            }
        }

        if(!anho.isEmpty()){
            int ano = Integer.parseInt(anho);
            for(CDVO aux: listado){
                if(aux.getAnho() != ano){
                    if(!catalogoFiltrado.contains(aux)){
                        catalogoFiltrado.add(aux);
                    }
                }
            }
        }

        for(CDVO aux : catalogoFiltrado){
            if(listado.contains(aux)){
                listado.remove(aux);
            }
        }

        return listado;
    }

}