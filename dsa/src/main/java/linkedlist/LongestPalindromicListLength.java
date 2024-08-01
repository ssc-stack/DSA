/*
Problem Description

Given a linked list of integers. Find and return the length of the longest palindrome list that exists in that linked list.

A palindrome list is a list that reads the same backward and forward.

Expected memory complexity : O(1)



Problem Constraints

1 <= length of the linked list <= 2000

1 <= Node value <= 100
 */
package linkedlist;

public class LongestPalindromicListLength {
    private static int countCommon(ListNode f,ListNode s) {
        int count=0;
        while(f!=null && s!=null) {
            if(f.val==s.val) {
                count++;
            } else {
                break;
            }
            f=f.next;
            s=s.next;
        }

        return count;
    }

    public int solve(ListNode A) {
        int ans=0;
        ListNode curr=A,prev=null,next=null;

        while(curr!=null) {
            next=curr.next;
            curr.next=prev;

            ans=Math.max(ans,2*countCommon(prev,next)+1);// For Odd Length
            ans=Math.max(ans,2*countCommon(curr,next)); // For Even Length

            prev=curr;
            curr=next;
        }

        return ans;
    }
}
