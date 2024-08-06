package linkedlist.singly;

public class ListIntersection {
    public ListNode getIntersectionNode(ListNode A, ListNode B) {
        if(A==null || B==null) return null;

        ListNode a=A,b=B;

        while(a!=b) {
            a=a==null?B:a.next;
            b=b==null?A:b.next;
        }

        return a;
    }
}
