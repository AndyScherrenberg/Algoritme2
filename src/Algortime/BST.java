package Algortime;

public class BST {
	private BSTNode root;

	/**
	 * Inserts the value into the binary search tree
	 */
	public void insert(int number) {
		if (root == null) {
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
		return root.min();
	}

	/**
	 * Returns the largest value in the tree (or -1 if tree is empty)
	 */
	public int max() {
		return root.max();
	}

	/**
	 * Returns how many levels deep the deepest level in the tree is (the empty
	 * tree is 0 levels deep, the tree with only one root node is 1 deep)
	 * 
	 * @return
	 */
	public int depth() {
		if (root == null)
			return 0;
		return root.dept();
	}

	/**
	 * Returns the amount of values in the tree
	 * 
	 * @return
	 */
	public int count() {
		if (root != null) {
			return root.count(1);
		}
		return 0;
	}

	/**
	 * Print all the values in the tree in order
	 */
	public void print() {
		if (root != null) {
			root.Traverse();
		}
	}

	/**
	 * Print all values that lie between min and max in order (inclusive)
	 */
	public void printInRange(int min, int max) {
		if (root != null) {
			root.Traverse(min, max);
		}
	}

	/**
	 * Delete a number from the tree (if it exists)
	 */
	public void delete(int number) {
		if (exists(number) && root != null) {
			if (count() <= 1) {
				root = null;
			} else {
				delete(root, number);
			}
		} else {
			System.out.println("Fuck Off!!" + number);
		}

	}

	private BSTNode delete(BSTNode p, int toDelete) {
		if (p == null)
			throw new RuntimeException("cannot delete.");
		else if (toDelete < p.number)
			p.left = delete(p.left, toDelete);
		else if (toDelete > p.number)
			p.right = delete(p.right, toDelete);
		else {
			if (p.left == null)
				return p.right;
			else if (p.right == null)
				return p.left;
			else {
				// get data from the rightmost node in the left subtree
				p.number = retrieveData(p.left);
				// delete the rightmost node in the left subtree
				p.left = delete(p.left, p.number);
			}
		}
		return p;
	}

	private int retrieveData(BSTNode p) {
		while (p.right != null)
			p = p.right;

		return p.number;
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

		System.out.println("Count: " + tree.count()); // Should be 9
		System.out.println("Min: " + tree.min()); // Should be 2
		System.out.println("Max: " + tree.max()); // Should be 94
		System.out.println("Bestaat 50? " + tree.exists(50));
		System.out.println("Bestaat 2? " + tree.exists(2));
		System.out.println("Bestaat 7? " + tree.exists(7));
		System.out.println("Bestaat 94? " + tree.exists(94));
		System.out.println("Bestaat 24? " + tree.exists(24));
		System.out.println("Bestaat 71? " + tree.exists(71));
		System.out.println("Bestaat 30? " + tree.exists(30));
		System.out.println("Bestaat 49? " + tree.exists(49));
		System.out.println("Bestaat 756? " + tree.exists(756));
		System.out.println("Bestaat 69? " + tree.exists(69));
		System.out.println("Depth: " + tree.depth()); // Should be 7
		//tree.printInRange(1, 3);
		// tree.print(); // Prints the values in order

		// tree.delete(49); // test for value not in tree
		// tree.delete(51); // test for value not in tree
		// tree.delete(50);
		// tree.delete(2);
		// tree.delete(7);
		// tree.delete(94);
		// tree.delete(24);
		// tree.delete(24);
		// tree.delete(71);
		// tree.delete(30);

		// System.out.println("Count: " + tree.count()); // Should be 0
		// System.out.println("Min: " + tree.min()); // Should be -1
		// System.out.println("Max: " + tree.max()); // Should be -1
		// System.out.println("Depth: " + tree.depth()); // Should be 0
		// tree.print(); // Prints the values in order
	}
}