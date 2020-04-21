package modelo.tienda;

import java.util.ArrayList;

public class Carrito {
    private ArrayList<Seleccion> productos;
    
    public ArrayList<Seleccion> getProductos(){
        return this.productos;
    }

    public double getImporteTotal(){
        return 0.0;
    }
}