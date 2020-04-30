package modelo.vo;

public class InicioSesionVO {

    private String email;
    private String contrasenha;

    public InicioSesionVO() {
    }

    public InicioSesionVO(String email, String contrasenha) {
        this.email = email;
        this.contrasenha = contrasenha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

}