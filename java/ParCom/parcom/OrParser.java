package parcom;

import java.util.ArrayList;
import java.util.List;

import util.CharStream;

public class OrParser implements Parser {

	Parser p1;
	Parser p2;
	
	public OrParser(Parser p1, Parser p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	@Override
	public List<ParserState> parse(CharStream cs) {
		List<ParserState> s1 = p1.parse(cs);
		List<ParserState> s2 = p2.parse(cs);
		List<ParserState> ret = new ArrayList<ParserState>(s1);
		ret.addAll(s2);
		return ret;
	}
}
