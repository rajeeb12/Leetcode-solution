class Solution {
    int dp[][];
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n + 1][n + 1];
        for(int i[] : dp) Arrays.fill(i, -1);
        return solve(0, -1, nums);   
    }
    public int solve(int index,int prevIndex, int[] nums)
    {
        if(index >= nums.length)
        {
            return 0;
        }

        if(dp[index][prevIndex + 1] != -1) return dp[index][prevIndex + 1];

        int notPick = 0 + solve(index + 1, prevIndex, nums);
        int pick = 0;
        if(prevIndex == -1 || (nums[index] > nums[prevIndex]))
        {
            pick = 1 + solve(index + 1, index , nums);
        }
        return dp[index][prevIndex + 1] = Math.max(pick, notPick);
    }
}