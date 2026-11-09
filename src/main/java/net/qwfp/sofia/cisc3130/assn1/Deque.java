package net.qwfp.sofia.cisc3130.assn1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Deque class based on ArrayList <br>
 * Acts like a FIFO Queue with default methods,
 * but supports LIFO methods
 * @param <E>
 */
public class Deque<E> extends ArrayList<E> implements DequeADT<E> {
    /**
     * Default constructor
     * Initializes empty deque
     */
    public Deque() {}

    /**
     * Constructor for copying
     * @param original
     */
    public Deque(Deque<E> original) {
        super(original);
    }

    /**
     * Constructor for copying from an ArrayList
     * @param original
     */
    public Deque(ArrayList<E> original) {
        super(original);
    }

    /**
     * Removes and returns the first item in the deque
     * @return the first item in the deque
     */
    public E remove() {
        // Don't return anything if the deque is empty
        if (this.isEmpty()) {
            return null;
        }
        return super.removeFirst();
    }

    /**
     * Implements iterator
     * @return new DequeIterator
     */
    public Iterator<E> iterator() {
        return new DequeIterator();
    }

    /**
     * Implements Iterator interface for Deque class as a LIFO queue
     */
    private class DequeIterator implements Iterator<E> {
        /**
         *
         * @return true if the Deque is not empty, false if it is empty
         */
        public boolean hasNext() {
            return !Deque.this.isEmpty();
        }

        /**
         *
         * @return the last
         */
        public E next() {
            return Deque.this.remove();
        }
    }
}
