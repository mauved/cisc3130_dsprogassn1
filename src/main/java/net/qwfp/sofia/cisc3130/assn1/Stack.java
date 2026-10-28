package net.qwfp.sofia.cisc3130.assn1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Stack class based on an ArrayList
 * The bottom of the stack is the beginning of the list
 * @param <E>
 */
public class Stack<E> implements StackADT<E>, Iterable<E> {
    /**
     * The stack is stored in an ArrayList
     */
    private ArrayList<E> stack;

    /**
     * Default constructor
     */
    public Stack() {
        stack = new ArrayList<>();
    }

    /**
     * Depends on the ArrayList implementation of isEmpty()
     * @return
     */
    public boolean empty() {
        return stack.isEmpty();
    }

    /**
     *
     * @param e
     */
    public void push(E e) {
        stack.add(e);
    }

    /**
     * If the stack is empty, return null
     * Otherwise return the last item in the list
     * @return
     */
    public E pop() {
        if (empty()) return null;
        return stack.removeLast();
    }

    /**
     *
     * @return
     */
    public Iterator<E> iterator() {
        return new StackIterator<E>(this);
    }

    /**
     *
     * @param <E>
     */
    private class StackIterator<E> implements Iterator<E> {
        private Stack<E> stack;

        /**
         * Default constructor fo StackIterator
         * @param stack
         */
        public StackIterator(Stack<E> stack) {
            this.stack = stack;
        }

        public boolean hasNext() {
            return !stack.empty();
        }

        /**
         *
         * @return
         */
        public E next() {
            return stack.pop();
        }

        /**
         * P
         */
        public void remove() {
            stack.pop();
        }
    }
}
