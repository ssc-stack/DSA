package stack;

import java.util.Arrays;

public class ArrayStack {
    private int[] stack;
    private int top;
    private int capacity;

    public ArrayStack(int size) {
        this.capacity=size;
        stack=new int[capacity];
        top=-1;
    }

    public void push(int element) {
        if(isFull()) throw new RuntimeException("Stack is Full");
        stack[++top]=element;
    }

    public int pop() {
        if(isEmpty()) throw new RuntimeException("Stack is Empty");

        int element=stack[top--];
        return element;
    }

    public int peek() {
        return stack[top];
    }

    public boolean isEmpty() {
        return top==-1;
    }

    public boolean isFull() {
        return top==capacity-1;
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "stack=" + Arrays.toString(stack) +
                '}';
    }
}
