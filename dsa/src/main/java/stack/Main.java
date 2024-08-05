package stack;

public class Main {
    public static void main(String[] args) {
        ArrayStack stack=new ArrayStack(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        System.out.println("Peek Element:"+stack.peek());
        stack.push(4);
        System.out.println(stack);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Peek Element:"+stack.peek());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Peek Element:"+stack.peek());

        stack.push(100);
        stack.push(200);
    }
}
