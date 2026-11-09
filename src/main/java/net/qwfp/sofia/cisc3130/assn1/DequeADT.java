package net.qwfp.sofia.cisc3130.assn1;

/**
 * Interface specification for a double-ended queue <br>
 * Based on <a href="https://docs.oracle.com/en/java/javase/26/docs/api/java.base/java/util/Deque.html">.java.util.Deque</a>
 */
public interface DequeADT<E> extends QueueADT<E> {
    /**
     * Adds item to the front of the queue
     * @param e
     */
    void addFirst(E e);

    /**
     * Adds item to the end of the queue
     * @param e
     */
    void addLast(E e);

    /**
     * Removes and returns item from the front of the queue
     * @return
     */
    E removeFirst();

    /**
     * Removes and returns item from the back of the queue
     * @return
     */
    E removeLast();
}
