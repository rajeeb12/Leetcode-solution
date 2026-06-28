class Solution {
    int dp[];
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(0, nums);
    }
    public int solve(int index, int nums[]){
        if(index >= nums.length) return 0;

        if(dp[index] != -1) return dp[index];

        int pick = nums[index] + solve(index + 2, nums);
        int notPick = solve(index + 1, nums);

        return dp[index] = Math.max(pick, notPick);
    }
}