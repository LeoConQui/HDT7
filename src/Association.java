/**
 * Association es la clase que representa las asociaciones del diccionario.
 * @author Leonel Contreras
 * @version 1.0
 */
public class Association<K,V> {

    // atributos
    private K key;
    private V value;

    // metodos

    public  Association(K key, V value) {
        this.key = key;
        this.value = value;
        
    }

   // get key
   public K getKey() {
    return this.key;
   }

   // get value
   public V getValue() {
    return this.value;
   }

   // set value
   public void setValue(V value) {
    this.value = value;
   }

   public String toString() {
    return "(" + key + ", " + value + ")";
   }
    
}
