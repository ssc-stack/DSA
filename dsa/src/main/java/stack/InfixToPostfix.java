package stack;

import java.util.*;

public class InfixToPostfix {
    private int checkPriority(char ch) {
        switch(ch) {
            case '+':
            case '-':
                return 0;
            case '*':
            case '/':
                return 1;
            case '^':
                return 2;
        }
        return -1;
    }

    public String solve(String A) {
        Deque<Character> stack=new ArrayDeque<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<A.length();++i) {
            char ch=A.charAt(i);

            if(Character.isLetterOrDigit(ch)) {
                sb.append(ch);
            } else if(ch=='(') {
                stack.push(ch);
            } else if(ch==')') {
                while(!stack.isEmpty() && stack.peek()!='(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            } else {
                while(!stack.isEmpty() && checkPriority(ch)<=checkPriority(stack.peek())) {
                    sb.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
