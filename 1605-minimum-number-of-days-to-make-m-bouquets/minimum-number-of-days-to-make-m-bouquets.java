class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long val = (long) m * (long) k;
        if(val > bloomDay.length) return -1;
        int low = (int)1e9;
        int high = -(int)1e9;

        for(int i: bloomDay){
            low = Math.min(i, low);
            high = Math.max(i, high);
        }
        int ans = -1;
        while(low <= high){
            int mid = (low + high) >> 1;
            if(isPossible(mid, bloomDay, m,k)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    public boolean isPossible(int mid, int[] bloomDay, int m, int k){
        int count = 0;
        int bMade = 0;

        for(int i: bloomDay){
            if(i <= mid){
                count++;
            }else{
                bMade += (count / k);
                count = 0;
            }
        }
        bMade += (count / k);
        return (bMade >= m);
    }
}