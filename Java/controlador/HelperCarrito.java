package controlador;

import java.sql.Connection;
import java.util.ArrayList;

import modelo.dao.DAOPedidos;
import modelo.tienda.Carrito;
import modelo.tienda.Pedido;
import modelo.tienda.Seleccion;
import modelo.vo.CDVO;
import modelo.vo.UsuarioVO;

public class HelperCarrito {
    private DAOPedidos daoPedidos;

    public HelperCarrito() {
        this.daoPedidos = new DAOPedidos();
    }

    public boolean anhadirSeleccion(Carrito carrito, int cantidad, CDVO cd){
        return false;
    }

    public boolean eliminarSeleccion(Carrito carrito, CDVO cd){
        return false;
    }

    public boolean eliminarCD(Carrito carrito, CDVO cd){
        return false;
    }

    public double calcularImporte(Carrito carrito){
        return 0.0;
    }

    public boolean guardarPedido(Carrito carrito, UsuarioVO usuario, Connection conexion){
        ArrayList<Seleccion> selecciones = new ArrayList();

        Pedido pedido = new Pedido(usuario, selecciones, carrito.getImporteTotal());
        
        return this.daoPedidos.guardarPedido(pedido, conexion);
    }

    public boolean vaciarCarrito(Carrito carrito){
        return false;
    }

    public boolean asignarMembresía(){
        return false;
    }
}