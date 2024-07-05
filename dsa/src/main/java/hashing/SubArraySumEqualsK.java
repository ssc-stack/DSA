package hashing;

import java.util.*;

public class SubArraySumEqualsK {
    public int solve(ArrayList<Integer> A, int B) {
        int count=0;
        int prefixSum=0;

        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);

        for(int el:A) {
            prefixSum+=el;
            count+=map.getOrDefault(prefixSum-B,0);
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }

        return count;
    }
}
