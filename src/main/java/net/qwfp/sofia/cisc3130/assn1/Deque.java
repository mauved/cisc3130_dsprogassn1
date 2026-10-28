package net.qwfp.sofia.cisc3130.assn1;

import java.util.ArrayList;

/**
 * Deque class based on ArrayList
 * Default behavior is LIFO, but FIFO behavior is possible
 * @param <E>
 */
public class Deque<E> implements DequeADT<E> {
    /**
     *
     */
    private ArrayList<E> deque;

    /**
     * Default constructor
     * Initializes empty deque
     */
    public Deque() {
        deque = new ArrayList<>();
    }

    /**
     * Adds item to front of deque
     * @param item
     */
    public void addFirst(E item) {
        deque.addFirst(item);
    }

    /**
     * Inserts item to the back of the queue
     * @param item
     */
    public void addLast(E item) {
        deque.addLast(item);
    }

    /**
     * Inserts item to the back of the queue
     * @param item
     */
    public void add(E item) {
        this.addLast(item);
    }

    /**
     * Removes and returns first item in deque
     * @return
     */
    public E removeFirst() {
        return deque.removeFirst();
    }

    /**
     * Removes and returns last item in deque
     * @return
     */
    public E removeLast() {
        return deque.removeLast();
    }

    /**
     * Removes and returns first item in deque
     * @return
     */
    public E remove() {
        return this.removeFirst();
    }
}
