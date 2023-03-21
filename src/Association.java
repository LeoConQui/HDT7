/**
 * Association es la clase que representa las asociaciones del diccionario.
 * @author Leonel Contreras
 * @version 1.0
 */
public class Association {

    // atributos
    private String key;
    private String[] value;

    // metodos

    public  Association(String key, String palabra1, String palabra2) {
        this.key = key;
        value = new String[2];
        value[0] = palabra1;
        value[1]= palabra2;
    }

    public void setValue(String palabra1, String palabra2) {
        value[0] = palabra1;
        value[1] = palabra2;
    }

    public String[] getValue() {
        return this.value;
    }
    
}
