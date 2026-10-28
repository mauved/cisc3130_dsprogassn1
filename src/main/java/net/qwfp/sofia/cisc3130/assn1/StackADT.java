package net.qwfp.sofia.cisc3130.assn1;

/**
 * This interface defines what methods a stack should implement
 * Based on the methods provided at https://docs.oracle.com/en/java/javase/26/docs/api/java.base/java/util/Stack.html
 */
public interface StackADT<E> {
    /**
     * Determines if the stack is empty
     * @return
     */
    boolean empty();

    /**
     * Adds item to the stack
     * @param item
     */
    void push(E item);

    /**
     * Retrieves and removes item from stack
     * @return
     */
    E pop();
}
