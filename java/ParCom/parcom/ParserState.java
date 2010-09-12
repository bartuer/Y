package parcom;

import util.CharStream;
import ast.Node;

public class ParserState {
	public Node result;
	public CharStream cs;
	public int indent = 0;
	public int precedence = 0;
	
	public ParserState(Node result, CharStream cs) {
		this.result = result;
		this.cs = cs;
	}

	public ParserState(Node result, CharStream cs, int indent) {
		super();
		this.result = result;
		this.cs = cs;
		this.indent = indent;
	}

	public ParserState(Node result, CharStream cs, int indent, int precedence) {
		super();
		this.result = result;
		this.cs = cs;
		this.indent = indent;
		this.precedence = precedence;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("<P.S.:");
		sb.append("result=");
		sb.append(result);
		sb.append(",");
		sb.append("cs=\"");
		sb.append(cs);
		sb.append("\")");
		return sb.toString();
	}

}
