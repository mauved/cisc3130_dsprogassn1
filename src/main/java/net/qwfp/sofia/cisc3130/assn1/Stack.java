package net.qwfp.sofia.cisc3130.assn1;

import java.util.ArrayList;

/**
 * This interface defines what methods a stack should implement
 * Based on the methods provided at https://docs.oracle.com/en/java/javase/26/docs/api/java.base/java/util/Stack.html
 */
public interface Stack {
    public boolean empty();
    public void push(E item);
    public E pop();
}
