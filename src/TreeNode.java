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
			System.out.println(pair);
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

		// validamos que las llaves coindicen
		if (compRslt==0) {
			// retornamos el valor
			return pair.getValue();
		} else if(compRslt<0){ // la llave es mayor que el pair get key
			// validamos que el nodo left sea nulo
			if (left == null ) {
				return null;
			}else{
				// si no es nulo seguimos la busqueda en el left
				return left.search(key, comp);
			}
		} else{ // el caso en que nos movemos al nodo derecho
			// validamos que el nodo derecho no sea null
			if (right == null) {
				return null;
			}else{
				return right.search(key, comp);
			}
		}

		
	}

	/**
	 * remove es el metodo que remueve un nodo del arbol
	 * @param key es la llave 
	 * @param node es el nodo
	 * @param comp es el comparador de llaves
	 * @return un objeto de tipo TreeNode que se va a remover
	 */
	public TreeNode<K,V> remove(K key, TreeNode<K,V> node, Comparator<K> comp) {
		if (node == null) {
			return null;
		} else if(comp.compare(key, node.pair.getKey())<0){
			node.left = remove(key, node.left, comp);
		} else if(comp.compare(key, node.pair.getKey())>0){
			node.right = remove(key, node.right, comp);
		}else{
			node = removeNode(node, comp);
		}

		return node;
	}

	/**
	 * removeNode es un metodo que remueve un nodo
	 * @param node es el nodo 
	 * @param comp el un objeto comparator
	 * @return un objeto de tipo TreeNode
	 */
	private TreeNode<K,V> removeNode(TreeNode<K,V> node, Comparator<K> comp) {
		if (node.left == null) {
			return node.right;
		} else if(node.right == null){
			return node.left;
		} else{
			Association<K,V> p = getPredecessor(node.left);
			node.pair = p;
			node.left = remove(p.getKey(), node.left, comp);
			return node;
		}
	}

	/**
	 * getPredecessor es un metodo que obtiene el atributo association del predecesor de un nodo
	 * @param subtree
	 * @return
	 */
	private Association<K,V> getPredecessor(TreeNode<K,V> subtree) {
		TreeNode<K,V> tmp = subtree;
		while (tmp.right != null) {
			tmp = tmp.right;
		}
		return tmp.pair;
	}
}