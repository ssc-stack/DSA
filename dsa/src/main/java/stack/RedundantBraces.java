package stack;

import java.util.*;

public class RedundantBraces {
    public int braces(String A) {
        Deque<Character> stack=new ArrayDeque<>();
        for(int i=0;i<A.length();++i) {
            char ch=A.charAt(i);
            if(!Character.isLetter(ch) && ch!=')') {
                stack.push(ch);
            } else if(ch==')') {
                if(!stack.isEmpty() && stack.peek()=='(') return 1;
                while(!stack.isEmpty() && stack.peek()!='(') {
                    stack.pop();
                }
                stack.pop();
            }
        }

        return 0;
    }
}
