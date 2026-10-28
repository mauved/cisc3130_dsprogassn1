package net.qwfp.sofia.cisc3130.assn1;

/**
 * Based on https://docs.oracle.com/en/java/javase/26/docs/api/java.base/java/util/Deque.html
 */
public interface DequeADT<E> extends QueueADT<E> {
    /**
     *
     * @param e
     */
    void addFirst(E e);

    /**
     *
     * @param e
     */
    void addLast(E e);

    /**
     *
     * @return
     */
    E removeFirst();

    /**
     *
     * @return
     */
    E removeLast();
}
