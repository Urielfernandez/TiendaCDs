package modelo.vo;

import java.util.ArrayList;

public class CDVO implements CD {

    private String titulo;
    private String artista;
    private String pais;
    private double precio;
    private int anho;
    private ArrayList<String> valoraciones;

    public CDVO() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getAnho() {
        return anho;
    }

    public void setAnho(int anho) {
        this.anho = anho;
    }

    public ArrayList<String> getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(ArrayList<String> valoraciones) {
        this.valoraciones = valoraciones;
    }

    

}