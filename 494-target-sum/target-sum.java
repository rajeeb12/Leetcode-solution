class Solution {
    int dp[][];
    public int findTargetSumWays(int[] nums, int target) {
        dp = new int[nums.length + 1][2000];

        for(int i[]: dp) Arrays.fill(i, -1);

        return solve(0, nums, target, 0);
    }
    public int solve(int index,int[] nums,int target,int sum){

        if(index == nums.length){
            return (sum == target ? 1 : 0);
        }

        if(dp[index][sum + 1000] != -1) return dp[index][sum + 1000];

        int pickPositive = solve(index + 1, nums, target, sum + nums[index]);
        int pickNegative = solve(index + 1, nums, target, sum - nums[index]);

        return dp[index][sum+ 1000] = pickPositive + pickNegative;
    }
}