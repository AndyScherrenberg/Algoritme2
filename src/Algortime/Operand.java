package Algortime;

public class Operand extends Expression {
	char operand;
	Expression left;
	Expression right;
	public Operand(char operand, Expression left, Expression right) {
		this.operand = operand;
		this.left = left;
		this.right = right;
	}
	
	@Override
	public int evaluate() {
		switch(operand){
	    case '+':
	        return left.evaluate() + right.evaluate();
		case '*':
	    	return left.evaluate() * right.evaluate();
		default:
	    	return 0;
		}  
	}

	@Override
	public String toString() {
		return "(" + left.toString() + String.valueOf(operand) + right.toString()+ ")";// ((4+5)*7)
	}

}
