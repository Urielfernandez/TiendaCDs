package modelo.tienda;

import java.util.ArrayList;

public class Carrito {

    private ArrayList<Seleccion> productos;

    public Carrito() {
    }

    public ArrayList<Seleccion> getProductos() {
        return this.productos;
    }

    public void setProductos(ArrayList<Seleccion> productos) {
        this.productos = productos;
    }

    public double getImporteTotal() {
        return 0.0;
    }

}