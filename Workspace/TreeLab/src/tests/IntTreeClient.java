/**
 * 
 */
package tests;

import dataStructures.IntTree;
import dataStructures.IntTreeNode;

/**
 * @author E
 *
 */
public class IntTreeClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//root level zero
		IntTree test1 = new IntTree(new IntTreeNode(50));
		
		//level one
		test1.getRoot().left = new IntTreeNode(20);
		test1.getRoot().right = new IntTreeNode(70);

		
		//level two left
		test1.getRoot().left.left = new IntTreeNode(5);
		test1.getRoot().left.right = new IntTreeNode(23);
		//level two right
		test1.getRoot().right.left = new IntTreeNode(60);
		test1.getRoot().right.right = new IntTreeNode(90);		

		//level three leftLeft
		test1.getRoot().left.left.left = new IntTreeNode(1);
		test1.getRoot().left.left.right = new IntTreeNode(10);
		//level three leftRight
		test1.getRoot().left.right.left = new IntTreeNode(22);
		//level three rightRight
		test1.getRoot().right.right.left = new IntTreeNode(80);
		test1.getRoot().right.right.right = new IntTreeNode(100);
		
		
		//Test pre-order
		test1.printPreorder();
		//Test Inorder
		test1.printInorder();		
		//Test post-order
		test1.printPostorder();
		
		//Sequential Tree constructor test
		IntTree test2 = new IntTree(1, 10);
		
		test2.printInorder();
		
		test2.print();
		
		



	}

}
