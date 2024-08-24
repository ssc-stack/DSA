package maths;

import java.util.*;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans=new ArrayList<>();
        for(int n=0;n<numRows;++n) {
            int val=1;
            ArrayList<Integer> row=new ArrayList<>();
            for(int r=0;r<=n;++r) {
                row.add(val);
                val=val*(n-r)/(r+1);
            }
            ans.add(row);
        }

        return ans;
    }
}
