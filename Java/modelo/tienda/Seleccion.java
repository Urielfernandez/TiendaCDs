package modelo.tienda;

import modelo.vo.CDVO;

public class Seleccion {
    private CDVO cd;
    private int cantidad;

    public CDVO getCd() {
        return cd;
    }

    public void setCd(CDVO cd) {
        this.cd = cd;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getImporteSeleccion(){
        return 0.0;
    }
}