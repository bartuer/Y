package util;

public class CharStream {
	
    private char[] chars;
	private int start;
	
	public CharStream(String s) {
		this.chars = s.toCharArray();
		this.start = 0;
	}

	private CharStream(char[] s, int start) {
	    this.chars = s;
	    this.start = start;
	}
	
	public char get(int i) {
	    if (i < 0 || start + i > chars.length - 1) {
	        throw new IllegalArgumentException("Index out of bound: " + i);
	    } else {
	        return chars[start + i];
	    }
    }

	public boolean isEmpty() {
	    return (start > chars.length - 1);
	}
	
	////////////////////////////////////////////////////
	
    public String head() {
		return String.valueOf(get(0));
	}

	public CharStream rest(int n) {
	    if (n < 0) {
	        throw new IllegalArgumentException("Argument must be positive");
	    }
	    int newStart = start + n;
		if (newStart > chars.length)
		    throw new IllegalArgumentException("Taking rest of CharStream out of bound");
		else {
		    return new CharStream(chars, newStart);
		}
	}

	public CharStream rest() {
		return rest(1);
	}
	
	public CharStream match(String str) {
		char[] pattern = str.toCharArray();
		if (pattern.length > chars.length) {
		    return null;
		}
		for (int i = 0; i < pattern.length; i++) {
			if (pattern[i] != get(i))
				return null;
		}
		return rest(pattern.length);
	}

	@Override
	public String toString() {
		String s = new String(chars);
		return s.substring(start);
	}	
}
