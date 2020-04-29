package modelo.vo;

import java.util.ArrayList;

public class CDVO implements CD {

    private String titulo;
    private String artista;
    private String pais;
    private double precio;
    private int anho;
    private ArrayList<ValoracionVO> valoraciones;

    public CDVO(String titulo, String artista, String pais, double precio, int anho, ArrayList<ValoracionVO> valoraciones) {
        this.titulo = titulo;
        this.artista = artista;
        this.pais = pais;
        this.precio = precio;
        this.anho = anho;
        this.valoraciones = valoraciones;
    }

    public CDVO(String titulo, String artista, String pais, double precio, int anho) {
        this.titulo = titulo;
        this.artista = artista;
        this.pais = pais;
        this.precio = precio;
        this.anho = anho;
        this.valoraciones=new ArrayList<>();
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

    public ArrayList<ValoracionVO> getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(ArrayList<ValoracionVO> valoraciones) {
        this.valoraciones = valoraciones;
    }

    

}