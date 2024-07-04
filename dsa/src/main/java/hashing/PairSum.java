package hashing;

import java.util.*;

public class PairSum {
    public int solve(int A, ArrayList<Integer> B) {
        Set<Integer> set=new HashSet<>();

        for(int el:B) {
            if(set.contains(A-el)) return 1;
            set.add(el);
        }

        return 0;
    }
}
