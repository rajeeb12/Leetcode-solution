class Solution {
    int dp[][];
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n + 1][n + 1];
        for(int i[]: dp)
        {
            Arrays.fill(i, -1);
        }
        return solve(0, -1, nums);
    }
    public int solve(int index,int prev,int[] nums)
    {
        if(index == nums.length)
        {
            return 0;
        }
        if(dp[index][prev + 1] != -1) return dp[index][prev + 1];

        int not_pick = solve(index + 1, prev, nums);
        int pick = 0;

        if(prev == -1 || (nums[index] > nums[prev]))
        {
            pick = 1 + solve(index + 1, index, nums);
        } 
        return dp[index][prev + 1] = Math.max(pick , not_pick);
    }
}