import java.util.Comparator;

/**
 * TreeNode es la clase que modela los nodos del arbol binario de busqueda.
 * El codigo fue extraido de: Li, Y. (2018) Binary Search Tree. Available at: https://cs.colby.edu/courses/S18/cs231/notes/outlines19.pdf. 
 * @author Leonel Contreras 18797
 * @version 1.0
 */
public class TreeNode<K,V> {

	// atributos
	private Association<K,V> pair;
	private TreeNode<K,V> left;
	private TreeNode<K,V> right;

	// metodos

	/**
	 * TreeNode es el constructor de la clase
	 * @param k es la llave
	 * @param v es el valor
	 * @param l es el nodo izquierdo del nodo a crear
	 * @param r es el nodo derecho del nodo a crear
	 */
	public  TreeNode(K k, V v, TreeNode<K,V> l, TreeNode<K,V> r) {
		// asignamos el pair 
		pair = new Association<K,V>(k, v);
		// asignamos los nodos izquierdo y derecho
		left = l;
		right = r;
	}

	/**
	 * add es el metodo que agrega valor y llave al atributo pair del nodo
	 * @param key es la llave
	 * @param value es el valor
	 * @param comp es un objeto de tipo Comparator
	 */
	public void add(K key, V value, Comparator<K> comp) {
		// validamos si las llaves coinciden
		if(comp.compare(key, pair.getKey())==0){
			pair.setValue(value);
		}else if(comp.compare(key, pair.getKey())<0){ // si el valor a ingresar es menor, se anade a la izquierda del nodo
			// validamos que el left este vacio
			if (left == null) {
				// asignamos un nodo al left
				left = new TreeNode<K,V>(key, value,null,null);
			}else{
				// agregamos el nodo a la izquierda
				left.add(key, value, comp);
			}
		}else{ // se anade a la derecha del nodo
			// validamos que el right este vacio
			if (right == null) {
				// asignamos un nodo al right
				right = new TreeNode<K,V>(key, value, null, null);
			} else {
				// agregamos el nodo a la derecha
				right.add(key, value, comp);
			}
		}
	}

	/**
	 * traverse es el metodo que recorre el arbol
	 */
	public void traverse() {
		// validamos que el left no este vacio
		if (left!= null) {
			// hacemos una llamada recursiva
			left.traverse();
			System.out.println(pair);
		} 

		if (right!=null) {
			right.traverse();
		}
	}
	
	/**
	 * search metodo que sirve para buscar un valor, dada una llave
	 * @param key es la llave dada
	 * @param comp es un objeto de tipo comparator
	 * @return el valor correspondiente a la llave
	 */
	public V search(K key, Comparator<K> comp) {
		int compRslt = comp.compare(key, pair.getKey());

		
	}
}