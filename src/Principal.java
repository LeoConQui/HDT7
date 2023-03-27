import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;


/**
 * Principal es la clase que interactua con el usuario y tiene el metodo main
 * @author Leonel Contreras 18797
 * @version 1.0
 */
public class Principal {
    public static void main(String[] args) {
        
        // creamos una arraylist donde guardar las palabras del diccionario
        ArrayList<String> lectura = new ArrayList<String>();
        ArrayList<String> lecturados = new ArrayList<String>();

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

        // creamos un nuevo BufferedReader
        try {
            BufferedReader readertwo = new BufferedReader(new FileReader("texto.txt"));
            String line;
            while ((line = readertwo.readLine())!= null) {
                line = line.toLowerCase();
                lecturados.add(line);
            }
            readertwo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        while (opcionusuario!=5) {
            System.out.println("Ingrese una opcion");
            System.out.println("1. Traducir texto");
            System.out.println("2. Mostrar arbol");
            System.out.println("3. Eliminar palabra del diccionario");
            System.out.println("4. Editar valor de una palabra");
            System.out.println("5. Salir");
            opcionusuario = numero.nextInt();

            if (opcionusuario == 1) {
                

                int contadororaciones = 1;
                System.out.println("Las opciones a traducir son:");
                for (String string : lecturados) {
                    System.out.println(contadororaciones + ". " +string);
                    contadororaciones+=1;
                }
                System.out.println("Ingrese la opcion a traducir");
                int opcionoracion = numero.nextInt();
                System.out.println("Ingrese el idioma en el que se encuentra la oracion a traducir");
                System.out.println("1. Espanol");
                System.out.println("2. Ingles");
                System.out.println("3. Frances");
                int caracterizacionidioma = numero.nextInt();

                if (caracterizacionidioma == 1) {
                    System.out.println("Ingrese el idioma al que desea traducir");
                    System.out.println("1. Ingles");
                    System.out.println("2. Frances");
                    int opcionidioma = numero.nextInt();
                

                    if (opcionidioma == 1) {
                        // traducimos de espanol al ingles 
                    
                        String palabraatrducir = lecturados.get(opcionoracion-1);
                        String[] listadepalabrasatraducir = palabraatrducir.split(" ");
                        ArrayList<String> palabrastraducidas = new ArrayList<String>();
                    
                    for (String string : listadepalabrasatraducir) {
                        
                        String valor = diccionarioespanol.search(string);
                        if (valor == null) {
                            String stringtraducido = "*" + string + "*";
                            palabrastraducidas.add(stringtraducido);
                        } else{
                            String[] value = valor.split(",");
                            palabrastraducidas.add(value[0]);
                        }
                    }

                    String palabratraducida = "";
                    for (String string : palabrastraducidas) {
                        palabratraducida = palabratraducida +" "+string;
                    }

                    System.out.println("La oracion traducida es:");
                    System.out.println(palabratraducida);



                } else {
                    // traducimos al frances
                    String palabraatrducir = lecturados.get(opcionoracion-1);
                    String[] listadepalabrasatraducir = palabraatrducir.split(" ");
                    ArrayList<String> palabrastraducidas = new ArrayList<String>();
                    
                    for (String string : listadepalabrasatraducir) {
                        
                        String valor = diccionarioespanol.search(string);
                        if (valor == null) {
                            String stringtraducido = "*" + string + "*";
                            palabrastraducidas.add(stringtraducido);
                        } else{
                            String[] value = valor.split(",");
                            palabrastraducidas.add(value[1]);
                        }
                    }

                    String palabratraducida = "";
                    for (String string : palabrastraducidas) {
                        palabratraducida = palabratraducida +" "+string;
                    }

                    System.out.println("La oracion traducida es:");
                    System.out.println(palabratraducida);
                } 

                } else if (caracterizacionidioma == 2){
                    System.out.println("Ingrese el idioma al que desea traducir");
                    System.out.println("1. Espanol");
                    System.out.println("2. Frances");
                    int opcionidioma = numero.nextInt();
                

                    if (opcionidioma == 1) {
                    // traducimos de espanol al espanol 
                    
                        String palabraatrducir = lecturados.get(opcionoracion-1);
                        String[] listadepalabrasatraducir = palabraatrducir.split(" ");
                        ArrayList<String> palabrastraducidas = new ArrayList<String>();
                    
                        for (String string : listadepalabrasatraducir) {
                        
                            String valor = diccionarioingles.search(string);
                            if (valor == null) {
                                String stringtraducido = "*" + string + "*";
                                palabrastraducidas.add(stringtraducido);
                            } else{
                                String[] value = valor.split(",");
                                palabrastraducidas.add(value[0]);
                            }
                        }

                        String palabratraducida = "";
                        for (String string : palabrastraducidas) {
                            palabratraducida = palabratraducida +" "+string;
                        }

                        System.out.println("La oracion traducida es:");
                        System.out.println(palabratraducida);



                    } else {
                        // traducimos al frances
                        String palabraatrducir = lecturados.get(opcionoracion-1);
                        String[] listadepalabrasatraducir = palabraatrducir.split(" ");
                        ArrayList<String> palabrastraducidas = new ArrayList<String>();
                    
                        for (String string : listadepalabrasatraducir) {
                        
                            String valor = diccionarioingles.search(string);
                            if (valor == null) {
                                String stringtraducido = "*" + string + "*";
                                palabrastraducidas.add(stringtraducido);
                            } else{
                                String[] value = valor.split(",");
                                palabrastraducidas.add(value[1]);
                            }
                        }

                        String palabratraducida = "";
                        for (String string : palabrastraducidas) {
                            palabratraducida = palabratraducida +" "+string;
                        }

                        System.out.println("La oracion traducida es:");
                        System.out.println(palabratraducida);
                    } 

                } else {
                    System.out.println("Ingrese el idioma al que desea traducir");
                    System.out.println("1. Ingles");
                    System.out.println("2. Espanol");
                    int opcionidioma = numero.nextInt();
                

                    if (opcionidioma == 1) {
                        // traducimos de espanol al ingles 
                    
                        String palabraatrducir = lecturados.get(opcionoracion-1);
                        String[] listadepalabrasatraducir = palabraatrducir.split(" ");
                        ArrayList<String> palabrastraducidas = new ArrayList<String>();
                    
                        for (String string : listadepalabrasatraducir) {
                        
                            String valor = diccionariofrances.search(string);
                            if (valor == null) {
                                String stringtraducido = "*" + string + "*";
                                palabrastraducidas.add(stringtraducido);
                            } else{
                                String[] value = valor.split(",");
                                palabrastraducidas.add(value[0]);
                            }
                        }

                        String palabratraducida = "";
                        for (String string : palabrastraducidas) {
                            palabratraducida = palabratraducida +" "+string;
                        }

                        System.out.println("La oracion traducida es:");
                        System.out.println(palabratraducida);



                    } else {
                        // traducimos al espanol
                        String palabraatrducir = lecturados.get(opcionoracion-1);
                        String[] listadepalabrasatraducir = palabraatrducir.split(" ");
                        ArrayList<String> palabrastraducidas = new ArrayList<String>();
                    
                        for (String string : listadepalabrasatraducir) {
                        
                            String valor = diccionariofrances.search(string);
                            if (valor == null) {
                                String stringtraducido = "*" + string + "*";
                                palabrastraducidas.add(stringtraducido);
                            } else{
                                String[] value = valor.split(",");
                                palabrastraducidas.add(value[1]);
                            }
                        }

                        String palabratraducida = "";
                        for (String string : palabrastraducidas) {
                            palabratraducida = palabratraducida +" "+string;
                        }

                        System.out.println("La oracion traducida es:");
                        System.out.println(palabratraducida);
                    } 

                }
                
                
                
                
                
                /*System.out.println("Ingrese el idioma al que desea traducir");
                System.out.println("1. Ingles");
                System.out.println("2. Frances");
                int opcionidioma = numero.nextInt();
                

                if (opcionidioma == 1) {
                    // traducimos de espanol al ingles 
                    
                    String palabraatrducir = lecturados.get(opcionoracion-1);
                    String[] listadepalabrasatraducir = palabraatrducir.split(" ");
                    ArrayList<String> palabrastraducidas = new ArrayList<String>();
                    
                    for (String string : listadepalabrasatraducir) {
                        
                        String valor = diccionarioespanol.search(string);
                        if (valor == null) {
                            String stringtraducido = "*" + string + "*";
                            palabrastraducidas.add(stringtraducido);
                        } else{
                            String[] value = valor.split(",");
                            palabrastraducidas.add(value[0]);
                        }
                    }

                    String palabratraducida = "";
                    for (String string : palabrastraducidas) {
                        palabratraducida = palabratraducida +" "+string;
                    }

                    System.out.println("La oracion traducida es:");
                    System.out.println(palabratraducida);



                } else {
                    // traducimos al frances
                    String palabraatrducir = lecturados.get(opcionoracion-1);
                    String[] listadepalabrasatraducir = palabraatrducir.split(" ");
                    ArrayList<String> palabrastraducidas = new ArrayList<String>();
                    
                    for (String string : listadepalabrasatraducir) {
                        
                        String valor = diccionarioespanol.search(string);
                        if (valor == null) {
                            String stringtraducido = "*" + string + "*";
                            palabrastraducidas.add(stringtraducido);
                        } else{
                            String[] value = valor.split(",");
                            palabrastraducidas.add(value[1]);
                        }
                    }

                    String palabratraducida = "";
                    for (String string : palabrastraducidas) {
                        palabratraducida = palabratraducida +" "+string;
                    }

                    System.out.println("La oracion traducida es:");
                    System.out.println(palabratraducida);
                }*/ 

            }

            if (opcionusuario == 2) {
                System.out.println("Ingrese el idioma");
                System.out.println("1. Ingles");
                System.out.println("2. Espanol");
                System.out.println("3. Frances");
                int opcionlenguaje = numero.nextInt();
                if (opcionlenguaje==1) {
                    //diccionarioingles.traverse();
                    System.out.println("Diccionario Ingles");
                    for (int i = 0; i < listadelistas.size(); i++) {
                        String key = listadelistas.get(i)[0];
                        System.out.println(diccionarioingles.search(key));
                    }
                } else if (opcionlenguaje == 2) {
                    //diccionarioespanol.traverse();
                    System.out.println("Diccionario espanol");
                    for (int i = 0; i < listadelistas.size(); i++) {
                        String key = listadelistas.get(i)[1];
                        System.out.println(diccionarioespanol.search(key));
                    }
                }else {
                    //diccionariofrances.traverse();
                    System.out.println("Diccionario frances");
                    for (int i = 0; i < listadelistas.size(); i++) {
                        String key = listadelistas.get(i)[2];
                        System.out.println(diccionariofrances.search(key));
                    }
                }
            }

            if (opcionusuario == 3) {
                int opcionlenguaje;
                String palabra;
                Scanner texto = new Scanner(System.in);
                System.out.println("1. Eliminar palabra en diccionario de Ingles");
                System.out.println("2. Eliminar palabra en diccionario de Espanol");
                System.out.println("3. Eliminar palabra en diccionario de Frances");
                opcionlenguaje = numero.nextInt();
                if (opcionlenguaje == 1) {
                    // pedimos al usuario que ingrese la palabra
                    System.out.println("Ingrese palabra a eliminar");
                    palabra = texto.nextLine();
                    // la convertimos a minusculas
                    palabra = palabra.toLowerCase();
                    // usamos el metodo remove de la clase BST
                    diccionarioingles.remove(palabra);
                } else if (opcionlenguaje == 2) {
                    // pedimos al usuario que ingrese la palabra
                    System.out.println("Ingrese palabra a eliminar");
                    palabra = texto.nextLine();
                    // la convertimos a minusculas
                    palabra = palabra.toLowerCase();
                    // usamos el metodo remove de la clase BST
                    diccionarioespanol.remove(palabra);
                } else {
                    // pedimos al usuario que ingrese la palabra
                    System.out.println("Ingrese palabra a eliminar");
                    palabra = texto.nextLine();
                    // la convertimos a minusculas
                    palabra = palabra.toLowerCase();
                    // usamos el metodo remove de la clase BST
                    diccionariofrances.remove(palabra);
                }
            }

            if (opcionusuario == 4) {
                Scanner texto = new Scanner(System.in);
                int opcionlenguaje;
                System.out.println("Ingrese lenguaje a editar");
                System.out.println("1. Ingles");
                System.out.println("2. Espanol");
                System.out.println("3. Frances");
                opcionlenguaje = numero.nextInt();
                if (opcionlenguaje ==1) {
                    System.out.println("Ingrese palabra a editar");
                    String palabravieja = texto.nextLine();
                    palabravieja = palabravieja.toLowerCase();
                    System.out.println("Ingrese las nuevas traducciones separadas por coma");
                    String nuevatraduccion = texto.nextLine();
                    // eliminamos el nodo viejo
                    diccionarioingles.remove(palabravieja);
                    // agregamos un nuevo nodo con la llave de la palabra vieja 
                    // y la nueva traduccion
                    diccionarioingles.add(palabravieja, nuevatraduccion);
                } else if (opcionlenguaje == 2) {
                    System.out.println("Ingrese palabra a editar");
                    String palabravieja = texto.nextLine();
                    palabravieja = palabravieja.toLowerCase();
                    System.out.println("Ingrese las nuevas traducciones separadas por coma");
                    String nuevatraduccion = texto.nextLine();
                    // eliminamos el nodo viejo
                    diccionarioespanol.remove(palabravieja);
                    // agregamos un nuevo nodo con la llave de la palabra vieja 
                    // y la nueva traduccion
                    diccionarioespanol.add(palabravieja, nuevatraduccion);
                } else {
                    System.out.println("Ingrese palabra a editar");
                    String palabravieja = texto.nextLine();
                    palabravieja = palabravieja.toLowerCase();
                    System.out.println("Ingrese las nuevas traducciones separadas por coma");
                    String nuevatraduccion = texto.nextLine();
                    // eliminamos el nodo viejo
                    diccionariofrances.remove(palabravieja);
                    // agregamos un nuevo nodo con la llave de la palabra vieja 
                    // y la nueva traduccion
                    diccionariofrances.add(palabravieja, nuevatraduccion);
                }
            }
        }

        if (opcionusuario==5) {
            System.out.println("Usted ha elegido salir.");
        } 
    }
}