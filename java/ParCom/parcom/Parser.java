package parcom;

import util.CharStream;

import java.util.List;

public interface Parser {
	public List<ParserState> parse(CharStream cs);
}
