/*
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

    For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].

The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

    For example, the next permutation of arr = [1,2,3] is [1,3,2].
    Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
    While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.

Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.
 */
package array.basic;

public class NextPermutation {
    private void swap(int[] nums,int i,int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    private void reverse(int[] nums,int i,int j) {
        while(i<j) {
            swap(nums,i,j);
            i++;
            j--;
        }
    }

    public void nextPermutation(int[] nums) {
        int index=-1; // Break point
        for(int i=nums.length-2;i>=0;i--) {
            if(nums[i]<nums[i+1]) {
                index=i;
                break;
            }
        }
        // Next greater arrangement not possible
        if(index==-1) {
            reverse(nums,0,nums.length-1);
            return;
        }

        // finding element just greater than nums[index] and swap
        for(int i=nums.length-1;i>index;--i) {
            if(nums[i]>nums[index]) {
                swap(nums,i,index);
                break;
            }
        }
        //Reversing elements after index
        reverse(nums,index+1,nums.length-1);
    }
}
