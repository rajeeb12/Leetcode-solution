class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n + 1];
        if(n == 2) return Math.max(nums[0], nums[1]);

        dp[0] = nums[0];

        for(int index = 1; index < n; index++){
            int rob = nums[index], skip = 0;
            if(index > 1) rob += dp[index - 2];
            skip = dp[index - 1];

            dp[index] = Math.max(rob, skip);
        }
        
        return dp[n - 1];
    }
}