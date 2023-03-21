import java.util.Comparator;

/**
 * StringComparator es la clase que compara strings. Implementa la interfaz Comparator<String>
 * @author Leonel Contreras 18797
 * @version 1.0
 */
public class KeyComparator implements Comparator<String>{

    @Override
    public  int compare( String o1, String o2) {
        if (o1.compareTo(o2) == 0) {
            return 0;
        } else if(o1.compareTo(o2)> 0){
            return -1;
        } else{ 
            return 1;
        }
    }
}