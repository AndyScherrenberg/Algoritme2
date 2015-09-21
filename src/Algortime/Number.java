package Algortime;

public class Number extends Expression{
	private int number;
	public Number(int number)
	{
		this.number = number;
	}

	@Override
	public int evaluate() {
		return this.number;
	}

	@Override
	public String toString() {
		return Integer.toString(this.number);
	}

}
