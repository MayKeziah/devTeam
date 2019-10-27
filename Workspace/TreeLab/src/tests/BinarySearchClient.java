/**
 * 
 */
package tests;


import dataStructures.BinarySearchTree;

/**
 * To test my binary search tree
 * @author E
 * 
 */
public class BinarySearchClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] list = new Integer[5];
		for (int i = 0; i < 5; i++) {
			list[i] = new Integer(i);
		}
		BinarySearchTree<Integer> test1 = new BinarySearchTree<Integer>(list);
		test1.printSideways();
		test1.printInorder();
		test1.printPreorder();
		test1.printPostorder();
		
		Integer[] list2 = {5, 9, 6, 1, 3, 2, 4, 7, 12, 8};
		BinarySearchTree<Integer> test2 = new BinarySearchTree<Integer>(list2);
		test2.printSideways();
		test2.printInorder();
		test2.printPreorder();
		test2.printPostorder();
		
		String[] list3 = {"Kez", "Will", "Adam", "Alex", "David", "Bob", "Zenith", "Will"};
		BinarySearchTree<String> test3 = new BinarySearchTree<String>(list3);
		test3.printSideways();
		test3.printInorder();
		test3.printPreorder();
		test3.printPostorder();
		
		System.out.println(test3.contains("Will"));
		System.out.println(test3.contains("Bob"));
		System.out.println(test3.contains(""));


	}

}
