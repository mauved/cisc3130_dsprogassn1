package net.qwfp.sofia.cisc3130.assn1;

public class Main {
    static void main(String[] args) {

        // Test a stack
        Stack<Integer> testStack = new Stack<>();
        testStack.push(1);
        testStack.push(1);
        testStack.push(5);
        testStack.push(-4);

        for (Integer number: testStack) {
            IO.println(number);
        }
    }
}