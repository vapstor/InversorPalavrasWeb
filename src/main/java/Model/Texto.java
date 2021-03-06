package Model;

/**
 *
 * @author vapstor
 */
public class Texto {
    private String texto;
    private String textoInvertido;
    
    public Texto(String texto, String textoInvertido) {
        this.texto = texto;
        this.textoInvertido = textoInvertido;
    }
    
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTextoInvertido() {
        return textoInvertido;
    }

    public void setTextoInvertido(String textoInvertido) {
        this.textoInvertido = textoInvertido;
    }
    
}
