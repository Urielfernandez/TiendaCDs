package modelo.vo;

public class UsuarioVO {

    private String nombre;
    private String email;
    private Tipo tipo;

    public UsuarioVO() {
        this.nombre = new String();
        this.email = new String();
    }

    public UsuarioVO(String nombre, String email, Tipo tipo) {
        this.nombre = nombre;
        this.email = email;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

}