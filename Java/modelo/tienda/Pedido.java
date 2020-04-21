package modelo.tienda;

import java.util.ArrayList;
import modelo.vo.UsuarioVO;

public class Pedido {

    private UsuarioVO usuario;
    private ArrayList<Seleccion> productos;

    public Pedido() {
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
        return 0.0;
    }

}