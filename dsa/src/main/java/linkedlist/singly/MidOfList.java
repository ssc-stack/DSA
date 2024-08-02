/*
public int solve(ListNode A) {
        ListNode slow=A,fast=A;

        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow.val;
    }
 */
package linkedlist.singly;

public class MidOfList {
    public int solve(ListNode A) {
        ListNode slow=A,fast=A;

        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow.val;
    }
}
