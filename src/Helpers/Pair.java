package Helpers;

/**
 * A class representing a container holding a pair of two elements.
 * The implementation makes it possible to create a pair of two elements of every possible type.
 * 
 * @author Lior Daniel.
 *
 * @param <F> first element
 * @param <S> second element
 */
public class Pair<F, S> {
	
    private final F first;
    private final S second;
    
    /**
     * Constructor
     * @param first any type of element.
     * @param second any type of element.
     */
    public Pair(F first, S second) {
    	this.first = first;
    	this.second = second;
    }
    
    /**
     * A function that returns the first element.
     * @return F
     */
    public F getFirst() {
    	return first;
    }
    
    /**
     * A function that returns the second element.
     * @return S
     */
    public S getSecond() {
    	return second;
    }
    
    /**
     * Function that allows comparison of two Pair objects using the '==' operator.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Pair)) return false;
        Pair temp = (Pair) o;
        return this.first == temp.first && this.second == temp.second;
    }
    
    
    public String toString() {
    	return "(" + first + ", " + second + ")";
    }
    
    
}