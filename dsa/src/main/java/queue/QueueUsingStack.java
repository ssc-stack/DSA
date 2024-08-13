/*
232. Implement Queue using Stacks
Solved
Easy
Topics
Companies

Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

    void push(int x) Pushes element x to the back of the queue.
    int pop() Removes the element from the front of the queue and returns it.
    int peek() Returns the element at the front of the queue.
    boolean empty() Returns true if the queue is empty, false otherwise.

Notes:

    You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
    Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.

 */
package queue;

import java.util.*;

public class QueueUsingStack {


    private Deque<Integer> input;
    private Deque<Integer> output;

    public QueueUsingStack() {
        input=new ArrayDeque<>();
        output=new ArrayDeque<>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        if(!output.isEmpty()) {
            return output.pop();
        } else {
            while(!input.isEmpty()) {
                output.push(input.pop());
            }
            return output.pop();
        }
    }

    public int peek() {
        if(!output.isEmpty()) {
            return output.peek();
        } else {
            while(!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
