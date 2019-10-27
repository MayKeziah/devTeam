/**
 * 
 */
package dataStructures;

/**
 * To learn and understand Generic Binary Search Trees.
 * 
 * Does not allow duplicates
 * 
 * @author E
 *
 */
public class BinarySearchTree<T> {
	private Node<T> overallRoot;
	private final String separator = "  ";
	
	/**
	 * Constructs a binary tree with values contained in an Array
	 * 
	 * @param list the Array used to build the list
	 */
	public BinarySearchTree(T[] list) {
		overallRoot = new Node<T>(list[0]);
		addAll(list);
	}	
	
	/**
	 * Inner Node class, the leaves and branches of the tree
	 * 
	 * @author E
	 *
	 */
	public class Node<E>{
		private E 		data; 
		private Node<E> left;
		private Node<E> right;
		
		public Node(E data){
			this(data, null, null);
		}
		public Node(E data, Node<E> left, Node<E> right) {
				this.data  = data;
				this.left  = left;
				this.right = right;
		}
		
		public boolean hasLeft() {
			return left != null;
		}
		
		public boolean hasRight() {
			return right != null;
		}
		public String toString() {
			return data.toString();
		}
	}

	/**
	 * Adds the given value to the list in natural binary order
	 * 
	 * @param value
	 */
	public void add(T value) {
		add(overallRoot, value);
	}
	
	/**
	 * Adds a given value to the list in natural binary order.
	 * 
	 * @param root the current node
	 * @param value the value to add
	 * @return the current node
	 */
	@SuppressWarnings("unchecked")
	private Node<T> add(Node<T> root, T value) {
		if (root == null) {
			root = new Node<T>(value);
		}else if (((Comparable<T>) root.data).compareTo(value) > 0) {
			root.left = add(root.left, value);
		}else if(((Comparable<T>) root.data).compareTo(value) < 0) {
			root.right = add(root.right, value);
		}
		return root;
	}

	/**
	 * Given an array, its elements are added to the tree.
	 * 
	 * @param list the values to add
	 */
	public void addAll(T[] list) {
		for (int i = 0; i < list.length; i++) {
			add(overallRoot, list[i]);
		}
	}
	/**
	 * Searches the list for a given value
	 * 
	 * @param value the value to search for
	 * @return whether the value was found
	 */
	public boolean contains(T value) {
		return contains(overallRoot, value);
	}
	
	/**
	 * Recursively searches the tree for the given value
	 * 
	 * @param root the current node to compare to the value
	 * @param value the value to search for
	 * @return whether the value was found
	 */
	@SuppressWarnings("unchecked")
	private boolean contains(Node<T> root, T value) {
		if (root == null) {
			return false;
		}else if (((Comparable<T>) root.data).compareTo(value) > 0){
			return contains(root.left, value);
		}else if (((Comparable<T>) root.data).compareTo(value) < 0){
			return contains(root.right, value);
		} 	return true;
	}
	
	/**
	 * Returns the number of leaves in this tree.
	 * 
	 * @return number of leaves
	 */
	public int countLeaves() {
		return countLeaves(overallRoot);
	}

	/**
	 * Recursively counts the number of leaves in this tree.
	 * @param root
	 * @return the number of leaves found
	 */
	private int countLeaves(Node<T> root) {
		if (root == null) {
			return 0;
		}else if (!root.hasLeft() && !root.hasRight()) {
			return 1;
		}else {
			return countLeaves(root.right) + countLeaves(root.left);
		}
	}

	public int countLevels() {
		return countLevels(overallRoot);
	}

	private int countLevels(Node<T> root) {
		if(root == null) {
			return 0;
		}
		return 1 + Math.max(countLevels(root.left), countLevels(root.right));
	}
	/**
	 * Prints the contents of the tree in order
	 */
	public void printInorder() {
		System.out.println("Inorder:");
		printInorder(overallRoot);
		System.out.println();
	
	}

	/**
	 * Private helper method recursively prints in order
	 */
	private void printInorder(Node<T> root) {
		if(root != null) {
			printInorder(root.left);
			System.out.print(root + separator);
			printInorder(root.right);
		}
	}

	/**
	 * Prints the contents of the tree in preorder
	 */
	public void printPreorder() {
		System.out.println("Preorder:");
		printPreorder(overallRoot);
		System.out.println();

	}
	
	/**
	 * Private helper method recursively prints in preorder
	 */
	private void printPreorder(Node<T> root) {
		if (root != null) {
			System.out.print(root + separator);
			printPreorder(root.left);
			printPreorder(root.right);
		}
		
	}
	
	/**
	 * Prints the contents of the tree in preorder
	 */
	public void printPostorder() {
		System.out.println("Postorder:");
		printPostorder(overallRoot);
		System.out.println();

	}
	
	/**
	 * Private helper method recursively prints in preorder
	 */
	private void printPostorder(Node<T> root) {
		if (root != null) {
			printPostorder(root.left);
			printPostorder(root.right);
			System.out.print(root + separator);

		}
		
	}
	
	/**
	 * Prints a visual representation of the tree turned sideways.
	 */
	public void printSideways() {
		System.out.println("Sideways Tree:");
		printSideways(overallRoot, 0);
	}

	/**
	 * Recursively prints a visual representation of the tree turned sideways.
	 */
	private void printSideways(Node<T> root, int level) {
		if(root != null) {
			String tab = "";
			for(int i = 0; i < level; i++) {
				tab += "\t";
			}
			printSideways(root.right, level + 1);
			System.out.println(tab + root);
			printSideways(root.left, level + 1);
		}
		
	}
}
