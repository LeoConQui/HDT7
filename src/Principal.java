import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Principal es la clase que interactua con el usuario y tiene el metodo main
 * @author Leonel Contreras 18797
 * @version 1.0
 */
public class Principal {
    public static void main(String[] args) {
        
        // creamos una arraylist donde guardar las palabras del diccionario
        ArrayList<String> lectura = new ArrayList<String>();

        // leemos el archivo con las palabras
        try {
            BufferedReader reader = new BufferedReader(new FileReader("diccionario.txt"));
            String line;
            while ((line = reader.readLine())!= null) {
                lectura.add(line);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // creamos un arraylist de arrays para guardar las tres palabras
        ArrayList<String[]> listadelistas = new ArrayList<String[]>();

        // agregamos las ternas de palabras a la lista de listas
        for (String string : lectura) {
            String[] palabra = string.split(",");
            listadelistas.add(palabra);
        }

        // creamos tres instancias de BST que representan los tres diccionarios
        BST<String, String> diccionarioingles = new BST<String, String>(new AscendingStringComparator());
        BST<String, String> diccionarioespanol = new BST<String, String>(new AscendingStringComparator());
        BST<String, String> diccionariofrances = new BST<String, String>(new AscendingStringComparator());

        System.out.println(listadelistas.size());
        
        // agregamos todas las palabras al diccionario en ingles
        for (String[] strings : listadelistas) {
            String key = strings[0];
            //System.out.println(key);
            String value = strings[1]+","+ strings[2];
            diccionarioingles.add(key, value);
            //System.out.println(diccionarioingles.search(key));
        }
        
        // agregamos todas las palabras al diccionario en espanol
        for (String[] strings : listadelistas) {
            String key = strings[1];
            //System.out.println(key);
            String value = strings[0]+","+ strings[2];
            diccionarioespanol.add(key, value);
            //System.out.println(diccionarioingles.search(key));
        }

        // agregamos todas las palabras al diccionario en frances
        for (String[] strings : listadelistas) {
            String key = strings[2];
            //System.out.println(key);
            String value = strings[0]+","+ strings[1];
            diccionariofrances.add(key, value);
            //System.out.println(diccionarioingles.search(key));
        }

        /*System.out.println("Diccionario Ingles");
        for (int i = 0; i < listadelistas.size(); i++) {
            String key = listadelistas.get(i)[0];
            System.out.println(diccionarioingles.search(key));
        }

        System.out.println("Diccionario espanol");
        for (int i = 0; i < listadelistas.size(); i++) {
            String key = listadelistas.get(i)[1];
            System.out.println(diccionarioespanol.search(key));
        }

        System.out.println("Diccionario frances");
        for (int i = 0; i < listadelistas.size(); i++) {
            String key = listadelistas.get(i)[2];
            System.out.println(diccionariofrances.search(key));
        }*/

        int opcionusuario = 0;

        Scanner numero = new Scanner(System.in);

        while (opcionusuario!=6) {
            System.out.println("Ingrese una opcion");
            System.out.println("1. Traducir texto");
            System.out.println("2. Mostrar arbol");
            System.out.println("3. Agregar palabra al diccionario");
            System.out.println("4. Eliminar palabra del diccionario");
            System.out.println("5. Editar valor de una palabra");
            System.out.println("6. Salir");
            opcionusuario = numero.nextInt();

            if (opcionusuario == 1) {
                System.out.println("aqui va lo de traducir");
            }

            if (opcionusuario == 2) {
                System.out.println("Ingrese el idioma");
                System.out.println("1. Ingles");
                System.out.println("2. Espanol");
                System.out.println("3. Frances");
                int opcionlenguaje = numero.nextInt();
                if (opcionlenguaje==1) {
                    diccionarioingles.traverse();
                } else if (opcionlenguaje == 2) {
                    diccionarioespanol.traverse();
                }else {
                    diccionariofrances.traverse();
                }
            }
        }

        if (opcionusuario==6) {
            System.out.println("Usted ha elegido salir.");
        } 
    }
}