class Solution {
    int dp[];
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        int one = helper(nums, 0, n - 2);
        Arrays.fill(dp, -1);

        int two = helper(nums, 1, n - 1);

        return Math.max(one , two);
    }
    public int helper(int[] nums, int end, int start)
    {
        if(start < end) return 0;
        if(start == end) return nums[start];

        if(dp[start] != -1) return dp[start];
        
        int notPick = helper(nums, end, start - 1);
        int pick = nums[start] + helper(nums, end, start - 2);

        return dp[start] = Math.max(notPick , pick); 
    }
}