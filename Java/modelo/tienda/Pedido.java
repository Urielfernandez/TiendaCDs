package modelo.tienda;

import java.util.ArrayList;
import modelo.vo.UsuarioVO;

public class Pedido {

    private UsuarioVO usuario;
    private ArrayList<Seleccion> productos;
    private double importe;

    public Pedido() {
    }

    public Pedido(UsuarioVO usuario, ArrayList<Seleccion> productos, double importe) {
        this.usuario = usuario;
        this.productos = productos;
        this.importe = importe;
    }

    public UsuarioVO getUsuario() {
        return this.usuario;
    }

    public void setUsuario(UsuarioVO usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Seleccion> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Seleccion> productos) {
        this.productos = productos;
    }

    public double getTotalCompra() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    

}