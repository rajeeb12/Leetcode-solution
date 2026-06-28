class Solution {
    int dp[];
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n + 1];
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        
        dp[n - 1] = nums[n - 1];
        dp[n - 2] = nums[n - 2];
        for(int index = n - 2; index >= 0; index--){
            int pick = nums[index] + dp[index + 2];
            int notPick = dp[index + 1];
            dp[index] = Math.max(pick, notPick);        
        }
        return dp[0];
    }
    public int solve(int index, int nums[]){
        if(index >= nums.length) return 0;

        if(dp[index] != -1) return dp[index];

        int pick = nums[index] + solve(index + 2, nums);
        int notPick = solve(index + 1, nums);

        return dp[index] = Math.max(pick, notPick);
    }
}