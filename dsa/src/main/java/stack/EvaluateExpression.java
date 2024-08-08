/*
Problem Description

An arithmetic expression is given by a string array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each string may be an integer or an operator.

Note: Reverse Polish Notation is equivalent to Postfix Expression, where operators are written after their operands.



Problem Constraints

1 <= N <= 105
 */
package stack;

import java.util.*;

public class EvaluateExpression {
    private boolean isOperator(String s) {
        switch(s.charAt(0)) {
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
        }

        return false;
    }

    public int evalRPN(ArrayList<String> A) {

        Deque<Integer> stack=new ArrayDeque<>();

        for(String s:A) {
            if(s.length()==1 && isOperator(s)) {
                Integer val2=stack.pop();
                Integer val1=stack.pop();
                switch(s.charAt(0)) {
                    case '+':
                        stack.push(val1+val2);
                        break;
                    case '-':
                        stack.push(val1-val2);
                        break;
                    case '*':
                        stack.push(val1*val2);
                        break;
                    case '/':
                        stack.push(val1/val2);
                }
            } else {
                stack.push(Integer.valueOf(s));
            }
        }

        return stack.peek();
    }
}
