/*
Problem Description

Given an integer A, you have to find the Ath Perfect Number.

A Perfect Number has the following properties:

    It comprises only 1 and 2.
    The number of digits in a Perfect number is even.
    It is a palindrome number.

For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.



Problem Constraints

1 <= A <= 100000
 */
package queue;

import java.util.*;

public class PerfectNumbers {
    public class Solution {
        public String solve(int A) {
            if(A<=2) return ""+A+A;

            Deque<String> queue=new ArrayDeque<>();
            queue.offer("1");
            queue.offer("2");
            int count=2;
            int i=1;
            while(i<=A) {
                String element=queue.poll();
                if(i==A) return element+new StringBuilder(element).reverse().toString();
                if(count<A) {
                    queue.offer(element+1);
                    queue.offer(element+2);
                }
                count+=2;
                i++;
            }

            return "0";
        }
    }

}
