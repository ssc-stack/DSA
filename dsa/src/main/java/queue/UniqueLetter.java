package queue;

import java.util.*;

public class UniqueLetter {
    public String solve(String A) {
        Deque<Character> dq=new ArrayDeque<>();
        Map<Character,Integer> map=new HashMap<>();
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<A.length();++i) {
            char ch=A.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            dq.offer(ch);
            while(!dq.isEmpty() && map.get(dq.peek())>1) {
                dq.pop();
            }

            if(!dq.isEmpty()) sb.append(dq.peek());
            else sb.append("#");
        }

        return sb.toString();
    }
}
