package interpreter;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
    private List<T> elems = new ArrayList<T>();
    
    public void push(T e) {
        elems.add(e);
    }
    
    public T pop() {
        T last = elems.get(elems.size() - 1);
        elems.remove(elems.size() - 1);
        return last;
    }

    public boolean isEmpty() {
        return elems.isEmpty();
    }
    
}
