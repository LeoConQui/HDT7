import java.util.Comparator;
/**
 * BST es la clase que modela la estructura de datos Binary Search Tree.
 * El codigo fue extraido de: Li, Y. (2018) Binary Search Tree. Available at: https://cs.colby.edu/courses/S18/cs231/notes/outlines19.pdf. 
 * @author Leonel Contreras 18797
 * @version 1.0
 */
public class BST <K,V> {

	// atributos
	private TreeNode<K,V> root;
	private Comparator<K> comparator;

	// metodos

	/**
	 * BST es el constructor de la clase
	 * @param comparator es un objeto de tipo Comparator
	 */
	public  BST(Comparator<K> comparator) {
		// asignamos la raiz como null al momento de construir el arbol
		this.root = null;
		// asignamos el valor del comparator
		this.comparator = comparator;
	}

	/**
	 * add es el metodo que agrega nodos al arbol
	 * @param k es la llave
	 * @param v es el valor
	 */
	public void add(K k, V v) {
		// validamos que la raiz del arbol sea vacia
		if (root==null) {
			// asignamos a la raiz un nodo con la llave y valor; sin hijos
			root = new TreeNode<K,V>(k, v, null, null);
		} else {
			// usamos el metodo add de la clase TreeNode
			root.add(k,v,comparator);
		}
	}

	/**
	 * traverse es el metodo que recorre el arbol
	 */
	public void traverse() {
		// validamos si el arbol esta vacio
		if (root == null) {
			System.out.println("Empty tree");
		} else {
			// usamos el metodo traverse de la clase TreeNode
			root.traverse();
		}
	}

	/**
	 * search es el metodo que busca en el arbol un nodo con la llave ingresada de parametro
	 * @param key es la llave del Associatio
	 * @return el valor correspondiente a la llave
	 */
	public V search(K key) {
		// validamos que el arbol no este vacio
		if (root == null) {
			return null;
		} else {
			// usamos el metodo search de la clase TreeNode
			return root.search(key, comparator);
		}
	}

	/**
	 * remove es el metodo que retira un nodo con la llave correspondiente
	 * @param key es la llave dada
	 * @return un objeto de tipo TreeNode
	 */
	public TreeNode<K,V> remove(K key) {
		// validamos si el arbol esta vacio
		if (root == null) {
			return null;
		} else {
			// usamos el metodo remove de la clase TreeNode
			return root.remove(key, root, comparator);
		}
	}



}