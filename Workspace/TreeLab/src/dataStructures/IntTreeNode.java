/**
 * 
 */
package dataStructures;

/**
 * @author E
 *
 *
 * The purpose of this class is to learn how to use trees of fixed type. 
 */
public class IntTreeNode {
	public int data;
	public IntTreeNode left;
	public IntTreeNode right;
	
	/**
	 * Constructs an IntTreeNode leaf with given data.
	 * 
	 * @param data
	 */
	public IntTreeNode(int data) {
		this(data, null, null);
	}
	
	/**
	 * Constructs an IntTreeNode branch with given data, left sub-tree, and right sub-tree.
	 * 
	 * @param data
	 * @param left
	 * @param right
	 */
	public IntTreeNode(int data, IntTreeNode left, IntTreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	
	/**
	 * This method informs the client on whether or not there is information stored to the left.
	 * 
	 * @return Answer to: is there information to the left?
	 */
	public boolean hasLeft() {
		return left != null;
	}
	
	/**
	 * This method informs the client on whether or not there is information stored to the right.
	 * 
	 * @return Answer to: is there information to the right?
	 */
	public boolean hasRight() {
		return right != null;
	}
	
	/**
	 * @return string representation of stored data
	 */
	public String toString() {
		return "" + data;
	}

}
