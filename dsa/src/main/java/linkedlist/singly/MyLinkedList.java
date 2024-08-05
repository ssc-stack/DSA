package linkedlist.singly;

public class MyLinkedList {

    private Node head;
    private int size;

    private class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val=val;
        }
    }

    public MyLinkedList() {
        head=null;
        size=0;
    }

    public int get(int index) {
        Node itr=head;
        while(itr!=null && index>0) {
            itr=itr.next;
            index--;
        }

        if(itr!=null) return itr.val;
        return -1;
    }

    public void addAtHead(int val) {
        Node newNode=new Node(val);
        newNode.next=head;
        head=newNode;
        size++;
    }

    public void addAtTail(int val) {
        Node newNode=new Node(val);
        if(head==null) {
            head=newNode;
        } else {
            Node itr=head;
            while(itr.next!=null) {
                itr=itr.next;
            }
            itr.next=newNode;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if(index>size) return;

        Node newNode=new Node(val);

        if(index==0) {
            if(head==null) {
                head=newNode;
            } else {
                newNode.next=head;
                head=newNode;
            }
            size++;
            return;
        }

        Node itr=head;
        while(itr!=null && index>1) {
            itr=itr.next;
            index--;
        }

        newNode.next=itr.next;
        itr.next=newNode;


        size++;

    }

    public void deleteAtIndex(int index) {
        if(index>=size) return;
        if(index==0) {
            head=head.next;
            size--;
            return;
        }
        Node itr=head;
        while(itr!=null && index>1) {
            itr=itr.next;
            index--;
        }
        itr.next=itr.next.next;
        size--;
    }
}
