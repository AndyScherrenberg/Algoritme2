package Algortime;

public class BSTNode {
	private int number;
	
	private BSTNode left;
	private BSTNode right;
	
	public BSTNode(int number) {
		this.number = number;
	}
	
	/**
	 * Add a number in the subtree of this node
	 */
	public void insert(int number) {
		if(number < this.number) {
			// Smaller value, insert it into the left subtree
			if(this.left == null) {
				this.left = new BSTNode(number);
			} else {
				this.left.insert(number);
			}
		} else {
			// Larger value, insert it in the right subtree
			if(this.right == null) {
				this.right = new BSTNode(number);
			} else {
				this.right.insert(number);
			}
		}
	}
	
	
	public boolean exists(int number)
	{
	Boolean b =	this.left.exists(number);
	
	
	return b;
	}
	
	public void Traverse()
	{
		if (left != null)
		left.Traverse();
		System.out.println(this.number);
		if (right != null)
		right.Traverse();
	}

}