package stack;

import java.util.*;

public class MinStack {
    private Deque<Integer> stack=new ArrayDeque<>();
    private Deque<Integer> minStack=new ArrayDeque<>();

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty()) {
            minStack.push(x);
        } else if(minStack.peek()>=x) {
            minStack.push(x);
        }
    }

    public void pop() {
        if(stack.isEmpty()) return;
        if(top()==minStack.peek()) minStack.pop();
        stack.pop();
    }

    public int top() {
        if(stack.isEmpty()) return -1;
        return stack.peek();
    }

    public int getMin() {
        if(minStack.isEmpty()) return -1;
        return minStack.peek();
    }
}
