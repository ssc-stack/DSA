package sorting;

import java.util.*;

public class CountSort {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int max=Collections.max(A);
        ArrayList<Integer> res=new ArrayList<>();
        int[] count=new int[max+1];

        for(int el:A) {
            count[el]++;
        }

        for(int i=0;i<=max;++i) {
            while(count[i]>0) { // Duplicates
                res.add(i);
                count[i]--;
            }
        }
        return res;
    }
}
