package net.qwfp.sofia.cisc3130.assn1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Queue implements a FIFO queue
 * @param <E>
 */
public class Queue<E> implements QueueADT<E>, Iterable<E> {
    private ArrayList<E> queue;

    public Queue() {
        queue = new ArrayList<>();
    }

    /**
     * Appends item to the end of the underlying ArrayList
     * @param item
     */
    public void add(E item) {
        queue.add(item);
    }

    /**
     * Removes and returns the oldest item in the ArrayList
     * @return
     */
    public E remove() {
        return queue.removeFirst();
    }

    public boolean empty() {
        return !queue.isEmpty();
    }

    /**
     *
     * @return
     */
    public Iterator<E> iterator() {
        return new QueueIterator<E>(this);
    }

    /**
     *
     * @param <E>
     */
    private class QueueIterator<E> implements Iterator<E> {
        private Queue<E> queue;

        public QueueIterator(Queue<E> queue) {
            this.queue = queue;
        }

        public boolean hasNext() {
            return queue.empty();
        }

        public E next() {
            return queue.remove();
        }

        public void remove() {
            queue.remove();
        }
    }
}
