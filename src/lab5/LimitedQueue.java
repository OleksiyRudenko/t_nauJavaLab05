/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;
import java.util.*;

/**
 *
 * @author Oleksiy.Rudenko@gmail.com
 * Queue of certain limited size.
 * Overflow => drop element from tail
 */

// https://docs.oracle.com/javase/8/docs/api/java/util/ArrayDeque.html
// http://docs.oracle.com/javase/7/docs/api/java/util/ArrayDeque.html

// Generics
// https://docs.oracle.com/javase/tutorial/extra/generics/simple.html
// http://www.angelikalanger.com/GenericsFAQ/FAQSections/ParameterizedTypes.html
// http://www.java2s.com/Tutorials/Java/Java_Language/8030__Java_generic_hierarchy.htm
// http://www.coderanch.com/t/477979/java/java/extend-generic-class

public class LimitedQueue<X> extends ArrayDeque<X> {
    // private X type;
    int numElements=0;
    
    public LimitedQueue(int numElements) {
        super(numElements);
        this.numElements=numElements;
    }
    
    /**
     *
     * @param e
     * @return
     */
    public boolean add(X e) {
        boolean ok=super.add(e);
        if (ok && this.size()>this.numElements) {
            removeFirst();
        }
        return ok;
    }
    
    public String dump() {
        StringBuilder ret=new StringBuilder();
        int count=0;
        for (X o : this) {
            ret.append((count++)+": "+o.toString()+"\n");
        }
        return ret.toString();
    }
    
}
