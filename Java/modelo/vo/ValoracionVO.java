package modelo.vo;

public class ValoracionVO {
    public float nota;
    public String opinion;
    public String tituloDelCD;
    public String emailUsuarioEmisor;

    public ValoracionVO(float nota, String opinion, String tituloDelCD, String emailUsuarioEmisor){
        this.nota = nota;
        this.opinion = opinion;
        this.tituloDelCD = tituloDelCD;
        this.emailUsuarioEmisor = emailUsuarioEmisor;
    }


    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public String getTituloDelCD() {
        return tituloDelCD;
    }

    public void setTituloDelCD(String tituloDelCD) {
        this.tituloDelCD = tituloDelCD;
    }

    public String getEmailUsuarioEmisor() {
        return emailUsuarioEmisor;
    }

    public void setEmailUsuarioEmisor(String emailUsuarioEmisor) {
        this.emailUsuarioEmisor = emailUsuarioEmisor;
    }

    
}