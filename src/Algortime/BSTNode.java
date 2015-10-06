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
		boolean rightIsBalanced = false;
		boolean leftIsBalanced = false;

		if (right != null) {
			rightDepth = right.depth(1);
			rightIsBalanced = right.isAVLGebalanceerd();
		}
		if (left != null) {
			leftDepth = left.depth(1);
			leftIsBalanced = left.isAVLGebalanceerd();
		}

		int i = Math.abs(rightDepth - leftDepth);

		if (right == null && left == null) {
			return true;
		}

		if (i > 1)
			return false;
		else if (rightIsBalanced && leftIsBalanced || rightIsBalanced
				&& left == null || leftIsBalanced && right == null)
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
	}

	public BSTNode insertAVLNode(int number) {

		if (number < this.number) {
			// Smaller value, insert it into the left subtree
			if (this.left == null) {
				// Add new node
				BSTNode node = new BSTNode(number);
				this.left = node;
				// check if balanced
				if (this.right != null) {
					int i = Math.abs(right.depth(0) - left.depth(0));
					if (i > 1) {
						System.out.println("hoe ken da nou!");
					}
				}
				return this;
			} else {
				// Going deeper to add new Node
				this.left = this.left.insertAVLNode(number);
				return balanceTree();
			}
		} else {
			// Larger value, insert it in the right subtree
			if (this.right == null) {
				BSTNode node = new BSTNode(number);
				this.right = node;
				// check if balanced
				if (this.left != null) {
					int i = Math.abs(right.depth(0) - left.depth(0));
					if (i > 1) {
						System.out.println("hoe ken da nou!");
					}
				}
				return this;
			} else {
				this.right = this.right.insertAVLNode(number);
				return balanceTree();
			}
		}
	}

	private BSTNode balanceTree() {
		int leftDepth = 0;
		int rightDepth = 0;

		if (this.right != null)
			rightDepth = right.depth(1);
		if (this.left != null)
			leftDepth = left.depth(1);

		int i = Math.abs(leftDepth - rightDepth);
		if (i > 1) {
			// iemand is te zwaar
			if (rightDepth > leftDepth) {
				// Rechts te zwaar || 2Methods

				int rightRight = 0;
				int rightLeft = 0;

				if (this.right.right != null)
					rightRight = this.right.right.depth(0);
				if (this.right.left != null)
					rightLeft = this.right.left.depth(0);
				if (rightRight >= rightLeft) {
					// het rechterkind is rechts zwaarder
					return rotateLeft();

				} else {
					// het rechterkind is links zwaarder
					this.right = right.rotateRight();
					return rotateLeft(); // TODO misschien naar links
				}

			} else {
				// Links te zwaar

				int leftRight = 0;
				int leftLeft = 0;

				if (this.left.right != null)
					leftRight = this.left.right.depth(1);
				if (this.left.left != null)
					leftLeft = this.left.left.depth(1);
				if (leftLeft >= leftRight) {
					// het linkerkind is links groter of gelijk aan rechts
					return rotateRight();
				} else {
					// het linkerkind is rechts groter
					this.left = left.rotateLeft();
					return rotateRight();
				}
			}
		}
		return this;
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

	public BSTNode rotateRight() {

		BSTNode root = this;
		BSTNode temp = root.left;
		root.left = temp.right;
		temp.right = root;

		return temp;
	}

	public BSTNode rotateLeft() {

		BSTNode root = this;
		BSTNode temp = root.right;
		root.right = temp.left;
		temp.left = root;

		return temp;

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