package modelo.vo;

public class UsuarioBasico extends UsuarioVO{

    public UsuarioBasico() {
    }

    public UsuarioBasico(String nombre, String email) {
        super(nombre, email, Tipo.usuario);
    }

    
}