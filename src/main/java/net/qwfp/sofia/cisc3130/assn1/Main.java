package net.qwfp.sofia.cisc3130.assn1;

public class Main {
    static void main(String[] args) {

        // Test a stack
        Stack<Integer> testStack = new Stack<>();
        testStack.push(1);
        testStack.push(1);
        testStack.push(5);
        testStack.push(-4);

        IO.println("Testing Stack");
        for (Integer stackNumber: testStack) {
            IO.println(stackNumber);
        }

        // Test a queue
        Queue<Integer> testQueue = new Queue<>();
        testQueue.add(1);
        testQueue.add(1);
        testQueue.add(3);
        testQueue.add(-4);

        IO.println("Testing Queue");
        for (Integer queueNumber: testQueue) {
            IO.println(queueNumber);
        }
    }
}