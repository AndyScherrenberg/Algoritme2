package Algortime;

public class BST {
	private BSTNode root;
	
	/**
	 * Inserts the value into the binary search tree
	 */
	public void insert(int number) {
		if(root == null) {
			root = new BSTNode(number);
		} else {
			root.insert(number);
		}
	}
	
	/**
	 * Returns true if the number is present as a node in the tree
	 */
	public boolean exists(int number) {
	    return root.exists(number);
	}
	
	/**
	 * Returns the smallest value in the tree (or -1 if tree is empty)
	 */
	public int min() {
	return	root.min();
	}
	
	/**
	 * Returns the largest value in the tree (or -1 if tree is empty)
	 */
	public int max() {
return root.max();
	}
	
	/**
	 * Returns how many levels deep the deepest level in the tree is
	 * (the empty tree is 0 levels deep, the tree with only one root node is 1 deep)
	 * @return
	 */
	public int depth() {
		throw new UnsupportedOperationException("Not implemented, yet");
	}
	
	/**
	 * Returns the amount of values in the tree
	 * @return
	 */
	public int count() {
		throw new UnsupportedOperationException("Not implemented, yet");
	}
	
	/**
	 * Print all the values in the tree in order
	 */
	public void print() {
		
		
	root.Traverse();
	
		//throw new UnsupportedOperationException("Not implemented, yet");
	}
	
	/**
	 * Print all values that lie between min and max in order (inclusive)
	 */
	public void printInRange(int min, int max) {
		throw new UnsupportedOperationException("Not implemented, yet");
	}
	
	/**
	 * Delete a number from the tree (if it exists)
	 */
	public void delete(int number) {
		throw new UnsupportedOperationException("Not implemented, yet");
	}
	
	public static void main(String args[]) {
		BST tree = new BST();
		tree.insert(50);
		tree.insert(2);
		tree.insert(7);
		tree.insert(94);
		tree.insert(24);
		tree.insert(24);
		tree.insert(71);
		tree.insert(30);
		tree.insert(49);
		tree.insert(1);
		tree.insert(3);
		tree.insert(9);
	//	System.out.println("Count: " + tree.count()); // Should be 9
		System.out.println("Min: " + tree.min()); // Should be 2
		System.out.println("Max: " + tree.max()); // Should be 94
//		System.out.println("Depth: " + tree.depth()); // Should be 7
	//	tree.print(); // Prints the values in order
		
  //      tree.delete(49); // test for value not in tree
    //    tree.delete(51); // test for value not in tree
      //  tree.delete(50);
      //  tree.delete(2);
      //  tree.delete(7);
      //  tree.delete(94);
      //  tree.delete(24);
       // tree.delete(24);
       // tree.delete(71);
       // tree.delete(30);
       // tree.delete(49);
       // System.out.println("Count: " + tree.count()); // Should be 0
      //  System.out.println("Min: " + tree.min()); // Should be -1
      //  System.out.println("Max: " + tree.max()); // Should be -1
      //  System.out.println("Depth: " + tree.depth()); // Should be 0
        //tree.print(); // Prints the values in order
	}
}