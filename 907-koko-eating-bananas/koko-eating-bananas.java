class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right = 1000000000;
        int left = 1;

        while(left <= right)
        {
            int mid = left + ((right - left) / 2);
            if(totalHours(mid, piles) <= h)
            {
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    public int totalHours(int h,int[] piles)
    {
        int th = 0;
        for(int i: piles)
        { 
            th += Math.ceil(1.0 * i / h); 
        }
        return th;
    }
}