package controlador;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import modelo.dao.DAOCDs;
import modelo.vo.CDVO;
import modelo.vo.UsuarioVO;
import modelo.vo.ValoracionVO;

public class HelperCD {
    private DAOCDs conexionBDCDs;

    public HelperCD(){
        this.conexionBDCDs = new DAOCDs();
    }

    public boolean introducirValoracion(CDVO cd, UsuarioVO usuario){
        return false;
    }

    public ArrayList<ValoracionVO> obtenerValoraciones(CDVO cd, Connection con){
        //conectar con tabla opiniones
        ArrayList<ValoracionVO> listaValoraciones; 
        listaValoraciones = conexionBDCDs.cargarValoracionesDeUnCD(cd.getTitulo(), con);
        return listaValoraciones;
    }

    public CDVO recogerCamposCD(HttpServletRequest request){
        //PONER LOS NOMBRES DE LOS CAMPOS DE LA VISTA
        String titulo = request.getParameter("titulo");
        String artista = request.getParameter("artista");
        String pais = request.getParameter("pais");
        Double precio = Double.parseDouble(request.getParameter("precio"));
        Integer anho = Integer.parseInt(request.getParameter("anho"));

        CDVO cd=new CDVO(titulo,artista,pais,precio,anho);
        return cd;
    }

    public ArrayList<CDVO> filtrarCDs(CDVO cd){
        return null;
    }

    public boolean anhadirNuevoCD(CDVO cd, Connection con){
        if(cd != null)
            return conexionBDCDs.guardarCD(cd,con);
        return false;
    }

    public boolean actualizarStock(CDVO cd, int nuevoStock){
        return false;
    }

    public ArrayList<CDVO> cargarCDs(Connection conexion){
        return this.conexionBDCDs.obtenerCatalogo(conexion);
    }
}