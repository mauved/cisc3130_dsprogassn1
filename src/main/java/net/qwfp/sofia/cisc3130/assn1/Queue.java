package net.qwfp.sofia.cisc3130.assn1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Queue implements a FIFO queue
 * @param <E> input type for the Queue
 */
public class Queue<E> extends ArrayList<E> implements QueueADT<E> {
    /**
     * Default constructor
     */
    public Queue() {}

    /**
     * Constructor for copying
     * @param original the queue being copied
     */
    public Queue(Queue<E> original) {
        super(original);
    }

    /**
     * Removes and returns the oldest item in the ArrayList
     * @return the first item in the queue
     */
    public E remove() {
        // Don't return anything if the queue is empty
        if (this.isEmpty()) {
            return null;
        }
        return super.removeFirst();
    }

    /**
     * Checks whether the queue has any items <br>
     * The java.util.Queue defines this method, so this is implemented for parity
     * @return true if the queue empty, otherwise return false
     */
    public boolean empty() {
        return super.isEmpty();
    }

    /**
     * Override the ArrayList iterator with queue behavior
     * @return a QueueIterator
     */
    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    /**
     * Define Iterator behavior for the Queue class
     */
    private class QueueIterator implements Iterator<E> {
        /**
         *
         * @return true if the queue is not empty, otherwise return false
         */
        public boolean hasNext() {
            return !Queue.this.isEmpty();
        }

        /**
         * Removes and returns the next item in the queue
         * @return the next item in the queue
         */
        public E next() {
            return Queue.this.remove();
        }
    }
}
