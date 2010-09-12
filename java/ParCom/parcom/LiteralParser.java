package parcom;

import java.util.ArrayList;
import java.util.List;

import util.CharStream;

import ast.Literal;

public class LiteralParser implements Parser {

	String lit;
	
	public LiteralParser(String lit) {
		this.lit = lit;
	}
	
	public List<ParserState> parse(CharStream cs) {
		CharStream ncs = cs.match(lit);
		if (ncs == null)
			return new ArrayList<ParserState>();
		else {
			List<ParserState> ret = new ArrayList<ParserState>();
			ParserState ps = new ParserState(new Literal(lit), ncs);
			ret.add(ps);
			return ret;
		}
	}

	public static void main(String[] args) {
		CharStream cs = new CharStream("good morning !");
		Parser p1 = new LiteralParser("good");
		Parser p2 = new LiteralParser("bad");
		System.out.println(p1.parse(cs));
		System.out.println(p2.parse(cs));
		
		Parser p3 = new LiteralParser("goo");
		Parser palt = new OrParser(p1, p3);
		System.out.println(palt.parse(cs));
	}

}

