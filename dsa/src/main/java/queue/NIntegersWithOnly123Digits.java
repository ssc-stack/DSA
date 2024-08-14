package queue;

import java.util.*;

public class NIntegersWithOnly123Digits {
    public int[] solve(int A) {
        Deque<Integer> q=new ArrayDeque<>();
        int[] res=new int[A];
        if(A<=3) {
            for(int i=0;i<A;++i) res[i]=i+1;
        } else {
            int i=1;
            int count=3;
            int k=0;
            q.offer(1);
            q.offer(2);
            q.offer(3);
            while(i<=A) {
                int frontElement=q.poll();
                res[k++]=frontElement;
                if(i==A) return res;
                if(count<A) {
                    q.offer(frontElement*10+1);
                    q.offer(frontElement*10+2);
                    q.offer(frontElement*10+3);
                }
                count+=3;
                i++;
            }
        }

        return res;

    }
}
