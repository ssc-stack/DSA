package linkedlist.singly;

public class PrintLinkedList {
    public void solve(ListNode A) {
        StringBuilder sb=new StringBuilder();
        while(A!=null) {
            sb.append(A.val);
            sb.append(" ");
            A=A.next;
        }
        System.out.println(sb.toString());
    }
}
