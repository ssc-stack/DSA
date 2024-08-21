package array.basic.carryandforward;

import java.util.*;

public class ClosestMinMax {
    public int solve(ArrayList<Integer> A) {
        int min=Collections.min(A);
        int max=Collections.max(A);

        if(min==max) return 1;

        int minIndex=-1;
        int maxIndex=-1;

        int ans=Integer.MAX_VALUE;

        for(int i=0;i<A.size();++i) {
            int el=A.get(i);
            if(el==min) {
                minIndex=i;
            }

            if(el==max) {
                maxIndex=i;
            }

            if(minIndex!=-1 && maxIndex!=-1)
                ans=Math.min(ans,Math.abs(maxIndex-minIndex)+1);

        }

        return ans;
    }
}
