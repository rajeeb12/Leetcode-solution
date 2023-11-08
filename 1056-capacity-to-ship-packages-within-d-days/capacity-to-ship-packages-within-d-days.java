class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 1;
        int high = 0;
        for(int w: weights){
            high += w;
            low =Math.max(low, w);
        }

        while(low <= high){
            int mid = (low + high) >> 1;
            if(isPossible(mid , weights , days)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    public boolean isPossible(int mid, int[] weights, int days){
        int countDays = 1;
        int totalWeight = 0;
        int n = weights.length;
        for(int i = 0 ; i < n; i++){
            if(totalWeight + weights[i] > mid){
                countDays++;
                totalWeight = weights[i];
            }
            else totalWeight += weights[i];
        }
        return countDays <= days;
    }
}