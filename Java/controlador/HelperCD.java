package controlador;

import java.sql.Connection;
import java.util.ArrayList;

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
        ArrayList<ValoracionVO> listaValoraciones; //= cd.getValoraciones();
        listaValoraciones=conexionBDCDs.cargarValoracionesDeUnCD(cd.getTitulo(), con);
        return listaValoraciones;
    }

    public ArrayList<CDVO> filtrarCDs(CDVO cd){
        return null;
    }

    public boolean anhadirNuevoCD(CDVO cd){
        return false;
    }

    public boolean actualizarStock(CDVO cd, int nuevoStock){
        return false;
    }

    public ArrayList<CDVO> cargarCDs(Connection conexion){
        return this.conexionBDCDs.obtenerCatalogo(conexion);
    }
}