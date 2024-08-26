package sorting;

//Selecting Last Element AS Pivot
public class QuickSort {

    private void swap(int[] nums,int i,int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    // This function takes last element as pivot,
    // places the pivot element at its correct position
    // in sorted array, and places all smaller to left
    // of pivot and all greater elements to right of pivot
    private int partition(int[] nums, int low, int high) {
        int pivot=nums[high-1];
        int i=0,j=0;
        while(j<high) { // Ignoring Last Element as it is already selected as Pivot
            if(nums[j]>=pivot) {
                j++;
            } else {
                swap(nums,i,j);
                i++;
                j++;
            }
        }
        swap(nums,i,j);
        return i;
    }

    public void quickSort(int[] nums,int low,int high) {
        if(low>=high) return;
        int pi=partition(nums,low,high);
        quickSort(nums,low,pi-1);
        quickSort(nums,pi+1,high);
    }


}
