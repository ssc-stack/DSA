/*
Given an m x n matrix, return all elements of the matrix in spiral order.
 */
package array.basic.matrix;

import java.util.*;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowCount=matrix.length;
        int colCount=matrix[0].length;
        List<Integer> res=new ArrayList<>();
        int top=0,left=0,bottom=rowCount-1,right=colCount-1;
        while(top<=bottom && left<=right) {
            //Moving from left to right
            for(int i=left;i<=right;++i) {
                res.add(matrix[top][i]);
            }
            top++;
            //Moving from top to bottom
            for(int i=top;i<=bottom;++i) {
                res.add(matrix[i][right]);
            }
            right--;
            //moving from right to left
            if(top<=bottom) {  // top is changed so this check is required
                for(int i=right;i>=left;--i) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            //moving from bottom to top
            if(left<=right) { // right is changes so this check is required
                for(int i=bottom;i>=top;--i) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}
