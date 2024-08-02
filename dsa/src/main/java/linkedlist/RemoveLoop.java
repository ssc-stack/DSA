/*
Problem Description

You are using Google Maps to help you find your way around a new place. But, you get lost and end up walking in a circle. Google Maps has a way to keep track of where you've been with the help of special sensors.These sensors notice that you're walking in a loop, and now, Google wants to create a new feature to help you figure out exactly where you started going in circles.

Here's how we can describe the challenge in simpler terms: You have a Linked List A that shows each step of your journey, like a chain of events. Some of these steps have accidentally led you back to a place you've already been, making you walk in a loop. The goal is to find out the exact point where you first started walking in this loop, and then you want to break the loop by not going in the circle just before this point.



Problem Constraints

1 <= number of nodes <= 1000
 */
package linkedlist;

public class RemoveLoop {
    public ListNode solve(ListNode A) {
        ListNode slow=A,fast=A;

        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast) {
                break;
            }
        }

        if(slow!=fast) return A;

        ListNode i=A,j=slow;


        while(i.next!=j.next) {
            i=i.next;
            j=j.next;
        }

        j.next=null;
        return A;
    }
}
