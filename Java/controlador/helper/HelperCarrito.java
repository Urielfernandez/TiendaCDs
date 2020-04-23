package controlador.helper;

import modelo.tienda.Carrito;
import modelo.vo.CDVO;
import modelo.vo.UsuarioVO;

public class HelperCarrito {

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

    public boolean guardarPedido(Carrito carrito, UsuarioVO usuario){
        return false;
    }

    public boolean vaciarCarrito(Carrito carrito){
        return false;
    }

    public boolean asignarMembresía(){
        return false;
    }
}