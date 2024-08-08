/*
Problem Description
You have a string, denoted as A.

To transform the string, you should perform the following operation repeatedly:

    Identify the first occurrence of consecutive identical pairs of characters within the string.
    Remove this pair of identical characters from the string.
    Repeat steps 1 and 2 until there are no more consecutive identical pairs of characters.

The final result will be the transformed string.



Problem Constraints

1 <= |A| <= 100000
 */
package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DoubleCharacterTrouble {
    public String solve(String A) {
        Deque<Character> stack=new ArrayDeque<>();

        for(int i=0;i<A.length();++i) {
            char ch=A.charAt(i);
            if(!stack.isEmpty() && ch==stack.peek()) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        StringBuilder res=new StringBuilder(stack.size());
        while(!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }
}
