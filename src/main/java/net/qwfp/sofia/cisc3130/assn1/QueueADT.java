package net.qwfp.sofia.cisc3130.assn1;

/**
 * This is based on the existing interface java.util.Queue
 * but without some of the fancier methods.
 * https://docs.oracle.com/en/java/javase/26/docs/api/java.base/java/util/Queue.html
 * @param <E>
 */
public interface QueueADT<E> {
    /**
     * Inserts the specified element into the queue.
     * @param e
     */
    void add(E e);

    /**
     * Retrieves and removes the head of this queue.
     * @return
     */
    E remove();
}
