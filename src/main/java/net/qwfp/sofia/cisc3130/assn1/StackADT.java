package net.qwfp.sofia.cisc3130.assn1;

/**
 * Interface specification for a stack.
 * Stack specifies LIFO behavior.
 * Based on the methods provided at
 * <a href=https://docs.oracle.com/en/java/javase/26/docs/api/java.base/java/util/Stack.html>java.util.Stack</a>.
 */
public interface StackADT<E> {
    /**
     * Determines if the stack is empty
     * @return true is stack is empty, false if any elements present in stack
     */
    boolean empty();

    /**
     * Adds item to the stack
     * @param item element to be added to top stack
     */
    void push(E item);

    /**
     * Retrieves and removes item from stack
     * @return
     */
    E pop();
}
