package ast;

public class Literal extends Node {

	private String lit;
	
	public Literal(String lit) {
		this.lit = lit;
	}
	
	@Override
	public String toString() {
		return lit;
	}
}
