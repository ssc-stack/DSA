package linkedlist.doubly;

public class MyLinkedList {

    private Node head;
    private int size;

    private class Node {
        private int val;
        private Node next;
        private Node prev;

        public Node(int val) {
            this.val=val;
        }
    }

    public MyLinkedList() {
        head=null;
        size=0;
    }

    public int get(int index) {
        if(index<0 || index>=size) return -1;

        Node itr=head;
        while(itr!=null && index>0) {
            itr=itr.next;
            index--;
        }
        return itr.val;
    }

    public void addAtHead(int val) {
        Node newNode=new Node(val);
        newNode.next=head;
        if(head!=null) head.prev=newNode;
        head=newNode;
        size++;
    }

    public void addAtTail(int val) {
        Node newNode=new Node(val);
        Node itr=head;
        if(head==null) {
            head=newNode;
            size++;
            return;
        }

        while(itr.next!=null) {
            itr=itr.next;
        }

        itr.next=newNode;
        newNode.prev=itr;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        Node newNode = new Node(val);

        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == size) {
            addAtTail(val);
            return;
        }

        Node itr = head;
        while (index > 0) {
            itr = itr.next;
            index--;
        }

        newNode.next = itr;
        newNode.prev = itr.prev;
        itr.prev.next = newNode;
        itr.prev = newNode;

        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;

        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else {
            Node itr = head;
            while (index > 0) {
                itr = itr.next;
                index--;
            }

            if (itr.prev != null) {
                itr.prev.next = itr.next;
            }
            if (itr.next != null) {
                itr.next.prev = itr.prev;
            }
        }
        size--;
    }

}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
