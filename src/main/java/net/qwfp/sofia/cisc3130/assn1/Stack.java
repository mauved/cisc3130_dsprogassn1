package net.qwfp.sofia.cisc3130.assn1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Stack implements a LIFO stack.
 * The bottom of the stack is the beginning of the list
 * @param <E>
 */
public class Stack<E> extends ArrayList<E> implements StackADT<E> {
    /**
     * Default constructor
     */
    public Stack() {}

    /**
     * Checks whether the stack has any items
     * @return true if the stack is empty, otherwise return false
     */
    public boolean empty() {
        return super.isEmpty();
    }

    /**
     * Appends item to the top of the stack
     * @param e the item to add
     */
    public void push(E e) {
        super.addLast(e);
    }

    /**
     * Removes and returns the newest item in the ArrayList
     * @return the last item in the stack, or null if the stack is empty
     */
    public E pop() {
        if (this.isEmpty()) {
            return null;
        }
        return super.removeLast();
    }

    /**
     * Override the ArrayList iterator with stack behavior
     * @return a StackIterator
     */
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    /**
     * Define Iterator behavior for the Stack class
     */
    private class StackIterator implements Iterator<E> {
        /**
         * Checks whether the stack has more items
         * @return true if the stack is not empty, otherwise return false
         */
        public boolean hasNext() {
            return !Stack.this.empty();
        }

        /**
         * Removes and returns the next item in the stack
         * @return the next item in the stack
         */
        public E next() {
            return Stack.this.pop();
        }
    }
}
