package Dominio;

/**
 *
 * @author Arthur
 */
public class Token {

    private String tipo;
    private int id;

    public Token(int id, String tipo) {
        this.tipo = tipo;
        this.id = id;
    }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return tipo;
    }

}
