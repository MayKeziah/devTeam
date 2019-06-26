package dataStructures;

public class IntTree {
	private IntTreeNode overallRoot;
	private final String separator = " ";
	
	/**
	 * Constructs an IntTree with the given base root.
	 * 
	 * @param root
	 */
	public IntTree(IntTreeNode root) {
		overallRoot = root;
	}
	
	/**
	 * Constructs a Sequential tree as read top to bottom from left to right.
	 * @param min the root and smallest number to store
	 * @param max the largest number to store
	 */
	public IntTree(int min, int max) {
		if (min <= max) {
			overallRoot = buildTree(min, max);
		}
	}
	
	/**
	 * Private helper method recursively builds a sequential tree.
	 * 
	 * @param min root or branch of this subtree
	 * @param max overall max value to store in the tree
	 * @return the next branch or leaf to add
	 */
	private IntTreeNode buildTree(int min, int max) {
		if (min > max) {
			return null;
		}
		else {
			return new IntTreeNode(min, buildTree(min * 2, max), buildTree(min * 2 + 1, max));
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
	private void printPreorder(IntTreeNode root) {
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
	private void printPostorder(IntTreeNode root) {
		if (root != null) {
			printPostorder(root.left);
			printPostorder(root.right);
			System.out.print(root + separator);

		}
		
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
	private void printInorder(IntTreeNode root) {
		if(root != null) {
			printInorder(root.left);
			System.out.print(root + separator);
			printInorder(root.right);
		}
	}
	
	/**
	 * Get the tree's overall root
	 * 
	 * @return
	 */
	public IntTreeNode getRoot() {
		return overallRoot;
	}
	
	/**
	 * Prints a sideways view of this tree.
	 */
	public void print() {
		System.out.println("Tree view:");
		print(overallRoot, 0);
		System.out.println();
	}
	
	/**
	 * Recursively prints a sideways view of this tree.
	 * @param root
	 * @param level
	 */
	private void print(IntTreeNode root, int level) {
		if (root != null) {
			String levelTab = "";
			for (int i = 0; i <= level; i++) {
				levelTab += "\t";
			}
			print(root.right, level + 1);
			System.out.println(levelTab + root);
			print(root.left, level + 1);
		}
		
	}
	
}
