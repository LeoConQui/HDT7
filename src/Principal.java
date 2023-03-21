/**
 * Principal es la clase que interactua con el usuario y tiene el metodo main
 * @author Leonel Contreras 18797
 * @version 1.0
 */
public class Principal {
    public static void main(String[] args) {
        KeyComparator comparador = new KeyComparator();
        System.out.println(comparador.compare("a", "b"));

        System.out.println(comparador.compare("ale", "leo"));

        Association association = new Association("llave", "key", "llave en frances");

        String[] array = association.getValue();

        System.out.println(array[0]);

        System.out.println(array[1]);

        association.setValue("asdf", "bichita");

        array= association.getValue();
        System.out.println(array[1]);

        
    }
}