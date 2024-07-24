/*
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

Constraints:

    1 <= piles.length <= 104
    piles.length <= h <= 109
    1 <= piles[i] <= 109

 */

package searching;

public class KokoEatingBanana {
    private static int maxValue(int[] A) {
        int max=Integer.MIN_VALUE;
        for(int el:A) {
            max=Math.max(max,el);
        }

        return max;
    }

    private static int calculateTotalHours(int[] piles,int hourlyRate) {
        int totalHours=0;
        for(int pile:piles) {
            totalHours+=Math.ceil((double)pile/hourlyRate);
        }
        return totalHours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low=1,high=maxValue(piles);
        int ans=0;
        while(low<=high) {
            int mid=low+(high-low)/2;

            int totalH=calculateTotalHours(piles,mid);
            if(totalH<=h) {
                ans=mid;
                high=mid-1;
            } else {
                low=mid+1;
            }
        }

        return ans;
    }
}
