package net.qwfp.sofia.cisc3130.assn1;

/**
 * This is based on the existing interface java.util.Queue
 * but without some of the fancier methods. </br>
 * Based on the <a href=https://docs.oracle.com/en/java/javase/26/docs/api/java.base/java/util/Queue.html>
 *     java.util.Queue class specification
 *     </a>
 * @param <E>
 */
public interface QueueADT<E> {
    /**
     * Inserts the specified element into the queue. </br>
     * This needed to be set to a boolean rather than a void due the ArrayList defining add as a boolean
     * @param e
     */
    boolean add(E e);

    /**
     * Retrieves and removes the head of this queue.
     * @return
     */
    E remove();
}
