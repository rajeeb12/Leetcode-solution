class Solution {
    int dp[][];
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n + 1][n + 1];
        
        for(int i[]: dp) Arrays.fill(i, - 1);

        return helper(0,-1,nums, n);
    }
    public int helper(int index,int prev_index,int nums[],int n)
    {
        if(index == n) return 0;
        
        if(dp[index][prev_index + 1] != -1) return dp[index][prev_index + 1];

        int not_take = helper(index + 1, prev_index,nums, n);
        int take = 0;

        if(prev_index == -1 || nums[index] > nums[prev_index])
        {
            take = 1 + helper(index + 1, index , nums, n);
        } 
        return dp[index][prev_index + 1] = Math.max(take, not_take);
    }
}