class Solution {
    int dp[];
    public int rob(int[] nums) {
        int n = nums.length; 
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        dp = new int[n + 1];
        
        dp[0] = nums[0];

        for(int index = 1; index < n ; index++)
        {
            int rob = nums[index];
            if(index > 1) rob += dp[index - 2];
            int notRob = dp[index - 1];

            dp[index] = Math.max(rob, notRob);
        }
        
        return dp[n - 1];
    }
    public int solve(int index, int[] nums)
    {
        if(index < 0) return 0;
        if(index == 0)
        {
            return nums[0];
        }

        if(dp[index] != -1) return dp[index];

        int rob = nums[index] + solve(index - 2, nums);
        int notRob = solve(index - 1,nums);

        return dp[index] = Math.max(rob, notRob);
    }
}