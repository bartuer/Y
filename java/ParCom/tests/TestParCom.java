package tests;
import junit.framework.TestCase;
import util.CharStream;

public class TestParCom extends TestCase {
    public void testCharStream() {
        CharStream cs1 = new CharStream("");
        assertTrue(cs1.isEmpty());

        CharStream cs2 = new CharStream(".");
        assertFalse(cs2.isEmpty());

        // rest is empty
        CharStream cs3 = new CharStream("wow");
        CharStream cs4 = cs3.rest(3);
        assertNotNull(cs4);
        assertTrue(cs4.isEmpty());

        // rest
        CharStream cs5 = new CharStream("helloworld");
        CharStream cs6 = cs5.rest(5);
        for (int i = 0; i < "world".length(); i++) {
            assertEquals("world".charAt(i), cs6.get(i));
        }
        
        CharStream cs7 = new CharStream("hello");
        assertEquals("h", cs7.head());
        assertEquals("lo", cs7.rest(3).toString());
        assertEquals("llo", cs7.rest().rest().toString());

        // literal match
        CharStream cs8 = cs7.match("hel");
        assertEquals("lo", cs8.toString());

        CharStream cs9 = cs7.match("hello");
        assertEquals("", cs9.toString());
        assertTrue(cs9.isEmpty());
        
        CharStream cs10 = cs7.match("hell0");
        assertNull(cs10);

        CharStream cs11 = cs7.match("helloooo");
        assertNull(cs11);
        
    }

}
