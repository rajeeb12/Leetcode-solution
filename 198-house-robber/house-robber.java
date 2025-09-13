class Solution {
    int dp[];
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n - 1, nums);
    }
    public int solve(int index, int nums[]){
        if(index < 0) return 0;

        if(dp[index] != -1) return dp[index];

        int notPick = solve(index - 1, nums);
        int pick = 0;
        if(index >= 0){
            pick = nums[index] + solve(index - 2, nums);
        }
        return dp[index] = Math.max(notPick, pick);
    }
}