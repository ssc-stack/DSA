/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
 */
package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> triplets=new ArrayList<>();

        for(int i=0;i<nums.length-2;++i) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j=i+1,k=nums.length-1;
            while(j<k) {
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==0) {
                    triplets.add(List.of(nums[i],nums[j],nums[k]));
                    while(j<k && nums[j]==nums[j+1]) j++;
                    while(j<k && nums[k]==nums[k-1]) k--;
                    j++;
                    k--;
                } else if(sum>0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return triplets;
    }
}
