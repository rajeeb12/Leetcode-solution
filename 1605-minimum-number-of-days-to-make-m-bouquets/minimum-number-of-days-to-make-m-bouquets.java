class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        int ans = -1;
        for(int i: bloomDay)
        {
            min = Math.min(i, min);
            max = Math.max(i,max);
        }
        int low = min , high = max;
        while(low <= high)
        {
            int mid = (low + high) >> 1;
            if(check(bloomDay,mid,k,m))
            {
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public boolean check(int[] bloomDay,int day,int k,int m)
    {
        int count = 0;
        int bouqMade= 0;
        for(int i : bloomDay)
        {
            if(i <= day)
            {
                count++;
            }else{
                bouqMade += (count / k);
                count = 0; 
            }
        }
        bouqMade += count / k;
        return (bouqMade >= m);
    }
}