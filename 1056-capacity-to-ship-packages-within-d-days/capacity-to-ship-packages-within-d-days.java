class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high= 0;
        for(int w: weights)
        {
            low = Math.max(w, low);
            high += w;
        }
        int ans = -1;
        while(low <= high)
        {
            int mid = (high + low ) >> 1;
            if(getDays(weights,mid,days))
            {
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public boolean getDays(int[] weights,int W,int days)
    {
        int sum = 0;
        int curDays = 0;
        for(int i: weights)
        {
            sum += i;
            if(sum > W)
            {
                sum = i;
                curDays++;
            }
        }
        curDays++;
        return (curDays <= days);
    }
}