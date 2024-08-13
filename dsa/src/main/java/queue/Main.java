package queue;

public class Main {

    public static void staticQueue() {
        ArrayQueue queue=new ArrayQueue(5);
        System.out.println(queue);
        try {
            queue.enqueue(2);
            queue.enqueue(3);
            queue.dequeue();
            System.out.println(queue);
            queue.enqueue(12);
            queue.enqueue(134);
            queue.enqueue(112);
            System.out.println(queue.size());
            queue.enqueue(122);
            queue.enqueue(16);
            queue.enqueue(14);
        } catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println(queue);
    }

    public static void dynamicQueue() {
        DynamicQueue queue=new DynamicQueue();
        for(int i=1;i<=10;++i) {
            queue.enqueue(i);
            if(i%2==0)
                queue.dequeue();
        }

        System.out.println(queue.size());
        System.out.println(queue);
    }
    public static void main(String[] args) {
        //staticQueue();
        dynamicQueue();
    }
}
