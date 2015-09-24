package Algortime;

public class BSTNode {
	public int number;

	public BSTNode left;
	public BSTNode right;
	public BSTNode parent;

	public BSTNode(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
	
	public boolean isAVLGebalanceerd() {
		int rightDepth = 0;
		int leftDepth = 0;
		
		if(right != null)
			rightDepth = right.depth(1);
		if(left != null)
			leftDepth = left.depth(1);
		
		int i =  Math.abs(rightDepth- leftDepth);
		
		if(i > 1)
			return false;
		else
			if(right.isAVLGebalanceerd() && left.isAVLGebalanceerd())
				return true;
			else
				return false;
	}

	/**
	 * Add a number in the subtree of this node
	 */
	public void insert(int number) {
		if (number < this.number) {
			// Smaller value, insert it into the left subtree
			if (this.left == null) {
				this.left = new BSTNode(number);
			} else {
				this.left.insert(number);
			}
		} else {
			// Larger value, insert it in the right subtree
			if (this.right == null) {
				this.right = new BSTNode(number);
			} else {
				this.right.insert(number);
			}
		}

		this.parent = this;
	}

	public boolean exists(int number) {

		boolean b = false;
		if (number == this.number)
			return true;

		if (left != null)
			b = left.exists(number);

		if (b)
			return b;

		if (right != null)
			b = right.exists(number);

		return b;

	}

	public void Traverse() {
		if (left != null)
			left.Traverse();
		System.out.println(this.number);
		if (right != null)
			right.Traverse();
	}

	public void Traverse(int min, int max) {
		if (left != null) {
			left.Traverse(min, max);
		}
		if (this.number >= min && this.number <= max) {
			System.out.println(this.number);
		}
		if (right != null) {
			right.Traverse(min, max);
		}
	}

	public int min() {
		int temp1 = (left != null) ? left.number : 0;
		int temp2 = (right != null) ? right.number : 0;

		if (this.number >= temp1 && temp1 != 0)
			return left.min();
		else if (this.number >= temp2 && temp2 != 0)
			return right.min();
		return this.number;
	}

	public int max() {
		int temp1 = (left != null) ? left.number : 0;
		int temp2 = (right != null) ? right.number : 0;

		if (this.number <= temp1 && temp1 != 0)
			return left.max();
		else if (this.number <= temp2 && temp2 != 0)
			return right.max();
		return this.number;
	}

	public int count(int value) {
		if (left != null)
			value += left.count(1);
		if (right != null)
			value += right.count(1);

		return value;

	}

	public int depth(int d) {

		int leftDepth = d, rightDepth = d;

		if (left != null) {
			leftDepth = left.depth(d + 1);
		}
		if (right != null) {
			rightDepth = right.depth(d + 1);
		}

		return leftDepth > rightDepth ? leftDepth : rightDepth;
	}

	public BSTNode rotateLeft(BSTNode root) {
		if (this.right == null) {
			return null;
		} else {
			BSTNode oldRoot = root;

			if (root.right != null)
				root = root.right;
			if (root.left != null)
				oldRoot.right = root.left;

			root.left = oldRoot;

			return root;
		}
	}

	public BSTNode rotateRight(BSTNode root) {
		if (this.left == null) {
			return null;
		} else {
			BSTNode oldRoot = root;
			if (root.left != null)
				root = root.left;
			if (root.right != null)
				oldRoot.left = root.right;

			root.right = oldRoot;

			return root;
		}
	}

	public void prettyprint(String firstPrefix, String prefix) {
		System.out.println(firstPrefix + number);

		if (right == null) {
			System.out.println(prefix + "├── .");
		} else {
			right.prettyprint(prefix + "├── ", prefix + "|   ");
		}

		if (left == null) {
			System.out.println(prefix + "└── .");
		} else {
			left.prettyprint(prefix + "└── ", prefix + "    ");
		}
	}

	public int minValue() {
		if (left == null)
			return number;
		else
			return left.minValue();
	}

	public int printInRange(int min, int max) {
		return 0;
	}

}