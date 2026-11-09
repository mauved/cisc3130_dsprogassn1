package net.qwfp.sofia.cisc3130.assn1;

/**
 * Interface specification for a double-ended queue <br>
 * Based on <a href="https://docs.oracle.com/en/java/javase/26/docs/api/java.base/java/util/Deque.html">.java.util.Deque</a>
 * @param <E> the datatype to be stored in the double-ended queue
 */
public interface DequeADT<E> extends QueueADT<E> {
    /**
     * Adds item to the front of the queue
     * @param e element to be added to the queue
     */
    void addFirst(E e);

    /**
     * Adds item to the end of the queue
     * @param e item to add to the tail of double-ended queue
     */
    void addLast(E e);

    /**
     * Removes and returns item from the front of the queue
     * @return item removed from head of double-ended queue
     */
    E removeFirst();

    /**
     * Removes and returns item from the back of the queue
     * @return item removed from tail of double-ended queue
     */
    E removeLast();
}
