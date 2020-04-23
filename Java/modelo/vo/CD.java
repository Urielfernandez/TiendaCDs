package modelo.vo;

import java.util.ArrayList;

public interface CD {

    public String getTitulo();

    public String getArtista();

    public String getPais();

    public double getPrecio();

    public int getAnho();

    public ArrayList<ValoracionVO> getValoraciones();
    
}