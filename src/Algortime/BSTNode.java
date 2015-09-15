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
	
	public int min()
	{
		int temp1 = (left != null)? left.number : 0;
		int temp2 = (right != null) ? right.number : 0;
		
		if (this.number >= temp1 && temp1 != 0)
			return left.min();
		else if(this.number >= temp2 && temp2 != 0)
			return	right.min();
		return this.number;
	}
	
	public int max()
	{
		int temp1 = (left != null)? left.number : 0;
		int temp2 = (right != null) ? right.number : 0;
		
		if (this.number <= temp1 && temp1 != 0)
			return left.max();
		else if(this.number <= temp2 && temp2 != 0)
			return	right.max();
		return this.number;		
	}
	
	
	public int count(int value)
	{
		if (left != null)
			value += left.count(1);
		if(right != null)
		 value += right.count(1);
		
	return value;
	
	}

}