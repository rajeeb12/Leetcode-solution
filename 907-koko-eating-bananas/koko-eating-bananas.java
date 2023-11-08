class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 1000000000;

        for(int i: piles){
            high = Math.max(high, i);
        }

        while(low <= high){
            int mid = low +  ((high - low) / 2);
            int hours = check(mid, piles);
            if(hours <= h){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    public int check(int mid, int[] piles){
        int totalHours = 0;

        for(int i: piles){
            totalHours += Math.ceil(1.0 * i / mid);
        }
        return totalHours;
    }
}