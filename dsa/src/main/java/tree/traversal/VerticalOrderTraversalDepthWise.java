/*
Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.
NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.
Problem Constraints
0 <= number of nodes <= 105
 */

package tree.traversal;

import java.util.*;
import tree.TreeNode;

public class VerticalOrderTraversalDepthWise {
    private class Pair {
        TreeNode node;
        int distance;

        Pair(TreeNode node,int distance) {
            this.node=node;
            this.distance=distance;
        }
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {

        ArrayList<ArrayList<Integer>> verticalOrder=new ArrayList<>();
        if(A==null) return verticalOrder;

        int minDistance=0,maxDistance=0;
        Map<Integer,List<Integer>> map=new HashMap<>();
        Deque<Pair> queue=new ArrayDeque<>();
        queue.offer(new Pair(A,0));

        while(!queue.isEmpty()) {
            int size=queue.size();
            for(int i=0;i<size;++i) {
                Pair p=queue.poll();
                TreeNode node=p.node;
                int distance=p.distance;
                minDistance=Math.min(minDistance,distance);
                maxDistance=Math.max(maxDistance,distance);
                List<Integer> list=map.get(distance);
                if(list==null) {
                    list=new ArrayList<>();
                }
                list.add(node.val);
                map.put(distance,list);
                if(node.left!=null) queue.add(new Pair(node.left,distance-1));
                if(node.right!=null) queue.add(new Pair(node.right,distance+1));
            }
        }
        for(int i=minDistance;i<=maxDistance;++i) {
            verticalOrder.add((ArrayList<Integer>)map.get(i));
        }
        return verticalOrder;
    }
}
