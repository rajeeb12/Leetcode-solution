class Solution {
    int n;
    int dp[][];
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        dp = new int[n +1][n+1];
        for(int i[]: dp) Arrays.fill(i, -1);
        return solve(0,-1,nums);
    }
    public int solve(int i,int pi,int[] nums)
    {
        if(i == n) return 0;
        if(dp[i][pi + 1] != -1) return dp[i][pi + 1];

        int notTake = 0 + solve(i + 1, pi, nums);
        int take = 0;
        if(pi == -1 || (nums[i] > nums[pi]))
        {
            take = 1 + solve(i + 1, i, nums);
        }
        return dp[i][pi + 1]= Math.max(notTake, take);
    }
}