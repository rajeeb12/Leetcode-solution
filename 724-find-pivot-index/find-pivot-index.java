class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int lsum[]=new int[n];
        int rsum[]= new int[n];
        lsum[0] = nums[0];
        rsum[n-1] = nums[n-1];
        for(int i = 1; i < n; i++)
        {
            lsum[i] = lsum[i-1] + nums[i];
            rsum[n - i - 1] = rsum[n - i] + nums[n - i - 1];
        }
        for(int i = 0 ; i < n ; i++)
        {
            if(lsum[i] == rsum[i]) return i;
        }
        return -1;
    }
}