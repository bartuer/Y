package parcom;

import java.util.List;

import util.CharStream;

public class OneOrMore implements Parser {

	private Parser p;
	
	public OneOrMore(Parser p) {
		this.p = p;
	}

	public List<ParserState> parse(CharStream cs) {
		List<ParserState> ps1 = p.parse(cs);
		List<ParserState> ps2 = p.parse(cs);
        return ps2;
	}

}
