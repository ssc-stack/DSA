/*
Problem Description

Imagine you're an ice cream truck driver in a beachside town. The beach is divided into several sections, and each section has varying numbers of beachgoers wanting ice cream given by the array of integers A.

For simplicity, let's say the beach is divided into 8 sections. One day, you note down the number of potential customers in each section: [5, 12, 3, 4, 8, 10, 2, 7]. This means there are 5 people in the first section, 12 in the second, and so on.

You can only stop your truck in B consecutive sections at a time because of parking restrictions. To maximize sales, you want to park where the most customers are clustered together.

For all B consecutive sections, identify the busiest stretch to park your ice cream truck and serve the most customers. Return an array C, where C[i] is the busiest section in each of the B consecutive sections. Refer to the given example for clarity.

NOTE: If B > length of the array, return 1 element with the max of the array.



Problem Constraints

1 <= |A|, B <= 106
 */
package queue;

import java.util.*;

public class SlidingWindowMaximum {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] slidingMaximum(final int[] A, int B) {
        Deque<Integer> dq=new ArrayDeque<>();
        int[] res=new int[A.length-B+1];
        int k=0;
        for(int i=0;i<A.length;++i) {
            if(!dq.isEmpty() && dq.peekFirst()<=i-B) dq.pollFirst();
            while(!dq.isEmpty() && A[dq.peekLast()]<=A[i]) dq.pollLast();
            dq.offer(i);
            if(i>=B-1) res[k++]=A[dq.peek()];
        }

        return res;
    }
}
