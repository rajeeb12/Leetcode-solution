class Solution {
    int n;
    int dp[][];
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        dp = new int[n +1][n+1];

        for(int i = n - 1; i>= 0; i--)
        {
            for(int pi = i - 1 ; pi >= -1; pi--)
            {
                int notTake = 0 + dp[i + 1][pi + 1];
                int take = 0;
                if(pi == -1 || (nums[i] > nums[pi]))
                {
                    take = 1 + dp[i + 1][i + 1];
                }
                dp[i][pi + 1]= Math.max(notTake, take);
            }
        }
        return dp[0][0];
    }
}