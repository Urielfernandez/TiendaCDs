package controlador.helper;

import java.util.ArrayList;

import modelo.vo.CDVO;
import modelo.vo.UsuarioVO;

public class HelperCD {
    public boolean introducirValoracion(CDVO cd, UsuarioVO usuario){
        return false;
    }

    public ArrayList<String> obtenerValoraciones(CDVO cd){
        return null;
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
}