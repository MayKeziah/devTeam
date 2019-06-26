/**
 * 
 */
package dataStructures;

/**
 * To learn and understand Generic Binary Search Trees.
 * 
 * @author E
 *
 */
public class BinarySearchTree<T> {
	public Node<T> overallRoot;
	
	public BinarySearchTree(T[] list) {
		addAll(list);
		
	}	
	public class Node<T>{
		private T 		data; 
		private Node<T> left;
		private Node<T> right;
		
		public Node(T data){
			this(data, null, null);
		}
		public Node(T data, Node<T> left, Node<T> right) {
			this.data  = data;
			this.left  = left;
			this.right = right;
		}
		public String toString() {
			return data.toString();
		}
	}
	
	public void printSideways() {
		System.out.println("Sideways Tree:");
		printSideways(overallRoot, 0);
	}

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
