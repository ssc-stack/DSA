/*
Problem Description

Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.

Refer to the examples for more clarity.



Problem Constraints

1 <= |A| <= 100
 */
package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedBrackets {
    private char oppositePair(char ch) {
        switch(ch) {
            case '}':
                return '{';
            case ')':
                return '(';
            case ']':
                return '[';
        }
        return ' ';
    }

    public int solve(String A) {
        Deque<Character> stack=new ArrayDeque<>();

        for(int i=0;i<A.length();++i) {
            char ch=A.charAt(i);
            if(ch=='(' || ch=='{' || ch=='[') {
                stack.push(ch);
            } else if(!stack.isEmpty() && stack.peek()==oppositePair(ch)){
                stack.pop();
            } else {
                return 0;
            }
        }

        return stack.size()==0?1:0;
    }
}
