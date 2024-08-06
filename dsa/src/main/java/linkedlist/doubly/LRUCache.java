package linkedlist.doubly;


import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private Map<Integer,Node> map;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
        int value=-1;
        if(map.containsKey(key)) {
            Node node=map.get(key);
            remove(node);
            insertToHead(node);
            return node.value;
        }

        return value;
    }

    public void set(int key, int value) {
        if(map.containsKey(key)) {
            Node node=map.get(key);
            remove(node);
            insertToHead(node);
            node.value=value;
        } else {
            if(capacity==map.size()) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }

            Node newNode=new Node(key,value);
            insertToHead(newNode);
            map.put(key,newNode);
        }
    }

    private class Node {
        private int key;
        private int value;
        private Node next;
        private Node prev;
        public Node(int key,int value) {
            this.key=key;
            this.value=value;
        }

    }

    private void insertToHead(Node node) {
        node.next=head.next;
        head.next.prev=node;
        node.prev=head;
        head.next=node;
    }

    private void remove(Node node) {
        node.prev.next=node.next;
        node.next.prev=node.prev;

    }
}
