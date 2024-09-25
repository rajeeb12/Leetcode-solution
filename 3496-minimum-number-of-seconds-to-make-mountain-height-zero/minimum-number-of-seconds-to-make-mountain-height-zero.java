class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int n = workerTimes.length;
        long low = 0, high = (long)1e18;
        long ans = 0;
        while(low <= high)
        {
            long mid = (low + high) >> 1;
            long curHeight = 0;
            for(int i = 0 ; i < n; i++){
                long val = (long) (mid * 2) / (workerTimes[i]*1);
                val *= 4;
                val++;
                val = (long) Math.sqrt(val);
                val--;
                val /= 2L;
                curHeight +=(long) Math.max(0, val);
            }
            System.out.print(curHeight+" ");
            if(curHeight >= mountainHeight)
            {
                ans = mid;
                high= mid - 1;
            }else{
                low = mid + 1;
            }
        } 
        return ans;
    }
}