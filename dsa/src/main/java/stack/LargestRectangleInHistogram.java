package stack;

import java.util.*;

public class LargestRectangleInHistogram {

    private static int[] nextSmallerLeft(int[] A) {
        int[] res = new int[A.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < A.length; ++i) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                stack.pop();
            }

            if (stack.size() == 0) res[i] = -1;
            else res[i] = stack.peek();
            stack.push(i);
        }

        return res;

    }

    private static int[] nextSmallerRight(int[] A) {
        int[] res = new int[A.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = A.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                stack.pop();
            }

            if (stack.size() == 0) res[i] = res.length;
            else res[i] = stack.peek();
            stack.push(i);
        }

        return res;
    }

    public int largestRectangleArea(int[] A) {
        int ans = Integer.MIN_VALUE;
        int[] nsl = nextSmallerLeft(A);
        int[] nsr = nextSmallerRight(A);
        //System.out.println(Arrays.toString(nsl));
        //System.out.println(Arrays.toString(nsr));
        for (int i = 0; i < A.length; ++i) {
            int height = A[i];
            int width = nsr[i] - nsl[i] - 1;
            ans = Math.max(height * width, ans);
        }

        return ans;
    }
}
