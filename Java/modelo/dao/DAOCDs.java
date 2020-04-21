package modelo.dao;

import java.sql.Connection;
import java.util.ArrayList;
import modelo.vo.CDVO;

public class DAOCDs {

    public DAOCDs() {
    }

    public boolean guardarCD(CDVO cd, Connection conexion) {
        return false;
    }

    public CDVO obtenerCD(CDVO cd, Connection conexion) {
        return null;
    }

    public ArrayList<CDVO> obtenerCatalogo(Connection conexion) {
        return null;
    }

    public boolean modificarCD(CDVO cd, Connection conexion) {
        return false;
    }

}