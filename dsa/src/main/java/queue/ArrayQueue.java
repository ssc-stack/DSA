package queue;

import java.util.Arrays;

public class ArrayQueue {

    private int[] queue;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    public ArrayQueue(int capacity) {
        this.capacity=capacity;
        rear=-1;
        front=0;
        size=0;
        queue=new int[capacity];
    }

    public void enqueue(int element) {
        if(isFull()) {
            throw new RuntimeException("Overflow!");
        }

        queue[++rear]=element;
        size++;
    }

    public int dequeue() {
        if(isEmpty()) {
            throw new RuntimeException("Underflow!");
        }

        int element=queue[front];
        queue[front++]=0;
        size--;
        return element;
    }

    public int size() {
        return size;
    }

    public boolean isFull() {
        return size==capacity-1;
    }

    public boolean isEmpty() {
        return front>rear;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        if(isEmpty()) sb.append("Queue is Empty!");
        else {
            sb.append("queue:");
            for(int i=front;i<=rear;++i) {
                sb.append(queue[i]);
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
