import java.util.Comparator;

/**
 * AscendingStringComparator es la clase que compara String de manera ascendente. Implementa la interfaz comparator
 * El codigo fue extraido de: Li, Y. (2018) Binary Search Tree. Available at: https://cs.colby.edu/courses/S18/cs231/notes/outlines19.pdf. 
 * @author Leonel Contreras 18797
 * @version 1.0
 */
public class AscendingStringComparator implements Comparator<String> {

    public int compare(String s1, String s2) {
        return s1.compareTo(s2);
    }
    
}