class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = 1000000000;

        while(lo <= hi)
        {
            int mid = (lo + hi) >> 1;
            int value = check(mid, piles);
            if(value <= h)
            {
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return lo;
    }
    public int check(int i,int[] piles)
    {
        int sum = 0;
        for(int num: piles)
        {
            sum += Math.ceil((double) num / (double)i);
        }
        return sum;
    }
    
}