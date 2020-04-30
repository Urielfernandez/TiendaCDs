package modelo.tienda;

import java.util.HashMap;

public class Carrito {

    private HashMap<String,Seleccion> productos;

    public Carrito() {
        this.productos = new HashMap<>();
    }


    public void anhadirAlCarrito(Seleccion item){
        if(this.productos.containsKey(item.getCd().getTitulo())){
            Seleccion aux = this.productos.get(item.getCd().getTitulo()); //Recogemos el valor para dicho cd que ya está introducido
            this.productos.remove(item.getCd().getTitulo()); //Lo eliminamos del carrito porque vamos a actualñizarlo

            item.setCantidad(item.getCantidad() + aux.getCantidad()); //sumamos las cantidades
            this.productos.put(item.getCd().getTitulo(), item); //y lo devolvemos al carrito
        }else{
            this.productos.put(item.getCd().getTitulo(), item);
        }
    }

    public void eliminarDelCarrito(String titulo){
        if(this.productos.containsKey(titulo)){
            this.productos.remove(titulo);
        }
    }


    public HashMap<String,Seleccion> getProductos() {
        return this.productos;
    }

    public void setProductos(HashMap<String,Seleccion> productos) {
        this.productos = productos;
    }

    public double getImporteTotal() {
        double resultado = 0.0;
        for(Seleccion item: this.productos.values()){
            resultado += item.getCantidad() * item.getCd().getPrecio();
        }

        return resultado;
    }

}