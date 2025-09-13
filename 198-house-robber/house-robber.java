class Solution {
    int dp[];
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        
        dp = new int[n + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int index = 2; index < n ; index++){
            int notPick = dp[index - 1];
            int pick = nums[index] + dp[index - 2];
            dp[index] = Math.max(notPick, pick);
        }
        return dp[n - 1];
    }
    
}