package queue;

public class DynamicQueue {

    private Node front;
    private Node rear;
    private int size;

    public DynamicQueue() {
        front=rear=null;
        size=0;
    }

    public void enqueue(int data) {
        if(isEmpty()) {
            rear = front = new Node(data);
        } else {
            rear.next=new Node(data);
            rear=rear.next;
        }
    }

    public int dequeue() {
        if(isEmpty()) {
            throw new RuntimeException("UnderFlow!");
        }

        int element=front.data; //Element to be deleted
        front=front.next;
        if(front==null) rear=null; // Reset front and rear if only one element is left
        return element;
    }

    public boolean isEmpty() {
        return rear==null;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();

        Node iterator=front;
        while(iterator!=null) {
            sb.append(iterator.data);
            sb.append(" ");
            iterator=iterator.next;
        }

        return sb.toString().trim();
    }

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data=data;
            this.next=null;
        }
    }
}
