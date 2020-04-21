package modelo.tienda;

import java.util.ArrayList;

import modelo.vo.UsuarioVO;

public class Pedido {
    private UsuarioVO usuario;
    private ArrayList<Seleccion> productos;

    public UsuarioVO getUsuario(){
        return this.usuario;
    }

    public void setUsuario(UsuarioVO usuario){
        this.usuario = usuario;
    }

    public double getTotalCompra(){
        return 0.0;
    }
}