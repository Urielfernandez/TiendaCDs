package modelo.vo;

public class UsuarioVIP extends UsuarioVO {

    public UsuarioVIP() {
    }

    public UsuarioVIP(String nombre, String email) {
        super(nombre, email, Tipo.usuario);
    }

}